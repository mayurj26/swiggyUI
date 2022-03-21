package com.ajit.swiggyui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ajit.swiggyui.databinding.FragmentHomeBinding
import com.ajit.swiggyui.ui.BaseFragment
import com.ajit.swiggyui.ui.home.adapter.CustomAdapter

import com.denzcoskun.imageslider.constants.ActionTypes
import com.denzcoskun.imageslider.interfaces.ItemChangeListener
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.interfaces.TouchListener

class HomeFragment : BaseFragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner, {
        })

        initHorizontalView()
        initSlider()
        initHorizontalViewHz()
        initHorizontalViewVz()
        return root
    }

    private fun initHorizontalView(){

        binding.recyclerView1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val data = homeViewModel.getData()
        val adapter = CustomAdapter(data)
        binding.recyclerView1.adapter = adapter
    }

    private fun initHorizontalViewHz(){

        binding.recyclerViewHz2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val data = homeViewModel.getDishesData()
        val adapter = CustomAdapter(data)
        binding.recyclerViewHz2.adapter = adapter
    }

    private fun initHorizontalViewVz(){

        binding.recyclerViewVz.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val data = homeViewModel.getDishesData()
        val adapter = CustomAdapter(data)
        binding.recyclerViewVz.adapter = adapter
    }

    private fun initSlider(){

        val imageList = homeViewModel.getSliderData()

        binding.imageSlider.setImageList(imageList)

        binding.imageSlider.setItemClickListener(object : ItemClickListener {
            override fun onItemSelected(position: Int) {
            }
        })

        binding.imageSlider.setItemChangeListener(object : ItemChangeListener {
            override fun onItemChanged(position: Int) {
            }
        })

        binding.imageSlider.setTouchListener(object : TouchListener {
            override fun onTouched(touched: ActionTypes) {
                if (touched == ActionTypes.DOWN){
                    binding.imageSlider.stopSliding()
                } else if (touched == ActionTypes.UP ) {
                    binding.imageSlider.startSliding(1000)
                }
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.ajit.swiggyui.ui.food

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.ajit.swiggyui.databinding.FragmentFoodBinding
import com.ajit.swiggyui.ui.BaseFragment

class FoodFragment : BaseFragment() {

    private lateinit var foodViewModel: FoodViewModel
    private var _binding: FragmentFoodBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        foodViewModel =
            ViewModelProvider(this)[FoodViewModel::class.java]

        _binding = FragmentFoodBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        foodViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
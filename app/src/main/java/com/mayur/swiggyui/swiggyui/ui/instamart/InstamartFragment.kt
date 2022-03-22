package com.mayur.swiggyui.swiggyui.ui.instamart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.mayur.swiggyui.swiggyui.databinding.FragmentInstamartBinding
import com.mayur.swiggyui.swiggyui.ui.BaseFragment

class InstamartFragment : BaseFragment() {

    private lateinit var instamartViewModel: InstamartViewModel
    private var _binding: FragmentInstamartBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        instamartViewModel =
            ViewModelProvider(this)[InstamartViewModel::class.java]

        _binding = FragmentInstamartBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        instamartViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
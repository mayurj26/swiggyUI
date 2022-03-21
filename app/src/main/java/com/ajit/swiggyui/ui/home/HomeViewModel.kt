package com.ajit.swiggyui.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ajit.swiggyui.R
import com.ajit.swiggyui.ui.home.adapter.ItemsViewModel
import com.denzcoskun.imageslider.models.SlideModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun getSliderData() : ArrayList<SlideModel>{
        val imageList = ArrayList<SlideModel>() // Create image list
        imageList.add(SlideModel(R.drawable.banner))
        imageList.add(SlideModel(R.drawable.banner2))
        imageList.add(SlideModel(R.drawable.banner3))

        return imageList
    }

    fun getData() : ArrayList<ItemsViewModel>{
        val data = ArrayList<ItemsViewModel>()
        data.add(ItemsViewModel(R.drawable.food, "Food"))
        data.add(ItemsViewModel(R.drawable.genie, "Genie"))
        return data
    }

    fun getDishesData() : ArrayList<ItemsViewModel>{
        val data = ArrayList<ItemsViewModel>()
        data.add(ItemsViewModel(R.drawable.images1, "Agatya"))
        data.add(ItemsViewModel(R.drawable.food, "Dominos"))
        data.add(ItemsViewModel(R.drawable.genie, "Aroma Biryani"))
        return data
    }
}
package com.mayur.swiggyui.swiggyui.ui.instamart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InstamartViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is instamart Fragment"
    }
    val text: LiveData<String> = _text
}
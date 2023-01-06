package com.vladislab.readsmarter.ui.books

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BooksViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is my books Fragment"
    }
    val text: LiveData<String> = _text
}
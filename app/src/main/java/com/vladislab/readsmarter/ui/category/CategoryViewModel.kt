package com.vladislab.readsmarter.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladislab.readsmarter.api.books.Book
import com.vladislab.readsmarter.api.books.BooksApi
import com.vladislab.readsmarter.api.books.BooksApiInterface

class CategoryViewModel(private val category: Int?) : ViewModel() {

    class Factory(private val category: Int?) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CategoryViewModel(category) as T
        }
    }

    private val api: BooksApiInterface = BooksApi()

    private val _items = MutableLiveData<List<Book>>().apply {
        value = api.getBooks(category)
    }

    val items: LiveData<List<Book>> = _items
}
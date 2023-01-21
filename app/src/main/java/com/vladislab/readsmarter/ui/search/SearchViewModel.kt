package com.vladislab.readsmarter.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vladislab.readsmarter.api.books.Book
import com.vladislab.readsmarter.api.books.BooksApi
import com.vladislab.readsmarter.api.books.BooksApiInterface

class SearchViewModel(private val query: String) : ViewModel() {

    class Factory(private val query: String) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SearchViewModel(query) as T
        }
    }

    private val api: BooksApiInterface = BooksApi()

    private val _items = MutableLiveData<List<Book>>().apply {
        value = api.searchBooks(query)
    }

    val items: LiveData<List<Book>> = _items
}
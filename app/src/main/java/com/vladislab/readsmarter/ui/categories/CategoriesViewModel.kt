package com.vladislab.readsmarter.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vladislab.readsmarter.api.category.CategoriesApi
import com.vladislab.readsmarter.api.category.CategoriesApiInterface
import com.vladislab.readsmarter.api.category.Category

class CategoriesViewModel : ViewModel() {

    private val api: CategoriesApiInterface = CategoriesApi()

    private val _items = MutableLiveData<List<Category>>().apply {
        value = api.getCategories()
    }

    val items: LiveData<List<Category>> = _items
}
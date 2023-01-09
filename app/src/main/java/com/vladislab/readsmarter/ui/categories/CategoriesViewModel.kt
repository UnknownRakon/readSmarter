package com.vladislab.readsmarter.ui.categories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoriesViewModel : ViewModel() {

    private val _items = MutableLiveData<List<String>>().apply {
        value = arrayListOf(
            "Бизнес",
            "Психология",
            "Семья и воспитание",
            "Наука и технологии",
            "Здоровый образ жизни",
            "Истории успеха и биографии",
            "Переговоры и продажи",
            "Маркетинг и реклама",
            "Финансы и экономика",
            "Менеджмент и лидерство"
        )
    }

    val items: LiveData<List<String>> = _items
}
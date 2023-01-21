package com.vladislab.readsmarter.api.books

import android.graphics.drawable.Drawable

data class Book(
    val id: Int,
    val category: Int,
    val name: String,
    val author: String,
    val image: Int? = null
)

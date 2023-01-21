package com.vladislab.readsmarter.api.books

import android.util.Log
import com.vladislab.readsmarter.R

interface BooksApiInterface {
    fun getBooks(categoryId: Int): List<Book>
    fun searchBooks(query: String): List<Book>
    fun allBooks(): List<Book>
}


class BooksApi() : BooksApiInterface {

    override fun allBooks(): List<Book> {
        return books
    }

    override fun getBooks(categoryId: Int): List<Book> {
        return books.filter {
            it.category == categoryId
        }
    }

    override fun searchBooks(query: String): List<Book> {
        return books.filter {
            it.name.contains(query) or it.author.contains(query)
        }
    }

    companion object Books {
        private val books: List<Book> = arrayListOf(
            Book(
                1,
                1,
                "Книга о бизнесе 1",
                "Автор Авторович"
            ),
            Book(
                2,
                1,
                "Книга о бизнесе 2",
                "Автор Авторович"
            ),
            Book(
                3,
                1,
                "Книга о бизнесе 3",
                "Автор Авторович"
            ),
            Book(
                4,
                1,
                "Книга о бизнесе 4",
                "Автор Авторович"
            ),
            Book(
                5,
                2,
                "Кига по психологии 1",
                "Автор Авторович"
            ),
            Book(
                6,
                2,
                "Книга по психологии 2",
                "Автор Авторович"
            ),
            Book(
                7,
                2,
                "Книга по психологии 3",
                "Автор Авторович"
            ),
            Book(
                8,
                3,
                "Кига по воспитанию 1",
                "Автор Авторович"
            ),
            Book(
                9,
                3,
                "Книга по воспитанию 2",
                "Автор Авторович"
            ),
            Book(
                10,
                3,
                "Книга по воспитанию 3",
                "Автор Авторович"
            ),
            Book(
                11,
                1,
                "Красная таблетка",
                "Андрей Курпатов",
                R.drawable.red_one
            ),
            Book(
                12,
                1,
                "Красная таблетка 2",
                "Андрей Курпатов",
                R.drawable.red_two
            ),
        )
    }
}
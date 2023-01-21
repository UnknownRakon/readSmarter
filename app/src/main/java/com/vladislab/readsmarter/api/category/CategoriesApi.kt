package com.vladislab.readsmarter.api.category

interface CategoriesApiInterface {
    fun getCategories(): List<Category>
}


class CategoriesApi() : CategoriesApiInterface {
    override fun getCategories(): List<Category> {
        return arrayListOf(
            Category(1, "Бизнес"),
            Category(2, "Психология"),
            Category(3, "Семья и воспитание"),
            Category(4, "Наука и технологии"),
            Category(5, "Здоровый образ жизни"),
            Category(6, "Истории успеха и биографии"),
            Category(7, "Переговоры и продажи"),
            Category(8, "Маркетинг и реклама"),
            Category(9, "Финансы и экономика"),
            Category(10, "Менеджмент и лидерство"),
        )
    }
}
package com.example.quotekaapplication.data.models

data class Quote(
    val quote: String, // Текст цитаты
    val author: String, // Автор цитаты
    val category: String // Категория цитаты
) {
    // Переопределение equals и hashCode для корректного сравнения цитат
    override fun equals(other: Any?): Boolean {
        // Проверяем, что другой объект является экземпляром Quote и сравниваем все поля
        return other is Quote &&
                other.quote == this.quote &&
                other.author == this.author &&
                other.category == this.category
    }

    override fun hashCode(): Int {
        // Генерируем hashCode на основе всех полей
        return quote.hashCode() * 31 + author.hashCode() * 31 + category.hashCode()
    }
}

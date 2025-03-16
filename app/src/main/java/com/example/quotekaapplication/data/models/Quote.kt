package com.example.quotekaapplication.data.models

data class Quote(
    val quote: String,
    val author: String,
    val category: String
) {

    override fun equals(other: Any?): Boolean {
        return other is Quote &&
                other.quote == this.quote &&
                other.author == this.author &&
                other.category == this.category
    }

    override fun hashCode(): Int {
        return quote.hashCode() * 31 + author.hashCode() * 31 + category.hashCode()
    }
}
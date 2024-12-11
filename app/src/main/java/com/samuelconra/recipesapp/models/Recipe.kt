package com.samuelconra.recipesapp.models

data class Recipe(
    val category: String = "",
    val description: String = "",
    val difficulty: String = "",
    val duration: Int = 0,
    val id: Int = 0,
    val image: String = "",
    val ingredients: String = "",
    val name: String = "",
    val plates: Int = 0,
    val short_description: String = ""
)
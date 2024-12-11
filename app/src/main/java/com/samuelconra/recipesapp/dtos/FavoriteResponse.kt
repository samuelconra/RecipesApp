package com.samuelconra.recipesapp.dtos

data class FavoriteResponse(
    val message: String,
    val user_id: Int,
    val recipe_id: Int
)

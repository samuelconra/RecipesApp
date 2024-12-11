package com.samuelconra.recipesapp.models

data class Step(
    val duration: Int = 0,
    val id: Int = 0,
    val instruction: String = "",
    val recipe_id: Int = 0,
    val step_number: Int = 0
)
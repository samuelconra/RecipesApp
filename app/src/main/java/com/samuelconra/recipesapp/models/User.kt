package com.samuelconra.recipesapp.models

data class User(
    val id: Int = 0,
    val email: String = "",
    val name: String = "",
    val password: String = "",
    val username: String = ""
)
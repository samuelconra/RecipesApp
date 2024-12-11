package com.samuelconra.recipesapp.utils

sealed class Screens(val route: String) {
    data object Login : Screens("login")
    data object SingUp : Screens("singUp")
    data object Home : Screens("home")
    data object Favorites : Screens("favorites")
    data object RecipeScreen : Screens("recipe")
    data object RecipeStep : Screens("step")
}
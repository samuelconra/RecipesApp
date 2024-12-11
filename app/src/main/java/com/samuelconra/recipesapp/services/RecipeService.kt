package com.samuelconra.recipesapp.services

import com.samuelconra.recipesapp.dtos.FavoriteResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("recipes/{id}")
    suspend fun get_recipe_by_id(@Path("id") id: Int): Response<Recipe>

    @GET("recipes/")
    suspend fun get_recipes_by_category(@Query("category") category: String): Response<List<Recipe>>

    @GET("recipes/populars")
    suspend fun get_popular_recipes(): Response<List<Recipe>>

    @GET("recipes/most_popular")
    suspend fun get_most_popular(): Response<List<Recipe>>
}
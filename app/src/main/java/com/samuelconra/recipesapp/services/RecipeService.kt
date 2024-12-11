package com.samuelconra.recipesapp.services

import com.samuelconra.recipesapp.dtos.AddFavorite
import com.samuelconra.recipesapp.dtos.AddFavoriteResponse
import com.samuelconra.recipesapp.dtos.Favorite
import com.samuelconra.recipesapp.dtos.FavoriteResponse
import com.samuelconra.recipesapp.models.Recipe
import com.samuelconra.recipesapp.models.Step
import retrofit2.Response
import retrofit2.http.*

interface RecipeService {
    @GET("recipes/{id}")
    suspend fun get_recipe_by_id(@Path("id") id: Int): Response<Recipe>

    @GET("recipes/by-category")
    suspend fun get_recipes_by_category(@Query("category") category: String): Response<List<Recipe>>

    @GET("/recipes/{recipe_id}/only-steps")
    suspend fun get_steps(@Path("recipe_id") recipe_id: Int): Response<List<Step>>

    @GET("recipes/populars")
    suspend fun get_popular_recipes(): Response<List<Recipe>>

    @GET("recipes/most_popular")
    suspend fun get_most_popular(): Response<Recipe>

    @POST("users/favorites")
    suspend fun add_favorite(@Body request: AddFavorite): Response<AddFavoriteResponse>

    @DELETE("users/{user_id}/favorites")
    suspend fun remove_favorite(@Path("user_id") user_id: Int, @Query("recipe_id") recipe_id: Int): Response<FavoriteResponse>

    @GET("users/{user_id}/favorites")
    suspend fun get_favorites(@Path("user_id") user_id: Int): Response<List<Recipe>>
}
package com.samuelconra.recipesapp.services
import com.samuelconra.recipesapp.dtos.Favorite
import com.samuelconra.recipesapp.dtos.FavoriteResponse
import retrofit2.Response
import retrofit2.http.*

interface FavoriteService {
    @POST("users/favorites")
    suspend fun add_favorite(@Body fav: Favorite): Response<FavoriteResponse>

    @DELETE("users/{user_id}/favorites")
    suspend fun remove_favorite(@Path("user_id") user_id: Int, @Query("recipe_id") recipe_id: Int): Response<FavoriteResponse>

    @GET("users/{user_id}/favorites")
    suspend fun get_favorites(@Path("user_id") user_id: Int): Response<List<Recipe>>
}
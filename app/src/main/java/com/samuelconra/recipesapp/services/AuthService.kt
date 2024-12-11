package com.samuelconra.recipesapp.services

import com.samuelconra.recipesapp.dtos.Auth
import com.samuelconra.recipesapp.dtos.SingUp
import com.samuelconra.recipesapp.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {
    @POST("users/verify")
    suspend fun login(@Body auth: Auth): Response<User>

    @POST("users")
    suspend fun singUp(@Body auth: SingUp): Response<User>

    @GET("users/{user_id}")
    suspend fun get_user(@Path("user_id") user_id: Int): Response<User>
}
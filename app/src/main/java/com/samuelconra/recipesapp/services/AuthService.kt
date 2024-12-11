package com.samuelconra.recipesapp.services

import com.samuelconra.recipesapp.dtos.Auth
import com.samuelconra.recipesapp.dtos.SingUp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("users/verify")
    suspend fun login(@Body auth: Auth): Response<User>

    @POST("users")
    suspend fun singUp(@Body auth: SingUp): Response<User>
}
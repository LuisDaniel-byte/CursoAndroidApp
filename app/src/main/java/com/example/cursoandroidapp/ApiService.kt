package com.example.cursoandroidapp

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @POST("change_password")
    fun passwordUpdate(@Body changePasswordRequest: ChangePasswordRequest) : Call<ChangePasswordResponse>

    @POST("update_user")
    fun userUpdate(@Body userUpdateRequest: UserUpdateRequest): Call<UserUpdateResponse>
}
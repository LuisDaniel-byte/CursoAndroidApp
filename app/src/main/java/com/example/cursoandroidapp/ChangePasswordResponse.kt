package com.example.cursoandroidapp

import com.google.gson.annotations.SerializedName

data class ChangePasswordResponse(
    @SerializedName("name") val name: String,
    @SerializedName("token") val token: String
)

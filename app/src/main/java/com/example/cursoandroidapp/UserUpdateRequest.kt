package com.example.cursoandroidapp

import com.google.gson.annotations.SerializedName

data class UserUpdateRequest(
    @SerializedName("token") val  token: String,
    @SerializedName("email") val  email : String,
    @SerializedName("name") val  name : String
)

package com.example.cursoandroidapp

import com.google.gson.annotations.SerializedName

data class ChangePasswordRequest(
    @SerializedName("token") val  token: String,
    @SerializedName("password") val  password : String

)

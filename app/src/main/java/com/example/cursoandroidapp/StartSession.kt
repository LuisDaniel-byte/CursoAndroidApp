package com.example.cursoandroidapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class StartSession : AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var btnChangePassword: Button
    lateinit var btnUpdateUser: Button
    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var tvHeader: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.session_start)


        btnLogin = findViewById(R.id.idBtnLogin)
        btnChangePassword = findViewById(R.id.idBtnChangePassword)
        btnUpdateUser = findViewById(R.id.idBtnUpdateUser)
        etEmail = findViewById(R.id.idEdtUserName)
        etPassword = findViewById(R.id.idEdtPassword)
        tvHeader = findViewById((R.id.idTVHeader))

        btnChangePassword.setOnClickListener() {
           val i = Intent (this,ChangePassword::class.java)
           startActivity(i)
        }
        btnUpdateUser.setOnClickListener() {
            val i = Intent (this,UserUpdate::class.java)
            startActivity(i)
        }

        btnLogin.setOnClickListener() {
            val apiService = ApiClient.getClient()
            val body: LoginRequest = LoginRequest(etEmail.text.toString(), etPassword.text.toString())

            val call = apiService.login(body)
            call.enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        tvHeader.text = "Bienvenido " + loginResponse?.name
                        Toast.makeText(applicationContext, "Inicio de Sesion Correcto", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()
                }
            })
        }
        btnLogin.setOnClickListener() {
            val i = Intent (this,FirstScreen::class.java)
            startActivity(i)
        }

    }
}

package com.example.cursoandroidapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserUpdate : AppCompatActivity() {

    lateinit var tv_email: TextInputEditText
    lateinit var tv_password: TextInputEditText

    lateinit var tiet_email: TextInputEditText
    lateinit var tiet_user: TextInputEditText

    lateinit var btn_change: Button

    //lateinit var tv_not_account: TextView
    //lateinit var btn_login: Button
    //var key = ""
    //var value = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_update)

        tv_email = findViewById(R.id.idEdtEmail)
        tv_password = findViewById(R.id.idEdtPassword)

        tiet_user = findViewById(R.id.idChange_User)
        tiet_email = findViewById(R.id.idChange_Email)

        btn_change = findViewById(R.id.idChange_Button)

        //btn_login = findViewById(R.id.idChange_Button)
        //tv_not_account = findViewById(R.id.idChange_Button)

        btn_change.setOnClickListener {
            changeUsername()
        }
        //btn_login.setOnClickListener {
        //   log_in()
        //}
        //tv_not_account.setOnClickListener {

            //val intent = Intent(this, UserUpdate::class.java)
             // UserUpdate(intent)
    }
        fun readCache(context: Context, key: String): String? {
            val sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE)
            return sharedPreferences.getString(key, null)
        }

        fun changeUsername() {
            val apiService = ApiClient.getClient()

            val token = readCache(this, "token")

            val body: UserUpdateRequest = UserUpdateRequest(
                token.toString(),
                tiet_email.text.toString(),
                tiet_user.text.toString()
            )

            val call = apiService.userUpdate(body)
            call.enqueue(object : Callback<UserUpdateResponse> {
                override fun onResponse(
                    call: Call<UserUpdateResponse>,
                    response: Response<UserUpdateResponse>
                ) {
                    if (response.isSuccessful) {
                        val loginResponse = response.body()
                        Toast.makeText(applicationContext, "Proceso completado con éxito", Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext, loginResponse?.name!!, Toast.LENGTH_LONG).show()
                    } else {
                        // Manejar el error de respuesta
                        Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<UserUpdateResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()
                }

            })
        }
/*
        fun log_in() {
            val apiService = ApiClient.getClient()
            val body: UserUpdateRequest = UserUpdateRequest(tv_email.text.toString(), tv_password.text.toString())
            val call = apiService.passwordUpdate(body)
                 call.enqueue(object : Callback<UserUpdateRequest> {
                     override fun onResponse(
                         call: Call<UserUpdateResponse>,
                         response: Response<UserUpdateResponse>
                     )
                        {
                    if (response.isSuccessful) {
                    val UserUpdateResponse = response.body()
                        key = "token"
                        value = UserUpdateResponse?.token!!
                        saveOnCache(applicationContext, key, value)

                    val intentList = Intent(applicationContext, UserUpdate::class.java)
                        intent.putExtra("name", UserUpdateResponse?.name!!)
                        intent.putExtra("email", tv_email.text.toString())
                        startActivity(intentList)
                } else {
                    // Manejar el error de respuesta
                    Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()
                }
                        }
                override fun onFailure(call: Call<UserUpdateResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()

                }

                })
        }*/
}
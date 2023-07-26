package com.example.cursoandroidapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatCallback
import com.google.android.material.textfield.TextInputEditText
import retrofit2.Call
import retrofit2.Response

class ChangePassword : AppCompatActivity() {
    lateinit var tiet_password : TextInputEditText
    lateinit var tiet_confirm_password : TextInputEditText
    lateinit var btn_change : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)


        tiet_password = findViewById(R.id.idChange_Password)
        tiet_confirm_password = findViewById(R.id.idChange_Confirm_Password)
        btn_change = findViewById(R.id.idChange_Button)

        btn_change.setOnClickListener {
            changePassword()
        }
    }

        fun readCache(context: Context, key: String): String? {
            val  sharedPreferences = context.getSharedPreferences("cache", Context.MODE_PRIVATE)
            return sharedPreferences.getString(key,null)
       }


        fun changePassword(){
            val apiService = ApiClient.getClient()

            val token = readCache(this,"token").toString()

            val  body : ChangePasswordRequest = ChangePasswordRequest(token, tiet_password.text.toString())

            val call = apiService.passwordUpdate(body)
            call.enqueue(object : retrofit2.Callback<ChangePasswordResponse> {
                override fun onResponse(
                    call: Call<ChangePasswordResponse>,
                    response: Response<ChangePasswordResponse>
                )  {
                    if (response.isSuccessful) {
                        val userResponse = response.body()
                        Toast.makeText(applicationContext, "Proceso completado con éxito", Toast.LENGTH_LONG).show()
                        Toast.makeText(applicationContext, userResponse?.name!!, Toast.LENGTH_LONG).show()
                    }else{
                        // Manejar el error de respuesta
                        Toast.makeText(applicationContext, "Error de red", Toast.LENGTH_LONG).show()
                    }
                }
                override fun onFailure(call: Call<ChangePasswordResponse>, t: Throwable) {
                    Toast.makeText(applicationContext,"Error de red", Toast.LENGTH_LONG).show()
                }

            } )
        }

}

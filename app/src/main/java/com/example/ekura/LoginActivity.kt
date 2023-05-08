package com.example.ekura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    private lateinit var EditEmail :EditText
    private lateinit var EditPass :EditText
    private lateinit var ButtonLogin :Button
    private lateinit var TextRegister :TextView
    private lateinit var IvLogin :ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EditEmail=findViewById(R.id.edt_email_login)
        EditPass=findViewById(R.id.edt_pass_login)
        ButtonLogin=findViewById(R.id.btn_login)
        TextRegister=findViewById(R.id.txt_reg_login)
        IvLogin = findViewById(R.id.iv_login)
    }
}
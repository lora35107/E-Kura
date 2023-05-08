package com.example.ekura

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView

class RegisterActivity : AppCompatActivity() {
    private lateinit var NameEdit :EditText
    private lateinit var EmailEdit :EditText
    private lateinit var PassEdit :EditText
    private lateinit var RegButton :EditText
    private lateinit var LoginText :EditText
    private lateinit var ivReg :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        NameEdit = findViewById(R.id.edt_name_reg)
        EmailEdit = findViewById(R.id.edt_email_reg)
        PassEdit = findViewById(R.id.edt_pass_reg)
        RegButton = findViewById(R.id.btn_register)
        LoginText = findViewById(R.id.txt_login_reg )
        ivReg = findViewById(R.id.iv_register)
    }
}
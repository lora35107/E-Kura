package com.example.ekura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var EditEmail :EditText
    private lateinit var EditPass :EditText
    private lateinit var ButtonLogin :Button
    private lateinit var TextRegister :TextView
    private lateinit var IvLogin :ImageView

    //Initialise firebase
    private lateinit var Auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        EditEmail=findViewById(R.id.edt_email_login)
        EditPass=findViewById(R.id.edt_pass_login)
        ButtonLogin=findViewById(R.id.btn_login)
        TextRegister=findViewById(R.id.txt_reg_login)
        IvLogin = findViewById(R.id.iv_login)

        // Initialise firebase again
        Auth = FirebaseAuth.getInstance()

        ButtonLogin.setOnClickListener {
            val email = EditEmail.text.toString().trim()
            val password = EditPass.text.toString().trim()

            //validate input
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "One of the fields is empty :(", Toast.LENGTH_SHORT).show()
            }else{
                Auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                    if (it.isSuccessful){
                        Toast.makeText(this, "Login success :)", Toast.LENGTH_SHORT).show()

                        val goToMain = Intent(this,MainActivity::class.java)
                        startActivity(goToMain)
                        finish()
                    }else {
                        Toast.makeText(this, "Login Failed :(", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        TextRegister.setOnClickListener {
            val gotoreg = Intent(this,RegisterActivity::class.java)
            startActivity(gotoreg)
            finish()

        }
    }


    }

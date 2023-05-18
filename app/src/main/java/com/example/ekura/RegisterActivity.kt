package com.example.ekura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var NameEdit :EditText
    private lateinit var EmailEdit :EditText
    private lateinit var PassEdit :EditText
    private lateinit var RegButton :Button
    private lateinit var LoginText :TextView
    private lateinit var ivReg :ImageView

    //Initialise firebase
    private lateinit var Auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        NameEdit = findViewById(R.id.edt_name_reg)
        EmailEdit = findViewById(R.id.edt_email_reg)
        PassEdit = findViewById(R.id.edt_pass_reg)
        RegButton = findViewById(R.id.btn_register)
        LoginText = findViewById(R.id.txt_login_reg)
        ivReg = findViewById(R.id.iv_register)

        // Initialise firebase again
        Auth = FirebaseAuth.getInstance()

        RegButton.setOnClickListener {
            val name = NameEdit.text.toString().trim()
            val email = EmailEdit.text.toString().trim()
            val password = PassEdit.text.toString().trim()

            //Validate inputs
            if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the fields is empty :(", Toast.LENGTH_SHORT).show()
            } else {
                //Create a user in firebase
                Auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User created Successfully!", Toast.LENGTH_SHORT).show()

                        val gotologin = Intent(this,LoginActivity::class.java)
                        startActivity(gotologin)
                        finish()

                    } else {
                        Toast.makeText(this, "Failed to create Account", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}

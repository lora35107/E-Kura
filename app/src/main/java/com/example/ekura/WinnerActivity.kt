package com.example.ekura

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class WinnerActivity : AppCompatActivity() {
    private lateinit var preWinner : TextView
    private lateinit var winner :TextView
    private lateinit var ivwinner : ImageView
    private lateinit var exitButton :Button
    private lateinit var backButton: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winner)

        preWinner = findViewById(R.id.txt_prewinner)
        winner = findViewById(R.id.txt_winner)
        exitButton = findViewById(R.id.btn_exit)
        backButton = findViewById(R.id.btn_voteagain)
        ivwinner = findViewById(R.id.iv_Winner)

        exitButton.setOnClickListener {
            Toast.makeText(this, "Byeeee <3", Toast.LENGTH_SHORT).show()
        }


    }
}
package com.example.ekura

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi

class VoteTest : AppCompatActivity() {
    private lateinit var image1 :ImageView
    private lateinit var image2 :ImageView
    private lateinit var txt1:TextView
    private lateinit var txt2:TextView
    private lateinit var btn1:Button
    private lateinit var btn2:Button

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vote_test)

        image1 = findViewById(R.id.imgFirst)
        image2 = findViewById(R.id.imgSecond)
        txt1 = findViewById(R.id.txtFirst)
        txt2 = findViewById(R.id.txtSecond)
        btn1 = findViewById(R.id.btnFirst)
        btn2 = findViewById(R.id.btnSecond)





        btn1.setOnClickListener {
            val scoreFirst = txt1.toString().trim() + 1
            txt1.text =scoreFirst.toString()

        }

        btn2.setOnClickListener {
            val scoreSecond = txt2.toString().trim() + 1
            txt2.text = scoreSecond.toString()

        }
    }
}
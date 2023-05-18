package com.example.ekura

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class VoteTest : AppCompatActivity() {
    private lateinit var image1 :ImageView
    private lateinit var image2 :ImageView
    private lateinit var txt1:TextView
    private lateinit var txt2:TextView
    private lateinit var btn1:Button
    private lateinit var btn2:Button
    private var clickCount1 = 0
    private var clickCount2 = 0

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

        //This is the code you will put to generate a new id for each person
        //I'm so proud of you you are doing so well!:)
//        View.generateViewId()

        btn1.setOnClickListener {

            //To increase the number in the TextView after the button has been clicked
            clickCount1++

            //To display the votes in the TextView
            txt1.text = clickCount1.toString().trim()
            Toast.makeText(this, "You have voted for the kitten!", Toast.LENGTH_SHORT).show()

            //To make sure the user can only vote once
            btn1.isEnabled = false
            btn1.isClickable=false

            //To make sure you can't vote for both
            btn2.isEnabled =false
           btn2.isClickable=false

        }
         btn2.setOnClickListener {

             //To increase the number in the TextView after the button has been clicked
             clickCount2++

             //To display the votes in the TextView
             txt2.text = clickCount2.toString().trim()
             Toast.makeText(this, "You have voted for the puppy!", Toast.LENGTH_SHORT).show()

             //To make sure the user can only vote once
             btn2.isEnabled =false
             btn2.isClickable=false

             //To make sure you can't vote for both
             btn1.isEnabled =false
             btn1.isClickable=false
         }
        }
    }

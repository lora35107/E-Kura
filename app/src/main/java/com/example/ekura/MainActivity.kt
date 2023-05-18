package com.example.ekura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var voterButton: Button
    private lateinit var candidateButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        voterButton= findViewById(R.id.btn_voter)
        candidateButton = findViewById(R.id.btn_candidate)

        candidateButton.setOnClickListener {
            val gotocand = Intent(this,CandidateActivity::class.java)
            startActivity(gotocand)
            finish()

        }
        voterButton.setOnClickListener {
            val gotovoter = Intent(this,VoteTest::class.java)
            startActivity(gotovoter)
            finish()

        }
    }
}
package com.example.ekura

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.Timer
import java.util.TimerTask

class SplashScreen : AppCompatActivity() {
    private lateinit var timer: Timer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        timer= Timer()
        timer.schedule(object : TimerTask(){
            override fun run(){
                val intent = Intent(this@SplashScreen,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, 3000)



    }
}

//private fun Timer.schedule(timerTask: TimerTask) {



private fun Timer.schedule(timerTask: TimerTask, function: () -> Unit) {

}

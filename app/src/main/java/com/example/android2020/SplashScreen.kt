package com.example.android2020

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val myThread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(2500)
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                    finish()

                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }
        myThread.start()
    }
}
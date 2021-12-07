package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationView

class MainActivity  : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                val intent = Intent(this,WelcomeSignup::class.java)
                startActivity(intent)
            },3000)
        }


    }
}
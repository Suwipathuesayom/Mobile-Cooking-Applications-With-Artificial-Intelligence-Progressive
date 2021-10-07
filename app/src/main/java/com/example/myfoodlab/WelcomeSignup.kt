package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class WelcomeSignup : AppCompatActivity() {

    lateinit var signUp: ConstraintLayout
    lateinit var textlogin : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_signup)

        //ปุ่ม SignUp เข้าหน้า SignUp
        signUp = findViewById<ConstraintLayout>(R.id.signupwelcome)
        signUp!!.setOnClickListener {
            val gotosignup = Intent(this, SignUp::class.java)
            startActivity(gotosignup)
        }

        //ปุ่ม Login TextView เข้าหน้า Login
        textlogin = findViewById<TextView>(R.id.textlogin)
        textlogin!!.setOnClickListener{
            val gotologin = Intent(this, Login::class.java)
            startActivity(gotologin)
        }


    }
}



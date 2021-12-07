package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout

class WelcomeSignup : AppCompatActivity() {

    lateinit var layout_constraint_SignUpWelcome: ConstraintLayout
    lateinit var txtLogin_Welcome: TextView
    lateinit var txtSkip_Welcome: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_signup)

        //ปุ่ม SignUp เข้าหน้า SignUp
        layout_constraint_SignUpWelcome = findViewById<ConstraintLayout>(R.id.layout_constraint_SignUpWelcome)
        layout_constraint_SignUpWelcome.setOnClickListener {
            val gotoSignup = Intent(this, SignUp::class.java)
            startActivity(gotoSignup)
        }

        //ปุ่ม Login TextView เข้าหน้า Login
        txtLogin_Welcome = findViewById<TextView>(R.id.txtLoginWelcome)
        txtLogin_Welcome.setOnClickListener {
            val gotoLogin = Intent(this, Login::class.java)
            startActivity(gotoLogin)
        }

        // ปุ่ม Skip เข้าหน้า MainMenu
        txtSkip_Welcome = findViewById<TextView>(R.id.txtSkip_Welcome)
        txtSkip_Welcome.setOnClickListener {
            val gotoMainMenu = Intent(this, MainMenu::class.java)
            startActivity(gotoMainMenu)
        }

    }
}



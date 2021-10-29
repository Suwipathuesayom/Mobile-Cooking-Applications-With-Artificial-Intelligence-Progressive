package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class Login: AppCompatActivity() {
    lateinit var txtSkip_Login: TextView
    lateinit var txtSignUp: TextView
    lateinit var txtForgotPassword: TextView
    lateinit var layout_constraint_Facebook: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //กดปุ่มforgetpassword ไปหน้ายัง forgetpassword
        txtForgotPassword = findViewById<TextView>(R.id.txtForgotPassword)
        txtForgotPassword!!.setOnClickListener {
            val gotoForgotPassword = Intent(this, ForgotPassword::class.java)
            startActivity(gotoForgotPassword)
        }

        //กดปุ่มsignup ไปยังหน้า login
        txtSignUp = findViewById<TextView>(R.id.txtSignUp)
        txtSignUp!!.setOnClickListener {
            val gotologin = Intent(this, SignUp::class.java)
            startActivity(gotologin)
        }

        txtSkip_Login = findViewById<TextView>(R.id.txtSignUp)
        txtSkip_Login!!.setOnClickListener {
            val gotoMainMenu = Intent(this, MainMenu::class.java)
            startActivity(gotoMainMenu)
        }
        layout_constraint_Facebook = findViewById<ConstraintLayout>(R.id.layout_constraint_Facebook)
        layout_constraint_Facebook!!.setOnClickListener {
            val gotoFilterSelect = Intent(this, FilterSelect::class.java)
            startActivity(gotoFilterSelect)
        }
    }
}




package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout


class Login: AppCompatActivity() {
    lateinit var textsignup: TextView
    lateinit var textView10 : TextView

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //กดปุ่มforgetpassword ไปหน้ายัง forgetpassword
        textView10= findViewById<TextView>(R.id.textView10)
        textView10!!.setOnClickListener{
            val gotologin = Intent(this, Forgotpassword::class.java)
            startActivity(gotologin)
        }

        //กดปุ่มsignup ไปยังหน้า login
        textsignup= findViewById<TextView>(R.id.textsignup)
        textsignup!!.setOnClickListener{
            val gotologin = Intent(this, SignUp::class.java)
            startActivity(gotologin)
        }
    }
}




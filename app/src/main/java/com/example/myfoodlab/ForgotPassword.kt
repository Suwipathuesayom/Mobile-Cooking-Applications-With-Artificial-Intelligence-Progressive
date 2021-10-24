package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class Forgotpassword : AppCompatActivity() {

    lateinit var resetpassword: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)


        //ปุ่มกดresetpassword ไปยังหน้า confirmpassword
        resetpassword = findViewById<ConstraintLayout>(R.id.resetpassword)
        resetpassword!!.setOnClickListener {
            val gotosignup = Intent(this, Confirmpassword::class.java)
            startActivity(gotosignup)
        }

    }
}
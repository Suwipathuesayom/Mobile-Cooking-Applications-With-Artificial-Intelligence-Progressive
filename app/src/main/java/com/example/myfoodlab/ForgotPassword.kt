package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth

class ForgotPassword : AppCompatActivity() {

    lateinit var txtEmailForget : EditText
    lateinit var layout_constraint_Reset : ConstraintLayout
    lateinit var mAuth: FirebaseAuth
    lateinit var txtSkip_Forgot : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        mAuth = FirebaseAuth.getInstance()

        layout_constraint_Reset = findViewById<ConstraintLayout>(R.id.layout_constraint_Reset)
        txtEmailForget = findViewById<EditText>(R.id.txtEmailForget)
        txtSkip_Forgot = findViewById <TextView>(R.id.txtSkip_Forgot)


        txtSkip_Forgot.setOnClickListener {
            val gotoMainMenu = Intent(this, MainMenu::class.java)
            startActivity(gotoMainMenu)
        }

        layout_constraint_Reset.setOnClickListener {
            var email = txtEmailForget.text.toString()
            if(TextUtils.isEmpty(email)){
                txtEmailForget.error = "Please Enter your Email"
                Toast.makeText(applicationContext,"Please Enter your Email", Toast.LENGTH_SHORT).show()
            }else{
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener{
                        task -> if (task.isSuccessful) {
                    Toast.makeText(this@ForgotPassword,"Please Check your Email", Toast.LENGTH_SHORT).show()

                }else{
                    txtEmailForget.error = "Fail to send reset password email"
                    Toast.makeText(this@ForgotPassword,"Fail to send reset password email", Toast.LENGTH_SHORT).show()

                }


                }

            }



        }


    }
}
package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.EditText
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class ForgotPassword : AppCompatActivity() {
    lateinit var txtEmailForget:EditText
    lateinit var buttonReset : ConstraintLayout
    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgotpassword)
        mAuth = FirebaseAuth.getInstance()

        buttonReset = findViewById<ConstraintLayout>(R.id.buttonReset)
        txtEmailForget = findViewById<EditText>(R.id.txtEmailCreate)

        buttonReset!!.setOnClickListener {
            var email = txtEmailForget.text.toString()
            if(TextUtils.isEmpty(email)){
                txtEmailForget.error = "Please Enter your Email"
                Toast.makeText(applicationContext,"Please Enter your Email",Toast.LENGTH_SHORT).show()
            }else{
                mAuth!!.sendPasswordResetEmail(email).addOnCompleteListener{
                        task -> if (task.isSuccessful) {
                    txtEmailForget.error = "Please Check your Email"
                    Toast.makeText(this@ForgotPassword,"Please Check your Email",Toast.LENGTH_SHORT).show()

                }else{
                    txtEmailForget.error = "Fail to send reset password email"
                    Toast.makeText(this@ForgotPassword,"Fail to send reset password email",Toast.LENGTH_SHORT).show()

                }


                }

            }



        }


    }
}
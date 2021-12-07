package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myfoodlab.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class Login: AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    lateinit var txtEmailAddress: EditText
    lateinit var txtPassword: EditText
    lateinit var layout_constraint_Login: ConstraintLayout
    lateinit var txtSignUp: TextView
    lateinit var email: String
    lateinit var password: String
    lateinit var txtForgotPassword: TextView
    lateinit var layout_constraint_Facebook: ConstraintLayout
    lateinit var layout_constraint_Google: ConstraintLayout
    lateinit var txtSkip_Login : TextView

    private lateinit var mAuth: FirebaseAuth





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtEmailAddress = findViewById<EditText>(R.id.txtEmailAddress)
        txtPassword = findViewById<EditText>(R.id.txtPassword)
        layout_constraint_Login = findViewById <ConstraintLayout>(R.id.layout_constraint_Login)
        txtSignUp = findViewById<TextView>(R.id.txtSignUp)
        txtForgotPassword =  findViewById<TextView>(R.id.txtForgotPassword)
        layout_constraint_Google = findViewById<ConstraintLayout>(R.id.layout_constraint_Google)
        txtSkip_Login = findViewById <TextView>(R.id.txtSkip_Login)

        mAuth = FirebaseAuth.getInstance()



        //เปลี่ยนหน้าไปหน้าสมัคร
        txtSignUp.setOnClickListener {

            val intent = Intent(this,SignUp::class.java)
            startActivity(intent)
        }



        txtForgotPassword.setOnClickListener{
            val gotoForget = Intent(this,ForgotPassword::class.java)
            startActivity(gotoForget)
        }

        layout_constraint_Login.setOnClickListener {
            validateData()
           /* val gotoMainMenu = Intent(this,MainMenu::class.java)
            startActivity(gotoMainMenu)*/
        }

        txtSkip_Login.setOnClickListener {
            val gotoMainMenu = Intent(this,MainMenu::class.java)
            startActivity(gotoMainMenu)
        }



    }

    override fun onStart(){
        super.onStart()
        val currentUser = mAuth.currentUser
        updateUI(currentUser)


    }

    private fun validateData() {

        //get data
        email = binding.txtEmailAddress.text.toString().trim()
        password = binding.txtPassword.text.toString().trim()

        //validate data
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            //invalid email format
            binding.txtEmailAddress.error = "Invalid email format"
        }
        else if (TextUtils.isEmpty(password)){
            //no password entered
            binding.txtPassword.error = "Please enter password"
        }
        else{
            //data is validate, begin login
            loginEmail()

        }


    }

    private fun loginEmail() {
        email = txtEmailAddress.text.toString()
        password = txtPassword.text.toString()

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                task -> if (task.isSuccessful){
            Log.d("My App","Create New User Success!")
            val user = mAuth.currentUser
            updateUI(user)
        }
        else{
            binding.txtPassword.error = "Invalid password format"
            Log.w("MyApp","Failure Process!",task.exception)
            Toast.makeText(this@Login,"Authentication Failed.", Toast.LENGTH_SHORT).show()
            updateUI(null)
        }

        }


    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            val uid = user.uid
            val email = user.email
            Toast.makeText(this@Login,"Welcome: $email your ID is: $uid", Toast.LENGTH_SHORT).show()
            val intenSession = Intent(this, MainMenu::class.java)
            startActivity(intenSession)
        }
    }


}





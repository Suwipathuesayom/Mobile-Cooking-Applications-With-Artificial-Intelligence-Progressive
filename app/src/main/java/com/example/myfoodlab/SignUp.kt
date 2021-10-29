package com.example.myfoodlab

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    /*lateinit var txtUsernameCreate: EditText
    lateinit var txtEmailCreate: EditText
    lateinit var txtPasswordCreate:EditText
    lateinit var layout_constraint_Submit: ConstraintLayout

    lateinit var email: String
    lateinit var password: String

    lateinit var mAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        /*txtEmailCreate = findViewById<EditText>(R.id.txtEmailCreate)
        txtPasswordCreate = findViewById<EditText>(R.id.txtPasswordCreate)
        layout_constraint_Submit = findViewById<ConstraintLayout>(R.id.layout_constraint_Submit)
        txtUsernameCreate = findViewById<EditText>(R.id.txtUsernameCreate)


        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance()


        layout_constraint_Submit.setOnClickListener {
            createAccount()

        }
    }


    override fun onStart(){
        super.onStart()
        val currentUser = mAuth.currentUser
        updateUI(currentUser)

    }


    private fun createAccount() {
        email = txtEmailCreate.text.toString()
        password = txtPasswordCreate.text.toString()
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) { task -> if (task.isSuccessful){
            Log.d("My App","Create New User Success!")
            val user = mAuth.currentUser
            val databaseReference = database.reference.child("users").push()
            databaseReference.child("uid").setValue(user!!.uid)
            databaseReference.child("password").setValue(user.email)
            //databaseReference.child("Username").setValue(txtUsernameCreate.text.toString()
            //updateUI(user)
        }
        else{
            Log.w("MyApp","Failure Process!",task.exception)
            Toast.makeText(this@SignUp,"Authentication Failed.", Toast.LENGTH_SHORT).show()
            updateUI(null)
        }

        }

    }



    private fun updateUI(user: FirebaseUser?) {
        if (user != null){
            val uid = user.uid
            val email = user.email
            Toast.makeText(this@SignUp,"Welcome: $email your ID is: $uid", Toast.LENGTH_SHORT).show()
            val intenSession = Intent(this, ListActivity::class.java)
            startActivity(intenSession)
        }*/
    }

}


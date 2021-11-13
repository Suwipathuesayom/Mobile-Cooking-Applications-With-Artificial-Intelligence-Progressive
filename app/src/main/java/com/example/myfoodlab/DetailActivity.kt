package com.example.myfoodlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    lateinit var txtDetailtitle:TextView
    lateinit var imageViewDetail: ImageView
    lateinit var txtCardDetail:TextView
    lateinit var mAuth: FirebaseAuth
    private lateinit var database: FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        txtDetailtitle = findViewById(R.id.textDetailtitle)
        imageViewDetail = findViewById(R.id.imageViewDetail)
        txtCardDetail = findViewById(R.id.txtCardDetail)

        mAuth = FirebaseAuth.getInstance()
        database = FirebaseDatabase.getInstance("https://foodapp-f4fe4-default-rtdb.asia-southeast1.firebasedatabase.app")

        val intent = intent
        var getKey = intent.getStringExtra("Key")


        var databaseReference = database.getReference("Card/$getKey")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                txtDetailtitle.text = snapshot.child("title").value.toString()
                txtCardDetail.text = snapshot.child("detail").value.toString()
                Picasso.get().load(snapshot.child("image").value.toString())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(imageViewDetail)
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
    }
}
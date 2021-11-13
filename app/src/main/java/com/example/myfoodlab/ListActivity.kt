package com.example.myfoodlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.MobileAds
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class ListActivity : AppCompatActivity() {

    lateinit var recyclerViewCard: RecyclerView
    lateinit var mAuth: FirebaseAuth
    lateinit var database: FirebaseDatabase
    lateinit var databaseReferenceCard: DatabaseReference
    lateinit var responseCard: MutableList<CardModel>
    private var cardAdapter: CardAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        MobileAds.initialize(this) {}


        recyclerViewCard = findViewById<RecyclerView>(R.id.recyclerViewCard)

        //ส่วนของ FirebaseAuth
        mAuth = FirebaseAuth.getInstance()
        //ส่วนของ FirebaseDatabase
        database = FirebaseDatabase.getInstance("https://foodapp-f4fe4-default-rtdb.asia-southeast1.firebasedatabase.app/")


       //การ์ด
        recyclerViewCard.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        databaseReferenceCard = database.getReference("Card/")
        responseCard = mutableListOf()
        cardAdapter = CardAdapter(responseCard as ArrayList<CardModel>)
        recyclerViewCard.adapter = cardAdapter
        onBindingFirebase()
    }

    private fun onBindingFirebase() {
        databaseReferenceCard.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                responseCard.add(snapshot.getValue(CardModel::class.java)!!)
                cardAdapter!!.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }


    override fun onStart() {
        super.onStart()
        val currentUser = mAuth.currentUser
        updateUI(currentUser)

    }


    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            val uid = user.uid
            val email = user.email
            Toast.makeText(
                this@ListActivity,
                "Welcome: $email your ID is: $uid",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            val intenSession = Intent(this, Login::class.java)
            startActivity(intenSession)
        }
    }


}
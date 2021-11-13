package com.example.myfoodlab

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CardAdapter (val cardList: List<CardModel>): RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.itemhorizontal, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = cardList[position]
        holder.txtTitleItem.text = dataModel.title
        Picasso.get().load(dataModel.image)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(holder.imageview)
        holder.cardview.setOnClickListener (View.OnClickListener{ view ->
            val readActivity = Intent(view.context,DetailActivity::class.java)
            readActivity.putExtra("Key",dataModel.key)
            view.context.startActivity(readActivity)
            Log.d("Trip Planner",dataModel.title.toString())
        })
    }

    override fun getItemCount(): Int {
        return cardList.size
    }

}

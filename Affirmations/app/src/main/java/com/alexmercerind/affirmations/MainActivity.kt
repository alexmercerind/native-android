package com.alexmercerind.affirmations

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView

class ItemAdapter(var context: Context, var affirmations: Array<String>, var images: Array<Int>) : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {
    class ItemHolder(var view: View): RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.ListTileImageView)
        val textView: TextView = view.findViewById(R.id.ListTileTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_tile, parent, false)
        return ItemHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.imageView.setImageResource(images[position])
        holder.textView.text = affirmations[position]
    }

    override fun getItemCount(): Int {
        return affirmations.size
    }
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerView.adapter = ItemAdapter(
            this,
            resources.getStringArray(R.array.affirmations),
            arrayOf<Int>(
                R.drawable.image1,
                R.drawable.image2,
                R.drawable.image3,
                R.drawable.image4,
                R.drawable.image5,
                R.drawable.image6,
                R.drawable.image7,
                R.drawable.image8,
                R.drawable.image9,
                R.drawable.image10
            )
        )
    }
}

package com.example.ailottecompany

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailsActivity : AppCompatActivity() {
    private var titles: String? = null
    private var image: String? = null
    private var summary: String? = null
    private var newsSite: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        if (intent != null) {
            titles = intent.extras!!.getString("title")
            image = intent.extras!!.getString("img")
            summary = intent.extras!!.getString("summary")
            newsSite = intent.extras!!.getString("news")
        }

        var title = findViewById<TextView>(R.id.title)
        var newsite = findViewById<TextView>(R.id.newSite)
        var summry = findViewById<TextView>(R.id.summary)
        var img = findViewById<ImageView>(R.id.imageView)

        title.text = titles
        summry.text = summary
        newsite.text = newsSite

        Glide
            .with(this)
            .load(image)
            .into(img)

        }
}
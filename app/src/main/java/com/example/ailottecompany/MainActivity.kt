package com.example.ailottecompany

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ailottecompany.data.network.NewsInteface

class MainActivity : AppCompatActivity() {
    private lateinit var factory: NewsViewModelFactory
    private lateinit var viewModel: NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = NewsInteface()
        val repository = NewsRepository(api)
        val recycler_view_news = findViewById<RecyclerView>(R.id.recycler_view_news)

        factory = NewsViewModelFactory(repository)
        viewModel = ViewModelProviders.of(this, factory).get(NewsViewModel::class.java)

        viewModel.getNews()

        viewModel.news.observe(this, Observer { news ->
            recycler_view_news.also {
                it.layoutManager = LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter = NewsAdapter(this,news)
            }
        })
    }
}
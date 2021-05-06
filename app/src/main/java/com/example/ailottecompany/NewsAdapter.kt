package com.example.ailottecompany

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.ailottecompany.data.model.NewsApus


class NewsAdapter( var context: Context,var getdetails: List<NewsApus>?): RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    private var view: View? = null
    private var status: TextView? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        view = LayoutInflater.from(context).inflate(R.layout.recyclerview_news, parent, false)
        return ViewHolder(view!!)
    }

    override fun getItemCount(): Int {
        return getdetails!!.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = ""+getdetails!!.get(position).title
        holder.desc.text = ""+getdetails!!.get(position).summary

        holder.card.setOnClickListener {
            val i = Intent(context,DetailsActivity::class.java)
            i.putExtra("title",""+getdetails!![position].title)
            i.putExtra("news",""+getdetails!![position].newsSite)
            i.putExtra("img",""+getdetails!![position].imageUrl)
            i.putExtra("summary",""+getdetails!![position].summary)
            i.flags = FLAG_ACTIVITY_NEW_TASK
            context.startActivity(i)
        }



    }

    class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        internal var title: TextView
        internal var desc: TextView
        internal var card: CardView


        init {
            title = itemView.findViewById(R.id.name)
            desc = itemView.findViewById(R.id.details)
            card = itemView.findViewById(R.id.cardvw)

        }
    }





    }

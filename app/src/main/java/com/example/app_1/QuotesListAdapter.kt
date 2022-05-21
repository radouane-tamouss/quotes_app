package com.example.app_1

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class QuotesListAdapter (val context: Context, val list: List<QuotesResponse>): RecyclerView.Adapter<QuotesViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): QuotesViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.list_quotes,p0, false)
        return QuotesViewHolder(layout)
    }

    override fun onBindViewHolder(p0: QuotesViewHolder, p1: Int) {
        p0.textView_quote.text = list.get(p1).requester_name
        p0.textView_author.text = list.get(p1).request_id

    }

    override fun getItemCount(): Int {
        return list.size
    }

}

class QuotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var textView_quote: TextView = itemView.findViewById(R.id.textView_quote)
    var textView_author: TextView = itemView.findViewById(R.id.textView_author)
    var buttonCopy: Button = itemView.findViewById(R.id.button_copy)
}

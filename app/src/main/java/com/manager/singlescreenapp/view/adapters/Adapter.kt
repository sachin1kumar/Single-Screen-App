package com.manager.singlescreenapp.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.manager.singlescreenapp.R
import com.manager.singlescreenapp.model.Author


class Adapter(private val list: List<Author>?) :
    RecyclerView.Adapter<Adapter.RecViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.trending_parent, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        val author = list!![position]
        holder.bind(author)
        holder.itemView.setOnClickListener { v: View? ->
            val expanded: Boolean = author.isExpanded
            author.isExpanded = !expanded
            notifyItemChanged(position)
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    inner class RecViewHolder(itemView: View) : ViewHolder(itemView) {
        private val name: TextView
        private val type: TextView
        private val url: TextView
        private val lang: TextView
        private val stars: TextView
        private val forks: TextView
        private val subItem: View
        private val seperator: View

        fun bind(author: Author) {
            val expanded: Boolean = author.isExpanded
            subItem.visibility = if (expanded) View.VISIBLE else View.GONE
            seperator.visibility = if (expanded) View.GONE else View.VISIBLE
            name.text = author.author
            type.text = author.name
            url.text = author.url
            lang.text = author.language
            stars.text = author.stars
            forks.text = author.forks
        }

        init {
            name = itemView.findViewById(R.id.name)
            type = itemView.findViewById(R.id.type)
            url = itemView.findViewById(R.id.url)
            lang = itemView.findViewById(R.id.language)
            stars = itemView.findViewById(R.id.star_count)
            forks = itemView.findViewById(R.id.fork)
            subItem = itemView.findViewById(R.id.child)
            seperator = itemView.findViewById(R.id.seperator)
        }
    }

}
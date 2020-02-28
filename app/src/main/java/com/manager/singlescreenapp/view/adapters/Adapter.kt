package com.manager.singlescreenapp.view.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.manager.singlescreenapp.R
import com.manager.singlescreenapp.model.Author
import de.hdodenhof.circleimageview.CircleImageView

class Adapter(
    private val list: List<Author>?,
    private val context: Context
) :
    RecyclerView.Adapter<Adapter.RecViewHolder>() {

    private var mExpandedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.trending_parent, parent, false)
        return RecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecViewHolder, position: Int) {
        val author = list!![position]
        author.isExpanded = position == mExpandedPosition
        holder.bind(author)
        holder.itemView.setOnClickListener {
            mExpandedPosition = if (author.isExpanded) -1 else position
            notifyDataSetChanged()
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
        private val image: CircleImageView
        private val dot: ImageView

        fun bind(author: Author) {
            subItem.visibility = if (author.isExpanded) View.VISIBLE else View.GONE
            seperator.visibility = if (author.isExpanded) View.GONE else View.VISIBLE
            name.text = author.author
            type.text = author.name
            url.text = author.url
            lang.text = author.language
            stars.text = author.stars
            forks.text = author.forks
            if (author.languageColor!=null) {
                dot.setColorFilter(Color.parseColor(author.languageColor))
            }
            Glide.with(context)
                .load(author.avatar)
                .placeholder(R.drawable.circular_view)
                .into(image)
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
            image = itemView.findViewById(R.id.image)
            dot = itemView.findViewById(R.id.dot)
        }
    }

}
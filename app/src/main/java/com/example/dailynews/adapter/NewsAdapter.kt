package com.example.dailynews.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailynews.Article
import com.example.dailynews.News
import com.example.dailynews.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_snipet.view.*

class NewsAdapter(var data: News?) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    var onItemClick: ((id: Article) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.news_snipet, parent, false)
        return NewsViewHolder(item)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        data?.articles?.get(position)?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return data?.articles!!.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Article) = with(itemView) {
            tvHeadline.text = item.title
            tvNewsSource.text = item.source.name
            tvDate.text = getDate(item.publish_date)
            val IMGURL = item.img_url
            if (IMGURL == null) {
                ivNewsImage.setBackgroundResource(R.drawable.ig_splash_screen)
            } else {
                Picasso.get().load(IMGURL).into(ivNewsImage)
            }

            setOnClickListener {
                data?.articles?.get(adapterPosition)?.let { it1 ->
                    onItemClick?.invoke(it1)
                }
            }
        }
    }
}


fun getDate(str : String) : String{
    val year = str.substring(2,4)
    val mo = str.substring(5,7)
    val date = str.substring(8,10)
    val time = str.substring(11,16)

    val month = when(mo){
        "1" -> "Jan"
        "2" -> "Feb"
        "3" -> "Mar"
        "4" -> "Apr"
        "5" -> "May"
        "6" -> "Jun"
        "7" -> "Jul"
        "8" -> "Aug"
        "9" -> "Sep"
        "10" -> "Oct"
        "11" -> "Nov"
        "12" -> "Dec"
        else -> null
    }
    return "$date $month $year | $time"
}
package com.example.dailynews.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailynews.Network.ClientAPI
import com.example.dailynews.News
import com.example.dailynews.R
import com.example.dailynews.ShortNews
import com.example.dailynews.adapter.NewsAdapter
import com.example.dailynews.adapter.getDate
import kotlinx.android.synthetic.main.fragment_business_news.*
import kotlinx.android.synthetic.main.fragment_technolog_news.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TechnologNews : Fragment() {

    var adapter: NewsAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    )= inflater.inflate(R.layout.fragment_technolog_news, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        GlobalScope.launch(Dispatchers.Main) {
            val response = withContext(Dispatchers.IO) {
                ClientAPI.api.getTechnologyHeadline()
            }
            if (response.isSuccessful) {
                val news: News? = response.body()
                adapter = NewsAdapter(news)
                rvTechnologyNews.layoutManager = LinearLayoutManager(requireContext())
                rvTechnologyNews.adapter = adapter
            }

            adapter?.onItemClick = {
                Intent(requireContext(), ShortNews::class.java).also { it1->
                    it1.putExtra("ImageURl",it.img_url)
                    it1.putExtra("Category","Technology")
                    it1.putExtra("Date", getDate(it.publish_date))
                    it1.putExtra("Source",it.source.name)
                    it1.putExtra("Title",it.title)
                    it1.putExtra("Description",it.description)
                    it1.putExtra("URL",it.url)
                    startActivity(it1)
                }
            }

        }
    }
}
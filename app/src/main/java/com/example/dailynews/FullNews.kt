package com.example.dailynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.dailynews.Network.ClientAPI
import kotlinx.android.synthetic.main.activity_full_news.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FullNews : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_news)

        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.light_blue))


        tbFullNews.title = intent.getStringExtra("title")
        tbFullNews.setNavigationOnClickListener {
            onBackPressed()
        }

        GlobalScope.launch(Dispatchers.Main){
            wvArticle.webViewClient =object  : WebViewClient(){
                override fun shouldOverrideUrlLoading(view: WebView?, url1: String?): Boolean {
                    view?.loadUrl(url1!!)
                    return true
                }
            }
            wvArticle.loadUrl(intent.getStringExtra("link")!!)
        }
    }
}
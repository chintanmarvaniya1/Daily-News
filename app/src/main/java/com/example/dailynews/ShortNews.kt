package com.example.dailynews

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_short_news.*
import kotlinx.android.synthetic.main.news_snipet.*

class ShortNews : AppCompatActivity() {

    var url :String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_short_news)

        supportActionBar?.hide()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        }

        val imgURL = intent.getStringExtra("ImageURl")
        if (imgURL == null) {
            ivNewsImage.setBackgroundResource(R.drawable.ig_splash_screen)
        } else {
            Picasso.get().load(imgURL).into(ivImage)
        }
        tvCategory.text = intent.getStringExtra("Category")
        tvDateOfPublish.text = intent.getStringExtra("Date")
        tvSource.text = intent.getStringExtra("Source")
        tvTitle.text = intent.getStringExtra("Title")
        tvDescription.text = intent.getStringExtra("Description")
        url = intent.getStringExtra("URL")

        /*tvFullNews.setOnClickListener{
            val intent = Intent(this, FullNews::class.java)
             intent.putExtra("link", url)
            intent.putExtra("title", tvCategory.text)
            startActivity(intent)
        }
         */

        clShortNews.setOnTouchListener(object : OnSwipeUp(this) {
            override fun onSwipeUp() {
                super.onSwipeUp()
                val intent = Intent(this@ShortNews, FullNews::class.java)
                intent.putExtra("link", url)
                intent.putExtra("title", tvCategory.text)
                startActivity(intent)
            }

        })

        fbShare.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, url)
            ContextCompat.startActivity(this, share, null)
        }
    }

}


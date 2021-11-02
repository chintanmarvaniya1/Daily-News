package com.example.dailynews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.dailynews.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.tab_layout.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.light_blue))

        fvFragmentContainer.adapter = ViewPagerAdapter(this.supportFragmentManager, lifecycle)
        TabLayoutMediator(tlMyTabLayout, fvFragmentContainer) { tab, position ->
            val id = intent.getIntExtra(("Id"), 0)
            when (position) {
                0 -> { tab.text = "Top Headlines" }
                1 -> { tab.text = "Business" }
                2 -> { tab.text = "Technology" }
                3 -> { tab.text = "Sport" }
                4 -> { tab.text = "Entertainment" }
            }
        }.attach()

    }
}
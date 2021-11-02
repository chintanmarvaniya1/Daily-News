package com.example.dailynews

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.light_blue))

        Handler().postDelayed({
            val intent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(intent)
            finish()
        },3000)


    }
}
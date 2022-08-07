package com.example.emptytesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        findViewById<Button>(R.id.btn_wv).setOnClickListener {
            val webViewActivity = Intent(this, WebViewActivity::class.java)
            startActivity(webViewActivity)
        }

    }
}
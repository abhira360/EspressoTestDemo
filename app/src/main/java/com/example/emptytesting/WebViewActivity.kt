package com.example.emptytesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.wv)
        webView.settings.javaScriptEnabled = true

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com/")


        webView.settings.supportZoom()

    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        }
        else {
            super.onBackPressed()
        }
    }
}
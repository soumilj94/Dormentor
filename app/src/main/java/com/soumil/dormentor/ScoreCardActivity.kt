package com.soumil.dormentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class ScoreCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_card)
        val url: String? = intent.getStringExtra("scoreCard_view")

        val webView = findViewById<WebView>(R.id.scoreCardWebView)
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url)
    }
}
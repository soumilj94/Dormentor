package com.soumil.dormentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class TimeTableViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time_table_view)

        val url: String? = intent.getStringExtra("pdf_url")

        val webView = findViewById<WebView>(R.id.pdfWebView)
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url)
    }
}
package com.soumil.dormentor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class AttendanceViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance_view)

        val url: String? = intent.getStringExtra("attendance_view")

        val webView = findViewById<WebView>(R.id.attendanceWebView)
        webView.webViewClient = WebViewClient()
        webView.settings.setSupportZoom(true)
        webView.settings.javaScriptEnabled
        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=" + url)
    }
}
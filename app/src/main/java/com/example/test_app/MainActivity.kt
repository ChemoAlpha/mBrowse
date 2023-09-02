package com.example.test_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var webView:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        webView = findViewById(R.id.webView)

        // Enable JavaScript (optional, if needed)
        val settings = webView.settings
        settings.javaScriptEnabled = true

        // Load "google.com" in the WebView
        webView.loadUrl("https://www.yandex.com/")

        // Set a WebViewClient to handle page navigation within the WebView
        webView.webViewClient = object : WebViewClient() {

        }
    }

    override fun onBackPressed() {
        // Check if the WebView can go back in its history
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            Toast.makeText(this,"Closing Browser Now",Toast.LENGTH_LONG).show()
            Thread.sleep(2000)
            super.onBackPressed()
        }
    }
}
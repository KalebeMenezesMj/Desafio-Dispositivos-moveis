package com.example.desafiodispositivosmoveis

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_activity)

        val webView = findViewById<WebView>(R.id.webView_destino)

        webView.settings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()

        val linkDestino = intent.getStringExtra("link")

        if (linkDestino != null) {
            webView.loadUrl(linkDestino)
        }
    }
}
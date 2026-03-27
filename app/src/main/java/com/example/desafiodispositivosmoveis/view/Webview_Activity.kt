package com.example.desafiodispositivosmoveis.view

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.desafiodispositivosmoveis.R

class Webview_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_activity)

        val webView = findViewById<WebView>(R.id.webView_destino)
        val btnVoltar = findViewById<Button>(R.id.btn_voltar_lista)

        val url = intent.getStringExtra("URL_DESTINO")

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true

        if (url != null) {
            webView.loadUrl(url)
        }

        btnVoltar.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        val webView = findViewById<WebView>(R.id.webView_destino)
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
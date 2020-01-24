package com.app.wastemanagementforkids.game;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wastemanagementforkids.R;

public class WebGame1Activity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_game1);

        webView = findViewById(R.id.webview_game1);

        // enter url
        webView.loadUrl("https://surrey.recycle.game/");

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setNetworkAvailable(true);

    }
}

package com.app.wastemanagementforkids.game;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class WebGame2Activity extends AppCompatActivity {
    WebView webView;
    Toolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_game2);
        materialToolbar = findViewById(R.id.webview_game2_toolbar);
        setSupportActionBar(materialToolbar);
        setTitle("Game");

        webView = findViewById(R.id.webview_game2);
        // enter url
        webView.loadUrl("https://cdn-factory.marketjs.com/en/paper-flick/index.html");

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setNetworkAvailable(true);


    }
}

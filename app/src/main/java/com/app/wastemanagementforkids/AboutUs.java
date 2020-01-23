package com.app.wastemanagementforkids;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AboutUs extends AppCompatActivity {
    Toolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        materialToolbar = findViewById(R.id.about_toolbar);
        setTitle("About Us");
        setSupportActionBar(materialToolbar);
        WebView webView = findViewById(R.id.about_webview);
        webView.loadUrl("file:///android_asset/about.html");
    }
}

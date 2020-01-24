package com.app.wastemanagementforkids.study;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class StudyActivity extends AppCompatActivity {
    Toolbar materialToolbar;
    String lang;
    WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        materialToolbar = findViewById(R.id.study_toolbar);
        lang = getIntent().getStringExtra("lang");
        setTitle("Study");
        setSupportActionBar(materialToolbar);
        webView = findViewById(R.id.study_webview);
        webView.setNetworkAvailable(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        if (lang.equals("English")) {
            webView.loadUrl("https://arjunjoshi.000webhostapp.com/Arjun/English/index.html");
        } else {
            webView.loadUrl("https://arjunjoshi.000webhostapp.com/Arjun/Gujarti/index.html");
        }
    }

}
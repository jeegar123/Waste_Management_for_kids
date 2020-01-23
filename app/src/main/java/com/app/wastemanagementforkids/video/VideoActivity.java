package com.app.wastemanagementforkids.video;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.MainActivity;
import com.app.wastemanagementforkids.R;
import com.valdesekamdem.library.mdtoast.MDToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
    public static int count = 0;
    WebView webView;
    Toolbar materialToolbar;
    ArrayList<String> arrayList;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        arrayList = new ArrayList<>();
        webView = findViewById(R.id.vide_webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient());
        new MyAssyncTask().execute();
        materialToolbar = findViewById(R.id.video_toolbar);
        setSupportActionBar(materialToolbar);
        setTitle("Videos");

        if (!isNetworkAvailable()) {
            MDToast.makeText(this, "please connect to internet", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR);
            startActivity(new Intent(VideoActivity.this, MainActivity.class));
            finish();
        }
    }

    public void next(View view) {
        if (count + 1 >= arrayList.size())
            MDToast.makeText(this, "Thank You", Toast.LENGTH_LONG, MDToast.TYPE_INFO);
        else {
            webView.loadUrl(arrayList.get(count + 1));
            count++;
        }
    }

    public void previous(View view) {
        if (count <= 0) {
            MDToast.makeText(this, "Sorry can't go back", Toast.LENGTH_LONG, MDToast.TYPE_WARNING);
        } else {
            webView.loadUrl(arrayList.get(count - 1));
            count--;
        }
    }

    @SuppressLint("StaticFieldLeak")
    class MyAssyncTask extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String json = null;
            try {
                InputStream is = getAssets().open("video_url.json");
                int size = is.available();
                byte[] bytes = new byte[size];
                is.read(bytes);
                is.close();
                json = new String(bytes, "UTF-8");
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("video");
                for (int i = 0; i < jsonArray.length(); i++) {
                    arrayList.add(jsonArray.getString(i));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }
        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            webView.loadUrl(arrayList.get(count));
            count++;
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

package com.app.wastemanagementforkids.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class Study2Activity extends AppCompatActivity {

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study2);
        toolbar = findViewById(R.id.study2_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Select Language");
    }

    public void english(View view) {
        startActivity(new Intent(Study2Activity.this, StudyActivity.class).putExtra("lang", "English"));
        finish();
    }

    public void gujarati(View view) {
        startActivity(new Intent(Study2Activity.this, StudyActivity.class).putExtra("lang", "Gujarati"));
        finish();
    }
}

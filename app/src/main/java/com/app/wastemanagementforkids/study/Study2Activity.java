package com.app.wastemanagementforkids.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wastemanagementforkids.R;

public class Study2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study2);
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

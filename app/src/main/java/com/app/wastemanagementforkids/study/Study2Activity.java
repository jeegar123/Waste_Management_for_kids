package com.app.wastemanagementforkids.study;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wastemanagementforkids.R;

public class Study2Activity extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study2);
        spinner = findViewById(R.id.lang_spinner);
    }

    public void langUpdate(View view) {
        String langauage = spinner.getSelectedItem().toString();
        if (langauage.equals("English")) {
            startActivity(new Intent(Study2Activity.this, StudyActivity.class).putExtra("lang", "English"));
            finish();
        } else if (langauage.equals("Gujarati")) {
            startActivity(new Intent(Study2Activity.this, StudyActivity.class).putExtra("lang", "Gujarati"));
            finish();
        } else {
            startActivity(new Intent(Study2Activity.this, StudyActivity.class).putExtra("lang", "Hindi"));
            finish();
        }
    }
}

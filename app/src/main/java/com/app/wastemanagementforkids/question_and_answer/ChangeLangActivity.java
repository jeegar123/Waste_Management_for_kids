package com.app.wastemanagementforkids.question_and_answer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class ChangeLangActivity extends AppCompatActivity {
    Toolbar materialToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_lang);
        materialToolbar = findViewById(R.id.change_toolbar);
        setTitle("Select Language");
        setSupportActionBar(materialToolbar);
    }

    public void english(View view) {
        startActivity(new Intent(ChangeLangActivity.this, QuesAndAnsActivity.class).putExtra("lang", "English"));
        finish();
    }

    public void gujarati(View view) {
        startActivity(new Intent(ChangeLangActivity.this, QuesAndAnsActivity.class).putExtra("lang", "Gujarati"));
        finish();
    }
}

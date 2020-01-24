package com.app.wastemanagementforkids.question_and_answer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wastemanagementforkids.R;

public class ChangeLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_lang);
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

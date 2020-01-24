package com.app.wastemanagementforkids.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class GameChangeLang2Activity extends AppCompatActivity {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_game_lang2);
        toolbar = findViewById(R.id.game2change_toolbar);
        setSupportActionBar(toolbar);
        setTitle("Select Language");
    }

    public void english(View view) {
        startActivity(new Intent(GameChangeLang2Activity.this, QuizGameActivity.class).putExtra("lang", "English"));
        finish();
    }

    public void gujarati(View view) {
        startActivity(new Intent(GameChangeLang2Activity.this, QuizGameActivity.class).putExtra("lang", "Gujarati"));
        finish();
    }
}

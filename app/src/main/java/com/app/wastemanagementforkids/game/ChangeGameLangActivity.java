package com.app.wastemanagementforkids.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class ChangeGameLangActivity extends AppCompatActivity {
    Toolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_game_lang);
        materialToolbar = findViewById(R.id.changehome_game_toolbar);
        setSupportActionBar(materialToolbar);
        setTitle("Quiz");
    }


    public void englishChange(View view) {
        startActivity(new Intent(ChangeGameLangActivity.this, GameActivity.class).putExtra("lang", "English"));
        finish();
    }

    public void gujaratiChange(View view) {
        startActivity(new Intent(ChangeGameLangActivity.this, GameActivity.class).putExtra("lang", "Gujarati"));
        finish();
    }
}

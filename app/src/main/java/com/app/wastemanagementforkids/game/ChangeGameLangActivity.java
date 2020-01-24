package com.app.wastemanagementforkids.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.wastemanagementforkids.R;

public class ChangeGameLangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_game_lang);
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

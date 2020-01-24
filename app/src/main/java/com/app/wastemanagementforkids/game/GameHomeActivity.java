package com.app.wastemanagementforkids.game;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.R;

public class GameHomeActivity extends AppCompatActivity {
    Toolbar materialToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_home);
        materialToolbar = findViewById(R.id.game_home_toolbar);
        setSupportActionBar(materialToolbar);
        setTitle("Games");
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.text_home_quiz:
                startActivity(new Intent(GameHomeActivity.this, ChangeGameLangActivity.class));
                break;
            case R.id.text_home_quiz2:
                startActivity(new Intent(GameHomeActivity.this, QuizGameActivity.class));
                break;
            case R.id.text_home_webgame1:
                startActivity(new Intent(GameHomeActivity.this, WebGame1Activity.class));
                break;
            case R.id.text_home_webgame2:
                startActivity(new Intent(GameHomeActivity.this, WebGame2Activity.class));
                break;
        }
    }
}

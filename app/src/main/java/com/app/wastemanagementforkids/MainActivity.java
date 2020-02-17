package com.app.wastemanagementforkids;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.game.GameHomeActivity;
import com.app.wastemanagementforkids.question_and_answer.ChangeLangActivity;
import com.app.wastemanagementforkids.study.Study2Activity;
import com.app.wastemanagementforkids.video.VideoActivity;


public class MainActivity extends AppCompatActivity {
    Toolbar materialToolbar;
    MediaPlayer mediaPlayer;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        materialToolbar = findViewById(R.id.home_toolbar);
        setSupportActionBar(materialToolbar);

    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.text_study:
                startActivity(new Intent(MainActivity.this, Study2Activity.class));
                if (mediaPlayer != null)
                    mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, R.raw.book);
                mediaPlayer.start();
                break;
            case R.id.text_video:
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
                if (mediaPlayer != null)
                    mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, R.raw.video);
                mediaPlayer.start();
                break;
            case R.id.text_question:
                startActivity(new Intent(MainActivity.this, ChangeLangActivity.class));
                if (mediaPlayer != null)
                    mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, R.raw.question);
                mediaPlayer.start();
                break;
            case R.id.text_game:
                startActivity(new Intent(MainActivity.this, GameHomeActivity.class));
                if (mediaPlayer != null)
                    mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(this, R.raw.game);
                mediaPlayer.start();
                break;
        }
    }

    public void aboutus(View view) {
        if (mediaPlayer != null)
            mediaPlayer.stop();
        mediaPlayer = MediaPlayer.create(this, R.raw.game);
        mediaPlayer.start();
        startActivity(new Intent(MainActivity.this, AboutUs.class));
    }
}

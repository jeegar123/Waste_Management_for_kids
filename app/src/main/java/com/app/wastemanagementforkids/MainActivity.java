package com.app.wastemanagementforkids;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.wastemanagementforkids.question_and_answer.QuesAndAnsActivity;
import com.app.wastemanagementforkids.study.Study2Activity;
import com.app.wastemanagementforkids.video.VideoActivity;


public class MainActivity extends AppCompatActivity {
    Toolbar materialToolbar;

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
                break;
            case R.id.text_video:
                startActivity(new Intent(MainActivity.this, VideoActivity.class));
                break;
            case R.id.text_question:
                startActivity(new Intent(MainActivity.this, QuesAndAnsActivity.class));
                break;
        }
    }
}

package com.app.wastemanagementforkids.game;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.wastemanagementforkids.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class GameActivity extends AppCompatActivity {
    JSONArray jsonArray;
    ViewPager viewPager;
    Toolbar materialToolbar;
    String lang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        materialToolbar = findViewById(R.id.game_toolbar);
        setSupportActionBar(materialToolbar);
        setTitle("Quiz");
        lang = getIntent().getStringExtra("lang");
        viewPager = findViewById(R.id.pageview);
        new MyAssyncTask().execute();
    }

    public void goToNextPage(View view) {
        if (viewPager.getCurrentItem() + 1 >= jsonArray.length()) {
            new AlertDialog.Builder(this)
                    .setMessage("Do want to close it?")
                    .setPositiveButton("confirm", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            startActivity(new Intent(GameActivity.this, GameHomeActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("close", null).show();

        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
        }
    }

    public void goToPreviousPage(View view) {
        if (viewPager.getCurrentItem() == 0) {

            new AlertDialog.Builder(this)
                    .setMessage("Do want to go back?")
                    .setPositiveButton("back", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            startActivity(new Intent(GameActivity.this, GameHomeActivity.class));
                            finish();
                        }
                    })
                    .setNegativeButton("close", null).show();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    class MyAssyncTask extends AsyncTask {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String json = null;
            try {
                InputStream is;
                if (lang.equals("English"))
                    is = getAssets().open("quiz.json");
                else
                    is = getAssets().open("quiz_guj.json");
                int size = is.available();
                byte[] bytes = new byte[size];
                is.read(bytes);
                is.close();
                json = new String(bytes, "UTF-8");
                Log.i("json", json);
                jsonArray = new JSONArray(json);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            viewPager.setAdapter(new MCQPageAdapter(getSupportFragmentManager()));
            viewPager.setPageTransformer(true, new ViewPager.PageTransformer() {
                private static final float MIN_SCALE = 0.85f;
                private static final float MIN_ALPHA = 0.5f;

                @Override
                public void transformPage(@NonNull View view, float position) {
                    int pageWidth = view.getWidth();
                    int pageHeight = view.getHeight();
                    if (position < -1) { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        view.setAlpha(0f);
                    } else if (position <= 1) { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        float scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position));
                        float vertMargin = pageHeight * (1 - scaleFactor) / 2;
                        float horzMargin = pageWidth * (1 - scaleFactor) / 2;
                        if (position < 0) {
                            view.setTranslationX(horzMargin - vertMargin / 2);
                        } else {
                            view.setTranslationX(-horzMargin + vertMargin / 2);
                        }
                        // Scale the page down (between MIN_SCALE and 1)
                        view.setScaleX(scaleFactor);
                        view.setScaleY(scaleFactor);
                        // Fade the page relative to its size.
                        view.setAlpha(MIN_ALPHA +
                                (scaleFactor - MIN_SCALE) /
                                        (1 - MIN_SCALE) * (1 - MIN_ALPHA));
                    } else { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        view.setAlpha(0f);
                    }
                }
            });
        }
    }

    class MCQPageAdapter extends FragmentStatePagerAdapter {

        public MCQPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            try {
                return new QuizFragment(setData(jsonArray.getJSONObject(position)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        public MCQItem setData(JSONObject data) {
            MCQItem mcqItem = new MCQItem();
            try {
                mcqItem.setQuestion(data.getString("Q"));
                JSONArray jsonArray = data.getJSONArray("O");
                String[] options = {jsonArray.getString(0), jsonArray.getString(1), jsonArray.getString(2), jsonArray.getString(3)};
                mcqItem.setOptions(options);
                mcqItem.setAnswer(data.getString("A"));

            } catch (JSONException e) {
                e.printStackTrace();
            }
            return mcqItem;
        }

        @Override
        public int getCount() {
            return jsonArray.length();
        }
    }
}

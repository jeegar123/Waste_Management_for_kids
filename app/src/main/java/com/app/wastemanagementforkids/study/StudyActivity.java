package com.app.wastemanagementforkids.study;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class StudyActivity extends AppCompatActivity {
    StudyAdapter studyAdapter;
    JSONArray jsonArray;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        viewPager=findViewById(R.id.content_pager);
        new MyAssyncTask().execute();
    }

    public void goToNextPage(View view) {
        viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
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
                InputStream is = getAssets().open("content.json");
                int size = is.available();
                byte[] bytes = new byte[size];
                is.read(bytes);
                is.close();
                json = new String(bytes, "UTF-8");
                jsonArray = new JSONArray(json);
                studyAdapter=new StudyAdapter(getSupportFragmentManager());
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
            viewPager.setAdapter(new StudyAdapter(getSupportFragmentManager()));
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

    public class StudyAdapter extends FragmentStatePagerAdapter{
        public StudyAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            try {
                return new StudyFragment(getContentItemData(jsonArray.getJSONObject(position)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        public ContentItem getContentItemData(JSONObject jsonObject){
            ContentItem contentItem = null;
            try {
                 contentItem=new ContentItem(jsonObject.getString("topic"),jsonObject.getString("data"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return contentItem;
        }
        @Override
        public int getCount() {
            return jsonArray.length();
        }
    }
}


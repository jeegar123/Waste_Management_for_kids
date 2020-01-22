package com.app.wastemanagementforkids.question_and_answer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import com.app.wastemanagementforkids.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;

public class QuesAndAnsActivity extends AppCompatActivity {
    QuestionAdapter questionAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_and_ans);
        new MyAssyncTask().execute();
        recyclerView=findViewById(R.id.recycle_ques_ans);
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
                InputStream is = getAssets().open("ques_ans.json");
                int size = is.available();
                byte[] bytes = new byte[size];
                is.read(bytes);
                is.close();
                json = new String(bytes, "UTF-8");
                Log.i("json", json);
                JSONArray jsonArray = new JSONArray(json);
                questionAdapter = new QuestionAdapter(jsonArray);

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
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(QuesAndAnsActivity.this);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setAdapter(questionAdapter);
        }

    }
}

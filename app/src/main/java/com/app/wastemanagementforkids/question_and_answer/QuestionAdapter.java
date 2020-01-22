package com.app.wastemanagementforkids.question_and_answer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.wastemanagementforkids.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    JSONArray jsonArray;


    public QuestionAdapter(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            JSONObject jsonObject=jsonArray.getJSONObject(position);
            holder.question.setText(String.format("Q. %s", jsonObject.getString("Q")));
            holder.answer.setText(String.format("A. %s", jsonObject.getString("A")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView question,answer;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            question=itemView.findViewById(R.id.text_recyle_question);
            answer=itemView.findViewById(R.id.text_recyle_ans);
        }
    }
}

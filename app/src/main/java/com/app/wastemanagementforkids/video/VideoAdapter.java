package com.app.wastemanagementforkids.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.app.wastemanagementforkids.R;

import java.util.ArrayList;
import java.util.List;

public class VideoAdapter  extends ArrayAdapter<String> {

Context context;
ArrayList<String> arrayList;

    public VideoAdapter( Context context, ArrayList<String> arrayList) {
        super(context, R.layout.video_view);
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return arrayList.get(position);
    }



    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.video_view,parent,false);
        }

        TextView link=convertView.findViewById(R.id.text_video_link);
        link.setText(arrayList.get(position));

        return convertView;
    }
}

package com.app.wastemanagementforkids.study;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.wastemanagementforkids.R;

public class StudyFragment extends Fragment {
    View view;
    ContentItem contentItem;
    TextView topic, content;

    public StudyFragment(ContentItem contentItem) {
        this.contentItem = contentItem;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.study_card_view, container, false);
        init();
        setData();
        return view;
    }

    public void init() {
        topic = view.findViewById(R.id.text_content_topic);
        content = view.findViewById(R.id.text_content);
    }

    public void setData() {
        topic.setText(contentItem.getTopic());
        content.setText(contentItem.getContent());
    }
}

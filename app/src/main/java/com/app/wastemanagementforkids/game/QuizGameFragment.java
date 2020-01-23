package com.app.wastemanagementforkids.game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.app.wastemanagementforkids.R;
import com.squareup.picasso.Picasso;

public class QuizGameFragment extends Fragment {
    static int v = 0;
    View view;
    ImageView button_option1, button_option2, button_option3, button_option4;
    TextView textQuestion;
    GameItem gameItem;


    public QuizGameFragment(GameItem gameItem) {
        this.gameItem = gameItem;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.game_quiz_fragment, container, false);
        init();
        setData();
        buttonListiner();
        return view;
    }
    private void init() {
        button_option1 = view.findViewById(R.id.option_imag1);
        button_option2 = view.findViewById(R.id.option_imag2);
        button_option3 = view.findViewById(R.id.option_imag3);
        button_option4 = view.findViewById(R.id.option_imag4);
        textQuestion = view.findViewById(R.id.question);
    }
    public void setData() {
        String[] data = gameItem.getLink();
        textQuestion.setText(gameItem.getQuestion());
        setImage(button_option1, data[0]);
        setImage(button_option2, data[1]);
        setImage(button_option3, data[2]);
        setImage(button_option4, data[3]);
    }
    public void setImage(ImageView im, String url) {
        Picasso.get()  //Here, this is context.
                .load(url)  //Url of the image to load.
                .into(im);
    }
    public void buttonListiner() {
        button_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameItem.getV() == 1) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (gameItem.getV() == 2) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameItem.getV() == 3) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
        button_option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (gameItem.getV() == 4) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

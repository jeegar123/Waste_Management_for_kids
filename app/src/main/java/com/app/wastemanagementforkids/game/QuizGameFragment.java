package com.app.wastemanagementforkids.game;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
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
import com.valdesekamdem.library.mdtoast.MDToast;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

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
        button_option1.setImageResource(R.drawable.green);
        button_option2.setImageResource(R.drawable.blue);
        button_option3.setImageResource(R.drawable.yellow);
        button_option4.setImageResource(R.drawable.red);

    }

    public Bitmap loadImage(String url) {
        Bitmap bitmap = null;
        try {
            URL Url = new URL(url);
            InputStream is = new BufferedInputStream(Url.openStream());
            bitmap = BitmapFactory.decodeStream(is);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public void buttonListiner() {
        button_option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("error", "" + gameItem.getV());
                if (gameItem.getV() == 1) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                    // MDToast.makeText(getActivity(), "Correct", MDToast.LENGTH_SHORT, MDToast.TYPE_SUCCESS);
                } else {
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
                    MDToast.makeText(getActivity(), "InCorrect", MDToast.LENGTH_SHORT, MDToast.TYPE_ERROR);
                }
            }
        });
        button_option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v = 2;
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
                v = 3;
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
                v = 4;
                if (gameItem.getV() == 4) {
                    Toast.makeText(getActivity(), "correct", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

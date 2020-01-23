package com.app.wastemanagementforkids.game;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.app.wastemanagementforkids.MainActivity;
import com.app.wastemanagementforkids.R;
import com.valdesekamdem.library.mdtoast.MDToast;

public class QuizFragment extends Fragment {
    View view;
    RadioGroup radioGroup;
    RadioButton optionA, optionB, optionC, optionD;
    TextView textQuestion;
    MCQItem mcqItem;
    Button btnSubmit, btnCancel;

    public QuizFragment(MCQItem mcqItem) {
        this.mcqItem = mcqItem;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.mcq_fragment, container, false);
        init();
        setData();
        listiner();
        return view;
    }


    public void init() {
        radioGroup = view.findViewById(R.id.radio_option_group);
        textQuestion = view.findViewById(R.id.text_game_question);
        optionA = view.findViewById(R.id.radio_option_a);
        optionB = view.findViewById(R.id.radio_option_b);
        optionC = view.findViewById(R.id.radio_option_c);
        optionD = view.findViewById(R.id.radio_option_d);
        btnSubmit = view.findViewById(R.id.btn_submit);
        btnCancel = view.findViewById(R.id.btn_cancel);
    }

    public void listiner() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton  radioBtn=view.findViewById(radioGroup.getCheckedRadioButtonId());
                String userOptionText= (String) radioBtn.getText();

                if(userOptionText.equals(mcqItem.getAnswer())){
                    MDToast.makeText(getActivity(),"correct",MDToast.LENGTH_SHORT,MDToast.TYPE_SUCCESS).show();
                }else{
                    MDToast.makeText(getActivity(),"incorrect",MDToast.LENGTH_SHORT,MDToast.TYPE_ERROR).show();
                }
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("cancel quiz")
                        .setMessage("Do u want to close it?")
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getContext(), MainActivity.class));
                                getActivity().finish();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }

    public void setData(){
        String []data=mcqItem.getOptions();
        textQuestion.setText(mcqItem.getQuestion());
        optionA.setText(data[0]);
        optionB.setText(data[1]);
        optionC.setText(data[2]);
        optionD.setText(data[3]);
    }
}

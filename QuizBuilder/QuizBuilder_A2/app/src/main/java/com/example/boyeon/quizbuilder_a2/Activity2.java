package com.example.boyeon.quizbuilder_a2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Activity2 extends AppCompatActivity {
    Button btnAnswer1,btnAnswer2,btnAnswer3,btnAnswer4;
    TextView txtQuestion2, txtScore2, txtName2;
    private ArrayList<String> questionList;
    private ArrayList<String> answerList;
    private HashMap<String, String> quizMap;

    private String curAnswer;
    private int quizScore = 0;
    private int curQuizNum = 0;
    private final int MAX_QUIZ_NUM = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();

        

        if(extras != null){
            txtName2.setText(extras.getString("userName"));
        }
        btnAnswer1.findViewById(R.id.btnAnswer1);
        btnAnswer2.findViewById(R.id.btnAnswer2);
        btnAnswer3.findViewById(R.id.btnAnswer3);
        btnAnswer4.findViewById(R.id.btnAnswer4);


        txtQuestion2.findViewById(R.id.txtQuestion2);
        txtScore2.findViewById(R.id.txtScore2);
        txtName2.findViewById(R.id.txtName2);


        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check with the correct answer
            }
        });

        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check with the correct answer
            }
        });

        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check with the correct answer
            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check with the correct answer
            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check with the correct answer
            }
        });
    }

    private boolean setQuiz(){
        AssetManager quiz = getApplicationContext().getAssets();
        InputStream i = null;
        try{
            i=quiz.open("quiz.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(i == null){
            return false;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(i));
        questionList = new ArrayList<>();
        answerList = new ArrayList<>();
        quizMap = new HashMap<String, String>();
        try{
            while(br.ready()){
                String t = br.readLine();
                String[] a = t.split("\\|");
                questionList.add(a[0]);
                answerList.add(a[1]);
                quizMap.put(a[0],a[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }return true;
    }

    private ArrayList<String> getQuiz{
        if(curQuizNum >= MAX_QUIZ_NUM) return null;
        curQuizNum ++;
        ArrayList<String> quiz = new ArrayList<>();

        String question = questionList.get(0);
    }

}

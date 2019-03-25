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
    private String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle extras = getIntent().getExtras();
        // button
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        btnAnswer3 = findViewById(R.id.btnAnswer3);
        btnAnswer4 = findViewById(R.id.btnAnswer4);

        // textview
        txtQuestion2 = findViewById(R.id.txtQuestion2);
        txtScore2 = findViewById(R.id.txtScore2);
        txtName2 = findViewById(R.id.txtName2);

        if (extras != null){
            userName= extras.getString("userName");
            txtName2.setText(userName);
        }

        setQuiz();
        ArrayList<String> nextQuiz = getNextQuiz();
        displayQuiz(nextQuiz);


        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button here = (Button)v;
                String answer = here.getText().toString();
                checkAnswer(answer);
                ArrayList<String> nextQuiz = getNextQuiz();
                if(nextQuiz == null){
                    goToResultPage();
                }else{
                    displayQuiz(nextQuiz);
                }
            }
        });

        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button here = (Button)v;
                String answer = here.getText().toString();
                checkAnswer(answer);
                ArrayList<String> nextQuiz = getNextQuiz();
                if(nextQuiz == null){
                    goToResultPage();
                }else{
                    displayQuiz(nextQuiz);
                }
            }
        });

        btnAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button here = (Button)v;
                String answer = here.getText().toString();
                checkAnswer(answer);
                ArrayList<String> nextQuiz = getNextQuiz();
                if(nextQuiz == null){
                    goToResultPage();
                }else{
                    displayQuiz(nextQuiz);
                }
            }
        });

        btnAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button here = (Button)v;
                String answer = here.getText().toString();
                checkAnswer(answer);
                ArrayList<String> nextQuiz = getNextQuiz();
                if(nextQuiz == null){
                    goToResultPage();
                }else{
                    displayQuiz(nextQuiz);
                }
            }
        });
    }


    private void goToResultPage(){
        Bundle extras = new Bundle();
        extras.putString("userName",userName);
        extras.putString("score", String.valueOf(quizScore));
        Intent i = new Intent("Activity3");
        i.putExtras(extras);
        startActivity(i);
    }
    private boolean setQuiz () {
        AssetManager quiz = getApplicationContext().getAssets();
        InputStream i = null;
        try {
            i = quiz.open("quiz.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (i == null) {
            return false;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(i));
        questionList = new ArrayList<>();
        answerList = new ArrayList<>();
        quizMap = new HashMap<String, String>();
        try {
            while (br.ready()) {
                String t = br.readLine();
                String[] a = t.split("\\|");
                questionList.add(a[0]);
                answerList.add(a[1]);
                quizMap.put(a[0], a[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    private void doShuffle(){
        long seed = System.nanoTime();
        Collections.shuffle(questionList, new Random(seed));
        //Collections.shuffle(answerList, new Random(seed));
    }

    private ArrayList<String> getNextQuiz(){
        if(curQuizNum >= MAX_QUIZ_NUM) return null;
        curQuizNum++;

        ArrayList<String> quiz = new ArrayList<String>();

        String question = questionList.get(0);
        String answer = quizMap.get(question);

        questionList.remove(0);

        Collections.shuffle(answerList);

        quiz.add(answer);
        for(int i=0; i<4 ; i++){ // 0 1 2 3
            if(quiz.size()<4 && !answer.equals(answerList.get(i))){
                quiz.add(answerList.get(i));
            }
        }

        Collections.shuffle(quiz);
        quiz.add(question);
        curAnswer = answer;
        return quiz;
    }

    private void displayQuiz(ArrayList<String> quiz){
        txtQuestion2.setText(quiz.get(4));
        btnAnswer1.setText(quiz.get(0));
        btnAnswer2.setText(quiz.get(1));
        btnAnswer3.setText(quiz.get(2));
        btnAnswer4.setText(quiz.get(3));
        txtScore2.setText(String.valueOf(quizScore));
    }

    private void checkAnswer(String answer){
        if(answer.equals(curAnswer)){
            //correct!
            quizScore++;
            Toast.makeText(this,"Good!", Toast.LENGTH_SHORT).show();
        }else{
            //wrong!
            Toast.makeText(this,"Wrong!", Toast.LENGTH_SHORT).show();
        }
    }


}

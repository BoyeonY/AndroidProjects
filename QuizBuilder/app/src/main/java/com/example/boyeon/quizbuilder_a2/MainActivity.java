package com.example.boyeon.quizbuilder_a2;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    EditText edName;
    TextView error;
    Bundle extras = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //button
        btnStart = findViewById(R.id.btnStart);
        // editText
        edName = findViewById(R.id.edName);
        // textView
        error = findViewById(R.id.txtError);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation(edName.getText().toString())) {

                    extras.putString("userName", edName.getText().toString());
                    Intent i = new Intent("Activity2");
                    i.putExtras(extras);
                    startActivity(i);
                } else {
                    error.setText("Please Enter the user name!");
                }
            }
        });
    }
    public boolean validation (String edName){
        if (edName != null && edName.length() > 0) {
            return true;
        } else
            return false;
    }
}
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
    EditText userName;
    TextView error;
    Bundle extras = new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart.findViewById(R.id.btnStart);
        userName.findViewById(R.id.edName);
        error.findViewById(R.id.txtError);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // validation check
                if(validation(userName.getText().toString())){
                    // pass data to next page
                    extras.putString("userName", userName.getText().toString());
                    Intent i = new Intent("Activity2");
                    i.putExtras(extras);
                    startActivity(i);

                }else{
                    error.setText("Please enter the user name!");
                }
            }
        });
    }

    private boolean validation(String username){
        if(username != null&& username.length()>0){
            return true;
        }else{
            return false;
        }
    }


}
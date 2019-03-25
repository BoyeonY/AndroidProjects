
 package com.example.boyeon.quizbuilder_a2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class Activity3 extends AppCompatActivity {
    Button btnHome;
    TextView txtScore3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Intent i = getIntent();
        String userName = i.getStringExtra("userName");
        String score = i.getStringExtra("score");
        //button
        btnHome = findViewById(R.id.btnHome);
        //textView
        txtScore3 = findViewById(R.id.txtScore3);
        txtScore3.setText(userName+": "+score+" points!");


        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

     public void openMainActivity(){
         Intent intent = new Intent(this, MainActivity.class);
         startActivity(intent);

     }
}

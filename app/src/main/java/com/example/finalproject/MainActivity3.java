package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private Button button4,button5;
    private TextView textRest,text1,text2,text3;
    public int TV_case = 0,counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        final TextView text1 = findViewById(R.id.textView4);
        final TextView text2 = findViewById(R.id.textView6);
        final TextView text3 = findViewById(R.id.textView8);

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TV_case++;
                counter = 0;
                switch(TV_case){
                    case 1:
                        new CountDownTimer(5000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                text1.setText(String.valueOf(counter));
                                counter++;
                            }
                            @Override
                            public void onFinish() {
                                text1.setText("休息");
                            }
                        }.start();
                    break;

                    case 2:
                        new CountDownTimer(5000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                text2.setText(String.valueOf(counter));
                                counter++;
                            }
                            @Override
                            public void onFinish() {
                                text2.setText("休息");
                            }
                        }.start();
                    break;

                    case 3:
                        new CountDownTimer(5000,1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                                text3.setText(String.valueOf(counter));
                                counter++;
                            }
                            @Override
                            public void onFinish() {
                                text3.setText("結束");
                            }
                        }.start();
                    break;
                }
            }
        });
    }
}
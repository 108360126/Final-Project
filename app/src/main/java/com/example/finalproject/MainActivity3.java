package com.example.finalproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {

    private Button button4,button5;
    private TextView textRest,text1,text2,text3;
    public int TV_case = 0,counter;
    private void showToast1(){
        Toast toast = new Toast(MainActivity3.this);
        toast.setGravity(Gravity.TOP,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,(ViewGroup)findViewById(R.id.custom_toast_root));
        toast.setView(layout);
        toast.show();
    }
    private void showToast2(){
        Toast toast = new Toast(MainActivity3.this);
        toast.setGravity(Gravity.TOP,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast2,(ViewGroup)findViewById(R.id.custom_toast_root2));
        toast.setView(layout);
        toast.show();
    }

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
                                text1.setTextColor(Color.parseColor("#00FF00"));
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
                                text2.setTextColor(Color.parseColor("#00FF00"));
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
                                text3.setTextColor(Color.parseColor("#00FF00"));
                            };
                        }.start();
                    break;
                }
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity3.this);
                dialog.setTitle("返回主畫面");
                dialog.setMessage("請問是否已完成運動且要返回主畫面");
                dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(text1.getCurrentTextColor()==Color.GREEN&&text2.getCurrentTextColor()==Color.GREEN&&text3.getCurrentTextColor()==Color.GREEN){
                            showToast1();
                            startActivityForResult(new Intent(MainActivity3.this, MainActivity2.class),
                                    1);
                        }else{
                            showToast2();
                            startActivityForResult(new Intent(MainActivity3.this, MainActivity2.class),
                                    1);
                        }
                    }
                });
                dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        });
    }
}
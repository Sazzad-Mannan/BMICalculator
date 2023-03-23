package com.riftech.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    String type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txt1=(TextView)findViewById(R.id.textView3);
        ImageView img=(ImageView)findViewById(R.id.imageView2);

        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi",0.0);
        String gender = intent.getStringExtra("gender");
        if(Objects.equals(gender, "Male")){
            img.setImageResource(R.drawable.bmim);
        }else{
            img.setImageResource(R.drawable.bmif);
        }
        txt1.setText(String.valueOf(bmi));
        if(bmi<18.5){
            type="Underweight";
            txt1.setTextColor(Color.parseColor("#87B1D9"));
        } else if (bmi<24.9) {
            type="Normal";
            txt1.setTextColor(Color.parseColor("#3DD365"));
        } else if (bmi<29.9) {
            type="Overweight";
            txt1.setTextColor(Color.parseColor("#EEE133"));
        } else if (bmi<34.9) {
            type="OBESE";
            txt1.setTextColor(Color.parseColor("#FD802E"));
        }else {
            type="Extreemly OBESE";
            txt1.setTextColor(Color.parseColor("#F95353"));
        }
    }
}
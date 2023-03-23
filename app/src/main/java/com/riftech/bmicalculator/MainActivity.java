package com.riftech.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    String h_unit,w_unit,gender;
double height,weight,bmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=(Button)findViewById(R.id.button);
        Spinner dropdown = findViewById(R.id.spinner);
        Spinner dropdown1 = findViewById(R.id.spinner2);
        Spinner dropdown2 = findViewById(R.id.spinner3);
        EditText editText1 = (EditText)findViewById(R.id.editTextNumber4);
        EditText editText2 = (EditText)findViewById(R.id.editTextNumber3);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                // click handling code
                 h_unit = dropdown.getSelectedItem().toString();
                w_unit = dropdown1.getSelectedItem().toString();
                gender = dropdown2.getSelectedItem().toString();
                if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Please enter height & weight.", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                weight = Float.parseFloat(editText1.getText().toString());
                height = Float.parseFloat(editText2.getText().toString());


                    if (Objects.equals(h_unit, "ft")) {
                        height = height * 0.3048;
                    } else {
                        height = height * 0.01;
                    }

                    if (Objects.equals(w_unit, "lb")) {
                        weight = weight * 0.45359237;
                    }

                    bmi = weight / (height * height);
                    bmi = Math.round(bmi * 100.0) / 100.0;

                    Toast toast = Toast.makeText(getApplicationContext(), String.valueOf(bmi), Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("bmi", bmi);
                    intent.putExtra("gender", gender);
                    startActivity(intent);
                }
            }
        });

        //get the spinner from the xml.

//create a list of items for the spinner.
        String[] items = new String[]{"ft", "cm"};
        String[] items1 = new String[]{"kg", "lb"};
        String[] items2 = new String[]{"Female", "Male"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);

        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);
        dropdown1.setAdapter(adapter1);
        dropdown2.setAdapter(adapter2);
    }
}
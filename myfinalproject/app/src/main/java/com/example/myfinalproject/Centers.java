package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Centers extends AppCompatActivity {

    Button VHRC,AMCC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centers);

        VHRC = (Button)findViewById(R.id.Veterinary_HRC);
        AMCC = (Button)findViewById(R.id.army_MCC);

        VHRC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Veterinary_Hospital_and_Research_Centre.class));
            }
        });

        AMCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Army_Medical_Corps_Centre.class));
            }
        });
    }
}

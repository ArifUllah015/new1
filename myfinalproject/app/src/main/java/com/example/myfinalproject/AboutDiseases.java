package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutDiseases extends AppCompatActivity {

Button tuber,polio,diphtheria,pertussis,hepB,tetanus,measles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_diseases);

        tuber = (Button)findViewById(R.id.tuberculosis);
        polio = (Button)findViewById(R.id.polio);
        diphtheria = (Button)findViewById(R.id.Diphtheria);
        pertussis = (Button)findViewById(R.id.Pertussis);
        hepB = (Button)findViewById(R.id.HepB);
        tetanus = (Button)findViewById(R.id.Tetanus);
        measles = (Button)findViewById(R.id.Measles);

     tuber.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             startActivity(new Intent(getApplicationContext(),Tuberculosis_Dis.class));
         }
     });
    polio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Polio_VC.class));
        }
    });

    diphtheria.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Diphtheria_Dis.class
            ));
        }
    });
    pertussis.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Pertussis_Dis.class));
        }
    });
    hepB.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Hep_B.class));
        }
    });
    tetanus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Tetanus_Dis.class));
        }
    });
    measles.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(),Measles_Dis.class));
        }
    });
    }
}

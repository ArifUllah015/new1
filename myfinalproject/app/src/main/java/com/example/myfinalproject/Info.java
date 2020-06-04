package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Info extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void btn_about_vaccination(View view) {

        startActivity(new Intent(getApplication(), AboutVaccination.class));
    }

    public void btn_diseases(View view) {

        startActivity(new Intent(getApplication(), AboutDiseases.class));

    }



    public void btn_app_info(View view) {

        startActivity(new Intent(getApplication(),AboutApplication.class));


    }

    public void btn_immunize(View view) {
        startActivity(new Intent(getApplication(),About_Immunization.class));
    }
}

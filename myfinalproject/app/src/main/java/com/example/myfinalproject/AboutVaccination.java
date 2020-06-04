package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AboutVaccination extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_vaccination);
    }

    public void btn_BCG(View view) {

        startActivity(new Intent(getApplicationContext(),BCG.class));
    }

    public void btn_hepB(View view) {
        startActivity(new Intent(getApplicationContext(),Hep_B.class
        ));
    }

    public void btn_Opv(View view) {
        startActivity(new Intent(getApplicationContext(),OPV_VC.class));
    }

    public void btn_pent(View view) {
        startActivity(new Intent(getApplicationContext(),Pentavalent_VC_.class));
    }

    public void btn_Measles(View view) {
    startActivity(new Intent(getApplicationContext(),Measles_VC.class));
    }

    public void btn_DPT(View view) {
        startActivity(new Intent(getApplicationContext(),DPT_VC.class));
    }

    public void btn_polio(View view) {
    }
}

package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminActivity extends AppCompatActivity {

    private Button btn_vaccinator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btn_vaccinator = (Button)findViewById(R.id.vaccinator);


        btn_vaccinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplication(), AddVaccinator.class));
            }
        });
    }

    public void btn_listOfUser(View view) {

        startActivity(new Intent(getApplication(),ListOfUsers.class));
    }

    public void btn_listOfChild(View view) {
        startActivity(new Intent(getApplication(),ListOfChild.class));
    }

    public void btn_addVaccinator(View view) {

        startActivity(new Intent(getApplication(),AddVaccinator.class));

    }
}

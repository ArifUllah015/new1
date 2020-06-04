package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddVaccinator extends AppCompatActivity {

    EditText username,Password;
    Button btn_add;

    //get the firebase reference
    FirebaseDatabase database;
    DatabaseReference ref;

    VaccinatorData vaccinatorData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vaccinator);

        username = (EditText)findViewById(R.id.Name);
        Password = (EditText)findViewById(R.id.pass);
        btn_add = (Button)findViewById(R.id.add);

        vaccinatorData = new VaccinatorData();

        //get instance of database
        database = FirebaseDatabase.getInstance();
        //specific node/child reference which is users table/child
        ref = database.getReference("Vaccinator");


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userName = username.getText().toString();
                String password = Password.getText().toString();

                if(userName.isEmpty()){
                    username.setError("Please enter user name");
                }else if(password.isEmpty()){
                    Password.setError("Please enter password");
                }else {

                    vaccinatorData.setUserName(userName);
                    vaccinatorData.setPassword(password);

                    ref.push().setValue(vaccinatorData);
                    Toast.makeText(AddVaccinator.this, "vaccinator add successfully", Toast.LENGTH_SHORT).show();

                    btn_pess();

                }


            }
        });
    }

    private void btn_pess() {
        username.setText("");
        Password.setText("");




    }


}

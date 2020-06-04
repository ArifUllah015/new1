package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Vaccinator extends AppCompatActivity {


    //declare all edit text and button
    EditText name,pass;
    Button vaccinator;

    //get the firebase reference
    FirebaseDatabase database;
    DatabaseReference ref;

    Vaccinator_info vaccinator_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccinator);


        //casting id or find by id
        name = (EditText)findViewById(R.id.vaccinator_name);
        pass = (EditText)findViewById(R.id.vaccinator_password);
        vaccinator =(Button)findViewById(R.id.btn_vaccinator);


        vaccinator_info = new Vaccinator_info();

        //get instance of database
        database = FirebaseDatabase.getInstance();
        //specific node/child reference which is users table/child
        ref = database.getReference("Vaccinator");

        //set on click listener event
        vaccinator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String VName = name.getText().toString();
                final String Vpass = pass.getText().toString();

                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        for(DataSnapshot ds: dataSnapshot.getChildren()){

                                //now i have successfully access to all children in the database
                                //next we need to add these children to the adapter

                                //we need a instance of user
                                //get value and convert to user type
                               vaccinator_info  = ds.getValue(Vaccinator_info.class);


                                String a =vaccinator_info.getUserName().toString();
                                String b = vaccinator_info.getPassword().toString();

                                if(a.matches(VName) && (b.matches(Vpass))) {
                                    Toast.makeText(Vaccinator.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),Centers.class));

                                }else {

                                    Toast.makeText(Vaccinator.this, "Error", Toast.LENGTH_SHORT).show();


                                }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }



}

package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

public class AdminLogin extends AppCompatActivity {

    //declare every field
    EditText admin_Email, admin_Password;


    //String email="admin";
   // String password = "admin";


    //get the firebase reference
    FirebaseDatabase database;
    DatabaseReference ref;

    FirebaseUser user;

    Admin_info admin_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        //casting views or find View by childDataID
        admin_Email = (EditText) findViewById(R.id.login_email);
        admin_Password = (EditText) findViewById(R.id.login_password);

        admin_info = new Admin_info();



        //get instance of database
       database = FirebaseDatabase.getInstance();
        //specific node/child reference which is users table/child
        ref = database.getReference("admin");




    }

    public void btn_admin_login(View view) {

        // From this field we get data and store in some string
        final String email = admin_Email.getText().toString();
       final String password = admin_Password.getText().toString();



        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String Email = dataSnapshot.child("email").getValue().toString();
                String pass = dataSnapshot.child("password").getValue().toString();

                //tx.setText(Email);
                //txt.setText(pass);

                if(Email.matches(email) && (pass.matches(password))){
                    startActivity(new Intent(getApplicationContext(),AdminActivity.class));


                }else {
                    Toast.makeText(AdminLogin.this, "error", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


           }
        }









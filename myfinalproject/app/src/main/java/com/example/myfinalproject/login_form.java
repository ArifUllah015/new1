package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login_form extends AppCompatActivity {

    //declare every field
    EditText login_email, login_password;

    //create object of Firebase Authentication
    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);



        //casting views or find View by childDataID
        login_email = (EditText) findViewById(R.id.login_email);
        login_password = (EditText) findViewById(R.id.login_password);

        //get state of firebase or get instance
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public void btn_login(View view) {

        // From this field we get data and store in some string
        String Email = login_email.getText().toString();
        String Password = login_password.getText().toString();


        //validation of registration form
        if (Email.isEmpty()) {
            login_email.setError("Please Enter Email Address");

        } else if (Password.isEmpty()) {
            login_password.setError("Please Enter Password");

        } else {

            //method used for read data from firebasedatabase
            //in this method two string email and password are input which will be checked in if condition
            firebaseAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(login_form.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //Toast.makeText(login_form.this, "before logon", Toast.LENGTH_SHORT).show();
                            if (task.isSuccessful()) {

                                //if email and password are match it goes to other activity other wise show toast message
                                startActivity(new Intent(getApplicationContext(), dashboard.class));

                            } else {
                                    Toast.makeText(login_form.this,"Invalid User",Toast.LENGTH_LONG).show();

                            }

                        }
                    });
        }
    }

    public void btn_Signform(View view) {
        startActivity(new Intent(getApplicationContext(), signup_form.class));

    }




    public void btn_awareness(View view) {
        startActivity(new Intent(getApplication(), Awareness.class));
    }



    public void btn_vaccinator(View view) {

   startActivity(new Intent(getApplication(),Vaccinator.class));
    }

    public void btn_admin(View view) {
        startActivity(new Intent(getApplication(),AdminLogin.class));
    }
}

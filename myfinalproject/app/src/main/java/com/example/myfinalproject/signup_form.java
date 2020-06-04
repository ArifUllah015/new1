package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class signup_form extends AppCompatActivity {

    //declare every field and button
    EditText txt_fullName, txt_userName, txt_email, txt_password,txt_confirm_password;

    Spinner _spinner;
    Button Registration;
    String mailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    //create database reference
    DatabaseReference databaseReference;
    //create fire base authentication
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);


        //casting views or find View by childDataID, data get which user put in the input field
        txt_fullName = (EditText) findViewById(R.id.fullname);
        txt_userName = (EditText) findViewById(R.id.username);
        txt_email = (EditText) findViewById(R.id.email);
        txt_password = (EditText) findViewById(R.id.Password);
        txt_confirm_password = (EditText) findViewById(R.id.confirm_password);
        _spinner = (Spinner)findViewById(R.id.spinner);
        Registration = (Button) findViewById(R.id.registration);

        //create a adapter using array
        //"create from resource" method is used for creating  "array adapter" from "string array".
        //the third argument of method "create from resource" is the layout that define how the selected choice is occur which is "drop down item"
        ArrayAdapter <CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender, R.layout.support_simple_spinner_dropdown_item);
       //apply adapter to the spinner
        _spinner.setAdapter(adapter);


        //getInstance and create node in data base, give reference of helper class
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        //get in instance of authentication
        firebaseAuth = FirebaseAuth.getInstance();



        //set the on Click Listener method on register button
        Registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Store the data in some strings, those data which we get from user input
                final String fullName = txt_fullName.getText().toString();
                final String userName = txt_userName.getText().toString();
                final String email = txt_email.getText().toString();
                final String password = txt_password.getText().toString();
                String confirm_password = txt_confirm_password.getText().toString();
                final String Gender = _spinner.getSelectedItem().toString();


                //validation of form

                //condition for full name
                if (fullName.isEmpty()) {
                    txt_fullName.setError("Please Enter Full Name");
                } else if(fullName.length() < 4){
                    txt_fullName.setError("Full ame is too short");

                    //condition for user name
                }else if(userName.isEmpty()){
                    txt_userName.setError("Please Enter User Name");
                }else if(userName.length() > 10){
                    txt_userName.setError("User name is too long");


                    //condition for email
                }else if(email.isEmpty()){
                    txt_email.setError("Please enter email address");
                }else if(!email.matches(mailpattern)){
                    txt_email.setError("Please enter proper email address");




                //condition for password
                }else if(password.isEmpty()){
                    txt_password.setError("Please enter password");
                }else if(password.length() < 8){
                    txt_password.setError("Password is too small");


                    //condition for confirm password
                }else if(confirm_password.isEmpty()){
                    txt_confirm_password.setError("Please enter confirm password");
                }else if(!confirm_password.equals(password)){
                    txt_confirm_password.setError("Password mismatch");
                }else{

                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(signup_form.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        //create object of helper class
                                        Users information = new Users(
                                                fullName,
                                                userName,
                                                email,
                                                password,
                                                Gender
                                        );

                                        //use fire base data base, give reference of node/table where our data should be insert
                                        //create a child
                                        //set the value which we are use in the information object and pass this object
                                        FirebaseDatabase.getInstance().getReference("users")
                                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {

                                                //if everything is proper show a toast message from which we known that our registration is successfull
                                                Toast.makeText(signup_form.this, "Registration Complete", Toast.LENGTH_SHORT).show();

                                                backpress();




                                            }
                                        });

                                    } else {


                                    }
                                }
                            });
                }
            }
        });

    }

    private void backpress() {

        txt_fullName.setText("");
        txt_userName.setText("");
        txt_email.setText("");
        txt_password.setText("");
        txt_confirm_password.setText("");

        //if register successfull go to Login  activity
        startActivity(new Intent(getApplicationContext(), login_form.class));

    }


}

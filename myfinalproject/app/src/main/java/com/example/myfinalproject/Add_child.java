package com.example.myfinalproject;


import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Add_child extends AppCompatActivity {

    //declare every field and buutton
    EditText txt_childname, txt_address, txt_contactnumber, txt_countryname;
    Button addchild;
    public String dob;

    //for date picker dailog
    private EditText date;
    //DatePickerDialog.OnDateSetListener setListener;
    DatePickerDialog datePickerDialog;


     ChildData childdata;
     Schedule schedule;


    //create database reference
    DatabaseReference databaseReference;

    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_child);

        //casting views or find View by childDataID
        txt_childname =  findViewById(R.id.childname);
        txt_address = (EditText) findViewById(R.id.address);
        txt_contactnumber = (EditText) findViewById(R.id.contactnumber);
        txt_countryname = (EditText) findViewById(R.id.countryname);
        date = (EditText)findViewById(R.id.Date);
        addchild = (Button) findViewById(R.id.addchild);


        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        /*date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Add_child.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String Date = day+"/"+month+"/"+year;
                date.setText(Date);
            }
        };*/


        //on click listener method use for date picker
        //when someone click in this edit field this method will be run
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                datePickerDialog = new DatePickerDialog(Add_child.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {

                        date.setText(day+"-"+(month+1)+"-"+year);
                    }
                },year,month,day);

               datePickerDialog.show();

            }
        });



        childdata = new ChildData();
        schedule = new Schedule();


        //getInstance and create node in data base, give reference of helper class
        databaseReference = FirebaseDatabase.getInstance().getReference("ChildData");


    }

    public void btn_addchild(View view) {

        // From this field we get data and store in some string
        String add_childname = txt_childname.getText().toString();

        String add_address = txt_address.getText().toString();
        String add_contactnumber = txt_contactnumber.getText().toString();
        String add_countryname = txt_countryname.getText().toString();
        String add_date = date.getText().toString();



        //validation of registration form
        //condition for child name
        if (add_childname.isEmpty()) {
            txt_childname.setError("Please Enter Child Name");
        } else if (add_childname.length() < 4) {
            txt_childname.setError("Child Name Is Too Short");

            //condition for address
        } else if (add_address.isEmpty()) {
            txt_address.setError("Please Enter Address");


            //condition for contact number
        } else if (add_contactnumber.isEmpty()) {
            txt_contactnumber.setError("Please Enter Contact Number");


            //condition for country name
        } else if (add_countryname.isEmpty()) {
            txt_countryname.setError("Please Enter Country Name");


        } else {

           childdata.setAdd_childname(add_childname);
           childdata.setAddress(add_address);
           childdata.setContact_number(add_contactnumber);
           childdata.setCountry_name(add_countryname);
           childdata.setDate(add_date);




          String id =  databaseReference.push().getKey();
          childdata.setChildDataID(id);
          databaseReference.push().setValue(childdata);
            Toast.makeText(this, "successfull", Toast.LENGTH_SHORT).show();


            //schedule.setDd(add_date);


           /* Intent intent = new Intent(getApplicationContext(), Schedule.class);
            intent.putExtra("message", add_date);



            startActivity(intent);*/
           backbtn();






        }
    }

    private void backbtn() {


        txt_childname.setText("");
        txt_address.setText("");
        txt_contactnumber.setText("");
        txt_countryname.setText("");
        date.setText("");
        startActivity(new Intent(getApplicationContext(), Schedule.class));
    }

}






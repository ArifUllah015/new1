package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity implements OnItemClickListener {


    TextView d;

    //private String dd;
   // private String numberAsString;

    RecyclerView recyclerView;
    ScheduleRV scheduleRV;

    FirebaseAuth auth;
    DatabaseReference reference;

    List<ChildData> mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        mylist = new ArrayList<>();

        recyclerView = findViewById(R.id.scheduleRV);
        scheduleRV = new ScheduleRV(this,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(scheduleRV);

        reference = FirebaseDatabase.getInstance().getReference();


        reference.child("ChildData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ChildData childData = snapshot.getValue(ChildData.class);
                    mylist.add(childData);
                }
                scheduleRV.setList(mylist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });


       /* Intent intent = getIntent();
        String add_date = intent.getStringExtra("message");
        d.setText(add_date);*/
    }


    @Override
    public void getId(String id) {
        Intent intent = new Intent(Schedule.this, DetailsChild.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}

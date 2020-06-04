package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsChild extends AppCompatActivity {

    Intent intent;
    String id;
    DatabaseReference reference;

    TextView date;
    TextView frstV;
    String frst = "BCG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_child);

        reference = FirebaseDatabase.getInstance().getReference();
        intent = getIntent();
        id = intent.getStringExtra("id");

        date = findViewById(R.id.dateFinalTV);
        frstV = findViewById(R.id.firstVaccine);


        getData();


    }

    public void getData() {
        reference.child("ChildData").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    ChildData childData = snapshot.getValue(ChildData.class);
                    if (childData.getChildDataID().equals(id)) {
                        date.setText(childData.getDate().toString());
                        frstV.setText(frst);


                    }


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

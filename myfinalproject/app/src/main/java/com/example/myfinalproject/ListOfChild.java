package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListOfChild extends AppCompatActivity {

    //declare a list view
    ListView listView;

    //get the firebase reference
    FirebaseDatabase database;
    DatabaseReference ref;

    //need adapter to map a data from database to user info
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    //declare user
    ChildrenData childrenData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_child);

        //costing id or find by id
        listView = (ListView)findViewById(R.id.listView1);

        //initalize user information
        childrenData = new ChildrenData();

        //get instance of database
        database = FirebaseDatabase.getInstance();
        //specific node/child reference which is users table/child
        ref = database.getReference("ChildData");

        list = new ArrayList<>();
        //initalize adapter
        //go to layout of user_info and then go to userInfo textView
        adapter = new ArrayAdapter<String>(this,R.layout.child_info,R.id.childInfo,list);

        //add a method od add value event listener
        //create two method automatic which is onDataChange and onCancelled
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //for loop used for to get all user present in this table/child, using instance of dataSnapshot
                for(DataSnapshot ds: dataSnapshot.getChildren()){

                    //now i have successfully access to all children in the database
                    //next we need to add these children to the adapter

                    //we need a instance of user
                    //get value and convert to user type
                    childrenData = ds.getValue(ChildrenData.class);
                    //now add this to our list
                    list.add(childrenData.getAdd_childname().toString()+"\n"+childrenData.getDate().toString());

                }
                //set adapter to our listView
                listView.setAdapter(adapter);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

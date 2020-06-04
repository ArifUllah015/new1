package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class dashboard extends AppCompatActivity implements View.OnClickListener{

    //declare all variable
    private CardView prof,addchild,viewchild,Event,Schedule,Info,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //casting childDataID Or find view by childDataID Or defining cards
        prof = (CardView)findViewById(R.id.profile);
        addchild = (CardView)findViewById(R.id.add_child);
        viewchild = (CardView)findViewById(R.id.view_child);
        Event = (CardView)findViewById(R.id.event);
        Schedule = (CardView)findViewById(R.id.schedule);
        Info = (CardView)findViewById(R.id.info);
        map = (CardView)findViewById(R.id.maps);

        //add click Listener to the cards
        prof.setOnClickListener(this);
        addchild.setOnClickListener(this);
        viewchild.setOnClickListener(this);
        Event.setOnClickListener(this);
        Schedule.setOnClickListener(this);
        Info.setOnClickListener(this);
        map.setOnClickListener(this);


     // now onClick Method will called every time we click a CardView
    }


    @Override
    public void onClick(View v) {

        // we use a switch case for this methods

        // initialized Intent by i
        Intent i;
        switch (v.getId()) {
            case R.id.profile:
                i = new Intent(this, Profile.class);
                startActivity(i);
                break;

            case R.id.add_child:
                i = new Intent(this, Add_child.class);
                startActivity(i);
                break;

            case R.id.view_child:
                i = new Intent(this, View_Child.class);
                startActivity(i);
                break;

            case R.id.event:
                i = new Intent(this, Event.class);
                startActivity(i);
                break;

            case R.id.schedule:
                i = new Intent(this, Schedule.class);
                startActivity(i);
                break;

            case R.id.info:
                i = new Intent(this, Info.class);
                startActivity(i);
                break;

            case R.id.maps:
                i = new Intent(this, MapsActivity.class);
                startActivity(i);
                break;
                default:break;
        }
    }
}

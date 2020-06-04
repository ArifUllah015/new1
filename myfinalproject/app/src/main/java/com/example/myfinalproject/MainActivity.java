package com.example.myfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declare the textView and imageView
    private TextView textView;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the TextView and ImageView by it's childDataID
        textView = (TextView)findViewById(R.id.tv);
        imageView = (ImageView)findViewById(R.id.iv);

       //use animation with name of myanim
        //with the load of this activity animation display in some time (time we use in mytransition file)
        //give the reference of directory and animation file (R.childDataID.anim.mytransition)



        Animation myanim = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        //start the animation
        //pass animation name to TextView and ImageView and start the animation
        textView.startAnimation(myanim);
        imageView.startAnimation(myanim);


        //create a thread
        //thread is used for long operation
        Thread timer = new Thread(){

            public void run(){
                try {
                    //it hold the welcome screen for 5000 millis
                    sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    //after 5000 millis display login form
                    startActivity(new Intent(getApplication(), login_form.class));
                    finish();
                }
            }
        };
        timer.start();


    }


}

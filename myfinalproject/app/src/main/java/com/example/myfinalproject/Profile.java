package com.example.myfinalproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;

public class Profile extends AppCompatActivity {

 //declare all the text view and image view or UI reference
     TextView userName,fullname,Email,gender;
     Button btn_logout;

     private FirebaseDatabase mFirebaseDatabase;
     private FirebaseAuth mAuth;
     private FirebaseAuth.AuthStateListener mAuthListener;
     private DatabaseReference myRef;
     private String userID;




    /* private ImageView user_profile;
    private Button btn_choose;
    private  Button btn_upload;*/

    //private TextView user_name;
   // private TextView full_name,email,gender;

    //for file path store
   /* private Uri filepath;

    private FirebaseStorage storage;
    private StorageReference storageReference;*/




    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userName = (TextView)findViewById(R.id.username_profile_textview);
        fullname = (TextView)findViewById(R.id.Fullname_profile_textview);
        Email = (TextView)findViewById(R.id.Email_profile_textview);
        gender = (TextView)findViewById(R.id.gender_profile_textview);




        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();
        FirebaseUser user = mAuth.getCurrentUser();
        userID = user.getUid();




        //find view by childDataID or casting the childDataID

       /* user_profile = (ImageView)findViewById(R.id.user_imageview);
        btn_choose = (Button)findViewById(R.id.choose);
        btn_upload = (Button) findViewById(R.id.upload);*/

        /*user_name = (TextView)findViewById(R.childDataID.username_profile_textview);
        full_name = (TextView)findViewById(R.childDataID.Fullname_profile_textview);
        email = (TextView) findViewById(R.childDataID.Email_profile_textview);
        gender = (TextView) findViewById(R.childDataID.gender_profile_textview);*/


        //get instance
       /* storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();*/



        //method use for upload button

       /* btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //call this method for uploading process
                uploadImage();

            }
        });

       //method use for choose image from gallery
        btn_choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call this method below
                chooseImage();

            }
        });*/

}



    //same like upload Image method
   /* private void chooseImage() {

        //use for choosing image from gallery
        Intent intent = new Intent();

        //we set image type (which we gonna choose.e.g,image,audio,video)
        //in this type every image will show either its gpg,png etc
        intent.setType("image/*");

        //set action
        intent.setAction(Intent.ACTION_GET_CONTENT);

        //we start a activity in which we use create chooser and tittle and a request code
        //now for that we use a method "on activity result" below
       startActivityForResult(Intent.createChooser(intent,"Select image"),1);

    }*/

    //here we use on activity result method
    //simply override this method by(right click+generate+override method)
 /*   @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //functionalities use for selecting  image
        if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){

            //data assign to file path
            //these data which are selected(image)
            filepath = data.getData();

            //now we use bitmap for passing the image
            //we we try and catch for error resolving

            try {
              Bitmap  bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filepath);

                //now we set this image in our imageview which we declare above
                user_profile.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }*/


    //this method is called in above upload method
    /* private void uploadImage() {

        if (filepath != null){

            //code for showing the progress dialog
            final ProgressDialog progressDialog = new ProgressDialog(this);
            //set a title for this progress dialog
            progressDialog.setTitle("Uploading...");
            //now show the progress dialog
            progressDialog.show();



            //using storage reference create a child
            StorageReference reference = storageReference.child("images/" + UUID.randomUUID().toString());

            //use method put to out the data
            reference.putFile(filepath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    //progress dialog dismiss
                    progressDialog.dismiss();
                    //if image is uploaded show a toast message
                    Toast.makeText(Profile.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
                }
            })
                    //other method use for showing the progress
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {

                            //progress show in dialog
                            //it will show progress in %(percentage)
                            double progres = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                            progressDialog.setMessage("Uploaded"+(int)progres+"%");


                        }
                    });
        }
    } */
}
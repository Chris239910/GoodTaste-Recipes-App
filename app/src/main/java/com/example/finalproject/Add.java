package com.example.finalproject;

//WangYuntao

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

public class Add<button> extends AppCompatActivity{
    EditText ItemName, ItemDescription,ItemTime;
    ImageView recipeImage;
    Food food;
    Uri uri;
    String imageUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiy_add);
        ItemName = findViewById(R.id.editTextItemName);
        ItemDescription = findViewById(R.id.editTextItemDescription);
        ItemTime = findViewById(R.id.editTextItemTime);
        recipeImage = findViewById(R.id.iv_foodImage);
    }
    public void btnSelectImage(View view){
        Intent photoPicker = new Intent();
        photoPicker .setType("image/*");
        photoPicker .setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(photoPicker, "Select Photo"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            uri = data.getData();
            recipeImage.setImageURI(uri);
        }
        else Toast.makeText(this,"You haven't pick image", Toast.LENGTH_SHORT).show();
    }

    public void uploadImage(){
        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images").child(uri.getLastPathSegment());
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Recipe Uploading..");
        progressDialog.show();
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri uriImage = uriTask.getResult();
                imageUrl = uriImage.toString();
                uploadRecipe();
                progressDialog.dismiss();
                //Toast.makeText(Add.this,"Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
            }
        });
    }

    public void btnUploadRecipe(View view) {
        uploadImage();
    }

    public void uploadRecipe(){

        StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("images").child(uri.getLastPathSegment());

        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage = uriTask.getResult();
                imageUrl = urlImage.toString();
                uploadRecipe();
                //Toast.makeText(Add.this,"Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        });
        Food food = new Food(
                ItemName.getText().toString(),
                ItemDescription.getText().toString(),
                ItemTime.getText().toString(),
                imageUrl
        );
        String myCurrentDateTime = DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime());
        FirebaseDatabase.getInstance().getReference("Recipe").child(myCurrentDateTime).setValue(food).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Add.this,"Recipe Uploaded", Toast.LENGTH_SHORT).show();
                    finish();
                    //Intent intent = new Intent(Add.this, MainActivity.class);
                    //this.startActivity(intent);

                }
            }

            //private void startActivity(Intent intent) {
            //}
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Add.this,e.getMessage().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}

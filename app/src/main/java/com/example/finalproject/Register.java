package com.example.finalproject;
//Chris
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    TextView btn;
    private EditText inputEmail, inputPassword, inputConfirmPassword;
    Button btnRegister;
    private FirebaseAuth mAuth;
    private ProgressDialog mLoadingBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        btn = findViewById(R.id.alreadyHaveAccount);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        mAuth = FirebaseAuth.getInstance();
        mLoadingBar = new ProgressDialog(Register.this);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                checkCredentials();

            }
        });
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, Login.class));

            }
        });
    }
    private void checkCredentials(){
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConfirmPassword.getText().toString();
        if (email.isEmpty() || !email.contains("@")){
            showError(inputEmail, "Email is not valid");
        }
        else if (password.isEmpty()||password.length() <7){
            showError(inputPassword, "Password must be more than 7 characters");
        }
        else if (confirmPassword.isEmpty() || !confirmPassword.equals(password)){
            showError(inputConfirmPassword, "Password is not match");
        }
        else{
            mLoadingBar.setTitle("Registration");
            mLoadingBar.setMessage("Please wait while checking your credentials");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();

            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        String email = inputEmail.getText().toString();
                        Toast.makeText(Register.this, "Successfully Registration", Toast.LENGTH_LONG).show();
                        mLoadingBar.dismiss();
                        Intent intent = new Intent(Register.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    }
                    else {
                        Toast.makeText(Register.this, "Cannot register", Toast.LENGTH_LONG).show();
                        mLoadingBar.dismiss();
                    }
                }
            });
            
        }
    }
    private void showError(EditText input, String s){
        input.setError(s);
        input.requestFocus();
    }
}
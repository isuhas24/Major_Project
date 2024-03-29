package com.example.majorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {


    EditText mEmail,mPassword;
    ImageView mlogindbtn;
    TextView mRegn;
    ProgressBar progressBar;

    FirebaseAuth fAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.Email);
        mPassword = findViewById(R.id.Password);
        mRegn = findViewById(R.id.Regn);
        progressBar = findViewById(R.id.progressBar);
        mlogindbtn = findViewById(R.id.logindbtn);
        fAuth = FirebaseAuth.getInstance();


        mRegn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }

        });


        mlogindbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = mEmail.getText().toString().trim();
                String Password = mPassword.getText().toString().trim();


                if (TextUtils.isEmpty(Email))
                {
                    mEmail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(Password))
                {
                    mPassword.setError("Password is Required");
                }

                if (Password.length() < 6)
                {
                    mPassword.setError("Password must be > = 6 character");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                fAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),LandingPage.class));
                        }

                        else
                        {

                            Toast.makeText(getApplicationContext(), "Please Enter Valid Email & Password", Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }


                });



            }

        });






    }
}
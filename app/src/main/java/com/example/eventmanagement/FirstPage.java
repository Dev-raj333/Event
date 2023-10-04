package com.example.eventmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FirstPage extends AppCompatActivity {
    Button signup,login;
    TextView fpw;
    EditText email,password;

    MyDbHelper myDbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);

        login=findViewById(R.id.btnLogin);
        signup=findViewById(R.id.btnSignup);
        fpw=findViewById(R.id.forgotpw);
        myDbHelper = new MyDbHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SQLiteDatabase db= myDbHelper.getWritableDatabase();
                Intent i=new Intent(FirstPage.this,SignupPage.class);
                startActivity(i);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (valid()) {
                    String enteredEmail = email.getText().toString();
                    String enteredPassword = password.getText().toString();

                    if (myDbHelper.checkAdmin(enteredEmail, enteredPassword)) {
                        Toast.makeText(FirstPage.this, "Admin Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(FirstPage.this, AdminActivity.class);
                        startActivity(i);
                    } else if(myDbHelper.checkUsernamePassword(enteredEmail, enteredPassword)) {
                        Toast.makeText(FirstPage.this, "User Login Successful", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(FirstPage.this, UserActivity.class);
                        startActivity(i);
                    }else{
                        Toast.makeText(FirstPage.this, "User login failure", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            private boolean valid() {
                boolean validation=true;
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Email cannot be empty");
                    validation=false;
                }
                if(TextUtils.isEmpty(password.getText().toString())){
                    password.setError("Password cannot be empty");
                    validation=false;
                }
                return validation;
            }
       });

        fpw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(FirstPage.this,ForgotPassword.class);
                startActivity(i);
            }
        });
    }
}
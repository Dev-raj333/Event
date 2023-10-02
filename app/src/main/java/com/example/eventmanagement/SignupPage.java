package com.example.eventmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignupPage extends AppCompatActivity {

    TextView exacc;
    EditText name,address,email,phone,pw;
    Button signup;
    MyDbHelper myDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_page);
        exacc=findViewById(R.id.textViewLogin);
        name=findViewById(R.id.editTextName);
        address=findViewById(R.id.editaddress);
        email=findViewById(R.id.editTextEmail);
        phone=findViewById(R.id.editphoneno);
        pw=findViewById(R.id.editTextPassword);

        signup=findViewById(R.id.buttonSignup);
        myDbHelper = new MyDbHelper(this);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = name.getText().toString();
                String emails = email.getText().toString();
                String password = pw.getText().toString();
                String userAddress = address.getText().toString();
                String contact = phone.getText().toString();

                if(valid()){
                    //user registration
                    myDbHelper.insertUser(username,emails,password,userAddress,contact);
                    Toast.makeText(getApplicationContext(),"Successfully added",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignupPage.this,FirstPage.class);
                    startActivity(i);


                }else {
                    Toast.makeText(SignupPage.this,"User Registration Unsuccessful \n", Toast.LENGTH_SHORT).show();

                }
            }

            private boolean valid() {
                boolean validation=true;
                String error = "";
                if(TextUtils.isEmpty(name.getText().toString())){
                    name.setError("Name cannot be empty");
                    error +="name";
                    validation=false;
                }
                if(TextUtils.isEmpty(address.getText().toString())){
                    address.setError("Address cannot be empty");
                    error +="Address";
                    validation=false;
                }
                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Email cannot be empty");
                    error +="Email";
                    validation=false;
                }
                if(TextUtils.isEmpty(phone.getText().toString())){
                    phone.setError("Phone number cannot be empty");
                    error +="Phone";
                    validation=false;
                }
                if(TextUtils.isEmpty(pw.getText().toString())){
                    pw.setError("Password cannot be empty");
                    error +="Password";
                    validation=false;
                }

                if(!validation)
                    Toast.makeText(SignupPage.this, error,Toast.LENGTH_SHORT).show();

                return validation;
            }
        });

        exacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(SignupPage.this,FirstPage.class);
                startActivity(i);
            }
        });
    }
}
package com.example.eventmanagement;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class ForgotPassword extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetButton;
    private ProgressBar progressBar;
    String strEmail;
    PasswordGenerator pg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        emailEditText = findViewById(R.id.recoverEmail);
        resetButton = findViewById(R.id.btnreset);
        progressBar = findViewById(R.id.forgotpw);

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strEmail=emailEditText.getText().toString();
                if(!TextUtils.isEmpty(strEmail)){
                    ResetPassword();
                }else{
                    emailEditText.setError("Email field cant be empty");
                }
            }
        });


    }

    private void ResetPassword() {
        pg= new PasswordGenerator();
        progressBar.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
        String mEmail = emailEditText.getText().toString();
        String mSubject = "Reset password";
        String password = pg.generatePassword(5);
        SendEmail sendEmail = new SendEmail(this, mEmail, mSubject, password);
        sendEmail.execute();
            Toast.makeText(ForgotPassword.this, "Reset Password link has been sent to your mail", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(ForgotPassword.this,FirstPage.class);
            startActivity(intent);
            finish();
    }

    // ... rest of your code ...
}








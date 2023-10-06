package com.example.eventmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RatingBar;
import android.widget.Toast;

public class ReviewActivity extends AppCompatActivity {
    private MultiAutoCompleteTextView feedbackEditText;
    private RatingBar ratingBar;
    private Button submitButton;
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        feedbackEditText = findViewById(R.id.feedbackEditText);
        ratingBar = findViewById(R.id.ratingBar);
        submitButton = findViewById(R.id.submitButton);
        String userId = getIntent().getStringExtra("userId");
        String vId = getIntent().getStringExtra("vid");
        myDbHelper = new MyDbHelper(this);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitReview(userId, vId);
            }
        });
    }
    private void submitReview(String userId,String vId) {
        String feedback = feedbackEditText.getText().toString();
        String rating = String.valueOf(ratingBar.getRating());
        myDbHelper.insertRating(userId,vId, rating, feedback);
        String message = "Feedback: " + feedback + "\nRating: " + rating;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}
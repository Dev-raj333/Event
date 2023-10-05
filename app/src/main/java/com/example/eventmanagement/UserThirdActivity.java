package com.example.eventmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class UserThirdActivity extends AppCompatActivity {
    private LinearLayout servicesLayout;
    private Button saveButton;
    private String selectedServices = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_third);
        servicesLayout = findViewById(R.id.servicesLayout);
        saveButton = findViewById(R.id.btnsave);


        View.OnClickListener serviceClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button selectedButton = (Button) v;
                String serviceName = selectedButton.getText().toString();
                if (selectedServices.contains(serviceName)) {
                    selectedServices = selectedServices.replace(serviceName + ", ", "");
                    selectedButton.setBackgroundColor(getResources().getColor(android.R.color.transparent));
                } else {
                    selectedServices += serviceName + ", ";
                    selectedButton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
                }
            }
        };

        for (int i = 0; i < servicesLayout.getChildCount(); i++) {
            View child = servicesLayout.getChildAt(i);
            if (child instanceof Button) {
                Button serviceButton = (Button) child;
                serviceButton.setOnClickListener(serviceClickListener);
            }
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Remove the trailing comma and space
                if (selectedServices.length() > 0) {
                    selectedServices = selectedServices.substring(0, selectedServices.length() - 2);
                    Intent i = new Intent(UserThirdActivity.this, UserActivity.class);
                    startActivity(i);

                }
           }
        });

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.eventmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminAddvenuedetails extends AppCompatActivity {

    private EditText nameEditText, addressEditText, occupancyEditText, emailEditText, numberEditText;
    private Button saveButton;

    MyDbHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvenuedetailsadmin);

        nameEditText = findViewById(R.id.add_name);
        addressEditText = findViewById(R.id.add_address);
        occupancyEditText = findViewById(R.id.add_occupancy);
        emailEditText = findViewById(R.id.add_email);
        numberEditText = findViewById(R.id.add_number);
        saveButton = findViewById(R.id.save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String occupancy = occupancyEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String number = numberEditText.getText().toString();

                if(name.isEmpty() || address.isEmpty() || occupancy.isEmpty() || email.isEmpty() || number.isEmpty()){
                    Toast.makeText(AdminAddvenuedetails.this,"Please fill up the field", Toast.LENGTH_SHORT).show();
                }else{
                    Venue venue = new Venue(name,address, occupancy, email, number);
                    long rowID = database.insertVenue(venue);
                    if(rowID != -1){
                        Toast.makeText(AdminAddvenuedetails.this,"Data inserted sucessfully",Toast.LENGTH_SHORT).show();
                        clearInputs();
                    }else {
                        Toast.makeText(AdminAddvenuedetails.this,"Error inserting data", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
    private void clearInputs() {
        nameEditText.setText("");
        addressEditText.setText("");
        occupancyEditText.setText("");
        emailEditText.setText("");
        numberEditText.setText("");
    }
}





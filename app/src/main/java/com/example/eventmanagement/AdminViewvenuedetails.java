package com.example.eventmanagement;


import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AdminViewvenuedetails extends AppCompatActivity {

    private TextView nameTextView, addressTextView, occupancyTextView, emailTextView, numberTextView;
    ListView listView;

    private CustomVenueAdaptor customVenueAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_adminviewbooking);

        // Initialize TextViews
        listView = findViewById(R.id.adminlistview);
//        nameTextView = findViewById(R.id.view_name);
//        addressTextView = findViewById(R.id.view_address);
//        occupancyTextView = findViewById(R.id.view_occupancy);
//        emailTextView = findViewById(R.id.view_email);
//        numberTextView = findViewById(R.id.view_number);

        // Retrieve venueId from intent
        String venueId = getIntent().getStringExtra("venueId");

        // Initialize Firebase
//        DatabaseReference venueRef = FirebaseDatabase.getInstance().getReference("addvenue").child(venueId);
        DatabaseReference venueRef = FirebaseDatabase.getInstance().getReference("addvenue");
        List<Venue> venueList = new ArrayList<>();
//        venueRef.addListenerForSingleValueEvent(new ValueEventListener() {
        venueRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //TODO: here should get venues
                venueList.clear();
                for(DataSnapshot venueSnapshot : snapshot.getChildren()) {
                    Venue venue = venueSnapshot.getValue(Venue.class);
                    Log.e("reached", "here");
                    if(venue != null) {
                        Log.e("venue list", venue.getName());
                        venueList.add(venue);
                    }
                }

                customVenueAdaptor = new CustomVenueAdaptor(AdminViewvenuedetails.this, venueList);
                listView.setAdapter(customVenueAdaptor);
                /** this is replaced with above code
                if (snapshot.exists()) {
                    Venue venue = snapshot.getValue(Venue.class);
                    if (venue != null) {
                        Log.e("venue","is not empty");
                        // Populate the UI elements with the retrieved venue details
                        nameTextView.setText("Name: " + venue.getName());
                        addressTextView.setText("Address: " + venue.getAddress());
                        occupancyTextView.setText("Occupancy: " + venue.getOccupancy());
                        emailTextView.setText("Email: " + venue.getEmail());
                        numberTextView.setText("Number: " + venue.getNumber());
                    }
                    else {
                        //todo: test
                        Log.e("venue","is empty");
                        nameTextView.setText("here");
                    }
                }else {
                    Log.e("Error","snapshot is empty");
                }
                */
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Handle error
            }
        });
    }
}

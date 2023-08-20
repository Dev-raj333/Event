package com.example.eventmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AdminViewBookingFragment extends Fragment {

    public AdminViewBookingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewbooking, container, false);

        // Initialize RecyclerView and Adapter
        RecyclerView bookingsRecyclerView = view.findViewById(R.id.bookingRecyclerview);
        // Initialize your adapter and attach it to the RecyclerView

        // Retrieve booking details from the database
        DatabaseReference bookingsRef = FirebaseDatabase.getInstance().getReference("Event");
        bookingsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot bookingSnapshot : userSnapshot.getChildren()) {
                       // BookingDetails booking = bookingSnapshot.getValue(BookingDetails.class);     before
                        Event event = bookingSnapshot.getValue(Event.class);
                        // Add booking to your adapter's data list
                    }
                }
                // Notify your adapter that data has changed
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle errors
            }
        });

        return view;
    }
}
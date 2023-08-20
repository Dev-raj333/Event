package com.example.eventmanagement;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class AdminVenuesFragment extends Fragment {


    Button addvenue,viewvenue;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_admin_venues, container, false);


        addvenue=view.findViewById(R.id.addvenues);
        viewvenue=view.findViewById(R.id.viewvenues);

        addvenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getContext(), AdminAddvenuedetails.class);
                startActivity(i);
            }
        });

        viewvenue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String venueId = "venue_id_placeholder";
                Intent intent = new Intent(getContext(), AdminViewvenuedetails.class);

                intent.putExtra("venueId", venueId); // Make sure venueId is not null
                startActivity(intent);
            }

        });

        return view;

    }

}
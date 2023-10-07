package com.example.eventmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AlertDialog;

import java.util.List;

public class CustomVenueEditAdaptor extends ArrayAdapter<Venue> {
    private final List<Venue> venueList;
    private Context context;

    public CustomVenueEditAdaptor(Context context, int fragment_venue_review, List<Venue> venueList){
        super(context, R.layout.viewuser, venueList);
        this.venueList = venueList;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.viewuser, parent,false);
        final Venue venue = getItem(position);
        TextView name = view.findViewById(R.id.view_name);
        TextView address = view.findViewById(R.id.view_address);
        TextView occupancy = view.findViewById(R.id.view_occupancy);
        TextView email = view.findViewById(R.id.view_email);
        TextView number = view.findViewById(R.id.view_number);
        name.setText("Name: "+venue.getName());
        address.setText("Address: " +venue.getAddress());
        occupancy.setText("Occupancy: " +venue.getOccupancy());
        email.setText("Email: "+venue.getEmail());
        number.setText("Contact No: " +venue.getNumber());

        return view;
    }
}

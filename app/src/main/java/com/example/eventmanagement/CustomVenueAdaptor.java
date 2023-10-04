package com.example.eventmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class CustomVenueAdaptor extends ArrayAdapter<Venue> {
    public CustomVenueAdaptor(Context context, int activity_admin_viewvenuedetails, List<Venue> venues){
        super(context, R.layout.venueview, venues);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.venueview, parent,false);

        TextView name = view.findViewById(R.id.view_name);
        TextView address = view.findViewById(R.id.view_address);
        TextView occupancy = view.findViewById(R.id.view_occupancy);
        TextView email = view.findViewById(R.id.view_email);
        TextView number = view.findViewById(R.id.view_number);

        Venue venueItems = getItem(position);
        name.setText("Name: "+venueItems.getName());
        address.setText("Address: " +venueItems.getAddress());
        occupancy.setText("Occupancy: " +venueItems.getOccupancy());
        email.setText("Email: "+venueItems.getEmail());
        number.setText("Contact No: " +venueItems.getNumber());

        return view;
    }
}

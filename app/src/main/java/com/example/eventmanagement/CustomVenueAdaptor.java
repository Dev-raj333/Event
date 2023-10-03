package com.example.eventmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import java.util.ArrayList;

public class CustomVenueAdaptor extends ArrayAdapter<Venue> {
    public CustomVenueAdaptor(Context context, ArrayList<Venue> venues){
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
        name.setText(venueItems.getName());
        address.setText(venueItems.getAddress());
        occupancy.setText(venueItems.getOccupancy());
        email.setText(venueItems.getEmail());
        number.setText(venueItems.getNumber());

        return view;
    }
}

package com.example.eventmanagement;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;
import java.util.List;

public class CustomVenueAdaptor extends ArrayAdapter<Venue> {
    private final List<Venue> venueList;
    private Context context;

    public CustomVenueAdaptor(Context context, int activity_admin_viewvenuedetails, List<Venue> venueList){
        super(context, R.layout.venueview, venueList);
        this.venueList = venueList;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.venueview, parent,false);
        final Venue venue = getItem(position);
        TextView name = view.findViewById(R.id.view_name);
        TextView address = view.findViewById(R.id.view_address);
        TextView occupancy = view.findViewById(R.id.view_occupancy);
        TextView email = view.findViewById(R.id.view_email);
        TextView number = view.findViewById(R.id.view_number);
        Button btnEdit = view.findViewById(R.id.edit);
        Button btnDelete = view.findViewById(R.id.delete);
        name.setText("Name: "+venue.getName());
        address.setText("Address: " +venue.getAddress());
        occupancy.setText("Occupancy: " +venue.getOccupancy());
        email.setText("Email: "+venue.getEmail());
        number.setText("Contact No: " +venue.getNumber());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = LayoutInflater.from(context).inflate(R.layout.dialoguebox_edit,null);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setView(dialogView);

                EditText editName = dialogView.findViewById(R.id.editName);
                EditText address = dialogView.findViewById(R.id.editAddress);
                EditText Occupancy = dialogView.findViewById(R.id.occupancy);
                EditText email = dialogView.findViewById(R.id.editEmail);
                EditText Contact = dialogView.findViewById(R.id.editContact);

                Button saveButton = dialogView.findViewById(R.id.saveButton);
                Button cancelButton = dialogView.findViewById(R.id.cancelButton);

                AlertDialog dialog = builder.create();

                saveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String id = venue.getVenueId();
                        String name = editName.getText().toString();
                        String add = address.getText().toString();
                        String occ = Occupancy.getText().toString();
                        String ema= email.getText().toString();
                        String contact = Contact.getText().toString();

                        MyDbHelper dbHelper = new MyDbHelper(getContext());
                        dbHelper.updateVenue(id,name,add, Integer.parseInt(occ),ema,contact);
                        notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });

                cancelButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDbHelper dbHelper = new MyDbHelper(getContext());
                String id = venue.getVenueId();
                dbHelper.deleteVenue(id);
                Toast.makeText(getContext(), "Successfully deleted",Toast.LENGTH_SHORT).show();
                venueList.remove(position);
                notifyDataSetChanged();
                }
        });
        return view;
    }
}

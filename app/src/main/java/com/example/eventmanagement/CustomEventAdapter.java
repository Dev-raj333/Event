package com.example.eventmanagement;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomEventAdapter extends ArrayAdapter<Event> {

    private List<Event> eventList;

    public CustomEventAdapter(@NonNull Context context, List<Event> eventList) {
        super(context, 0, eventList);
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adminviewbookingrelated, parent, false);
        }

        final Event event = getItem(position);
        Button btnConfirm = convertView.findViewById(R.id.confirmbutton);
        Button btnCancel = convertView.findViewById(R.id.cancelbutton);
        MyDbHelper dbHelper = new MyDbHelper(getContext());


        if (event != null) {
            TextView eventNameTextView = convertView.findViewById(R.id.eventName);
            TextView eventHotelTextView = convertView.findViewById(R.id.venueName);
            TextView eventServiceTextView = convertView.findViewById(R.id.eventService);
            TextView eventEntryDate = convertView.findViewById(R.id.eventEntryDate);
            TextView eventExitDate = convertView.findViewById(R.id.eventExitDate);
            TextView noGuest = convertView.findViewById(R.id.noGuest);
            TextView status = convertView.findViewById(R.id.status);
            TextView username = convertView.findViewById(R.id.username);
            String stat =event.getStatus();


            if(event.getStatus()=="completed"){
                eventNameTextView.setText("Empty pending event");
            }else{
                if (eventNameTextView != null) {
                    eventNameTextView.setText("Event Name: " +event.getEventName());
                }

                if (eventHotelTextView != null) {
                    eventHotelTextView.setText("Venue Name: " +event.getVenueName());
                }
                if (eventServiceTextView != null) {
                    eventServiceTextView.setText("Service Type: "+ event.getSelectedServices());
                }
                if (eventEntryDate != null) {
                    eventEntryDate.setText("Entry Date: "+event.getEntryDate());
                }
                if (eventExitDate != null) {
                    eventExitDate.setText("Exit Date: " +event.getExitDate());
                }
                if (noGuest != null) {
                    noGuest.setText("No of Guest: " +event.getNumberOfGuests());
                }

                if (username != null) {
                    username.setText("Name: " +event.getUsername());
                }
                if (status != null) {
                    status.setText("Status: " +event.getStatus());
                }
            }
        }
        btnConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String id = event.geteId();
                dbHelper.updateEvent(id);
                Toast.makeText(getContext(), "Booking accepted successfully",Toast.LENGTH_SHORT).show();
                eventList.remove(event);
                notifyDataSetChanged();
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = event.geteId();
                dbHelper.deleteEvent(id);
                eventList.remove(position);
                notifyDataSetChanged();
            }
        });
        return convertView;
    }
    private void refreshUI(){

    }
}

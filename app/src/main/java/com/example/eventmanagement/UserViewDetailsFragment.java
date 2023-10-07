package com.example.eventmanagement;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class UserViewDetailsFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_details, container, false);
        List<Event> eventList = new ArrayList<>();
        MyDbHelper myDbHelper = new MyDbHelper(getContext());
        eventList =myDbHelper.selectEvent();
        final TextView selectedEventTextView = view.findViewById(R.id.selectedevent);
        ;
        final TextView selectedHotelTextView = view.findViewById(R.id.selectedhotel);
        final TextView selectedServicesTextView = view.findViewById(R.id.services);
        final TextView eventNameTextView = view.findViewById(R.id.eventname1);
        final TextView guestsTextView = view.findViewById(R.id.guests1);
        final TextView entryDateTextView = view.findViewById(R.id.entrydate1);
        final TextView exitDateTextView = view.findViewById(R.id.exitdate1);

        return view;
    }
}
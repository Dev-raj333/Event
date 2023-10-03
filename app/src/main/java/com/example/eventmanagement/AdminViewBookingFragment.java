package com.example.eventmanagement;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

public class AdminViewBookingFragment extends Fragment {

    private List<Event> eventList = new ArrayList<>();
    private CustomEventAdapter customAdapter;



    public AdminViewBookingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adminviewbooking, container, false);

        //confirmButton = view.findViewById(R.id.confirmbutton);

        // Initialize ListView and CustomEventAdapter
        ListView listView = view.findViewById(R.id.adminlistview);


        return view;
    }
}
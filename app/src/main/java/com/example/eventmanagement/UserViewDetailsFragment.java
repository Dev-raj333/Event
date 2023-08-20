package com.example.eventmanagement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class UserViewDetailsFragment extends Fragment {

    private TextView eventtextview;
    private TextView hoteltextview;
    private TextView detailstextview;
    private TextView servicestextview;




    public UserViewDetailsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_details, container, false);

        eventtextview = view.findViewById(R.id.selectedevent);
        hoteltextview = view.findViewById(R.id.selectedhotel);
        detailstextview = view.findViewById(R.id.eventdetails);
        servicestextview = view.findViewById(R.id.services);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String selectedEvent = arguments.getString("selected_event");
            String selectedHotel = arguments.getString("selected_hotel");
            String selectedDetails = arguments.getString("selected_details");
            String selectedServices = arguments.getString("selected_services");

            eventtextview.setText(selectedEvent);
            hoteltextview.setText(selectedHotel);
            detailstextview.setText(selectedDetails);
            servicestextview.setText(selectedServices);
        }

        return view;
    }
}
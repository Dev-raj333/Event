package com.example.eventmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class VenueReview extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    MyDbHelper dbHelper;

    boolean isFragmentVisible = false;
    CustomVenueEditAdaptor customVenueEditAdaptor;
    public VenueReview() {
        // Required empty public constructor
    }


    public static VenueReview newInstance(String param1, String param2) {
        VenueReview fragment = new VenueReview();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbHelper = new MyDbHelper(getActivity());
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_venue_review, container, false);
        ListView listView = view.findViewById(R.id.listview1);
        String userId = getArguments().getString("userId");


        List<Venue> venueList = dbHelper.getEventVenue(userId);


        customVenueEditAdaptor = new CustomVenueEditAdaptor(getActivity(), R.layout.fragment_venue_review, venueList);
        listView.setAdapter(customVenueEditAdaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Venue selectedVenue = venueList.get(position);
                String vid = selectedVenue.getVenueId();
                Intent intent = new Intent(getActivity(),ReviewActivity.class);
                intent.putExtra("uid",userId);
                intent.putExtra("vid",vid);
                startActivity(intent);

            }
        });
        return view;
        }

}
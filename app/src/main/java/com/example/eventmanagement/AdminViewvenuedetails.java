package com.example.eventmanagement;


import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.selects.WhileSelectKt;


public class AdminViewvenuedetails extends AppCompatActivity {

    private TextView nameTextView, addressTextView, occupancyTextView, emailTextView, numberTextView;
    ListView listView;
    MyDbHelper dbHelper = new MyDbHelper(this);


    private CustomVenueAdaptor customVenueAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_viewvenuedetails);

        // Initialize TextViews
        listView = findViewById(R.id.list_view);
        List<Venue> venueList = dbHelper.getAllVenues();
        customVenueAdaptor = new CustomVenueAdaptor(this, R.layout.activity_admin_viewvenuedetails, venueList);
        listView.setAdapter(customVenueAdaptor);
    }
}

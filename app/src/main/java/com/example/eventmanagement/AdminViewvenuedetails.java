package com.example.eventmanagement;


import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class AdminViewvenuedetails extends AppCompatActivity {

    private TextView nameTextView, addressTextView, occupancyTextView, emailTextView, numberTextView;
    ListView listView;

    private CustomVenueAdaptor customVenueAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_viewvenuedetails);

        // Initialize TextViews
        listView = findViewById(R.id.list_view);
        ArrayList<Venue> dataList = get

    }
}

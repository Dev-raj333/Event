package com.example.eventmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.List;


public class UserSecondActivity extends AppCompatActivity {

    CardView cardview;

    private String selectHotel;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    MyDbHelper myDbHelper = new MyDbHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_second);
        List<Venue> venueList = myDbHelper.getAllVenues();
        String selectEvent = getIntent().getStringExtra("selected_event");
        String uid = getIntent().getStringExtra("uid");
        RecyclerView recyclerVenueAdapter = findViewById(R.id.recycleview);
        layoutManager = new LinearLayoutManager(this);
        recyclerVenueAdapter.setLayoutManager(layoutManager);

        adapter = new RecyclerVenueAdapter(venueList,selectEvent,uid, this);
        recyclerVenueAdapter.setAdapter(adapter);
    }
   }
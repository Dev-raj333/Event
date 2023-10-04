package com.example.eventmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import java.util.List;


public class UserSecondActivity extends AppCompatActivity {

    CardView cardview,cardview1,cardview2,cardview3,cardview4,cardview5;

    private String selectHotel;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    MyDbHelper myDbHelper = new MyDbHelper(this);
   // private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_second);
        List<Venue> venueList = myDbHelper.getAllVenues();
        String selectEvent = getIntent().getStringExtra("selected_event");
        RecyclerView recyclerVenueAdapter = findViewById(R.id.recycleview);
        layoutManager = new LinearLayoutManager(this);
        recyclerVenueAdapter.setLayoutManager(layoutManager);

        adapter = new RecyclerVenueAdapter(venueList,selectEvent, this);
        recyclerVenueAdapter.setAdapter(adapter);


        cardview = findViewById(R.id.cardview);
//        cardview1 = findViewById(R.id.cardview1);
//        cardview2 = findViewById(R.id.cardview2);
//        cardview3 = findViewById(R.id.cardview3);
//        cardview4 = findViewById(R.id.cardview4);
//        cardview5 = findViewById(R.id.cardview5);



        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectEvent = getIntent().getStringExtra("selected_event");
                selectHotel = "Hotel Pabera";

                Intent i = new Intent(UserSecondActivity.this, BookEventActivity.class);
                i.putExtra("selected_hotel", selectHotel);
                i.putExtra("selected_event", selectEvent);
                startActivity(i);
            }
        });
    }
   }
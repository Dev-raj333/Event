package com.example.eventmanagement;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


public class UserSecondActivity extends AppCompatActivity {

    CardView cardview,cardview1,cardview2,cardview3,cardview4,cardview5;

    private String selectHotel;

   // private DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_second);

        cardview = findViewById(R.id.cardview);
        cardview1 = findViewById(R.id.cardview1);
        cardview2 = findViewById(R.id.cardview2);
        cardview3 = findViewById(R.id.cardview3);
        cardview4 = findViewById(R.id.cardview4);
        cardview5 = findViewById(R.id.cardview5);


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
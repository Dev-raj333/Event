package com.example.eventmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    Handler h=new Handler();
    ImageView gif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDbHelper db = new MyDbHelper(this);
        SQLiteDatabase db2 = db.getWritableDatabase();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(MainActivity.this,FirstPage.class);
                startActivity(i);
            }
        } ,1000);
    }

    }

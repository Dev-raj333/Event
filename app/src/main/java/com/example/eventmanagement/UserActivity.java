package com.example.eventmanagement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {


    FrameLayout fl;
    FragmentTransaction ft;
    DrawerLayout dl;
    NavigationView nv;
    ActionBarDrawerToggle adt;
    Toolbar tb;
    CardView cv1, cv2, cv3, cv4, cv5, cv6;

    private String selectEvent;


    private void replaceFragment(Fragment fragment, String userId) {
        fl.setVisibility(View.VISIBLE);
        Bundle bundle = new Bundle();
        bundle.putString("userId",userId);
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framelayout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        MyDbHelper myDbHelper= new MyDbHelper(this);

        cv1 = findViewById(R.id.card1);
        cv2 = findViewById(R.id.card2);
        cv3 = findViewById(R.id.card3);
        cv4 = findViewById(R.id.card4);
        cv5 = findViewById(R.id.card5);
        cv6 = findViewById(R.id.card6);

        Cursor cursor = myDbHelper.selectUser();
        List<User> userList = new ArrayList<>();
        if(cursor.moveToNext()){
            do{
                @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex("uid"));
                Log.d("Id", id);
                @SuppressLint("Range") String username = cursor.getString(cursor.getColumnIndex("username"));
                @SuppressLint("Range") String email = cursor.getString(cursor.getColumnIndex("email"));
                @SuppressLint("Range") String password = cursor.getString(cursor.getColumnIndex("password"));
                @SuppressLint("Range") String address = cursor.getString(cursor.getColumnIndex("address"));
                @SuppressLint("Range") String phoneNumber = cursor.getString(cursor.getColumnIndex("phoneNumber"));

                User user = new User(id, username, email, password, address, phoneNumber);
                userList.add(user);
            }while (cursor.moveToNext());
        }
        String username = getIntent().getStringExtra("username");

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEvent = "Wedding";
                String id = null;
                for (User user : userList) {
                    if (user.getEmail().equals(username)) {
                        id = user.getUserId();
                    }
                }

                Intent i = new Intent(UserActivity.this, UserSecondActivity.class);
                i.putExtra("selected_event", selectEvent);
                i.putExtra("uid", id);

                startActivity(i);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEvent = "Anniversary";
                String id = null;
                for (User user : userList) {
                    if (user.getEmail().equals(username)) {
                        id = user.getUserId();
                    }
                }

                Intent i = new Intent(UserActivity.this, UserSecondActivity.class);
                i.putExtra("selected_event", selectEvent);
                i.putExtra("uid", id);
                startActivity(i);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEvent = "Birthday";
                String id = null;
                for (User user : userList) {
                    if (user.getEmail().equals(username)) {
                        id = user.getUserId();
                    }
                }

                Intent i = new Intent(UserActivity.this, UserSecondActivity.class);
                i.putExtra("selected_event", selectEvent);
                i.putExtra("uid", id);
                startActivity(i);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEvent = "BachelorParty";
                String id = null;
                for (User user : userList) {
                    if (user.getEmail().equals(username)) {
                        id = user.getUserId();
                    }
                }

                Intent i = new Intent(UserActivity.this, UserSecondActivity.class);
                i.putExtra("selected_event", selectEvent);
                i.putExtra("uid", id);
                startActivity(i);
            }
        });

        cv5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEvent = "Meeting";
                String id = null;
                for (User user : userList) {
                    if (user.getEmail().equals(username)) {
                        id = user.getUserId();
                    }
                }

                Intent i = new Intent(UserActivity.this, UserSecondActivity.class);
                i.putExtra("selected_event", selectEvent);
                i.putExtra("uid", id);
                startActivity(i);
            }
        });

        cv6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectEvent = "Graduation";
                String id = null;
                for (User user : userList) {
                    if (user.getEmail().equals(username)) {
                        id = user.getUserId();
                    }
                }
                Intent i = new Intent(UserActivity.this, UserSecondActivity.class);
                i.putExtra("selected_event", selectEvent);
                i.putExtra("uid", id);
                startActivity(i);
            }
        });
        String uid = null;
        for (User user : userList) {
            if (user.getEmail().equals(username)) {
                uid = user.getUserId();
            }
        }
        Log.d("abc",uid);
        fl = findViewById(R.id.framelayout);
        nv = findViewById(R.id.navigation);
        dl = findViewById(R.id.drawerlayout);
        tb = findViewById(R.id.toolbar);

        adt = new ActionBarDrawerToggle(UserActivity.this, dl, tb, R.string.open, R.string.close);


        String finalUid = uid;
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id == R.id.home) {
                    fl.setVisibility(View.GONE);
                }
                if (id == R.id.profile) {

                    replaceFragment(new UserProfileFragment(), finalUid);
                }


                if (id == R.id.details) {
                    replaceFragment(new UserViewDetailsFragment(), finalUid);
                }

                if (id == R.id.changepw) {
                    replaceFragment(new ChangePasswordFragment(),finalUid);
                }

                if (id == R.id.review) {
                    replaceFragment(new ReviewFragment(),finalUid);

                }


                if (id == R.id.logout) {
                    replaceFragment(new LogoutFragment(), finalUid);
                }
                dl.closeDrawers();
                return false;
            }
        });
    }

    //later added
    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() > 0) {
            fragmentManager.popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    @Nullable
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        adt.syncState();
    }
}

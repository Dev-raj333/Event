package com.example.eventmanagement;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class UserProfileFragment extends Fragment {
    private TextView textViewName;
    private TextView textViewAddress;
    private TextView textViewEmail;
    private TextView textViewPhoneNo;
    private TextView textViewPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,null);
        String userId = getArguments().getString("userId");
        MyDbHelper myDbHelper = new MyDbHelper(getActivity());
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

        // Initialize the TextView fields
        textViewName = view.findViewById(R.id.editTextName);
        textViewAddress = view.findViewById(R.id.editaddress);
        textViewEmail = view.findViewById(R.id.editTextEmail);
        textViewPhoneNo = view.findViewById(R.id.editphoneno);
        textViewPassword = view.findViewById(R.id.editTextPassword);

        for (User user : userList){
            if(user.getUserId().equals(userId)){
                textViewName.setText("Name: "+user.getUsername());
                textViewAddress.setText("Address: " +user.getAddress());
                textViewEmail.setText("Email: "+user.getEmail());
                textViewPhoneNo.setText("Phone Number: " +user.getPhoneNumber());
            }
        }
        return view;
    }
}




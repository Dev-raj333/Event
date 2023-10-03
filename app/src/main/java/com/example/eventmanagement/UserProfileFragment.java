package com.example.eventmanagement;

import android.app.Activity;
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


public class UserProfileFragment extends Fragment {
    private TextView textViewName;
    private TextView textViewAddress;
    private TextView textViewEmail;
    private TextView textViewPhoneNo;
    private TextView textViewPassword;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,null);

        // Initialize the TextView fields
        textViewName = view.findViewById(R.id.editTextName);
        textViewAddress = view.findViewById(R.id.editaddress);
        textViewEmail = view.findViewById(R.id.editTextEmail);
        textViewPhoneNo = view.findViewById(R.id.editphoneno);
        textViewPassword = view.findViewById(R.id.editTextPassword);
        return view;
    }
}




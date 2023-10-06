package com.example.eventmanagement;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.util.ArrayList;
import java.util.List;

public class ChangePasswordFragment extends Fragment {

    private EditText editTextCurrentPassword, editTextNewPassword, editTextConfirmPassword;
    private Button btnChangePassword;
    MyDbHelper myDbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        editTextCurrentPassword = view.findViewById(R.id.editTextCurrentPassword);
        editTextNewPassword = view.findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = view.findViewById(R.id.editTextConfirmPassword);
        btnChangePassword = view.findViewById(R.id.btnChangePassword);
        String userId = getArguments().getString("userId");
        myDbHelper = new MyDbHelper(getActivity());
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


        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(User user: userList){
                    if(user.getUserId().equals(userId)){
                        String password = user.getPassword();
                        Log.d("ab",password);
                        if (validateInputFields(user.getPassword())) {
                            changePassword(userId);
                        }
                    }

                }

            }
        });

        return view;
    }
    private boolean validateInputFields(String password) {
        String currentPassword = editTextCurrentPassword.getText().toString();
        String newPassword = editTextNewPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        if (currentPassword.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter current password", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(!currentPassword.equals(password)){
            Toast.makeText(getActivity(), "Current password is incorrect", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (newPassword.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter new password", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (confirmPassword.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter confirm password", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!newPassword.equals(confirmPassword)) {
            Toast.makeText(getActivity(), "New password and confirm password do not match", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    private void changePassword(String userId) {
        String newPassword = editTextNewPassword.getText().toString();
        myDbHelper.updateUserPassword(userId,newPassword);
        Toast.makeText(getActivity(),"Successfully changed password",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), UserActivity.class);
        startActivity(intent);
    }
}
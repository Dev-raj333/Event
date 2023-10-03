package com.example.eventmanagement;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public class ChangePasswordFragment extends Fragment {

    private EditText editTextCurrentPassword, editTextNewPassword, editTextConfirmPassword;
    private Button btnChangePassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_change_password, container, false);

        editTextCurrentPassword = view.findViewById(R.id.editTextCurrentPassword);
        editTextNewPassword = view.findViewById(R.id.editTextNewPassword);
        editTextConfirmPassword = view.findViewById(R.id.editTextConfirmPassword);
        btnChangePassword = view.findViewById(R.id.btnChangePassword);

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateInputFields()) {
                    changePassword();
                }
            }
        });

        return view;
    }

    private boolean validateInputFields() {
        String currentPassword = editTextCurrentPassword.getText().toString();
        String newPassword = editTextNewPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        if (currentPassword.isEmpty()) {
            Toast.makeText(getActivity(), "Please enter current password", Toast.LENGTH_SHORT).show();
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

    private void changePassword() {
        String newPassword = editTextNewPassword.getText().toString();

    }
}
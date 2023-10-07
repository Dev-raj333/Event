package com.example.eventmanagement;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.List;

public class UserEventAdapter extends ArrayAdapter<Event> {
    public UserEventAdapter(@NonNull Context context, List<Event> items) {
        super(context, 0, items);
    }
}

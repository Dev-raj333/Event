package com.example.eventmanagement;


import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class BookEventActivity extends AppCompatActivity {

    EditText eventNameEditText, numberOfGuestsEditText;
    EditText entryDateEditText, exitDateEditText;

    Button next;
    ImageView entryDateImage, exitDateImage;
    Calendar calendar;
    SimpleDateFormat dateFormat;
    MyDbHelper myDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_event);

        myDbHelper = new MyDbHelper(this);

        eventNameEditText = findViewById(R.id.eventtext);
        numberOfGuestsEditText = findViewById(R.id.eventtext1);
        entryDateEditText = findViewById(R.id.entryDateEditText);
        exitDateEditText = findViewById(R.id.exitDateEditText);
        next = findViewById(R.id.nextbutton);
        entryDateImage = findViewById(R.id.imgentry);
        exitDateImage = findViewById(R.id.imgexit);
        String vId = getIntent().getStringExtra("vId");
        String selectedEvent = getIntent().getStringExtra("selected_event");
        String uId = getIntent().getStringExtra("uid");
        eventNameEditText.setText(selectedEvent);


        calendar = Calendar.getInstance();
        dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);

        entryDateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(entryDateEditText);
            }
        });

        exitDateImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog(exitDateEditText);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveEventData(uId,vId);
            }
        });
    }

    private void showDatePickerDialog(final EditText editText) {
        final Calendar entryCalendar = Calendar.getInstance();
        entryCalendar.setTime(calendar.getTime());
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        Calendar selectedCalendar = Calendar.getInstance();
                        selectedCalendar.set(year, month, dayOfMonth);

                        Calendar entryCalendar = Calendar.getInstance();
                        entryCalendar.setTime(calendar.getTime());

                        if (selectedCalendar.before(entryCalendar) || selectedCalendar.equals(entryCalendar)) {
                            // Selected date is before or same as the entry date
                            Toast.makeText(BookEventActivity.this, "Invalid exit date", Toast.LENGTH_SHORT).show();
                        } else {
                            calendar.set(year, month, dayOfMonth);
                            editText.setText(dateFormat.format(calendar.getTime()));
                        }
                    }
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.getDatePicker().setMinDate(entryCalendar.getTimeInMillis());
        datePickerDialog.show();
    }


    private void saveEventData(String uid, String vid) {
        String eventName = eventNameEditText.getText().toString().trim();

        String numberOfGuests = numberOfGuestsEditText.getText().toString().trim();
        String entryDate = entryDateEditText.getText().toString().trim();
        String exitDate = exitDateEditText.getText().toString().trim();

        if (eventName.isEmpty() || numberOfGuests.isEmpty() || entryDate.isEmpty() || exitDate.isEmpty()) {
            Toast.makeText(BookEventActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }else{
            String eventID = String.valueOf(myDbHelper.insertEvent(eventName, numberOfGuests, entryDate,exitDate, uid, vid,"pending"));
            Intent i = new Intent(BookEventActivity.this,UserThirdActivity.class);
            i.putExtra("eventID",eventID);
            startActivity(i);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}








package com.example.eventmanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MyDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =2;
    private static final String name= "EventManagement";

    private static final String Table1 ="Admin";
    private static final String Table2 = "User";
    private static final String Table3 = "Venue";
    private static final String Table4 = "Rating";
    private static final String Table5 = "Event";
    private final Context context;

    public MyDbHelper(Context context){
        super(context,name,null, DATABASE_VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1 = "CREATE TABLE " + Table1 + "(id INTEGER PRIMARY KEY AUTOINCREMENT, email TEXT, password TEXT)";
        String table2 = "CREATE TABLE " + Table2 + "(uid INTEGER PRIMARY KEY AUTOINCREMENT, username TEXT, email TEXT, password TEXT, address TEXT, phoneNumber TEXT)";
        String table3 = "CREATE TABLE " + Table3 + "(vid INTEGER PRIMARY KEY AUTOINCREMENT, venueName TEXT, venueAddress TEXT, occupancy TEXT, email TEXT, phoneNumber TEXT)";
        String table4 = "CREATE TABLE " + Table4 + "(rid INTEGER PRIMARY KEY AUTOINCREMENT, uid INTEGER, vid INTEGER, rating INTEGER, feedback TEXT, FOREIGN KEY(uid) REFERENCES User(uid),FOREIGN KEY(vid) REFERENCES Venue(vid))";
        String table5 = "CREATE TABLE " + Table5 + "(eid INTEGER PRIMARY KEY AUTOINCREMENT, eventName TEXT, noGuest INTEGER, entryDate TEXT, exitDate TEXT, uid INTEGER, vid INTEGER, FOREIGN KEY(uid) REFERENCES User(uid),FOREIGN KEY(vid) REFERENCES Venue(vid))";
        db.execSQL(table1);
        db.execSQL(table2);
        db.execSQL(table3);
        db.execSQL(table4);
        db.execSQL(table5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + Table1);
        db.execSQL("DROP TABLE IF EXISTS " + Table2);
        db.execSQL("DROP TABLE IF EXISTS " + Table3);
        db.execSQL("DROP TABLE IF EXISTS " + Table4);
        db.execSQL("DROP TABLE IF EXISTS " + Table5);

    }

    //Users db
    public void insertUser(String username, String email, String password, String address, String phoneNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("phoneNumber", phoneNumber);

        long result = db.insert("User", null, contentValues);
        if(result == -1){
            Toast.makeText(context,"Error Occurred",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Successfully account created",Toast.LENGTH_SHORT).show();
        }
        db.close();
    }
    public  Cursor selectUser(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM User";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * from User where email =? and password= ?";
        Cursor cursor = db.rawQuery(query,new String[]{username, password});
        if(cursor.getCount()> 0){
            return  true;
        }else{
            return false;
        }
    }
    public void updateUserPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("password", password);
        db.update("User",contentValues,"email=?" , new String[] {email});
        db.close();
    }
    public void updateUser(String id, String username, String email, String password, String address, String phoneNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("address", address);
        contentValues.put("phoneNumber", phoneNumber);


        db.update("User",contentValues,"uid=?" , new String[] {id});
        db.close();
    }

    public void deleteUser(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("User","uid=?",new String[]{id});
    }

    // Venue
    public long insertVenue(Venue venue){
        String venueName = venue.getName();
        String venueAddress = venue.getAddress();
        String occupancy = venue.getOccupancy();
        String email = venue.getEmail();
        String phoneNumber = venue.getNumber();

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("venueName", venueName);
        contentValues.put("venueAddress", venueAddress);
        contentValues.put("occupancy", occupancy);
        contentValues.put("email", email);
        contentValues.put("phoneNumber", phoneNumber);

        long rowId = db.insert("Venue", null, contentValues);
        db.close();
        return rowId;
    }
    public List<Venue> getAllVenues() {
        List<Venue> venueList = new ArrayList<>();
        String selectQuery = "SELECT * FROM Venue";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Venue venue = new Venue(
                        cursor.getString(1), // venueName
                        cursor.getString(2), // address
                        cursor.getString(3),    // occupancy
                        cursor.getString(4), // email
                        cursor.getString(5)  // phoneNumber
                );
                venueList.add(venue);
            } while (cursor.moveToNext());
        }

        cursor.close();
        return venueList;
    }
    public  Cursor selectVenue(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Venue";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public void updateVenue(String id, String venueName, String venueAddress, int occupancy, String email, String phoneNumber){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("venueName", venueName);
        contentValues.put("venueAddress", venueAddress);
        contentValues.put("occupancy", occupancy);
        contentValues.put("email", email);
        contentValues.put("phoneNumber", phoneNumber);


        db.update("Venue",contentValues,"vid=?" , new String[] {id});
        db.close();
    }

    public void deleteVenue(String vid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Venue","vid=?",new String[]{vid});
    }
    //Event
    public void insertEvent(int eid ,String eventName, int noGuest,String entryDate,String exitDate, int uid,int vid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventName", eventName);
        contentValues.put("noGuest", noGuest);
        contentValues.put("entryDate", entryDate);
        contentValues.put("exitDate", exitDate);
        contentValues.put("uid", uid);
        contentValues.put("vid", vid);

        db.insert("Event", null, contentValues);
        db.close();
    }
    public  Cursor selectEvent(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Event";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
    public void updateEvent(String eid ,String eventName, int noGuest,String entryDate,String exitDate, int uid,int vid){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventName", eventName);
        contentValues.put("noGuest", noGuest);
        contentValues.put("entryDate", entryDate);
        contentValues.put("exitDate", exitDate);
        contentValues.put("uid", uid);
        contentValues.put("vid", vid);

        db.update("Event",contentValues,"eid=?" , new String[] {eid});
        db.close();
    }

    public void deleteEvent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Event","eid=?",new String[]{id});
    }

    //Rating table
    public void insertRating(String rid, String uid, String vid, int rating){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uid", uid);
        contentValues.put("vid",vid);
        contentValues.put("rating", rating);

        db.insert("Rating",null,contentValues);
        db.close();
    }

    //add admin
    public void insertAdmin(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email","admin@gmail.com");
        contentValues.put("password","123456");

        db.insert("Admin", null, contentValues);
    }
    public Cursor getAdmin(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Admin";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;
    }
    public boolean checkAdmin(String username,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        String query="SELECT * from Admin where email =? and password= ?";
        Cursor cursor = db.rawQuery(query,new String[]{username, password});
        if(cursor.getCount()> 0){
            return  true;
        }else{
            return false;
        }
    }
    public void deleteAdmin(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Admin","id=?", new String[]{String.valueOf(id)});
        db.close();
    }

}

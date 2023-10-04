package com.example.eventmanagement;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerVenueAdapter extends RecyclerView.Adapter<RecyclerVenueAdapter.ViewHolder> {
    private List<Venue> venueList;

    private Context context;
    private String eventName;
    public RecyclerVenueAdapter(List<Venue> venueList, String eventName, Context context){
        this.venueList= venueList;
        this.eventName = eventName;
        this.context = context;
    }
    @NonNull
    @Override
    public RecyclerVenueAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycle_venue_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setTag(eventName);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerVenueAdapter.ViewHolder holder, int position) {
        Venue venue = venueList.get(position);
        holder.hotelName.setText(venue.getName());
        holder.address.setText(venue.getAddress());
    }

    @Override
    public int getItemCount() {
        return venueList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView hotelName, address;
        ImageView imageView;
        private Context context;
        public ViewHolder(View itemView){
            super(itemView);
            hotelName= itemView.findViewById(R.id.hoteltext);
            address = itemView.findViewById(R.id.address);
            imageView = itemView.findViewById(R.id.imageView);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        String selectHotel = hotelName.getText().toString();
                        System.out.println(selectHotel);
                        String selectEvent = (String) itemView.getTag();
                        Log.d("Clicked data is ", selectHotel);
                        Intent i = new Intent(context, BookEventActivity.class );
                        i.putExtra("selected_hotel", selectHotel);
                        i.putExtra("selected_event", selectEvent);
                        context.startActivity(i);
                    }
                }
            });
        }
    }
}

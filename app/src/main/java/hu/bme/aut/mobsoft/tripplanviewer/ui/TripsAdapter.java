package hu.bme.aut.mobsoft.tripplanviewer.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripsAdapter extends RecyclerView.Adapter<TripViewHolder> {

    private ArrayList<TripItem> trips;

//    public TripsAdapter(ArrayList<TripItem> trips)
//    {
//        this.trips = trips;
//    }

    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tripitem,parent, false);

        return new TripViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TripViewHolder holder, int position) {

        TripItem trip = trips.get(position);

        holder.tvTripName.setText(trip.tripName);
        holder.tvEndpoints.setText(trip.endpoints);
        holder.tvCities.setText(trip.cities);
        holder.tvDays.setText(trip.days);
        holder.tvDistance.setText(trip.distance);

    }

    @Override
    public int getItemCount() {
        return trips.size();
    }

    public void swipe(ArrayList<TripItem> trips)
    {
        this.trips.clear();
        this.trips.addAll(trips);
        notifyDataSetChanged();
    }

}

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

public class TripsAdapter extends RecyclerView.Adapter<TripViewHolder> implements View.OnClickListener {

    private ArrayList<TripItem> trips;
    private View.OnClickListener listener;

    public TripsAdapter(ArrayList<TripItem> trips, View.OnClickListener listener) {
        this.trips = trips;
        this.listener = listener;
    }

    public TripsAdapter(View.OnClickListener listener) {
        trips = new ArrayList<>();
        this.listener = listener;
    }

    @Override
    public TripViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tripitem,parent, false);

        view.setOnClickListener(listener);

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

        holder.itemView.setTag(Integer.toString(position));

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

    @Override
    public void onClick(View v) {



    }

    public ArrayList<TripItem> getTrips() {
        return trips;
    }

    public void setTrips(ArrayList<TripItem> trips) {
        this.trips = trips;
    }
}

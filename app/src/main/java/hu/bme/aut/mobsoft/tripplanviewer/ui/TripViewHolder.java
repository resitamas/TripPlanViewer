package hu.bme.aut.mobsoft.tripplanviewer.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hu.bme.aut.mobsoft.tripplanviewer.R;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripViewHolder extends RecyclerView.ViewHolder {

    public TextView tvTripName;
    public TextView tvEndpoints;
    public TextView tvCities;
    public TextView tvDays;
    public TextView tvDistance;

    public TripViewHolder(View itemView) {

        super(itemView);

        tvTripName = (TextView) itemView.findViewById(R.id.tripName);
        tvEndpoints = (TextView) itemView.findViewById(R.id.endpoints);
        tvCities = (TextView) itemView.findViewById(R.id.cities);
        tvDays = (TextView) itemView.findViewById(R.id.days);
        tvDistance = (TextView) itemView.findViewById(R.id.distance);

    }

}

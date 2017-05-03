package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import hu.bme.aut.mobsoft.tripplanviewer.R;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class CityViewHolder extends RecyclerView.ViewHolder {

    public TextView tvDays;
    public TextView tvHours;
    public TextView tvKms;
    public TextView tvCityName;
    public TextView tvSights;

    public CityViewHolder(View itemView) {
        super(itemView);

        tvDays = (TextView) itemView.findViewById(R.id.days);
        tvHours = (TextView) itemView.findViewById(R.id.hours);
        tvKms = (TextView) itemView.findViewById(R.id.kms);
        tvCityName = (TextView) itemView.findViewById(R.id.cityName);
        tvSights = (TextView) itemView.findViewById(R.id.sights);

    }

}

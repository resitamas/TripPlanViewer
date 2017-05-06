package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.model.TravelItem;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TravelsAdapter extends RecyclerView.Adapter<CityViewHolder> {


    List<TravelItem> travels;

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cityitem, parent, false);

        return new CityViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {

        TravelItem city = travels.get(position);

        holder.tvDays.setText(city.days);
        holder.tvHours.setText(city.hours);
        holder.tvKms.setText(city.kms);
        holder.tvCityName.setText(city.cityName);
        holder.tvSights.setText(city.sights);

    }

    @Override
    public int getItemCount() {
        return travels.size();
    }

    public void swipe(List<TravelItem> cities)
    {
        this.travels.clear();
        this.travels.addAll(cities);
        notifyDataSetChanged();
    }

}

package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.model.CityItem;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class CitiesAdapter extends RecyclerView.Adapter<CityViewHolder> {


    ArrayList<CityItem> cities;

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cityitem, parent, false);

        return new CityViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {

        CityItem city = cities.get(position);

        holder.tvDays.setText(city.days);
        holder.tvHours.setText(city.hours);
        holder.tvKms.setText(city.kms);
        holder.tvCityName.setText(city.cityName);
        holder.tvSights.setText(city.sights);

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public void swipe(ArrayList<CityItem> cities)
    {
        this.cities.clear();
        this.cities.addAll(cities);
        notifyDataSetChanged();
    }

}

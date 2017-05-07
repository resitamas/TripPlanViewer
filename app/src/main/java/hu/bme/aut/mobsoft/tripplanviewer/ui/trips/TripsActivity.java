package hu.bme.aut.mobsoft.tripplanviewer.ui.trips;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Switch;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.ui.RecyclerViewClickListener;
import hu.bme.aut.mobsoft.tripplanviewer.ui.TripsAdapter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripActivity;

/**
 * Created by Resi Tamas on 04/04/2017.
 */

public class TripsActivity extends AppCompatActivity implements TripsScreen, View.OnClickListener, AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    @Inject
    TripsPresenter tripsPresenter;

    private RecyclerView recyclerView;
    private TripsAdapter tripsAdapter;

    private int spPosition;
    private int swChecked;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trips);

        TripPlanViewerApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        tripsPresenter.setTrips( (List<TripSight>)(new Gson().fromJson(getIntent().getStringExtra("trips"),new TypeToken<List<TripSight>>(){}.getType())));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        tripsAdapter = new TripsAdapter(createTripItems(tripsPresenter.getTrips()), this);

        recyclerView.setAdapter(tripsAdapter);

        Switch swDirectionn = (Switch) findViewById(R.id.swDirection);
        swDirectionn.setTextOff("Down");
        swDirectionn.setTextOn("Up");
        swDirectionn.setOnCheckedChangeListener(this);

        Spinner spinner = (Spinner) findViewById(R.id.spOrder);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.orderbyArray, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spPosition = 0;
        swChecked = 0;
        //showTrips(createTripItems(tripsPresenter.getTrips()));

    }

    @Override
    protected void onStart() {
        super.onStart();

        tripsPresenter.attachScreen(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

        tripsPresenter.detachScreen();

    }


    @Override
    public void showTrips(ArrayList<TripItem> trips) {

        tripsAdapter.swipe(trips);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, TripActivity.class);
        intent.putExtra("tripId", tripsAdapter.getTrips().get(Integer.parseInt((String)v.getTag())).getTripId());
        startActivity(intent);

    }

    public ArrayList<TripItem> createTripItems(List<TripSight> trips) {

        ArrayList<TripItem> tripItems = new ArrayList<>();

        Collections.sort(trips, new Comparator<TripSight>() {

            @Override
            public int compare(TripSight o1, TripSight o2) {

                if ( ((Integer)o1.getTrip().getTripId()).compareTo(o2.getTrip().getTripId()) == 0) {

                    return ((Integer)o1.getNumber()).compareTo(o2.getNumber());
                }

                return ((Integer)o1.getTrip().getTripId()).compareTo(o2.getTrip().getTripId());
            }

        });

        TripItem item = null;
        String startCity = "";
        String endCity = "";
        HashSet<Integer> cityIds = new HashSet<>();

        if (trips.size() > 0) {
            item = CreateItem(trips.get(0).getTrip());

            startCity = trips.get(0).getSight().getCity().getName();
            cityIds.add(trips.get(0).getSight().getCity().getCityId());
        }

        for (int i = 1; i < trips.size(); i++) {

            if (trips.get(i - 1).getTrip().getTripId() == (trips.get(i).getTrip().getTripId())) {
                cityIds.add(trips.get(i).getSight().getCity().getCityId());
                endCity = trips.get(i).getSight().getCity().getName();
            } else {
                item.setEndpoints(startCity + " - " + endCity);
                item.setCities(cityIds.size() + " cities");
                tripItems.add(item);
                item = CreateItem(trips.get(i).getTrip());
                cityIds.clear();
                cityIds.add(trips.get(i).getSight().getCity().getCityId());
                startCity = trips.get(i).getSight().getCity().getName();
            }

        }

        item.setEndpoints(startCity + " - " + endCity);
        item.setCities(cityIds.size() + " cities");
        tripItems.add(item);

        return tripItems;
    }

    private TripItem CreateItem(Trip trip){

        TripItem item = new TripItem();
        item.setDistance(Integer.toString(trip.getDistance()) + " km");
        item.setDays(Integer.toString(trip.getDays()) + " days");
        item.setTripName(trip.getName());
        item.setTripId(trip.getTripId());

        return item;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        spPosition = position;
        order();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        swChecked = isChecked ? 1 : -1;
        order();
    }

    void order() {

        ArrayList<TripItem> trips = tripsAdapter.getTrips();

        final int direction = swChecked;

        if (trips.size() > 0) {
            switch (spPosition) {

                case 0:

                    Collections.sort(trips, new Comparator<TripItem>() {
                        @Override
                        public int compare(TripItem o1, TripItem o2) {
                            return o1.getTripName().compareTo(o2.getTripName()) * direction;
                        }
                    });

                    break;

                case 1:

                    Collections.sort(trips, new Comparator<TripItem>() {
                        @Override
                        public int compare(TripItem o1, TripItem o2) {
                            return o1.getDistance().compareTo(o2.getDistance()) * direction;
                        }
                    });

                    break;


                case 2:

                    Collections.sort(trips, new Comparator<TripItem>() {
                        @Override
                        public int compare(TripItem o1, TripItem o2) {
                            return o1.getDays().compareTo(o2.getDays()) * direction;
                        }
                    });

                    break;

                case 3:

                    Collections.sort(trips, new Comparator<TripItem>() {
                        @Override
                        public int compare(TripItem o1, TripItem o2) {
                            return o1.getCities().compareTo(o2.getCities()) * direction;
                        }
                    });

                    break;
            }

            tripsAdapter.setTrips(trips);
            tripsAdapter.notifyDataSetChanged();
            //tripsAdapter.swipe(trips);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

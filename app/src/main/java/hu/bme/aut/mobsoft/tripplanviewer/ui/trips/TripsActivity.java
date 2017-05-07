package hu.bme.aut.mobsoft.tripplanviewer.ui.trips;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.ui.RecyclerViewClickListener;
import hu.bme.aut.mobsoft.tripplanviewer.ui.TripsAdapter;

/**
 * Created by Resi Tamas on 04/04/2017.
 */

public class TripsActivity extends AppCompatActivity implements TripsScreen, View.OnClickListener {

    @Inject
    TripsPresenter tripsPresenter;

    private RecyclerView recyclerView;
    private TripsAdapter tripsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_trip);

        TripPlanViewerApplication.injector.inject(this);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        tripsAdapter = new TripsAdapter(this);

        recyclerView.setAdapter(tripsAdapter);

        tripsPresenter.setTrips( (List<Trip>)(new Gson().fromJson(getIntent().getStringExtra("trips"),new TypeToken<List<Trip>>(){}.getType())));

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

//    @Override
//    public void recyclerViewClicked(View v, int position) {
//
//    }

    @Override
    public void onClick(View v) {

    }
}

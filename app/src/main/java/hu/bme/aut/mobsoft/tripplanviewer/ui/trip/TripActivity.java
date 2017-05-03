package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.CityItem;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripInfo;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class TripActivity extends AppCompatActivity implements TripScreen {

    @Inject
    TripPresenter tripPresenter;

    private RecyclerView recyclerView;
    private CitiesAdapter citiesAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_trip);

        TripPlanViewerApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        citiesAdapter = new CitiesAdapter();

        recyclerView.setAdapter(citiesAdapter);

        String tripId = getIntent().getStringExtra("tripId");

        tripPresenter.getTrip(tripId);

    }

    @Override
    protected void onStart() {
        super.onStart();

        tripPresenter.attachScreen(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

        tripPresenter.detachScreen();

    }

    @Override
    public void showTripInfo(TripInfo tripInfo) {

        ((TextView) findViewById(R.id.tripName)).setText(tripInfo.getTripName());
        ((TextView) findViewById(R.id.days)).setText(tripInfo.getDays());
        ((TextView) findViewById(R.id.kms)).setText(tripInfo.getKms());
        ((TextView) findViewById(R.id.cities)).setText(tripInfo.getCities());
        ((TextView) findViewById(R.id.endpoints)).setText(tripInfo.getEndpoints());

    }

    @Override
    public void showCities(ArrayList<CityItem> cities) {

        citiesAdapter.swipe(cities);

    }
}

package hu.bme.aut.mobsoft.tripplanviewer.ui.trips;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;

/**
 * Created by Resi Tamas on 04/04/2017.
 */

public class TripsActivity extends AppCompatActivity implements TripsScreen {

    @Inject
    TripsPresenter tripsPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_trip);

        TripPlanViewerApplication.injector.inject(this);

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


}

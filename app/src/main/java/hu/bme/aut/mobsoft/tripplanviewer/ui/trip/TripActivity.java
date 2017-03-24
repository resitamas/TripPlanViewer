package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class TripActivity extends AppCompatActivity implements TripScreen {

    @Inject
    TripPresenter tripPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_trip);

        TripPlanViewerApplication.injector.inject(this);

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
}

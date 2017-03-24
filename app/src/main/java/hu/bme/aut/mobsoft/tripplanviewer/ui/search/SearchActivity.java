package hu.bme.aut.mobsoft.tripplanviewer.ui.search;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SearchActivity extends AppCompatActivity implements SearchScreen {

    @Inject
    SearchPresenter searchPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_search);

        TripPlanViewerApplication.injector.inject(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        searchPresenter.attachScreen(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

        searchPresenter.detachScreen();

    }
}

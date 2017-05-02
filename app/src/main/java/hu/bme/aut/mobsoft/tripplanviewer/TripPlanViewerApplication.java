package hu.bme.aut.mobsoft.tripplanviewer;

import android.app.Application;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.repository.Repository;
import hu.bme.aut.mobsoft.tripplanviewer.ui.UIModule;

public class TripPlanViewerApplication extends Application {

    @Inject
    Repository repository;

    public static TripPlanViewerApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerTripPlanViewerApplicationComponent.builder().uIModule(new UIModule(this)).build();

        injector.inject(this);

        repository.open(getApplicationContext());
    }
}

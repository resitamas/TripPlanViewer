package hu.bme.aut.mobsoft.tripplanviewer;

import android.app.Application;

import hu.bme.aut.mobsoft.tripplanviewer.ui.UIModule;

public class TripPlanViewerApplication extends Application {

    public static TripPlanViewerApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerTripPlanViewerApplicationComponent.builder().uIModule(new UIModule(this)).build();
    }
}

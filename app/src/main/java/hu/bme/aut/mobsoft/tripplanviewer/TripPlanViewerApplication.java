package hu.bme.aut.mobsoft.tripplanviewer;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import io.fabric.sdk.android.Fabric;
import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.repository.Repository;
import hu.bme.aut.mobsoft.tripplanviewer.ui.UIModule;

public class TripPlanViewerApplication extends Application {

    @Inject
    Repository repository;

    public static TripPlanViewerApplicationComponent injector;
    public static User user;

    private Tracker tracker;

    @Override
    public void onCreate() {

        super.onCreate();

        Fabric.with(this, new Crashlytics());

        injector = DaggerTripPlanViewerApplicationComponent.builder().uIModule(new UIModule(this)).build();

        injector.inject(this);

        repository.open(getApplicationContext());
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {

        if (tracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            tracker = analytics.newTracker(R.xml.global_tracker);
        }
        return tracker;
    }
}

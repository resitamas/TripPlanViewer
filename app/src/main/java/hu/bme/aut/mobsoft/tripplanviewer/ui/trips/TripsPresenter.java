package hu.bme.aut.mobsoft.tripplanviewer.ui.trips;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SaveTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;

/**
 * Created by Resi Tamas on 04/04/2017.
 */

public class TripsPresenter extends Presenter<TripsScreen> {

    @Inject
    Executor executor;

    @Inject
    EventBus bus;

    List<Trip> trips;

    @Override
    public void attachScreen(TripsScreen screen) {

        super.attachScreen(screen);

        if (!bus.isRegistered(this)) {
            bus.register(this);
        }

    }

    @Override
    public void detachScreen() {

        bus.unregister(this);

        super.detachScreen();
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

}

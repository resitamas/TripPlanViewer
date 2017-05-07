package hu.bme.aut.mobsoft.tripplanviewer.ui.trips;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SaveTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SearchTripsAtServerEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by Resi Tamas on 04/04/2017.
 */

public class TripsPresenter extends Presenter<TripsScreen> {

//    @Inject
//    EventBus bus;

    @Inject
    Executor executor;

    List<TripSight> trips;

    @Override
    public void attachScreen(TripsScreen screen) {

        super.attachScreen(screen);

        injector.inject(this);

//        if (!bus.isRegistered(this)) {
//            bus.register(this);
//        }


    }

    @Override
    public void detachScreen() {

//        bus.unregister(this);

        super.detachScreen();
    }

    public List<TripSight> getTrips() {
        return trips;
    }

    public void setTrips(List<TripSight> trips) {
        this.trips = trips;
    }


}

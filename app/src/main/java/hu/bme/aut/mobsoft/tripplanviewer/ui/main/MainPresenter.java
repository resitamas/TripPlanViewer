package hu.bme.aut.mobsoft.tripplanviewer.ui.main;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetUserTripsFromLocalDBEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Sight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    Executor executor;

    @Inject
    TripInteractor interactor;

    @Inject
    EventBus bus;

    @Override
    public void attachScreen(MainScreen screen) {

        super.attachScreen(screen);

        injector.inject(this);

        if (!bus.isRegistered(this)) {
            bus.register(this);
        }

    }

    @Override
    public void detachScreen() {

        bus.unregister(this);

        super.detachScreen();

    }

    public void GetTripsFromLocalDB(final int index, final User user)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.getUserTripsFromLocalDB(index, user);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetUserTripsFromLocalDBEvent event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {

                ArrayList<TripItem> tripItems = new ArrayList<>();

                Collections.sort(event.getTrips(), new Comparator<TripSight>() {

                    @Override
                    public int compare(TripSight o1, TripSight o2) {

                        if ( ((Integer)o1.getTrip().getTripId()).compareTo(o2.getTrip().getTripId()) == 0) {

                            return ((Integer)o1.getNumber()).compareTo(o2.getNumber());
                        }

                        return ((Integer)o1.getTrip().getTripId()).compareTo(o2.getTrip().getTripId());
                    }

                });

                TripItem item = null;
                String startCity = "";
                String endCity = "";
                HashSet<Integer> cityIds = new HashSet<>();

                if (event.getTrips().size() > 0) {
                    item = CreateItem(event.getTrips().get(0).getTrip());

                    startCity = event.getTrips().get(0).getSight().getCity().getName();
                    cityIds.add(event.getTrips().get(0).getSight().getCity().getCityId());
                }

                for (int i = 1; i < event.getTrips().size(); i++) {

                    if (event.getTrips().get(i - 1).getTrip().getTripId() == (event.getTrips().get(i).getTrip().getTripId())) {
                        cityIds.add(event.getTrips().get(i).getSight().getCity().getCityId());
                        endCity = event.getTrips().get(i).getSight().getCity().getName();
                    } else {
                        item.setEndpoints(startCity + " - " + endCity);
                        item.setCities(cityIds.size() + " cities");
                        tripItems.add(item);
                        item = CreateItem(event.getTrips().get(i).getTrip());
                        cityIds.clear();
                        cityIds.add(event.getTrips().get(i).getSight().getCity().getCityId());
                        startCity = event.getTrips().get(i).getSight().getCity().getName();
                    }

                }

                item.setEndpoints(startCity + " - " + endCity);
                item.setCities(cityIds.size() + " cities");
                tripItems.add(item);

                screen.showTrips(tripItems);
            }
        }


    }

    private TripItem CreateItem(Trip trip){

        TripItem item = new TripItem();
        item.setDistance(Integer.toString(trip.getDistance()) + " km");
        item.setDays(Integer.toString(trip.getDays()) + " days");
        item.setTripName(trip.getName());
        item.setTripId(trip.getTripId());

        return item;

    }


}

package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetTravelsByTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SaveTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.TravelItem;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripInfo;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.City;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Travel;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TravelSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class TripPresenter extends Presenter<TripScreen> {

    @Inject
    EventBus bus;

    @Inject
    Executor executor;

    @Inject
    TripInteractor interactor;

    Trip trip;

    public TripPresenter() {

    }

    @Override
    public void attachScreen(TripScreen screen) {

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

    public void getTrip(final int tripId)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {

                interactor.getTrip(tripId);

            }
        });
    }

    public void saveTrip() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.saveTrip(trip);
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final SaveTripEvent event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {

                screen.showMessage(event.getTrip().getName() + " was successfully saved");

            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread1(final GetTripEvent event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getThrowable().getMessage());
            }
        } else {

            interactor.getSightsByTrip(event.getTrip());

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread2(final GetTravelsByTripEvent event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showMessage(event.getThrowable().getMessage());
            }
        } else {

            if (screen != null) {

                List<TravelSight> travelSights = event.getSights();

                if (travelSights.size() > 0) {

                    String startCity = null;
                    String endCity = null;

                    TripInfo tripInfo = new TripInfo();
                    tripInfo.setDays(Integer.toString(trip.getDays()));
                    tripInfo.setTripName(trip.getName());
                    tripInfo.setKms(Integer.toString(trip.getDistance()));

                    Collections.sort(travelSights, new Comparator<TravelSight>() {

                        @Override
                        public int compare(TravelSight o1, TravelSight o2) {

                            return ((Integer)o1.getTravel().getNumber()).compareTo(o2.getTravel().getNumber());

                        }

                    });

                    ArrayList<TravelItem> travelItems = new ArrayList<>();

                    TravelItem travelItem = null;
                    HashSet<Integer> ids = new HashSet<>();
                    String sights = "";

                    int days = 0;

                    for (TravelSight travelSight : travelSights) {

                        Travel travel = travelSight.getTravel();
                        City city = travelSight.getSight().getCity();

                        if (!ids.contains(travel.getTravelId())) {

                            ids.add(travel.getTravelId());

                            if (travelItem != null) {
                                travelItems.add(travelItem);
                                startCity = city.getName();
                            }

                            endCity = city.getName();

                            travelItem = new TravelItem();
                            travelItem.setCityName(city.getName());
                            travelItem.setDays( "Day " + Integer.toString(days) + " - " +  (days + travel.getDays()));
                            days += travel.getDays();
                            travelItem.setKms(Integer.toString(travel.getKmsTo()) + " kms");
                            travelItem.setHours(Integer.toString(travel.getTimeTo()) + " hours");
                            travelItem.setSights(sights);
                            sights = travelSight.getSight().getName();

                        } else {

                            sights += ", " + travelSight.getSight().getName();

                        }

                    }

                    tripInfo.setTravelItems(travelItems);
                    tripInfo.setEndpoints(startCity + " - " + endCity);

                    screen.showTripInfo(tripInfo);
                }

            }

        }
    }
}

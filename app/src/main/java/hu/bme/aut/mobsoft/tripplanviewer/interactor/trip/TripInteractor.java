package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetUserTripsFromLocalDBEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SaveTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SearchTripsAtServerEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.network.TripApi;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class TripInteractor {

    @Inject
    Repository repository;

//    @Inject
    EventBus bus;

    @Inject
    TripApi tripApi;

    public TripInteractor() {
        TripPlanViewerApplication.injector.inject(this);
        bus = EventBus.getDefault();
    }

    public void getUserTripsFromLocalDB(int index, User user) {

        GetUserTripsFromLocalDBEvent event = new GetUserTripsFromLocalDBEvent();
        try {

            List<TripSight> trips = repository.getTripsWithSights(user);
            event.setTrips(trips);
            bus.post(event);

        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(e);
        }

    }

    public void saveTrip(Trip trip) {

        SaveTripEvent event = new SaveTripEvent();
        event.setTrip(trip);

        try {

            repository.saveTrip(trip);
            bus.post(event);

        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(e);
        }

    }

    public void getTrip(int id)
    {

        GetTripEvent event = new GetTripEvent();

        try {

            Trip trip = repository.getTrip(id);
            event.setTrip(trip);
            bus.post(event);

        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(e);
        }

    }

    public void searchTripsAtServer(SearchCriteria criteria) {

        Call<List<Trip>> tripsQueryCall =  tripApi.getTrips(criteria.getCityIds(), criteria.getMinDistance(), criteria.getMaxDistance(), criteria.getMinDays(), criteria.getMaxDays());
        SearchTripsAtServerEvent event = new SearchTripsAtServerEvent();

        try {

            Response<List<Trip>> response = tripsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setTrips(response.body());

            bus.post(event);

        } catch (Exception e) {
            event.setThrowable(e);
            bus.post(e);
        }

    }

}

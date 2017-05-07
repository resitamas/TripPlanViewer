package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetSightsByTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetTravelsByTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.GetUserTripsFromLocalDBEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SaveTripEvent;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SearchTripsAtServerEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.network.TripApi;
import hu.bme.aut.mobsoft.tripplanviewer.orm.TripType;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.repository.Repository;
import retrofit2.Call;
import retrofit2.Response;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class TripInteractor {

    @Inject
    Repository repository;

    @Inject
    EventBus bus;

    @Inject
    TripApi tripApi;

    public TripInteractor() {
        injector.inject(this);

    }

    public void getUserTripsFromLocalDB(int index, User user) {

        GetUserTripsFromLocalDBEvent event = new GetUserTripsFromLocalDBEvent();
        try {

            List<TripSight> trips = new ArrayList<>();

            if (index == 0) {
                trips = repository.getTripsWithSights(user, TripType.Own);
            } else {
                trips = repository.getTripsWithSights(user, TripType.Other);
            }

            event.setTrips(trips);

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    public void saveTrip(Trip trip) {

        SaveTripEvent event = new SaveTripEvent();
        event.setTrip(trip);

        try {

            repository.saveTrip(trip);

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    public void getTrip(int id)
    {

        GetTripEvent event = new GetTripEvent();

        try {

            Trip trip = repository.getTrip(id);
            event.setTrip(trip);

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    public void searchTripsAtServer(SearchCriteria criteria) {

        Call<List<TripSight>> tripsQueryCall =  tripApi.getTrips(criteria.getCityIds(), criteria.getMinDistance(), criteria.getMaxDistance(), criteria.getMinDays(), criteria.getMaxDays());
        SearchTripsAtServerEvent event = new SearchTripsAtServerEvent();

        try {

            Response<List<TripSight>> response = tripsQueryCall.execute();
            if (response.code() != 200) {
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setTrips(response.body());


        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    public void getSightsByTrip(Trip trip) {

        GetSightsByTripEvent event = new GetSightsByTripEvent();

        try {

            event.setSights(repository.getSightsByTrip(trip));

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    public void getTravelsByTrip(Trip trip) {

        GetTravelsByTripEvent event = new GetTravelsByTripEvent();

        try {

            event.setSights(repository.getTravelsWithSights(trip));

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

}

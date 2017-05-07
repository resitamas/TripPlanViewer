package hu.bme.aut.mobsoft.tripplanviewer.repository;

import android.content.Context;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.TripType;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Travel;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TravelSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public interface Repository {

    void open(Context ctx);

    void close();

    List<Trip> getTrips(User user);

    List<Trip> getOtherTrips(User user);

    void saveTrip(Trip trip);

    void removeTrip(Trip trip);

    List<Travel> getTravels(Trip trip);

    Trip getTrip(int id);

    List<TripSight> getSightsByTrip(Trip trip);

    List<TripSight> getTripsWithSights(User user, TripType tripType);

    List<TravelSight> getSightsByTravel(Travel travel);

    List<TravelSight> getTravelsWithSights(Trip trip);


}

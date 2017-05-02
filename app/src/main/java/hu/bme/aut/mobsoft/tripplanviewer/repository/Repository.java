package hu.bme.aut.mobsoft.tripplanviewer.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public interface Repository {

    void open(Context ctx);

    void close();

    List<Trip> getTrips(User user);

    void saveTrip(Trip trip);

    void removeTrip(Trip trip);

}

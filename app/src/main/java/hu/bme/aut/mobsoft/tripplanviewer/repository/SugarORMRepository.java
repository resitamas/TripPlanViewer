package hu.bme.aut.mobsoft.tripplanviewer.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class SugarORMRepository implements Repository {

    @Override
    public void open(Context ctx) {
        SugarContext.init(ctx);
    }

    @Override
    public void close() {
        SugarContext.terminate();
    }

    @Override
    public List<Trip> getTrips(User user) {
        return SugarRecord.find(Trip.class, "user = ? ", String.valueOf(user.getId()));
    }

    @Override
    public void saveTrip(Trip trip) {
        SugarRecord.save(trip);
    }

    @Override
    public void removeTrip(Trip trip) {
        SugarRecord.delete(trip);
    }


}

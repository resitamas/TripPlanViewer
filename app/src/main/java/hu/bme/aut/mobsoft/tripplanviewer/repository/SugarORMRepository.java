package hu.bme.aut.mobsoft.tripplanviewer.repository;

import android.content.Context;

import com.orm.SugarContext;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Travel;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TravelSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
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
    public List<Trip> getOtherTrips(User user) {
        return SugarRecord.find(Trip.class, "user != ? ", String.valueOf(user.getId()));
    }

    @Override
    public void saveTrip(Trip trip) {
        SugarRecord.save(trip);
    }

    @Override
    public void removeTrip(Trip trip) {
        SugarRecord.delete(trip);
    }

    @Override
    public List<Travel> getTravels(Trip trip) {
        return SugarRecord.find(Travel.class,"trip = ? ", String.valueOf(trip.getId()));
    }

    @Override
    public Trip getTrip(int id) {
        return Trip.findById(Trip.class,id);
    }

    @Override
    public List<TripSight> getSightsByTrip(Trip trip) {
        return SugarRecord.find(TripSight.class, "trip != ? ", String.valueOf(trip.getId()));
    }

    @Override
    public List<TripSight> getTripsWithSights(User user) {

        ArrayList<TripSight> list = new ArrayList<>();

        List<Trip> trips = SugarRecord.find(Trip.class, "user = ? ", String.valueOf(user.getId()));

        for (Trip tr : trips) {

            list.addAll(getSightsByTrip(tr));

        }

        return list;

    }

    @Override
    public List<TravelSight> getTravelsWithSights(Trip trip) {

        ArrayList<TravelSight> list = new ArrayList<>();

        List<Travel> travels = SugarRecord.find(Travel.class, "trip = ? ", String.valueOf(trip.getId()));

        for (Travel travel : travels) {

            list.addAll(getSightsByTravel(travel));

        }

        return list;
    }

    @Override
    public List<TravelSight> getSightsByTravel(Travel travel) {

        return SugarRecord.find(TravelSight.class, "travel = ?",  String.valueOf(travel.getId()));

    }

}

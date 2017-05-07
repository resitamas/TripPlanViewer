package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event;

import java.util.Dictionary;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class GetUserTripsFromLocalDBEvent {

    private int code;
    private List<TripSight> trips;
    private Throwable throwable;


    public GetUserTripsFromLocalDBEvent() {
    }

    public GetUserTripsFromLocalDBEvent(int code, List<TripSight> trips, Throwable throwable) {
        this.code = code;
        this.trips = trips;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<TripSight> getTrips() {
        return trips;
    }

    public void setTrips(List<TripSight> trips) {
        this.trips = trips;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

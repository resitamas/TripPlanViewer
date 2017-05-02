package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class SearchTripsAtServerEvent {

    private int code;
    private List<Trip> trips;
    private Throwable throwable;

    public SearchTripsAtServerEvent() {
    }

    public SearchTripsAtServerEvent(int code, List<Trip> trips, Throwable throwable) {
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

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

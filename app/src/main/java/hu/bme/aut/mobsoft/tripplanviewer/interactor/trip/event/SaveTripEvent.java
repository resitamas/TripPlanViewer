package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class SaveTripEvent {

    private int code;
    private Trip trip;
    private Throwable throwable;

    public SaveTripEvent() {
    }

    public SaveTripEvent(int code, Trip trip, Throwable throwable) {
        this.code = code;
        this.trip = trip;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

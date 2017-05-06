package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Sight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;

/**
 * Created by Resi Tamas on 05/05/2017.
 */

public class GetSightsByTripEvent {

    private int code;
    private Throwable throwable;
    private List<TripSight> sights;

    public GetSightsByTripEvent() {
    }

    public GetSightsByTripEvent(int code, Trip trip, Throwable throwable, List<TripSight> sights) {
        this.code = code;
        this.throwable = throwable;
        this.sights = sights;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public List<TripSight> getSights() {
        return sights;
    }

    public void setSights(List<TripSight> sights) {
        this.sights = sights;
    }
}

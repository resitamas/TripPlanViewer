package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TravelSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;

/**
 * Created by Resi Tamas on 06/05/2017.
 */

public class GetTravelsByTripEvent {

    private int code;
    private Throwable throwable;
    private List<TravelSight> sights;

    public GetTravelsByTripEvent() {
    }

    public GetTravelsByTripEvent(int code, Throwable throwable, List<TravelSight> sights) {
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

    public List<TravelSight> getSights() {
        return sights;
    }

    public void setSights(List<TravelSight> sights) {
        this.sights = sights;
    }
}

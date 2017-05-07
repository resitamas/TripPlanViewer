package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

public class TripSight extends SugarRecord {

    Trip trip;
    Sight sight;
    int number;

    public TripSight(Trip trip, Sight sight, int number) {
        this.trip = trip;
        this.sight = sight;
        this.number = number;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Sight getSight() {
        return sight;
    }

    public void setSight(Sight sight) {
        this.sight = sight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

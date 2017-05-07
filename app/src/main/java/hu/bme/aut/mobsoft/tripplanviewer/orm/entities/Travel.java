package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

public class Travel extends SugarRecord {

    @Unique
    int travelId;

    int days;
    int kmsTo;
    int timeTo;

    City city;

    Trip trip;

    int number;

    public Travel(int tripId, int days, int kmsTo, int timeTo, Trip trip, City city, int number) {
        this.travelId = tripId;
        this.days = days;
        this.kmsTo = kmsTo;
        this.timeTo = timeTo;
        this.trip = trip;
        this.city = city;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getKmsTo() {
        return kmsTo;
    }

    public void setKmsTo(int kmsTo) {
        this.kmsTo = kmsTo;
    }

    public int getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(int timeTo) {
        this.timeTo = timeTo;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getTravelId() {
        return travelId;
    }

    public void setTravelId(int travelId) {
        this.travelId = travelId;
    }
}

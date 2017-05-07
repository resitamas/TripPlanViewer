package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;
import com.orm.dsl.Unique;

import java.lang.reflect.Array;
import java.util.ArrayList;

import hu.bme.aut.mobsoft.tripplanviewer.orm.CityWithSights;
import hu.bme.aut.mobsoft.tripplanviewer.orm.TripType;
import hu.bme.aut.mobsoft.tripplanviewer.orm.Visibility;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class Trip extends SugarRecord {

    @Unique
    int tripId;

    String name;
    Visibility visibility;
    int distance;
    int days;
    TripType tripType;

    User user;

    public Trip() {

    }

    public Trip(int tripId, String name, Visibility visibility, int distance, int days, TripType type, User user) {
        this.tripId = tripId;
        this.name = name;
        this.visibility = visibility;
        this.distance = distance;
        this.days = days;
        this.tripType = type;
        this.user = user;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public TripType getTripType() {
        return tripType;
    }

    public void setTripType(TripType tripType) {
        this.tripType = tripType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}

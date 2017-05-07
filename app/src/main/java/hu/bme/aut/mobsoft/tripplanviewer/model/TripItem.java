package hu.bme.aut.mobsoft.tripplanviewer.model;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripItem {

    public String tripName;
    public String endpoints;
    public String cities;
    public String days;
    public String distance;
    public int tripId;

    public TripItem() {
    }

    public TripItem(String tripName, String endpoints, String cities, String days, String distance) {
        this.tripName = tripName;
        this.endpoints = endpoints;
        this.cities = cities;
        this.days = days;
        this.distance = distance;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public int getTripId() {
        return tripId;
    }

    public void setTripId(int tripId) {
        this.tripId = tripId;
    }
}

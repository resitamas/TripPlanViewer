package hu.bme.aut.mobsoft.tripplanviewer.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripInfo {

    String tripName;
    String days;
    String kms;
    String cities;
    String endpoints;

    List<TravelItem> travelItems;

    public void addCityItem(TravelItem travelItem) {

        if (travelItems == null) {
            travelItems = new ArrayList<>();
        }

        travelItems.add(travelItem);

    }

    public List<TravelItem> getTravelItems() {
        return travelItems;
    }

    public void setTravelItems(List<TravelItem> travelItems) {
        this.travelItems = travelItems;
    }

    public String getTripName() {
        return tripName;
    }

    public void setTripName(String tripName) {
        this.tripName = tripName;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getKms() {
        return kms;
    }

    public void setKms(String kms) {
        this.kms = kms;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public String getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(String endpoints) {
        this.endpoints = endpoints;
    }
}

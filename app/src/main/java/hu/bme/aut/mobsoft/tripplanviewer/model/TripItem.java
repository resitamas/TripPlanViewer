package hu.bme.aut.mobsoft.tripplanviewer.model;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripItem {

    public String tripName;
    public String endponts;
    public String cities;
    public String days;
    public String distance;

    public TripItem(String tripName, String endponts, String cities, String days, String distance) {
        this.tripName = tripName;
        this.endponts = endponts;
        this.cities = cities;
        this.days = days;
        this.distance = distance;
    }
}

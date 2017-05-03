package hu.bme.aut.mobsoft.tripplanviewer.model;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class CityItem {

    public String days;
    public String hours;
    public String kms;
    public String cityName;
    public String sights;

    public CityItem(String days, String hours, String kms, String cityName, String sights) {
        this.days = days;
        this.hours = hours;
        this.kms = kms;
        this.cityName = cityName;
        this.sights = sights;
    }
}

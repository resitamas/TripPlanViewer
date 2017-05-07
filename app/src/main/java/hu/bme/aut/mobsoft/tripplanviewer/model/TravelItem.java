package hu.bme.aut.mobsoft.tripplanviewer.model;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TravelItem {

    public String days;
    public String hours;
    public String kms;
    public String cityName;
    public String sights;

    public TravelItem() {
    }

    public TravelItem(String days, String hours, String kms, String cityName, String sights) {
        this.days = days;
        this.hours = hours;
        this.kms = kms;
        this.cityName = cityName;
        this.sights = sights;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getKms() {
        return kms;
    }

    public void setKms(String kms) {
        this.kms = kms;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getSights() {
        return sights;
    }

    public void setSights(String sights) {
        this.sights = sights;
    }
}

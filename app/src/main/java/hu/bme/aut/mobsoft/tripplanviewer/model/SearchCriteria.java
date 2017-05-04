package hu.bme.aut.mobsoft.tripplanviewer.model;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.City;
import hu.bme.aut.mobsoft.tripplanviewer.utils.GsonHelper;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class SearchCriteria {

    List<City> cities;
    int minDistance;
    int maxDistance;
    int minDays;
    int maxDays;

    public String getCityIds() {

        ArrayList<Integer> ids = new ArrayList<Integer>();

        for (City city: cities) {
            ids.add(city.getCityId());
        }

        return GsonHelper.getGson().toJson(ids);
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public int getMinDistance() {
        return minDistance;
    }

    public void setMinDistance(int minDistance) {
        this.minDistance = minDistance;
    }

    public int getMaxDistance() {
        return maxDistance;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public int getMinDays() {
        return minDays;
    }

    public void setMinDays(int minDays) {
        this.minDays = minDays;
    }

    public int getMaxDays() {
        return maxDays;
    }

    public void setMaxDays(int maxDays) {
        this.maxDays = maxDays;
    }
}

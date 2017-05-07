package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class City extends SugarRecord {

    @Unique
    int cityId;

    String name;
    String country;

    public City() {

    }

    public City(int cityId, String name, String country) {
        this.cityId = cityId;
        this.name = name;
        this.country = country;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

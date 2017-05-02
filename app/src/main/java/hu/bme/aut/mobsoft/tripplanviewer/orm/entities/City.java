package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class City extends SugarRecord {

    String cityId;
    String name;
    String country;

    public City() {

    }

    public City(String cityId, String name, String country) {
        this.cityId = cityId;
        this.name = name;
        this.country = country;
    }

}

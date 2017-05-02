package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class Sight extends SugarRecord {

    String sightId;
    String name;
    City city;

    public Sight() {

    }

    public Sight(String sightId, String name, City city) {
        this.sightId = sightId;
        this.name = name;
        this.city = city;
    }

}

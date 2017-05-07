package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class Sight extends SugarRecord {

    @Unique
    int sightId;

    String name;
    City city;

    public Sight() {

    }

    public Sight(int sightId, String name, City city) {
        this.sightId = sightId;
        this.name = name;
        this.city = city;
    }

    public int getSightId() {
        return sightId;
    }

    public void setSightId(int sightId) {
        this.sightId = sightId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}

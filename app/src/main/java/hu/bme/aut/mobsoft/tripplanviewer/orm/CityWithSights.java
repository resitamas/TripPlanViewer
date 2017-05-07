package hu.bme.aut.mobsoft.tripplanviewer.orm;

import java.util.ArrayList;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.City;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Sight;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class CityWithSights {

    City city;
    ArrayList<Sight> sights;

    public CityWithSights(City city, ArrayList<Sight> sights) {
        this.city = city;
        this.sights = sights;
    }
}

package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Ignore;

import java.util.ArrayList;

import hu.bme.aut.mobsoft.tripplanviewer.orm.CityWithSights;
import hu.bme.aut.mobsoft.tripplanviewer.orm.TripType;
import hu.bme.aut.mobsoft.tripplanviewer.orm.Visibility;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class Trip extends SugarRecord {

    String tripId;
    String name;
    Visibility visibility;
    int distance;
    int days;
    TripType tripType;

    User user;

    @Ignore
    ArrayList<CityWithSights> citiesWithSights;

    public Trip() {

    }

    public Trip(String tripId, String name, Visibility visibility, int distance, int days, TripType type, User user) {
        this.tripId = tripId;
        this.name = name;
        this.visibility = visibility;
        this.distance = distance;
        this.days = days;
        this.tripType = type;
        this.user = user;
    }

}

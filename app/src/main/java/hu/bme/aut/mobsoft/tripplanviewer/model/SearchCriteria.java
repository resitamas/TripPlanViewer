package hu.bme.aut.mobsoft.tripplanviewer.model;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.City;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class SearchCriteria {

    List<City> cities;
    int minDistance;
    int maxDistance;
    int minDays;
    int maxDays;

}

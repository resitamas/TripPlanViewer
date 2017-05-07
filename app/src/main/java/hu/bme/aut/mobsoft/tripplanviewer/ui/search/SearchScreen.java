package hu.bme.aut.mobsoft.tripplanviewer.ui.search;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface SearchScreen {

    void showNetworkError(String msg);

    void startTripsActivity(List<TripSight> trips);

}

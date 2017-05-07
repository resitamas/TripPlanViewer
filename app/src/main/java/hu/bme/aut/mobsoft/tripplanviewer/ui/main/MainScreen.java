package hu.bme.aut.mobsoft.tripplanviewer.ui.main;


import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;

public interface MainScreen {

    void showTrips(ArrayList<TripItem> trips);

    void showNetworkError(String errorMsg);

}

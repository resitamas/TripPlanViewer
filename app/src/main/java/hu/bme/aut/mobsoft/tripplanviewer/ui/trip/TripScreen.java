package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import java.util.ArrayList;

import hu.bme.aut.mobsoft.tripplanviewer.model.CityItem;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripInfo;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface TripScreen {

    void showTripInfo(TripInfo tripInfo);

    void showCities(ArrayList<CityItem> cities);

}

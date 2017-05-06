package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import hu.bme.aut.mobsoft.tripplanviewer.model.TripInfo;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface TripScreen {

    void showTripInfo(TripInfo tripInfo);

    void showMessage(String msg);

}

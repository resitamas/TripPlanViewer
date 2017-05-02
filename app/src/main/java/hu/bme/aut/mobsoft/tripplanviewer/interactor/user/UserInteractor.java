package hu.bme.aut.mobsoft.tripplanviewer.interactor.user;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class UserInteractor {

    public UserInteractor() {
        TripPlanViewerApplication.injector.inject(this);
    }

    public void GetUserDataFromServer() {

    }


}

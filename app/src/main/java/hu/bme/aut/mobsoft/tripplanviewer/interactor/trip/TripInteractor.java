package hu.bme.aut.mobsoft.tripplanviewer.interactor.trip;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.repository.Repository;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class TripInteractor {

    @Inject
    Repository repository;

    public TripInteractor() {
        TripPlanViewerApplication.injector.inject(this);
    }

    public void getUserTripsFromLocalDB(int index, User user) {

    }

    public void saveTrip(Trip trip) {

    }

    public void getTrip(String id)
    {

    }

    public void searchTripsAtServer(SearchCriteria citeria) {

    }

}

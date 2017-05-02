package hu.bme.aut.mobsoft.tripplanviewer.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

@Module
public class InteractorModule {

    @Provides
    public TripInteractor provideTripInteractor() {
        return new TripInteractor();
    }

}

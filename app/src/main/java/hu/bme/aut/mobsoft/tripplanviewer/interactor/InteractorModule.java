package hu.bme.aut.mobsoft.tripplanviewer.interactor;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.AuthInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.user.UserInteractor;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

@Module
public class InteractorModule {

    @Provides
    public TripInteractor provideTripInteractor() {
        return new TripInteractor();
    }

    @Provides
    public AuthInteractor provideAuthInteractor() {
        return new AuthInteractor();
    }

    @Provides
    public UserInteractor provideUserInteractor() {
        return new UserInteractor();
    }
}

package hu.bme.aut.mobsoft.tripplanviewer;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.InteractorModule;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.AuthInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.user.UserInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.network.NetworkModule;
import hu.bme.aut.mobsoft.tripplanviewer.repository.RepositoryModule;
import hu.bme.aut.mobsoft.tripplanviewer.ui.UIModule;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsActivity;

@Singleton
@Component(modules = {UIModule.class, RepositoryModule.class, InteractorModule.class, NetworkModule.class})
public interface TripPlanViewerApplicationComponent {
    void inject(TripPlanViewerApplication tripPlanViewerApplication);
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(SearchActivity searchActivity);
    void inject(TripActivity tripActivity);
    void inject(TripsActivity tripsActivity);
    void inject(AuthInteractor authInteractor);
    void inject(UserInteractor userInteractor);
    void inject(TripInteractor tripInteractor);
}

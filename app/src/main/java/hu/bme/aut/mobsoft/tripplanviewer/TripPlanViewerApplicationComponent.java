package hu.bme.aut.mobsoft.tripplanviewer;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.tripplanviewer.ui.UIModule;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripActivity;

@Singleton
@Component(modules = {UIModule.class})
public interface TripPlanViewerApplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(LoginActivity loginActivity);
    void inject(SearchActivity searchActivity);
    void inject(TripActivity tripActivity);
}

package hu.bme.aut.mobsoft.tripplanviewer;

import javax.inject.Singleton;

import dagger.Component;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.InteractorModule;
import hu.bme.aut.mobsoft.tripplanviewer.mock.MockNetworkModule;
import hu.bme.aut.mobsoft.tripplanviewer.repository.TestRepositoryModule;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@Singleton
@Component(modules = { MockNetworkModule.class, TestModule.class, InteractorModule.class, TestRepositoryModule.class})
public interface TestComponent extends TripPlanViewerApplicationComponent {
}

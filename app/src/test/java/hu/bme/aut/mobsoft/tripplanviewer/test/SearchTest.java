package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SearchTest {

    private SearchPresenter searchPresenter;
    private SearchScreen searchScreen;

    @Captor
    private ArgumentCaptor<List<TripSight>> tripsCaptor;

    @Test
    public void startTripsActivityTest() {

        SearchCriteria cr = new SearchCriteria();
        cr.setCityName("City");
        cr.setMaxDistance(1000);
        cr.setMinDistance(0);
        cr.setMinDays(3);
        cr.setMaxDays(10);

        searchPresenter.search(cr);

        verify(searchScreen).startTripsActivity(tripsCaptor.capture());

    }

    @Before
    public void setup() throws Exception {

        MockitoAnnotations.initMocks(this);

        setTestInjector();

        searchScreen = mock(SearchScreen.class);
        searchPresenter = new SearchPresenter();
        searchPresenter.attachScreen(searchScreen);

    }


    @After
    public void tearDown() {
        searchPresenter.detachScreen();
    }

}

package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class TripsTest {

    private TripsPresenter tripsPresenter;
    private TripsScreen tripsScreen;

    @Before
    public void setup() throws Exception {

        setTestInjector();
        tripsScreen = mock(TripsScreen.class);
        tripsPresenter = new TripsPresenter();
        tripsPresenter.attachScreen(tripsScreen);

    }

    @Test
    public void setTripTest() {


    }

    @After
    public void tearDown() {
        tripsPresenter.detachScreen();
    }


}

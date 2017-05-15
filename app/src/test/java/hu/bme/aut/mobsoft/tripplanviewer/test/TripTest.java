package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class TripTest {

    private TripPresenter tripPresenter;
    private TripScreen tripScreen;

    @Before
    public void setup() throws Exception {

        setTestInjector();
        tripScreen = mock(TripScreen.class);
        tripPresenter = new TripPresenter();
        tripPresenter.attachScreen(tripScreen);

    }

    @Test
    public void showTripInfoTest() {

        //tripPresenter.saveTrip();


    }

    @After
    public void tearDown() {
        tripPresenter.detachScreen();
    }

}

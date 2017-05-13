package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void showTripsTest() {

    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}

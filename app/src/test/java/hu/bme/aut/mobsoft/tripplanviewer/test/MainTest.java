package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.MockitoAnnotations;
import org.robolectric.ParameterizedRobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class MainTest {

    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Captor
    private ArgumentCaptor<ArrayList<TripItem>> tripsCaptor;
//
//    @ParameterizedRobolectricTestRunner.Parameters(name = "Index: {0}")
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//                { 0, null }, { 1, null }
//        });
//    }
//
    private User user;
    private int index;
//
//    public MainTest(User user, int index) {
//        this.user = user;
//        this.index = index;
//    }

    @Before
    public void setup() throws Exception {

        MockitoAnnotations.initMocks(this);

        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void showTripsTest() {

        index = 1;
        user = new User(1,"Rési Tamás");

        mainPresenter.GetTripsFromLocalDB(index,user);

        //verify(mainScreen).showTrips(tripsCaptor.capture());


    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }

}

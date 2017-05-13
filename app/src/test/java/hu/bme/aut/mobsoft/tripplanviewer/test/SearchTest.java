package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class SearchTest {

    private SearchPresenter searchPresenter;
    private SearchScreen searchScreen;


    @Before
    public void setup() throws Exception {

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

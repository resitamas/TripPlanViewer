package hu.bme.aut.mobsoft.tripplanviewer.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import hu.bme.aut.mobsoft.tripplanviewer.BuildConfig;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginScreen;
import hu.bme.aut.mobsoft.tripplanviewer.utils.RobolectricDaggerTestRunner;

import static hu.bme.aut.mobsoft.tripplanviewer.TestHelper.setTestInjector;
import static org.mockito.Mockito.mock;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class LoginTest {

    private LoginPresenter loginPresenter;
    private LoginScreen loginScreen;

    @Before
    public void setup() throws Exception {

        setTestInjector();
        loginScreen = mock(LoginScreen.class);
        loginPresenter = new LoginPresenter();
        loginPresenter.attachScreen(loginScreen);

    }

    @Test
    public void testLogin() {



    }

    @After
    public void tearDown() {
        loginPresenter.detachScreen();
    }

}

package hu.bme.aut.mobsoft.tripplanviewer.ui.login;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.AuthInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.AuthType;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainScreen;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class LoginPresenter extends Presenter<LoginScreen> {

    @Inject
    Executor executor;

    @Inject
    AuthInteractor authInteractor;

    public LoginPresenter() {

    }

    public void loginWithFacebook() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                authInteractor.AuthUser(AuthType.Facebook);
            }
        });

    }

    public void loginWithTwitter() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                authInteractor.AuthUser(AuthType.Twitter);
            }
        });

    }

    public void loginWihGoogle() {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                authInteractor.AuthUser(AuthType.Google);
            }
        });

    }

    @Override
    public void attachScreen(LoginScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

}

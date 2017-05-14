package hu.bme.aut.mobsoft.tripplanviewer.ui.login;

import android.content.Intent;
import android.support.annotation.NonNull;

import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.AuthInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.AuthType;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.event.AuthUserEvent;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainScreen;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class LoginPresenter extends Presenter<LoginScreen> implements GoogleApiClient.OnConnectionFailedListener {

    @Inject
    Executor executor;

    @Inject
    AuthInteractor authInteractor;

    @Inject
    EventBus bus;


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

    public void loginWihGoogle(final GoogleSignInResult result) {

        executor.execute(new Runnable() {
            @Override
            public void run() {

                if (result.isSuccess()) {
                    authInteractor.AuthUser(AuthType.Google);
                } else {
                    screen.showAuthError("Authentication failed!");
                }

            }
        });

    }

    @Override
    public void attachScreen(LoginScreen screen) {

        super.attachScreen(screen);
        injector.inject(this);
        bus.register(this);
    }

    @Override
    public void detachScreen() {

        bus.unregister(this);

        super.detachScreen();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final AuthUserEvent event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showAuthError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {

                screen.startActivity(event.getUser());

            }
        }


    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

        screen.showAuthError(connectionResult.getErrorMessage());

    }
}

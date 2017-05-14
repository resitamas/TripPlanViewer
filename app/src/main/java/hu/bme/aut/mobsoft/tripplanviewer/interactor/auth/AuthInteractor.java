package hu.bme.aut.mobsoft.tripplanviewer.interactor.auth;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.event.AuthUserEvent;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class AuthInteractor {

    @Inject
    EventBus bus;

    public AuthInteractor() {
        TripPlanViewerApplication.injector.inject(this);
    }

    public void AuthUser(AuthType authType) {

        AuthUserEvent event = new AuthUserEvent();

        try {

            switch (authType) {

                case Facebook:

                    event.setUser(SignIn());

                case Google:

                    event.setUser(SignIn());

                    break;

                case Twitter:

                    throw new Exception("Not supported yet");

            }

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    private User SignIn() {

        return new User(1, "Rési Tamás");
    }


}

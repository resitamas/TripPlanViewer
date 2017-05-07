package hu.bme.aut.mobsoft.tripplanviewer.interactor.auth;

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

                    throw new Exception("Not supported yet");

                case Google:

                    event.setUser(SignInWithGoogle());

                    break;

                case Twitter:

                    throw new Exception("Not supported yet");

            }

        } catch (Exception e) {
            event.setThrowable(e);
        }

        bus.post(event);

    }

    private User SignInWithGoogle() {

        return new User(1, "Rési Tamás");
    }

}

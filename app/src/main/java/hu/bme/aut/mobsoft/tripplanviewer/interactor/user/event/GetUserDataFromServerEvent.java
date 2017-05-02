package hu.bme.aut.mobsoft.tripplanviewer.interactor.user.event;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class GetUserDataFromServerEvent {

    private int code;
    private User user;
    private Throwable throwable;

    public GetUserDataFromServerEvent() {
    }

    public GetUserDataFromServerEvent(int code, User user, Throwable throwable) {
        this.code = code;
        this.user = user;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

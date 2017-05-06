package hu.bme.aut.mobsoft.tripplanviewer.ui.login;

import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public interface LoginScreen {

    void showAuthError(String msg);

    void startActivity(User user);

}

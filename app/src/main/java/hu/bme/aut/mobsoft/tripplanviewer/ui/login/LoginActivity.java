package hu.bme.aut.mobsoft.tripplanviewer.ui.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;


/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class LoginActivity extends AppCompatActivity implements LoginScreen, View.OnClickListener {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        setContentView(R.layout.activity_login);

        TripPlanViewerApplication.injector.inject(this);

        findViewById(R.id.btFacebook).setOnClickListener(this);
        findViewById(R.id.btGoogle).setOnClickListener(this);
        findViewById(R.id.btTwitter).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();

        loginPresenter.attachScreen(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

        loginPresenter.detachScreen();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.btFacebook:

                loginPresenter.loginWithFacebook();

                break;

            case R.id.btTwitter:

                loginPresenter.loginWithTwitter();

                break;

            case R.id.btGoogle:

                loginPresenter.loginWihGoogle();

                break;
        }

    }
}

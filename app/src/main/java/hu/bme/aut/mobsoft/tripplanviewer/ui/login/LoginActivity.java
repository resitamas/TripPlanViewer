package hu.bme.aut.mobsoft.tripplanviewer.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.auth.event.AuthUserEvent;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainActivity;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;


/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class LoginActivity extends AppCompatActivity implements LoginScreen, View.OnClickListener {

    @Inject
    LoginPresenter loginPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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


    @Override
    public void showAuthError(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void startActivity(User user) {

        TripPlanViewerApplication.user = user;

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

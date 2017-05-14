package hu.bme.aut.mobsoft.tripplanviewer.ui.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

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

    GoogleApiClient googleApiClient;

    CallbackManager callbackManager;

    /* Request code used to invoke sign in user interactions. */
    private static final int RC_SIGN_IN = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        TripPlanViewerApplication.injector.inject(this);

        //findViewById(R.id.btFacebook).setOnClickListener(this);
        findViewById(R.id.btGoogle).setOnClickListener(this);
        findViewById(R.id.btTwitter).setOnClickListener(this);

        //google sign in
        initGoogleSignIn();

        //facebook sing in
        initFacebookSignIn();

    }

    private void initFacebookSignIn() {

        LoginButton loginButton = (LoginButton) findViewById(R.id.btFacebook);
        loginButton.setReadPermissions("email");

        callbackManager = CallbackManager.Factory.create();

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {

                loginPresenter.loginWithFacebook();

            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });

    }

    private void initGoogleSignIn() {

        // Set the dimensions of google the sign-in button.
        SignInButton signInButton = (SignInButton) findViewById(R.id.btGoogle);
        signInButton.setSize(SignInButton.SIZE_WIDE);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, loginPresenter).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();


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

                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);

                //loginPresenter.loginWihGoogle(null);

                break;
        }

    }


    @Override
    public void showAuthError(final String msg) {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public void startActivity(User user) {

        TripPlanViewerApplication.user = user;

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            loginPresenter.loginWihGoogle(result);
            return;
        }

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

}

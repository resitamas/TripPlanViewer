package hu.bme.aut.mobsoft.tripplanviewer.ui.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.ui.TripsAdapter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.TripsPagerAdapter;

public class MainActivity extends AppCompatActivity {

//    @Inject
//    MainPresenter mainPresenter;

    ViewPager viewPager;

    TripsPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        TripPlanViewerApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPagerAdapter = new TripsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);

        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        mainPresenter.attachScreen(this);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mainPresenter.detachScreen();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trips, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case R.id.action_search:


                break;

            default:

                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void showMessage(String text) {
//        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//    }
}

package hu.bme.aut.mobsoft.tripplanviewer.ui.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import org.florescu.android.rangeseekbar.RangeSeekBar;
import org.greenrobot.eventbus.EventBus;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsActivity;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SearchActivity extends AppCompatActivity implements SearchScreen, View.OnClickListener {

    @Inject
    SearchPresenter searchPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search);

        injector.inject(this);

        InitToolbar();

        findViewById(R.id.btSearch).setOnClickListener(this);

        InitDaysSeekbar((RangeSeekBar) findViewById(R.id.skDays));
        InitDistanceSeekbar((RangeSeekBar) findViewById(R.id.skKms));

//        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SE‌​RVICE);
//        imm.hideSoftInputFromWindow(myEditText.getWindowToken(), 0);
    }

    private void InitToolbar() {

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
//        getSupportActionBar().setHomeButtonEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                NavUtils.navigateUpFromSameTask(this);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void InitDaysSeekbar(RangeSeekBar seekBar) {

        seekBar.setRangeValues(0,30);
        seekBar.setSelectedMinValue(2);
        seekBar.setSelectedMaxValue(25);

        seekBar.setTextAboveThumbsColorResource(R.color.colorAccent);

    }

    private void InitDistanceSeekbar(RangeSeekBar seekBar) {

        seekBar.setRangeValues(0,5000);
        seekBar.setSelectedMinValue(20);
        seekBar.setSelectedMaxValue(3000);

        seekBar.setTextAboveThumbsColorResource(R.color.colorAccent);

    }

    @Override
    protected void onStart() {
        super.onStart();

        searchPresenter.attachScreen(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

        searchPresenter.detachScreen();

    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btSearch) {

            searchPresenter.search(getSearchCriteria());

        }

    }

    private SearchCriteria getSearchCriteria() {

        SearchCriteria cr = new SearchCriteria();

        cr.setCityName(((EditText) findViewById(R.id.cityName)).getText().toString());
        cr.setMinDays(((RangeSeekBar) findViewById(R.id.skDays)).getSelectedMinValue().intValue());
        cr.setMaxDays(((RangeSeekBar) findViewById(R.id.skDays)).getSelectedMaxValue().intValue());
        cr.setMinDistance(((RangeSeekBar) findViewById(R.id.skKms)).getSelectedMinValue().intValue());
        cr.setMaxDistance(((RangeSeekBar) findViewById(R.id.skKms)).getSelectedMaxValue().intValue());

        return cr;
    }

    @Override
    public void showNetworkError(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startTripsActivity(List<Trip> trips) {

        Intent intent = new Intent(this, TripsActivity.class);
        startActivity(intent);

    }
}

package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripInfo;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class TripActivity extends AppCompatActivity implements TripScreen {

    @Inject
    TripPresenter tripPresenter;

    private RecyclerView recyclerView;
    private TravelsAdapter travelsAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trip);

        TripPlanViewerApplication.injector.inject(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        travelsAdapter = new TravelsAdapter();

        recyclerView.setAdapter(travelsAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();

        tripPresenter.attachScreen(this);

    }

    @Override
    protected void onStop() {
        super.onStop();

        tripPresenter.detachScreen();

    }

    @Override
    protected void onResume() {
        super.onResume();

        tripPresenter.getTrip(getIntent().getIntExtra("tripId",1));

    }

    @Override
    public void showTripInfo(TripInfo tripInfo) {

        ((TextView) findViewById(R.id.tripName)).setText(tripInfo.getTripName());
        ((TextView) findViewById(R.id.days)).setText(tripInfo.getDays());
        ((TextView) findViewById(R.id.kms)).setText(tripInfo.getKms());
        ((TextView) findViewById(R.id.cities)).setText(tripInfo.getCities());
        ((TextView) findViewById(R.id.endpoints)).setText(tripInfo.getEndpoints());
        //((TextView) findViewById(R.id.sights)).setText(tripInfo.get());

        travelsAdapter.swipe(tripInfo.getTravelItems());

    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.trip, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId())
        {
            case R.id.action_menu:

                tripPresenter.saveTrip();

                break;

            default:

                return super.onOptionsItemSelected(item);
        }

        return super.onOptionsItemSelected(item);
    }

}

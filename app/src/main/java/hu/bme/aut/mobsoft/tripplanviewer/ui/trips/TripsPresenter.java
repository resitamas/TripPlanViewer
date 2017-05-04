package hu.bme.aut.mobsoft.tripplanviewer.ui.trips;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;

/**
 * Created by Resi Tamas on 04/04/2017.
 */

public class TripsPresenter extends Presenter<TripsScreen> {

    @Inject
    Executor executor;

    public TripsPresenter() {

    }

    @Override
    public void attachScreen(TripsScreen screen) {

        super.attachScreen(screen);

        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {

        EventBus.getDefault().unregister(this);

        super.detachScreen();
    }

    public void getTripsFromRemote(SearchCriteria cr)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }

}

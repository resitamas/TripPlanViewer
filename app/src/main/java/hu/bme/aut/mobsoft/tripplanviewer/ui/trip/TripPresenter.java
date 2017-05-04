package hu.bme.aut.mobsoft.tripplanviewer.ui.trip;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class TripPresenter extends Presenter<TripScreen> {

    @Inject
    Executor executor;

    @Inject
    TripInteractor interactor;

    public TripPresenter() {

    }

    @Override
    public void attachScreen(TripScreen screen) {

        super.attachScreen(screen);

        EventBus.getDefault().register(this);

    }

    @Override
    public void detachScreen() {

        EventBus.getDefault().unregister(this);

        super.detachScreen();

    }

    public void getTrip(final int tripId)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.getTrip(tripId);
            }
        });
    }
}

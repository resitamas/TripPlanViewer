package hu.bme.aut.mobsoft.tripplanviewer.ui.search;

import android.content.Intent;
import android.icu.text.SearchIterator;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.event.SearchTripsAtServerEvent;
import hu.bme.aut.mobsoft.tripplanviewer.model.SearchCriteria;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginScreen;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsActivity;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by mobsoft on 2017. 03. 24..
 */

public class SearchPresenter extends Presenter<SearchScreen> {

    @Inject
    EventBus bus;

    @Inject
    TripInteractor tripInteractor;

    @Inject
    Executor executor;

    public SearchPresenter() {

    }

    public void search(final SearchCriteria cr) {

        executor.execute(new Runnable() {
            @Override
            public void run() {
                tripInteractor.searchTripsAtServer(cr);
            }
        });

    }

    @Override
    public void attachScreen(SearchScreen screen) {

        super.attachScreen(screen);

        injector.inject(this);

        if (!bus.isRegistered(this)) {
            bus.register(this);
        }

    }

    @Override
    public void detachScreen() {

        super.detachScreen();

        bus.unregister(this);

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final SearchTripsAtServerEvent event) {

        if (event.getThrowable() != null) {

            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {

                screen.startTripsActivity(event.getTrips());

            }
        }

    }

}

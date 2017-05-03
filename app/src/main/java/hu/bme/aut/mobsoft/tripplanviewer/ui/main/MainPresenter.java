package hu.bme.aut.mobsoft.tripplanviewer.ui.main;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.interactor.trip.TripInteractor;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;
import hu.bme.aut.mobsoft.tripplanviewer.ui.Presenter;


public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    Executor executor;

    @Inject
    TripInteractor interactor;

    public MainPresenter() {
    }

    @Override
    public void attachScreen(MainScreen screen) {

        super.attachScreen(screen);

        EventBus.getDefault().register(this);

    }

    @Override
    public void detachScreen() {

        EventBus.getDefault().unregister(this);

        super.detachScreen();

    }

    public void GetTripsFromLocalDB(final int index, final User user)
    {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                interactor.getUserTripsFromLocalDB(index, user);
            }
        });
    }




}

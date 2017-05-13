package hu.bme.aut.mobsoft.tripplanviewer;

import android.content.Context;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsPresenter;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@Module
public class TestModule {

    private Context ctx;

    public TestModule(Context ctx) {
        this.ctx = ctx;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return new LoginPresenter();
    }

    @Provides
    @Singleton
    public SearchPresenter provideSearchPresenter() { return new SearchPresenter(); }

    @Provides
    @Singleton
    public TripPresenter provideTripPresenter() {
        return new TripPresenter();
    }

    @Provides
    @Singleton
    public TripsPresenter provideTripsPresenter() {
        return new TripsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return Executors.newFixedThreadPool(1);
    }

}

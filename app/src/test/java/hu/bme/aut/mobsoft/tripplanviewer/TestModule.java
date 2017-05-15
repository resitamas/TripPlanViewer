package hu.bme.aut.mobsoft.tripplanviewer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.aut.mobsoft.tripplanviewer.ui.UIModule;
import hu.bme.aut.mobsoft.tripplanviewer.ui.login.LoginPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.main.MainPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.search.SearchPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trips.TripsPresenter;
import hu.bme.aut.mobsoft.tripplanviewer.utils.UIExecutor;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@Module
public class TestModule {

    private final UIModule uiModule;

    public TestModule(Context ctx) {
        this.uiModule = new UIModule(ctx);
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return uiModule.provideMainPresenter();
    }

    @Provides
    @Singleton
    public LoginPresenter provideLoginPresenter() {
        return uiModule.provideLoginPresenter();
    }

    @Provides
    @Singleton
    public SearchPresenter provideSearchPresenter() {
        return uiModule.provideSearchPresenter();
    }

    @Provides
    @Singleton
    public TripPresenter provideTripPresenter() {
        return uiModule.provideTripPresenter();
    }

    @Provides
    @Singleton
    public TripsPresenter provideTripsPresenter() {
        return uiModule.provideTripsPresenter();
    }

    @Provides
    @Singleton
    public EventBus provideEventBus() {
        return EventBus.getDefault();
    }

    @Provides
    @Singleton
    public Executor provideExecutor() {
        return new UIExecutor(new Handler(Looper.getMainLooper()));
    }

}

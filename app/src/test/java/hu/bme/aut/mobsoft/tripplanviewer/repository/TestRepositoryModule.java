package hu.bme.aut.mobsoft.tripplanviewer.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

@Module
public class TestRepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }

}

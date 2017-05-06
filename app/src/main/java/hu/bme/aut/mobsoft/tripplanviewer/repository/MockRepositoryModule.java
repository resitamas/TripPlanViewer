package hu.bme.aut.mobsoft.tripplanviewer.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Resi Tamas on 05/05/2017.
 */

@Module
public class MockRepositoryModule  {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new MemoryRepository();
    }

}

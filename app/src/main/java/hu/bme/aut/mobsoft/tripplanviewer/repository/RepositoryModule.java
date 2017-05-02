package hu.bme.aut.mobsoft.tripplanviewer.repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    public Repository provideRepository() {
        return new SugarORMRepository();
    }

}

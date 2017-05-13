package hu.bme.aut.mobsoft.tripplanviewer;

import org.robolectric.RuntimeEnvironment;
import org.robolectric.shadows.ShadowLog;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

public class TestHelper {


    public static void setTestInjector() {
        ShadowLog.stream = System.out;
        TripPlanViewerApplication application = (TripPlanViewerApplication) RuntimeEnvironment.application;
        TripPlanViewerApplicationComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.injector = injector;
    }

}

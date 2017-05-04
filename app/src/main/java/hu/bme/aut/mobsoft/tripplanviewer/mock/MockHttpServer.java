package hu.bme.aut.mobsoft.tripplanviewer.mock;

import hu.bme.aut.mobsoft.tripplanviewer.mock.interceptors.MockInterceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

public class MockHttpServer {

    public static Response call(Request request) {
        MockInterceptor mockInterceptor = new MockInterceptor();
        return mockInterceptor.process(request);
    }

}

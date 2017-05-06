package hu.bme.aut.mobsoft.tripplanviewer.mock.interceptors;

import android.net.Uri;

import hu.bme.aut.mobsoft.tripplanviewer.network.NetworkConfig;
import hu.bme.aut.mobsoft.tripplanviewer.repository.MemoryRepository;
import hu.bme.aut.mobsoft.tripplanviewer.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.aut.mobsoft.tripplanviewer.mock.interceptors.MockHelper.makeResponse;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

public class TripMock {

    public static Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "trips") && request.method().equals("GET")){

            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getTrips(null));
            responseCode = 200;

        } else if(uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "savetrip") && request.method().equals("POST")) {

            responseString = "";
            responseCode = 200;

        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {

            responseString = "";
            responseCode = 200;

        } else {

            responseString = "ERROR";
            responseCode = 503;

        }

        return makeResponse(request, headers, responseCode, responseString);
    }

}

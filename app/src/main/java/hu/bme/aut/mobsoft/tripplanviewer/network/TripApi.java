package hu.bme.aut.mobsoft.tripplanviewer.network;

import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.network.model.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.network.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

public interface TripApi {

    /**
     *
     * Log in user
     * @return Call<User>
     */

    @POST("login")
    Call<User> login();

    /**
     *
     * Add trip to user
     * @param trip The trip which will be added to user
     * @return Call<Void>
     */

    @POST("savetrip")
    Call<Void> saveTrip(@Body Trip trip);

    /**
     *
     * Get all trips.
     * @param cities The ids of the visited cities.
     * @param mindistance The minimum distance
     * @param maxdistance The maximum distance
     * @param mindays The minimum number of days
     * @param maxdays The maximum number of days
     * @return Call<List<DefinitionsTrip>>
     */

    @GET("trips")
    Call<List<Trip>> getTrips(
            @Query("cities") String cities,
            @Query("mindistance") Integer mindistance,
            @Query("maxdistance") Integer maxdistance,
            @Query("mindays") Integer mindays,
            @Query("maxdays") Integer maxdays
    );

}

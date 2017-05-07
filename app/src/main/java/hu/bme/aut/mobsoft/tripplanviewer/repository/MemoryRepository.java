package hu.bme.aut.mobsoft.tripplanviewer.repository;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.orm.TripType;
import hu.bme.aut.mobsoft.tripplanviewer.orm.Visibility;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.City;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Sight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Travel;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TravelSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.TripSight;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.User;

/**
 * Created by Resi Tamas on 04/05/2017.
 */

public class MemoryRepository implements Repository {

    private ArrayList<Trip> trips;
    private ArrayList<Travel> travels;
    private ArrayList<TripSight> tripSights;
    private ArrayList<TravelSight> travelSights;

    private City losAngeles;
    private City sanFrancisco;
    private City lasVegas;
    private City budapest;
    private City balaton;
    private City rome;
    private City venice;
    private City paris;
    private City versaille;

    private Sight hollywood;
    private Sight disneyland;

    private Sight strip;

    private Sight goldenGateBridge;
    private Sight fishermansWharf;

    private Sight squareHeroes;
    private Sight hillGellert;

    private Sight aranypart;

    private Sight colosseum;

    private Sight canals;

    private Sight eifelTower;

    private Sight castle;

    private Trip californiaTrip;

    private Trip hungaryTrip;

    private Trip italyTrip;

    private Trip franceTrip;

    @Override
    public void open(Context ctx) {

        //Init cities
        initCities();

        //Init sights
        initSights();

        //Init trips
        initTrips();

        //Init travels
        initTravel();

        //Init trip sights
        initTripSights();

        //Init travel with sights
        initTravelSights();

    }

    private void initTripSights() {

        tripSights = new ArrayList<>();

        tripSights.add(new TripSight(californiaTrip,hollywood,0));
        tripSights.add(new TripSight(californiaTrip,disneyland,1));
        tripSights.add(new TripSight(californiaTrip,strip,2));
        tripSights.add(new TripSight(californiaTrip,goldenGateBridge,3));
        tripSights.add(new TripSight(californiaTrip,fishermansWharf,4));

        tripSights.add(new TripSight(hungaryTrip,squareHeroes,0));
        tripSights.add(new TripSight(hungaryTrip,hillGellert,1));
        tripSights.add(new TripSight(hungaryTrip,aranypart,2));

        tripSights.add(new TripSight(italyTrip,canals,0));
        tripSights.add(new TripSight(italyTrip,colosseum,1));

        tripSights.add(new TripSight(franceTrip,castle,0));
        tripSights.add(new TripSight(franceTrip,eifelTower,1));

    }

    public void initTravelSights() {

        travelSights = new ArrayList<>();

        travelSights.add(new TravelSight(travels.get(0),hollywood));
        travelSights.add(new TravelSight(travels.get(0),disneyland));
        travelSights.add(new TravelSight(travels.get(1),strip));
        travelSights.add(new TravelSight(travels.get(2),goldenGateBridge));
        travelSights.add(new TravelSight(travels.get(2),fishermansWharf));

        travelSights.add(new TravelSight(travels.get(3),squareHeroes));
        travelSights.add(new TravelSight(travels.get(3),hillGellert));
        travelSights.add(new TravelSight(travels.get(4),aranypart));

        travelSights.add(new TravelSight(travels.get(5),eifelTower));
        travelSights.add(new TravelSight(travels.get(6),castle));

        travelSights.add(new TravelSight(travels.get(7),colosseum));
        travelSights.add(new TravelSight(travels.get(8),canals));

    }

    private void initTravel() {

        travels = new ArrayList<>();

        travels.add(new Travel(0,3,0,0,californiaTrip, losAngeles,0));
        travels.add(new Travel(1,2,300,4,californiaTrip, lasVegas,1));
        travels.add(new Travel(2,3,800,10,californiaTrip, sanFrancisco,2));

        travels.add(new Travel(3,1,0,0,hungaryTrip, budapest,3));
        travels.add(new Travel(4,1,100,2,hungaryTrip, balaton,4));

        travels.add(new Travel(5,1,100,2,franceTrip, paris,5));
        travels.add(new Travel(6,1,100,2,franceTrip, versaille,6));

        travels.add(new Travel(7,1,100,2,italyTrip, rome,7));
        travels.add(new Travel(8,1,100,2,italyTrip, venice,8));

    }

    private void initTrips() {

        californiaTrip = new Trip(0,"Roadtrip in California", Visibility.Public, 3000, 14, TripType.Own, new User(1, "Rési Tamás"));
        hungaryTrip = new Trip(1,"Explore Hungary", Visibility.Public, 100, 5, TripType.Own, new User(1, "Rési Tamás"));
        italyTrip = new Trip(2,"Visit Italy", Visibility.Private, 500, 6, TripType.Own, new User(1, "Rési Tamás"));
        franceTrip = new Trip(3,"Visit France", Visibility.Public, 400, 7, TripType.Other, new User(1, "Rési Tamás"));

        trips = new ArrayList<>();

        trips.add(californiaTrip);
        trips.add(hungaryTrip);
        trips.add(italyTrip);
        trips.add(franceTrip);
    }

    private void initCities()
    {
        losAngeles = new City(0,"Los Angeles","America");
        sanFrancisco = new City(1,"San Francisco","America");
        lasVegas = new City(2,"Las Vegas","America");
        budapest = new City(3,"Budapest","Hungary");
        balaton = new City(4,"Balaton","Hungary");
        rome = new City(5,"Rome","Italy");
        venice = new City(6,"Venice","Italy");
        paris = new City(7,"Paris","France");
        versaille = new City(8,"Versaille","France");
    }

    private void initSights()
    {
        hollywood = new Sight(0,"Hollywood",losAngeles);
        disneyland = new Sight(1,"Disneyland",losAngeles);

        strip = new Sight(2,"Las Vegas Strip",lasVegas);

        goldenGateBridge = new Sight(3,"Golden Gate Bridge",sanFrancisco);
        fishermansWharf = new Sight(4,"Fisherman's wharf",sanFrancisco);

        squareHeroes = new Sight(5,"Square of Heroes",budapest);
        hillGellert = new Sight(6,"Hill of Gellert",budapest);

        aranypart = new Sight(7,"Siófok aranypart",balaton);

        colosseum = new Sight(8,"Colosseum",rome);

        canals = new Sight(9,"Canals",venice);

        eifelTower = new Sight(10,"Tower of Eifel",paris);

        castle = new Sight(11,"Castle of Versaille", versaille);
    }

    @Override
    public void close() {

    }

    @Override
    public List<Trip> getTrips(User user) {
        return trips;
    }

    @Override
    public List<Trip> getOtherTrips(User user) {
        return trips;
    }

    @Override
    public void saveTrip(Trip trip) {
        trips.add(trip);
    }

    @Override
    public void removeTrip(Trip trip) {
        trips.remove(trip);
    }

    @Override
    public List<Travel> getTravels(Trip trip) {

        ArrayList<Travel> tvs = new ArrayList<>();

        for (Travel travel: travels) {
            if (travel.getTrip().getTripId() == trip.getTripId()) {
                tvs.add(travel);
            }
        }

        return tvs;
    }

    @Override
    public Trip getTrip(int id) {

        for (Trip trip : trips) {
            if (trip.getTripId() == id) {
                return trip;
            }
        }

        return trips.get(0);

    }

    @Override
    public List<TripSight> getSightsByTrip(Trip trip) {

        ArrayList<TripSight> shs =  new ArrayList<>();

        for (TripSight ts : tripSights) {
            if (ts.getTrip().getTripId() == trip.getTripId()) {
                shs.add(ts);
            }
        }

        return shs;
    }

    @Override
    public List<TripSight> getTripsWithSights(User user, TripType tripType) {

        List<TripSight> list = new ArrayList<>();

        for (TripSight tripSight : tripSights) {

            if (tripSight.getTrip().getUser().getUserId() == user.getUserId() && tripSight.getTrip().getTripType() == tripType) {
                list.add(tripSight);
            }
        }

        return list;

    }

    @Override
    public List<TravelSight> getSightsByTravel(Travel travel) {

        ArrayList<TravelSight> list = new ArrayList<>();

        for (TravelSight travelSight : travelSights) {

            if (travel.getTravelId() == travelSight.getTravel().getTravelId()) {
                list.add(travelSight);
            }

        }

        return list;
    }

    @Override
    public List<TravelSight> getTravelsWithSights(Trip trip) {

        ArrayList<TravelSight> list = new ArrayList<>();

        for (Travel travel: travels) {

            if (travel.getTrip().getTripId() == trip.getTripId()) {
                list.addAll(getSightsByTravel(travel));
            }
        }

        return list;
    }

    public ArrayList<TripSight> getTripSights() {
        return tripSights;
    }

    public void setTripSights(ArrayList<TripSight> tripSights) {
        this.tripSights = tripSights;
    }
}

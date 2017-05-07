package hu.bme.aut.mobsoft.tripplanviewer.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.ui.RecyclerViewClickListener;
import hu.bme.aut.mobsoft.tripplanviewer.ui.TripsAdapter;
import hu.bme.aut.mobsoft.tripplanviewer.ui.trip.TripActivity;

import static hu.bme.aut.mobsoft.tripplanviewer.TripPlanViewerApplication.injector;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripsFragment extends Fragment implements MainScreen, View.OnClickListener {

    @Inject
    MainPresenter mainPresenter;

    private RecyclerView recyclerView;
    private TripsAdapter tripsAdapter;

    private int index;
    private List<TripItem> trips;

    public TripsFragment() {

        injector.inject(this);

    }

    public static TripsFragment Instance(int index) {

        TripsFragment fragment = new TripsFragment();

        Bundle args = new Bundle();
        args.putInt("index",index);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        mainPresenter.attachScreen(this);
    }

    @Override
    public void onDetach() {

        mainPresenter.detachScreen();
        super.onDetach();

    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        index = getArguments().getInt("index");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.trips_fragment, container, false);

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        tripsAdapter = new TripsAdapter(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(tripsAdapter);

        return root;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        ArrayList<TripItem> items = new ArrayList<>();

//        items.add(new TripItem("Próba","Ide-oda","10","10","10"));
//        items.add(new TripItem("Próba","Ide-oda","10","10","10"));
//        items.add(new TripItem("Próba","Ide-oda","10","10","10"));
//
//        showTrips(items);

        mainPresenter.GetTripsFromLocalDB(index, TripPlanViewerApplication.user);

    }

    @Override
    public void showTrips(ArrayList<TripItem> trips) {

        this.trips = trips;
        tripsAdapter.swipe(trips);

    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getContext(),errorMsg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(getActivity(), TripActivity.class);
        intent.putExtra("tripId", trips.get(Integer.parseInt((String)v.getTag())).getTripId());
        startActivity(intent);
    }
}

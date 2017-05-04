package hu.bme.aut.mobsoft.tripplanviewer.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.inject.Inject;

import hu.bme.aut.mobsoft.tripplanviewer.R;
import hu.bme.aut.mobsoft.tripplanviewer.model.TripItem;
import hu.bme.aut.mobsoft.tripplanviewer.orm.entities.Trip;
import hu.bme.aut.mobsoft.tripplanviewer.ui.TripsAdapter;

/**
 * Created by Resi Tamas on 03/05/2017.
 */

public class TripsFragment extends Fragment implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    private RecyclerView recyclerView;
    private TripsAdapter tripsAdapter;

    private int index;

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
        tripsAdapter = new TripsAdapter();

        recyclerView.setAdapter(tripsAdapter);

        return root;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        mainPresenter.GetTripsFromLocalDB(index, null);

    }

    @Override
    public void showTrips(ArrayList<TripItem> trips) {

        tripsAdapter.swipe(trips);

    }

    @Override
    public void showNetworkError(String errorMsg) {
        Toast.makeText(getContext(),errorMsg,Toast.LENGTH_LONG).show();
    }

}

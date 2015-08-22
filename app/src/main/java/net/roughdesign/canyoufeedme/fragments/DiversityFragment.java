package net.roughdesign.canyoufeedme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.roughdesign.api.Country;
import net.roughdesign.canyoufeedme.R;



public class DiversityFragment extends AbsCountryDataFragment {
    // =============================================================================================
    // Variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountryDetailActivity";


    private TextView meat;
    private TextView animal_byproducts;
    private TextView cereals;
    private TextView fish;
    private TextView produce;
    private TextView non_essentials;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_country_data__diversity, container, false);
        Log.e(TAG, "GNOCCI 2: " + result);
        assignViews(result);
        return result;

        /*if (view == null) {
            view = inflater.inflate(R.layout.fragment_country_data__diversity, container, false);
            assignViews(view);
        }
        return view;*/
    }


    @Override
    public void onCountryDataRetrieved(Country result) {
        Fragment debug = getChildFragmentManager()
                .findFragmentById(R.id.country_data__diversity__graphic);

        Log.e(TAG, "PIZZA: " + debug);
        Log.e(TAG, "PASTA: " + this.getView());

        DiversityChartFragment chart = (DiversityChartFragment) getChildFragmentManager()
                .findFragmentById(R.id.country_data__diversity__graphic);
        /*/chart.onCountryDataRetrieved(result);
        meat.setText(Long.toString(result.getAvailableMeatInTons()) + " t");
        animal_byproducts.setText(Long.toString(result.getAvailableAnimalByproductsInTons()) + " t");
        cereals.setText(Long.toString(result.getAvailableCerealsInTons()) + " t");
        fish.setText(result.getAvailableFishInTons() + " t");
        produce.setText(result.getAvailableProduceInTons() + " t");
        non_essentials.setText(result.getAvailableNonEssentialsInTons() + " t");*/
    }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignViews(View result) {
        /*
        meat = (TextView) result.findViewById(R.id.country_data__diversity__v__meat);
        animal_byproducts = (TextView) result.findViewById(R.id.country_data__diversity__v__animal_byproducts);
        cereals = (TextView) result.findViewById(R.id.country_data__diversity__v__cereals);
        fish = (TextView) result.findViewById(R.id.country_data__diversity__v__fish);
        produce = (TextView) result.findViewById(R.id.country_data__diversity__v__produce);
        non_essentials = (TextView) result.findViewById(R.id.country_data__diversity__v__non_essentials);
        */
    }


}

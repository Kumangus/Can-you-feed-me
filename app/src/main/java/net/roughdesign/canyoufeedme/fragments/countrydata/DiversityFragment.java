package net.roughdesign.canyoufeedme.fragments.countrydata;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.CountryData;



public class DiversityFragment extends AbsCountryDataFragment
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountryDetailActivity";

    static private View view;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
        if (view == null)
            {
            view= inflater.inflate(R.layout.fragment_country_data__diversity, container, false);
            assignGuiElements();
            }
        return view;
        }


    @Override
    public void onCountryDataRetrieved(CountryData result)
        {

        }



    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignGuiElements()
        {
        }


    }

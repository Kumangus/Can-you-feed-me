package net.roughdesign.canyoufeedme.viewhandlers;


import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import net.roughdesign.api.Country;
import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.ownserverapi.OwnServerDatabase;



/**
 * Created by Rough on 30/04/2015.
 * Handles the Spinner where countries can be selected.
 */
public class CountrySelectionSpinnerHandler {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountrySelectionSpinnerHandler";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private final OnCountrySelectedListener listener;
    private final Spinner manualSpinnerView;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    public CountrySelectionSpinnerHandler(OnCountrySelectedListener listener, Activity activity) {
        this.listener = listener;
        manualSpinnerView = (Spinner) activity.findViewById(R.id.world_map_manual_selector);
        ArrayAdapter<Country> arrayAdapter = new ArrayAdapter<>(activity,
                R.layout.world_map__list_item, R.id.world_map_list_item_text,
                OwnServerDatabase.get().getAll());
        manualSpinnerView.setAdapter(arrayAdapter);
        manualSpinnerView.setOnItemSelectedListener(new ManualSelectionListener());
        manualSpinnerView.setSelection(0);
    }
    // =============================================================================================
    // Class methods
    // =============================================================================================

    // =============================================================================================
    // Overridden methods
    // =============================================================================================


    // =============================================================================================
    // Member methods
    // =============================================================================================
    public void setCountry(Country country) {
        manualSpinnerView.setVisibility(View.VISIBLE);
        if (country != null) {
            for (int i = 0; i < manualSpinnerView.getAdapter().getCount(); i++) {
                Country countryBuffer = (Country) manualSpinnerView.getItemAtPosition(i);
                if (countryBuffer.getIsoCode().equals(country.getIsoCode())) {
                    manualSpinnerView.setSelection(i);
                }
            }
        }
    }


    // =============================================================================================
    // Inner Class: OnCountrySelectedListener
    // =============================================================================================
    public interface OnCountrySelectedListener {
        void onCountrySelected();
    }



    // =============================================================================================
    // Inner Class: ManualSelectionListener
    // =============================================================================================
    private class ManualSelectionListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            CanYouFeedMeApp.currentCountry = ((Country) parent.getItemAtPosition(pos));
            listener.onCountrySelected();
        }


        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }


    }
}

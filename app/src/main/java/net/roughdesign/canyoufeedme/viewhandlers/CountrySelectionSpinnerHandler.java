package net.roughdesign.canyoufeedme.viewhandlers;


import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.Country;



/**
 * Created by Rough on 30/04/2015.
 * Handles the Spinner where countries can be selected.
 */
public class CountrySelectionSpinnerHandler
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountrySelectionSpinnerHandler";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private OnCountrySelectedListener listener;
    private Activity activity;
    private Spinner manualSpinnerView;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    public CountrySelectionSpinnerHandler(OnCountrySelectedListener listener, Activity activity)
        {
        this.listener = listener;
        this.activity = activity;
        manualSpinnerView = (Spinner) activity.findViewById(R.id.world_map_manual_selector);
        ArrayAdapter<Country> arrayAdapter = new ArrayAdapter<>(activity,
                R.layout.world_map__list_item, R.id.world_map_list_item_text, Country.getAll());
        manualSpinnerView.setAdapter(arrayAdapter);
        manualSpinnerView.setOnItemSelectedListener(new ManualSelectionListener());
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
    public void setCountry(Country country)
        {
        manualSpinnerView.setVisibility(View.VISIBLE);
        if (country != null)
            {
            for (int i = 0; i < manualSpinnerView.getAdapter().getCount(); i++)
                {
                Country countryBuffer = (Country) manualSpinnerView.getItemAtPosition(i);
                if (countryBuffer.code.equals(country.code))
                    {
                    manualSpinnerView.setSelection(i);
                    }
                }
            }
        }


    // =============================================================================================
    // Inner Class: OnCountrySelectedListener
    // =============================================================================================
    public interface OnCountrySelectedListener
        {
        public void onCountrySelected();
        }



    // =============================================================================================
    // Inner Class: ManualSelectionListener
    // =============================================================================================
    private class ManualSelectionListener implements AdapterView.OnItemSelectedListener
        {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
            Country.current = ((Country) parent.getItemAtPosition(pos));
            listener.onCountrySelected();
            }


        @Override
        public void onNothingSelected(AdapterView<?> parent)
            {

            }


        }
    }

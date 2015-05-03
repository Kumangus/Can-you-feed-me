package net.roughdesign.canyoufeedme.activities;


import android.content.Intent;
import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.Country;
import net.roughdesign.canyoufeedme.viewhandlers.CountrySelectionSpinnerHandler;
import net.roughdesign.roughlib.Geography;



/**
 * Created by Rough on 11/04/2015.
 * The Activity for the world map screen.
 */
public class WorldMapActivity extends ActionBarActivity implements OnMapReadyCallback,
        CountrySelectionSpinnerHandler.OnCountrySelectedListener
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "WorldMapActivity";

    private SupportMapFragment worldMapFragment;
    // TODO cleanup private TextView automaticLabelView;
    private TextView manualSelectorHeadline;
    private CountrySelectionSpinnerHandler spinnerHandler;
    private Button toCountryDetailView;

    private GoogleMap googleMap;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_map);

        assignGuiElements();
        worldMapFragment.getMapAsync(this);
        }


    @Override
    public void onMapReady(GoogleMap googleMap)
        {
        Log.i(TAG, "GoogleMap is ready");
        this.googleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.getUiSettings().setAllGesturesEnabled(false);
        new CountrySearchAsyncTask().execute();
        }


    @Override
    public void onCountrySelected()
        {
        googleMap.animateCamera(Country.current.getCameraUpdate());
        }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignGuiElements()
        {
        worldMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.world_map_map);
        // TODO cleanup automaticLabelView = (TextView) findViewById(R.id.world_map_automatic_label);
        manualSelectorHeadline = (TextView) findViewById(R.id.world_map__manual_selector__headline);
        spinnerHandler = new CountrySelectionSpinnerHandler(this, this);
        setupToCountryDetailView();
        }


    private void setupToCountryDetailView()
        {
        toCountryDetailView = (Button) findViewById(R.id.world_map_to_country_detail);
        toCountryDetailView.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View view)
            {
            Intent intent = new Intent(WorldMapActivity.this, CountryDataActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.world_map__zoom__in, R.anim.world_map__zoom__out);
            }
        });
        }


    // =============================================================================================
    // Inner Class: CountrySearchAsyncTask
    // =============================================================================================
    private class CountrySearchAsyncTask extends AsyncTask<Integer, Integer, Country>
        {

        @Override
        protected Country doInBackground(Integer... params)
            {
            Address address = Geography.getAddress(WorldMapActivity.this);
            if (address == null)
                return null;
            return Country.getForCountryCode(address.getCountryCode());
            }


        @Override
        protected void onPostExecute(Country result)
            {
            Country.current = result;
            // TODO cleanup automaticLabelView.setText(R.string.world_map__cant_find_country);
            if (result != null)
                {
                // TODO cleanup automaticLabelView.setText(R.string.world_map__found_country);
                Toast toast = Toast.makeText(WorldMapActivity.this, R.string.world_map__found_country, Toast.LENGTH_LONG);
                toast.getView().setBackgroundResource(R.color.cyfm_background_dark);
                toast.show();
                }
            manualSelectorHeadline.setVisibility(View.VISIBLE);
            toCountryDetailView.setVisibility(View.VISIBLE);
            spinnerHandler.setCountry(result);
            }
        }


    }

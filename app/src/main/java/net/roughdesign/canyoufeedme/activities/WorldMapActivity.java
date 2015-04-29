package net.roughdesign.canyoufeedme.activities;

import android.content.Intent;
import android.location.Address;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.Country;
import net.roughdesign.roughlib.Geography;
import net.roughdesign.canyoufeedme.helper.GoogleMapsHelper;

/**
 * Created by Rough on 11/04/2015.
 * The Activity for the world map screen.
 */
public class WorldMapActivity extends ActionBarActivity implements View.OnClickListener, OnMapReadyCallback
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "WorldMapActivity";

    private SupportMapFragment worldMapFragment;
    private TextView automaticLabelView;
    private TextView manualSelectorHeadline;
    private Spinner manualSpinnerView;
    private Button toCountryDetailView;

    private GoogleMap googleMap;

    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_map);

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
    public void onClick(View v)
        {
        if (v == toCountryDetailView)
            {
            Intent intent = new Intent(WorldMapActivity.this, CountryOverviewActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.world_map__zoom__in, R.anim.world_map__zoom__out);
            }
        }

    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignGuiElements()
        {
        worldMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.world_map_map);
        automaticLabelView = (TextView) findViewById(R.id.world_map_automatic_label);
        manualSelectorHeadline = (TextView) findViewById(R.id.world_map__manual_selector__headline);
        setupManualSelectionSpinner();
        toCountryDetailView = (Button) findViewById(R.id.world_map_to_country_detail);
        toCountryDetailView.setOnClickListener(this);
        }

    private void setupManualSelectionSpinner()
        {
        manualSpinnerView = (Spinner) findViewById(R.id.world_map_manual_selector);
        ArrayAdapter<Country> arrayAdapter = new ArrayAdapter<>(this,
                R.layout.world_map__list_item, R.id.world_map_list_item_text, Country.objects.getAll());
        manualSpinnerView.setAdapter(arrayAdapter);
        manualSpinnerView.setOnItemSelectedListener(new ManualSelectionListener());
        }


    private void setCountry(Country country)
        {
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
            return Country.objects.getForCountryCode(address.getCountryCode());
            }


        @Override
        protected void onPostExecute(Country result)
            {
            CanYouFeedMeApp.country = result;
            automaticLabelView.setText(R.string.world_map_cant_find_country);
            if (result != null)
                {
                automaticLabelView.setText(R.string.world_map_found_country);
                }
            manualSelectorHeadline.setVisibility(View.VISIBLE);
            manualSpinnerView.setVisibility(View.VISIBLE);
            toCountryDetailView.setVisibility(View.VISIBLE);
            setCountry(result);
            }
        }


    // =============================================================================================
    // Inner Class: ManualSelectionListener
    // =============================================================================================
    private class ManualSelectionListener implements AdapterView.OnItemSelectedListener
        {

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
            {
            CanYouFeedMeApp.country = ((Country) parent.getItemAtPosition(pos));
            // TODO CLEANUP CanYouFeedMeApp.country = (Country) parent.getItemAtPosition(pos);
            CanYouFeedMeApp.cameraUpdate = GoogleMapsHelper.getCameraUpdate(WorldMapActivity.this, CanYouFeedMeApp.country.code);
            if (CanYouFeedMeApp.cameraUpdate != null)
                googleMap.animateCamera(CanYouFeedMeApp.cameraUpdate);
            }

        @Override
        public void onNothingSelected(AdapterView<?> parent)
            {

            }
        }

    }

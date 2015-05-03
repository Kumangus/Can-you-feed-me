package net.roughdesign.canyoufeedme.fragments.countrydata;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.Country;
import net.roughdesign.canyoufeedme.models.country.CountryData;



/**
 * Created by Rough on 11/04/2015.
 * The Activity for the country overview.
 */
public class MapFragment extends AbsCountryDataFragment implements OnMapReadyCallback
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "MapFragment";

    static private View view;

    private ImageView judgement;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
        if (view == null)
            {
            view = inflater.inflate(R.layout.fragment_country_data__map, container, false);

            judgement = (ImageView) view.findViewById(R.id.country_overview__judgement);
            SupportMapFragment worldMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.country_data__map__googlemap);
            worldMapFragment.getMapAsync(this);
            }

        return view;
        }


    @Override
    public void onMapReady(final GoogleMap googleMap)
        {
        Log.i(TAG, "GoogleMap is ready");
        setupGoogleMaps(googleMap);
        }


    @Override
    public void onCountryDataRetrieved(CountryData result)
        {
        if (result.foodBalance.getSurplusOrDeficitInKcalPerPersonPerDay() > 0)
            {
            judgement.setImageResource(R.drawable.icon_yes);
            }
        }

    // =============================================================================================
    // Methods
    // =============================================================================================


    /**
     * GoogleMaps is setup with a GoogleMap.OnCameraChangeListener() because calling the
     * googleMap.moveCamera() function lead to NullPointerExceptions previously.
     */
    private void setupGoogleMaps(final GoogleMap googleMap)
        {
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.getUiSettings().setAllGesturesEnabled(false);
        googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener()
        {
        @Override
        public void onCameraChange(CameraPosition arg0)
            {
            googleMap.moveCamera(Country.current.getCameraUpdate());
            googleMap.setOnCameraChangeListener(null);  // Remove listener to prevent position reset on camera move.
            }
        });
        }


    }

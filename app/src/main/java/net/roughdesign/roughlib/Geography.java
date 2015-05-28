package net.roughdesign.roughlib;

import android.content.Context;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import java.io.IOException;
import java.util.List;

/**
 * Created by Rough on 13/04/2015.
 * Convenience class for Android's location services.
 */
public class Geography
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "Geography";

    // =============================================================================================
    // Public methods
    // =============================================================================================


    /**
     * @return The last known Address according to the best LocationManager, or null
     */
    static public Address getAddress(Context context)
        {
        Location location = getLastKnownLocation(context);

        if (location == null)
            {
            return null;
            }
        return getAddress(context, location);
        }

    // =============================================================================================
    // Private methods
    // =============================================================================================
    /**
     * @return The last known Location of the device, or null
     */
    static private Location getLastKnownLocation(Context context)
        {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        String nameOfBestProvider = locationManager.getBestProvider(new Criteria(), true);
        if (nameOfBestProvider == null)
            {
            return null;
            }
        return locationManager.getLastKnownLocation(nameOfBestProvider);
        }

    /**
     * @return The best known Address for this Location, or null
     */
    static private Address getAddress(Context context, Location location)
        {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses = null;
        try
            {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);
            } catch (IOException e)
            {
            Log.i(TAG, "No addresses retrieved from Geocoder.");
            }
        if (addresses != null && addresses.size() > 0)
            {
            return addresses.get(0);
            }
        return null;
        }





    }

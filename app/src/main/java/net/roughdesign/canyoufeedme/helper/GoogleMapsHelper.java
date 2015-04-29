package net.roughdesign.canyoufeedme.helper;

import android.content.Context;
import android.location.Address;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Rough on 13/04/2015.
 * Some static methods to help with GoogleMaps.
 */
public class GoogleMapsHelper
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String PATH_COUNTRY_BORDERS = "csv/country_borders.csv";
    static private final String TAG = "GoogleMapsHelper";

    // =============================================================================================
    // Public methods
    // =============================================================================================

    /**
     * @return A CameraUpdate to show the current Country, or null
     */
    static public CameraUpdate getCameraUpdate(Context context, String countryCode)
        {
        LatLngBounds countryBox = GoogleMapsHelper.getBoundsForCountryCode(context, countryCode);
        if (countryBox == null)
            {
            return null;
            }
        return CameraUpdateFactory.newLatLngBounds(countryBox, 20);
        }


    static public CameraUpdate getCameraUpdate(Address address)
        {
        if (address == null)
            {
            return null;
            }
        LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
        return CameraUpdateFactory.newLatLngZoom(latLng, 4.0f);
        }


    /**
     * @return The best fitting CameraUpdate
     */
    static public CameraUpdate getBestCameraUpdate(Context context, Address address)
        {
        CameraUpdate result;
        result = getCameraUpdate(context, address.getCountryCode());
        if (result != null)
            {
            return result;
            }
        result = getCameraUpdate(address);
        if (result != null)
            {
            return result;
            }
        return CameraUpdateFactory.zoomBy(0.0f);
        }

    // =============================================================================================
    // Private methods
    // =============================================================================================
    static private LatLngBounds getBoundsForCountryCode(Context context, String countryCode)
        {
        try
            {
            InputStream inputStream = context.getAssets().open(PATH_COUNTRY_BORDERS);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReader(inputStreamReader);

            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null)
                {
                if (nextLine[2].equals(countryCode))
                    {
                    double south = Double.parseDouble(nextLine[5]);
                    double west = Double.parseDouble(nextLine[6]);
                    double north = Double.parseDouble(nextLine[7]);
                    double east = Double.parseDouble(nextLine[8]);
                    LatLng southwest = new LatLng(south, west);
                    LatLng northeast = new LatLng(north, east);
                    return new LatLngBounds(southwest, northeast);
                    }
                }
            } catch (IOException | NumberFormatException e)
            {
            Log.i(TAG, "Unable to get boundaries for country code '" + countryCode + "'");
            }
        return null;
        }

    }

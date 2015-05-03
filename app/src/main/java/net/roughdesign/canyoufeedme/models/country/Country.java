package net.roughdesign.canyoufeedme.models.country;


import android.content.Context;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import net.roughdesign.canyoufeedme.helper.CSVHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Rough on 30/04/2015.
 */
public class Country
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    static public Country current;

    static private List<Country> allCountries = new ArrayList<>();

    @SuppressWarnings("unused")
    static private final String TAG = "Country";
    static private final String CSV_PATH_COUNTRY_CODES = "csv/countries.csv";
    static private final String CSV_PATH_COUNTRY_BORDERS = "csv/country_borders.csv";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    public final String code;
    public final String name;
    public int year = 2010;
    public CountryData data;

    private final LatLngBounds latLngBounds;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    public Country(String code, String name, LatLngBounds latLngBounds)
        {
        this.code = code;
        this.name = name;
        this.latLngBounds = latLngBounds;
        }


    // =============================================================================================
    // Class methods
    // =============================================================================================


    /**
     * Reads the country codes and country borders.
     */
    static public void populateList(Context context) throws IOException
        {
        List<List<String>> countryCodeTable = CSVHelper.readFromDirectory(context, CSV_PATH_COUNTRY_CODES, true);
        List<List<String>> countryBorderTable = CSVHelper.readFromDirectory(context, CSV_PATH_COUNTRY_BORDERS, false);

        for (List<String> codeRow : countryCodeTable)
            {
            String countryCode = codeRow.get(1);
            String countryName = codeRow.get(0);
            LatLngBounds latLngBounds = null;

            for (List<String> borderRow : countryBorderTable)
                {
                if (borderRow.get(2).equals(countryCode))
                    {
                    double south = Double.parseDouble(borderRow.get(5));
                    double west = Double.parseDouble(borderRow.get(6));
                    double north = Double.parseDouble(borderRow.get(7));
                    double east = Double.parseDouble(borderRow.get(8));
                    LatLng southwest = new LatLng(south, west);
                    LatLng northeast = new LatLng(north, east);
                    latLngBounds = new LatLngBounds(southwest, northeast);
                    }
                }
            allCountries.add(new Country(countryCode, countryName, latLngBounds));
            }
        }


    static public List<Country> getAll()
        {
        return allCountries;
        }


    /**
     * @return The Country with the given country code, or null if none can be found
     */
    static public Country getForCountryCode(String countryCode)
        {
        for (Country country : allCountries)
            {
            if (country.code.equals(countryCode))
                {
                return country;
                }
            }
        return null;
        }


    // =============================================================================================
    // Overridden methods
    // =============================================================================================
    @Override
    public String toString()
        {
        return name;
        }


    // =============================================================================================
    // Member methods
    // =============================================================================================


    /**
     * @return The most accurate CameraUpdate possible with the existing information.
     */
    public CameraUpdate getCameraUpdate()
        {
        if (latLngBounds == null)
            {
            //LatLng southWest = new LatLng(-185, -360);
            //LatLng northEast = new LatLng(185, 360);
            //return CameraUpdateFactory.newLatLngBounds(new LatLngBounds(southWest, northEast), 100);
            //return CameraUpdateFactory.newLatLngZoom(new LatLng(0, 0), -50);  // Whole map view
            return CameraUpdateFactory.zoomBy(0);  // "Whole map view doesnt work
            }
        return CameraUpdateFactory.newLatLngBounds(latLngBounds, 20);

        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

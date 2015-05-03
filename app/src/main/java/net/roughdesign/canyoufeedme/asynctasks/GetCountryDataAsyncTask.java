package net.roughdesign.canyoufeedme.asynctasks;


import android.os.AsyncTask;

import net.roughdesign.canyoufeedme.models.country.Country;
import net.roughdesign.canyoufeedme.models.country.CountryData;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;



/**
 * Created by Rough on 02/05/2015.
 * The AsyncTask to retrieve statistical data for a country.
 */
public class GetCountryDataAsyncTask extends AsyncTask<Country, Integer, Country>
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "GetCountryDetailsAsyncTask";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private ArrayList<OnCountryDataRetrievedListener> listeners = new ArrayList<>();

    // =============================================================================================
    // Constructor
    // =============================================================================================

    // =============================================================================================
    // Class methods
    // =============================================================================================


    // =============================================================================================
    // Overridden methods
    // =============================================================================================
    @Override
    protected Country doInBackground(Country[] params)
        {
        try
            {
            Country country = params[0];
            country.data = null;
            country.data = CountryData.readFromWeb(Country.current.code, Country.current.year);
            return country;
            } catch (IOException | JSONException e)
            {
            e.printStackTrace();
            }
        return null;
        }


    @Override
    protected void onPostExecute(Country result)
        {
        for(OnCountryDataRetrievedListener listener : listeners)
            {
            listener.onCountryDataRetrieved(result.data);
            }
        }


    // =============================================================================================
    // Member methods
    // =============================================================================================
    public void addListener(OnCountryDataRetrievedListener listener)
        {
        listeners.add(listener);
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================
    public interface OnCountryDataRetrievedListener
        {
        void onCountryDataRetrieved(CountryData result);
        }

    }

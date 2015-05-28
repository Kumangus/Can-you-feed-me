package net.roughdesign.canyoufeedme.asynctasks;


import android.os.AsyncTask;

import net.roughdesign.canyoufeedme.models.country.Country;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



/**
 * Created by Rough on 02/05/2015.
 * The AsyncTask to retrieve the available years for a country.
 */
public class GetYearListAsyncTask extends AsyncTask<Country, Integer, List<String>>
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "GetCountryDetailsAsyncTask";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private OnYearListRetrievedListener listener;

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
    protected List<String> doInBackground(Country[] params)
        {
        try
            {
            final String[] YEARS = new String[]{"1990", "1991", "1992", "1993", "1994",
                    "1995", "1996", "1997", "1998", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
                    "2007", "2008", "2009", "2010"};

            ArrayList<String> result = new ArrayList<>();
            Collections.addAll(result, YEARS);
            return result;

            } catch (Exception e)
            {
            e.printStackTrace();
            }
        return null;
        }


    @Override
    protected void onPostExecute(List<String> result)
        {
        listener.onYearListRetrieved(result);
        }


    // =============================================================================================
    // Member methods
    // =============================================================================================


    /**
     * Sets the OnYearListRetrievedListener for this task.
     *
     * @return This GetYearListAsyncTask, for chaining methods.
     */
    public GetYearListAsyncTask setListener(OnYearListRetrievedListener listener)
        {
        this.listener = listener;
        return this;
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================
    public interface OnYearListRetrievedListener
        {
        void onYearListRetrieved(List<String> years);
        }

    }

package net.roughdesign.canyoufeedme.fragments;


import android.support.v4.app.Fragment;

import net.roughdesign.canyoufeedme.asynctasks.GetCountryDataAsyncTask;
import net.roughdesign.canyoufeedme.models.country.CountryData;



/**
 * Created by Rough on 03/05/2015.
 * Base class in order to use the three Fragments {@link AssessmentFragment},
 * {@link DiversityFragment} and {@link MapFragment} in a list.
 */
abstract public class AbsCountryDataFragment extends Fragment implements GetCountryDataAsyncTask.OnCountryDataRetrievedListener
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountryDataFragment";

    // =============================================================================================
    // Member variables
    // =============================================================================================

    // =============================================================================================
    // Constructor
    // =============================================================================================

    // =============================================================================================
    // Class methods
    // =============================================================================================

    // =============================================================================================
    // Overridden methods
    // =============================================================================================

    // =============================================================================================
    // Member methods
    // =============================================================================================
    abstract public void onCountryDataRetrieved(CountryData result);

    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

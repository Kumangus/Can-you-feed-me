package net.roughdesign.canyoufeedme;


import android.app.Application;
import android.content.Context;

/**
 * Created by Rough on 11/04/2015.
 */
public class CanYouFeedMeApp extends Application
    {

    // =============================================================================================
    // Constants
    // =============================================================================================
    static public final String INTENT_CODE__SELECTED_COUNTRY = "ic.selected_country";

    // =============================================================================================
    // Variables
    // =============================================================================================
    //public Country currentCountry;

    //static public int year = 2010;  // Standard set to 2013, but can be changed by the user.
    //static public OLDCountryData countryData = null;


    //static public OLDCountry country = null;
    //static public CameraUpdate cameraUpdate = null;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    public CanYouFeedMeApp()
        {

        }

    // =============================================================================================
    // Static methods
    // =============================================================================================
    static public CanYouFeedMeApp from(Context context)
        {

        return (CanYouFeedMeApp) context.getApplicationContext();
        }

    // =============================================================================================
    // Member methods
    // =============================================================================================
    public int[] getPrimaryColours()
        {
        int[] result = new int[6];
        result[0] = getResources().getColor(R.color.cyfm_indigo_light);
        result[1] = getResources().getColor(R.color.cyfm_yellow_light);
        result[2] = getResources().getColor(R.color.cyfm_green_light);
        result[3] = getResources().getColor(R.color.cyfm_red_light);
        result[4] = getResources().getColor(R.color.cyfm_blue_light);
        result[5] = getResources().getColor(R.color.cyfm_orange_light);
        return result;
        }

    }

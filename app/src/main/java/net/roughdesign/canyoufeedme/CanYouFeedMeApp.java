package net.roughdesign.canyoufeedme;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.maps.CameraUpdate;

import net.roughdesign.canyoufeedme.models.country.Country;
import net.roughdesign.canyoufeedme.models.countrydata.CountryData;

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
    static public Country country = null;
    static public CameraUpdate cameraUpdate = null;
    static public CountryData countryData = null;

    private int[] primaryColours = new int[6];

    // =============================================================================================
    // Constructor
    // =============================================================================================
    public CanYouFeedMeApp()
        {

        }

    // =============================================================================================
    // Static ethods
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

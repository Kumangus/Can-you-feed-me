package net.roughdesign.canyoufeedme;


import android.app.Application;
import android.content.Context;

import net.roughdesign.api.Country;



/**
 * Created by Rough on 11/04/2015.
 * The Application subclass to store global keys etc.
 */
public class CanYouFeedMeApp extends Application {

    // =============================================================================================
    // Constants
    // =============================================================================================

    // =============================================================================================
    // Variables
    // =============================================================================================

    static public Country currentCountry;
    static public int currentYear = 2000;


    // =============================================================================================
    // Constructor
    // =============================================================================================


    // =============================================================================================
    // Static methods
    // =============================================================================================
    static public CanYouFeedMeApp from(Context context) {

        return (CanYouFeedMeApp) context.getApplicationContext();
    }


    // =============================================================================================
    // Member methods
    // =============================================================================================
    public int[] getPrimaryColours() {
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

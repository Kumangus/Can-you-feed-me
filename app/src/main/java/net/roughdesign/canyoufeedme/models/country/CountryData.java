package net.roughdesign.canyoufeedme.models.country;


import net.roughdesign.canyoufeedme.models.foodbalance.FoodBalance;

import org.json.JSONException;

import java.io.IOException;



/**
 * Created by Rough on 30/04/2015.
 * All the available food data for a country.
 */
public class CountryData
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountryData";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    public final String[] availableYears;
    public final FoodBalance foodBalance;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    private CountryData(String[] availableYears, FoodBalance foodBalance)
        {
       this.availableYears = availableYears;
        this.foodBalance = foodBalance;
        }


    // =============================================================================================
    // Class methods
    // =============================================================================================


    /**
     * Reads all the values for a country from the web.
     *
     * @param countryCode A 2 letter ISO country code, e.g. "US", "CA" or "DE"
     * @param year        The year for which to retrieve the data.
     * @return A Countrydata object, populated with data from the web.
     */
    static public CountryData readFromWeb(String countryCode, int year) throws IOException, JSONException
        {
        FoodBalance foodBalance = FoodBalance.getFromWeb(countryCode, year);
        final String[] YEARS = new String[]{"1990", "1991", "1992", "1993", "1994",
                "1995", "1996", "1997", "1998", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
                "2007", "2008", "2009", "2010"};


        return new CountryData(YEARS, foodBalance);
        }


    // =============================================================================================
    // Overridden methods
    // =============================================================================================

    // =============================================================================================
    // Member methods
    // =============================================================================================


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

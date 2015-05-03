package net.roughdesign.canyoufeedme.models.country;

import net.roughdesign.canyoufeedme.models.foodbalance.FoodBalance;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Rough on 30/04/2015.
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
    public final int year;
    public final FoodBalance foodBalance;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    private CountryData(int year, FoodBalance foodBalance)
        {
        this.year = year;
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
        return new CountryData(year, foodBalance);
        }


    // =============================================================================================
    // Overridden methods
    // =============================================================================================

    // =============================================================================================
    // Member methods
    // =============================================================================================


    /**
     * arg
     *
     * @return The total amount of edible food rom animals and crops.
     */
    public double getKcalPerPersonPerDay()
        {
        return foodBalance.getEdibleFood().foodSupplyInKcalPerPersonPerDay;
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

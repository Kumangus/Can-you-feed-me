package net.roughdesign.canyoufeedme.models.countrydata;

import net.roughdesign.canyoufeedme.models.foodbalance.FoodBalance;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Rough on 12/04/2015.
 * A model to represent a country.
 */
public class CountryData
    {
    // =============================================================================================
    // Model fields
    // =============================================================================================
    public final String countryCode;
    public final int year;
    public final FoodBalance foodBalance;

    // public final Population population;
    // public final AnimalProduction animalProduction;
    // public final CropProduction cropProduction;
    // public final AnimalSupply animalSupply;
    // public final CropSupply cropSupply;
    // public final Trade trade;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    private CountryData(String countryCode, int year, FoodBalance foodBalance
                        // Population population, AnimalProduction animalProduction,
                        // CropProduction cropProduction, AnimalSupply animalSupply,
                        // CropSupply cropSupply, Trade trade
    )
        {
        this.countryCode = countryCode;
        this.year = year;
        this.foodBalance = foodBalance;
        // this.population = population;
        // this.animalProduction = animalProduction;
        // this.cropProduction = cropProduction;
        // this.animalSupply = animalSupply;
        // this.cropSupply = cropSupply;
        // this.trade = trade;
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
        FoodBalance foodBalance = FoodBalance.getFromWeb(countryCode,year);
        // Population population = Population.getFromWeb(countryCode,year);
        // AnimalProduction animalProduction = AnimalProduction.getFromWeb(countryCode, year);
        // CropProduction cropProduction = CropProduction.getFromWeb(countryCode, year);
        // AnimalSupply animalSupply = AnimalSupply.getFromWeb(countryCode, year);
        // CropSupply cropSupply = CropSupply.getFromWeb(countryCode, year);
        // Trade trade = Trade.getFromWeb(countryCode, year);
        // return new CountryData(countryCode, year, population, animalProduction, cropProduction, animalSupply, cropSupply, trade);
        return new CountryData(countryCode, year, foodBalance);
        }


    // =============================================================================================
    // Methods
    // =============================================================================================


    /**
     * arg
     * @return The total amount of edible food rom animals and crops.
     */
    public double getKcalPerPersonPerDay()
        {
        // double result = animalSupply.getTotalEdibleSupply().foodSupplyInKcalPerPersonPerDay;
        // result += cropSupply.getTotalEdibleSupply().foodSupplyInKcalPerPersonPerDay;
        // return result;
        return foodBalance.getEdibleFood().foodSupplyInKcalPerPersonPerDay;
        }

    }

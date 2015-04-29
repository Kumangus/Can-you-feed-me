package net.roughdesign.canyoufeedme.models.countrydata;

import net.roughdesign.canyoufeedme.models.population.Population;
import net.roughdesign.canyoufeedme.models.production.AnimalProduction;
import net.roughdesign.canyoufeedme.models.production.CropProduction;
import net.roughdesign.canyoufeedme.models.supply.AnimalSupply;
import net.roughdesign.canyoufeedme.models.supply.CropSupply;
import net.roughdesign.canyoufeedme.models.trade.Trade;

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
    public final Population population;
    public final AnimalProduction animalProduction;
    public final CropProduction cropProduction;
    public final AnimalSupply animalSupply;
    public final CropSupply cropSupply;
    public final Trade trade;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    private CountryData(String countryCode, int year, Population population, AnimalProduction animalProduction,
                        CropProduction cropProduction, AnimalSupply animalSupply, CropSupply cropSupply, Trade trade)
        {
        this.countryCode = countryCode;
        this.year = year;
        this.population = population;
        this.animalProduction = animalProduction;
        this.cropProduction = cropProduction;
        this.animalSupply = animalSupply;
        this.cropSupply = cropSupply;
        this.trade = trade;
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
        Population population = Population.getFromWeb(countryCode,year);
        AnimalProduction animalProduction = AnimalProduction.getFromWeb(countryCode, year);
        CropProduction cropProduction = CropProduction.getFromWeb(countryCode, year);
        AnimalSupply animalSupply = AnimalSupply.getFromWeb(countryCode, year);
        CropSupply cropSupply = CropSupply.getFromWeb(countryCode, year);
        Trade trade = Trade.getFromWeb(countryCode, year);
        return new CountryData(countryCode, year, population, animalProduction, cropProduction, animalSupply, cropSupply, trade);
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
        double result = animalSupply.getTotalEdibleSupply().foodSupplyInKcalPerPersonPerDay;
        result += cropSupply.getTotalEdibleSupply().foodSupplyInKcalPerPersonPerDay;
        return result;
        }

    }

package net.roughdesign.canyoufeedme.models.supply;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rough on 29/04/2015.
 */
public class FoodSupplyValueSet
    {

    // =============================================================================================
    // Measures, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/measures.xml?page=1&pageSize=50&fields=mnemonic%2Clabel%40en&sort=label%40en
    // =============================================================================================
    static private final String KEY_DISPLAY_NAME = "Item";
    static private final String KEY_FAT_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY = "m684";
    static private final String KEY_FOOD_SUPPLY_IN_CAL_PER_PERSON_PER_DAY = "m664";
    static private final String KEY_FOOD_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY = "m646";
    static private final String KEY_FOOD_SUPPLY_IN_KILO_PER_PERSON_PER_YEAR = "m645";
    static private final String KEY_FOOD_SUPPLY_IN_TONS_TOTAL = "m641";
    static private final String KEY_PROTEIN_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY = "m674";

    // =============================================================================================
    // MEMBER VARIABLES 
    // =============================================================================================
    public final String displayName;
    public final double fatSupplyInGramPerPersonPerDay;
    public final double foodSupplyInKcalPerPersonPerDay;
    public final double foodSupplyInGramPerPersonPerDay;
    public final double foodSupplyInKiloPerPersonPerYear;
    public final double foodSupplyInTonsTotal;
    public final double proteinSupplyInGramPerPersonPerDay;


    // =============================================================================================
    // CONSTRUCTOR 
    // =============================================================================================
    public FoodSupplyValueSet(final String displayName,
                              final double fatSupplyInGramPerPersonPerDay,
                              final double foodSupplyInKcalPerPersonPerDay,
                              final double foodSupplyInGramPerPersonPerDay,
                              final double foodSupplyInKiloPerPersonPerYear,
                              final double foodSupplyInTonsTotal,
                              final double proteinSupplyInGramPerPersonPerDay)
        {
        this.displayName = displayName;
        this.fatSupplyInGramPerPersonPerDay = fatSupplyInGramPerPersonPerDay;
        this.foodSupplyInKcalPerPersonPerDay = foodSupplyInKcalPerPersonPerDay;
        this.foodSupplyInGramPerPersonPerDay = foodSupplyInGramPerPersonPerDay;
        this.foodSupplyInKiloPerPersonPerYear = foodSupplyInKiloPerPersonPerYear;
        this.foodSupplyInTonsTotal = foodSupplyInTonsTotal;
        this.proteinSupplyInGramPerPersonPerDay = proteinSupplyInGramPerPersonPerDay;
        }


    // =============================================================================================
    // Class methods
    // =============================================================================================
    static public FoodSupplyValueSet getFromJSONObject(final JSONObject entry) throws JSONException
        {
        return new FoodSupplyValueSet(
                entry.getString(KEY_DISPLAY_NAME),
                entry.optDouble(KEY_FAT_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY, 0),
                entry.optDouble(KEY_FOOD_SUPPLY_IN_CAL_PER_PERSON_PER_DAY, 0),
                entry.optDouble(KEY_FOOD_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY, 0),
                entry.optDouble(KEY_FOOD_SUPPLY_IN_KILO_PER_PERSON_PER_YEAR, 0),
                entry.optDouble(KEY_FOOD_SUPPLY_IN_TONS_TOTAL, 0),
                entry.optDouble(KEY_PROTEIN_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY, 0));
        }


    static public FoodSupplyValueSet combine(final FoodSupplyValueSet... toAdd)
        {
        double fatSupplyInGramPerPersonPerDay = 0;
        for (FoodSupplyValueSet entry : toAdd)
            fatSupplyInGramPerPersonPerDay += entry.fatSupplyInGramPerPersonPerDay;
        double foodSupplyInCalPerPersonPerDay = 0;
        for (FoodSupplyValueSet entry : toAdd)
            foodSupplyInCalPerPersonPerDay += entry.foodSupplyInKcalPerPersonPerDay;
        double foodSupplyInGramPerPersonPerDay = 0;
        for (FoodSupplyValueSet entry : toAdd)
            foodSupplyInGramPerPersonPerDay += entry.foodSupplyInGramPerPersonPerDay;
        double foodSupplyInKiloPerPersonPerYear = 0;
        for (FoodSupplyValueSet entry : toAdd)
            foodSupplyInKiloPerPersonPerYear += entry.foodSupplyInKiloPerPersonPerYear;
        double foodSupplyInTonsTotal = 0;
        for (FoodSupplyValueSet entry : toAdd)
            foodSupplyInTonsTotal += entry.foodSupplyInTonsTotal;
        double proteinSupplyInGramPerPersonPerDay = 0;
        for (FoodSupplyValueSet entry : toAdd)
            proteinSupplyInGramPerPersonPerDay += entry.proteinSupplyInGramPerPersonPerDay;

        return new FoodSupplyValueSet(
                "COMBINED",
                fatSupplyInGramPerPersonPerDay,
                foodSupplyInCalPerPersonPerDay,
                foodSupplyInGramPerPersonPerDay,
                foodSupplyInKiloPerPersonPerYear,
                foodSupplyInTonsTotal,
                proteinSupplyInGramPerPersonPerDay);
        }


    // =============================================================================================
    // Member methods
    // =============================================================================================


    }

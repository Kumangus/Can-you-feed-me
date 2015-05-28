package net.roughdesign.canyoufeedme.models.foodbalance;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rough on 29/04/2015.
 * Contains all the different measures for an item in a food balance sheet from FAO.
 */
public class FoodBalanceValueSet
    {
    // =============================================================================================
    // DB keys, see: http://data.fao.org/developers/api/v1/en/resources/faostat/fbs/measures.xml?page=1&pageSize=50&fields=mnemonic%2Clabel%40en&sort=label%40en
    // =============================================================================================
    static private final String KEY_DISPLAY_NAME = "Item";
    static private final String KEY_DOMESTIC_SUPPLY_QUANTITY___1000_T = "m5301";
    static private final String KEY_EXPORT_QUANTITY___1000_T = "m5911";
    static private final String KEY_FAT_SUPPLY_QUANTITY___G_PER_CAPITA_PER_DAY = "m684";
    static private final String KEY_FEED___1000_T = "m5521";
    static private final String KEY_FOOD___1000_T = "m5142";
    static private final String KEY_FOOD_SUPPLY___KCAL_PER_CAPITA_PER_DAY = "m664";
    static private final String KEY_FOOD_SUPPLY_QUANTITY___KG_PER_CAPITA_PER_YEAR = "m645";
    static private final String KEY_IMPORT_QUANTITY___1000_T = "m5611";
    static private final String KEY_OTHER_UTIL___1000_T_UPDATED = "m5154";
    static private final String KEY_PROCESSED___1000_T = "m5131";
    static private final String KEY_PRODUCTION_QUANTITY___1000_T = "m5511";
    static private final String KEY_PROTEIN_SUPPLY_QUANTITY___G_PER_CAPITA_PER_DAY = "m674";
    static private final String KEY_SEED___1000_T = "m5527";
    static private final String KEY_STOCK_VARIATION___1000_T = "m5072";
    static private final String KEY_TOTAL_POPULATION___BOTH_SEXES___1000 = "m511";
    static private final String KEY_WASTE___1000_TONNES = "m5123";


    // =============================================================================================
    // Class variables
    // =============================================================================================


    @SuppressWarnings("unused")
    static private final String TAG = "FoodBalanceValueSet";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    @SuppressWarnings("unused")
    private final String displayName;
    private final double domesticSupplyInThousandTons;
    private final double exportInThousandTons;
    private final double fatSupplyInGramPerPersonPerDay;
    private final double feedInThousandTons;
    private final double foodInThousandTons;
    private final double foodSupplyInKcalPerPersonPerDay;
    private final double foodSupplyInKgPerPersonPerYear;
    private final double importInThousandTons;
    private final double otherUtilInThousandTonsUpdated;
    private final double processedInThousandTons;
    private final double productionInThousandTons;
    private final double proteinSupplyInGramPerPersonPerDay;
    private final double seedInThousandTonsUpdated;
    private final double stockVariationInThousandTons;
    private final double totalPopulationInThousand;
    private final double wasteInThousandTons;


    // =============================================================================================
    // Constructor
    // =============================================================================================
    private FoodBalanceValueSet(
            final String displayName,
            double domesticSupplyInThousandTons,
            double exportInThousandTons,
            double fatSupplyInGramPerPersonPerDay,
            double feedInThousandTons,
            double foodInThousandTons,
            double foodSupplyInKcalPerPersonPerDay,
            double foodSupplyInKgPerPersonPerYear,
            double importInThousandTons,
            double otherUtilInThousandTonsUpdated,
            double processedInThousandTons,
            double productionInThousandTons,
            double proteinSupplyInGramPerPersonPerDay,
            double seedInThousandTonsUpdated,
            double stockVariationInThousandTons,
            double totalPopulationInThousand,
            double wasteInThousandTons)
        {
        this.displayName = displayName;
        this.domesticSupplyInThousandTons = domesticSupplyInThousandTons;
        this.exportInThousandTons = exportInThousandTons;
        this.fatSupplyInGramPerPersonPerDay = fatSupplyInGramPerPersonPerDay;
        this.feedInThousandTons = feedInThousandTons;
        this.foodInThousandTons = foodInThousandTons;
        this.foodSupplyInKcalPerPersonPerDay = foodSupplyInKcalPerPersonPerDay;
        this.foodSupplyInKgPerPersonPerYear = foodSupplyInKgPerPersonPerYear;
        this.importInThousandTons = importInThousandTons;
        this.otherUtilInThousandTonsUpdated = otherUtilInThousandTonsUpdated;
        this.processedInThousandTons = processedInThousandTons;
        this.productionInThousandTons = productionInThousandTons;
        this.proteinSupplyInGramPerPersonPerDay = proteinSupplyInGramPerPersonPerDay;
        this.seedInThousandTonsUpdated = seedInThousandTonsUpdated;
        this.stockVariationInThousandTons = stockVariationInThousandTons;
        this.totalPopulationInThousand = totalPopulationInThousand;
        this.wasteInThousandTons = wasteInThousandTons;
        }


    // =============================================================================================
    // Class methods
    // =============================================================================================
    static public FoodBalanceValueSet getFromJSONObject(final JSONObject entry) throws JSONException
        {
        return new FoodBalanceValueSet(
                entry.getString(KEY_DISPLAY_NAME),
                entry.optDouble(KEY_DOMESTIC_SUPPLY_QUANTITY___1000_T, 0),
                entry.optDouble(KEY_EXPORT_QUANTITY___1000_T, 0),
                entry.optDouble(KEY_FAT_SUPPLY_QUANTITY___G_PER_CAPITA_PER_DAY, 0),
                entry.optDouble(KEY_FEED___1000_T, 0),
                entry.optDouble(KEY_FOOD___1000_T, 0),
                entry.optDouble(KEY_FOOD_SUPPLY___KCAL_PER_CAPITA_PER_DAY, 0),
                entry.optDouble(KEY_FOOD_SUPPLY_QUANTITY___KG_PER_CAPITA_PER_YEAR, 0),
                entry.optDouble(KEY_IMPORT_QUANTITY___1000_T, 0),
                entry.optDouble(KEY_OTHER_UTIL___1000_T_UPDATED, 0),
                entry.optDouble(KEY_PROCESSED___1000_T, 0),
                entry.optDouble(KEY_PRODUCTION_QUANTITY___1000_T, 0),
                entry.optDouble(KEY_PROTEIN_SUPPLY_QUANTITY___G_PER_CAPITA_PER_DAY, 0),
                entry.optDouble(KEY_SEED___1000_T, 0),
                entry.optDouble(KEY_STOCK_VARIATION___1000_T, 0),
                entry.optDouble(KEY_TOTAL_POPULATION___BOTH_SEXES___1000, 0),
                entry.optDouble(KEY_WASTE___1000_TONNES, 0));
        }


    static public FoodBalanceValueSet getEmptyValueSet()
        {
        return new FoodBalanceValueSet("EMPTY", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        }


    // =============================================================================================
    // Overridden methods
    // =============================================================================================


    // =============================================================================================
    // Member methods
    // =============================================================================================
    public FoodBalanceValueSet add(FoodBalanceValueSet other)
        {
        return new FoodBalanceValueSet(
                "ADDED",
                domesticSupplyInThousandTons + other.domesticSupplyInThousandTons,
                exportInThousandTons + other.exportInThousandTons,
                fatSupplyInGramPerPersonPerDay + other.fatSupplyInGramPerPersonPerDay,
                feedInThousandTons + other.feedInThousandTons,
                foodInThousandTons + other.foodInThousandTons,
                foodSupplyInKcalPerPersonPerDay + other.foodSupplyInKcalPerPersonPerDay,
                foodSupplyInKgPerPersonPerYear + other.foodSupplyInKgPerPersonPerYear,
                importInThousandTons + other.importInThousandTons,
                otherUtilInThousandTonsUpdated + other.otherUtilInThousandTonsUpdated,
                processedInThousandTons + other.processedInThousandTons,
                productionInThousandTons + other.productionInThousandTons,
                proteinSupplyInGramPerPersonPerDay + other.proteinSupplyInGramPerPersonPerDay,
                seedInThousandTonsUpdated + other.seedInThousandTonsUpdated,
                stockVariationInThousandTons + other.stockVariationInThousandTons,
                totalPopulationInThousand + other.totalPopulationInThousand,
                wasteInThousandTons + other.wasteInThousandTons
        );
        }

    public double getFoodSupplyInKcalPerPersonPerDay()
        {
        return foodSupplyInKcalPerPersonPerDay;
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

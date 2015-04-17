package net.roughdesign.canyoufeedme.models.countrydata;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rough on 16/04/2015.
 * Data for one type of food.
 */
public class FoodData
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    private String key;
    private long productionInTons;
    private long importInTons;
    private long exportInTons;
    private long availableInTons;
    private long availablePerPersonPerDay;

    // =============================================================================================
    // Constructor
    // =============================================================================================
    public FoodData(String key, JSONObject jsonObject) throws JSONException
        {
        this.key = key;
        this.productionInTons = jsonObject.getLong("prod" + key + "T");
        this.importInTons = jsonObject.getLong("import" + key + "T");
        this.exportInTons = jsonObject.getLong("export" + key + "T");
        this.availableInTons = jsonObject.getLong("food" + key + "T");
        this.availablePerPersonPerDay = jsonObject.getLong("food" + key + "PPD");
        }

    // =============================================================================================
    // Getters
    // =============================================================================================
    public long getProductionInTons()
        {
        return productionInTons;
        }

    public long getImportInTons()
        {
        return importInTons;
        }

    public long getExportInTons()
        {
        return exportInTons;
        }

    public long getAvailableInTons()
        {
        return availableInTons;
        }

    public long getAvailablePerPersonPerDay()
        {
        return availablePerPersonPerDay;
        }

    // =============================================================================================
    // Constructor
    // =============================================================================================

    }

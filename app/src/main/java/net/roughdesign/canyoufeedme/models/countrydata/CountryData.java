package net.roughdesign.canyoufeedme.models.countrydata;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Rough on 12/04/2015.
 * A model to represent a country.
 */
public class CountryData
    {
    // =============================================================================================
    // Model fields
    // =============================================================================================
    public long country;
    public long year;
    public long population;
    public long caloryConsumption;

    public final FoodData fish;
    public final FoodData animals;
    public final FoodData animalByProduce;
    public final FoodData cereals;
    public final FoodData produce;
    public final FoodData nonEssentials;

    private ArrayList<FoodData> foodDataList = new ArrayList<>();


    // =============================================================================================
    // Constructor
    // =============================================================================================
    public CountryData(String json) throws JSONException
        {
        JSONObject jsonObjectAll = new JSONObject(json);
        JSONObject jsonObject = jsonObjectAll.getJSONObject("body");
        this.country = jsonObject.getLong("country");
        this.year = jsonObject.getLong("year");
        this.population = jsonObject.getLong("population");
        this.caloryConsumption = jsonObject.getLong("caloryConsumption");


        foodDataList.add(fish = new FoodData("Fish", jsonObject));
        foodDataList.add(animals = new FoodData("Meat", jsonObject));
        foodDataList.add(animalByProduce = new FoodData("Aniby", jsonObject));
        foodDataList.add(cereals = new FoodData("Cereal", jsonObject));
        foodDataList.add(produce = new FoodData("Produce", jsonObject));
        foodDataList.add(nonEssentials = new FoodData("Ne", jsonObject));

        }

    // =============================================================================================
    // Getters
    // =============================================================================================
    public ArrayList<FoodData> getFoodDataList()
        {
        return foodDataList;
        }


    /**
     * @return The total amount of food produced by the country itself
     */
    public long getTotalProductionInTons()
        {
        long result = 0;
        for (FoodData foodData : foodDataList)
            {
            result += foodData.getProductionInTons();
            }
        return result;
        }


    /**
     * @return The total amount of food imported by the country
     */
    public long getTotalImportInTons()
        {
        long result = 0;
        for (FoodData foodData : foodDataList)
            {
            result += foodData.getImportInTons();
            }
        return result;
        }


    /**
     * @return The total amount of food exported by the country
     */
    public long getTotalExportInTons()
        {
        long result = 0;
        for (FoodData foodData : foodDataList)
            {
            result += foodData.getExportInTons();
            }
        return result;
        }


    /**
     * @return The total amount of food available after trade
     * TODO is this alright?
     */
    public long getTotalFoodInTons()
        {
        long result = 0;
        for (FoodData foodData : foodDataList)
            {
            result += foodData.getAvailableInTons();
            }
        return result;
        }


    /**
     * @return The amount of calories received per person per day
     */
    public long getTotalFoodPerPersonPerDay()
        {
        long result = 0;
        for (FoodData foodData : foodDataList)
            {
            result += foodData.getAvailablePerPersonPerDay();
            }
        return result;
        }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private long getHighestValue()
        {
        long result = getTotalProductionInTons();
        if (getTotalImportInTons() > result)
            {
            result = getTotalImportInTons();
            }
        if (getTotalExportInTons() > result)
            {
            result = getTotalExportInTons();
            }
        if (getTotalImportInTons() > result)
            {
            result = getTotalImportInTons();
            }
        if (getTotalImportInTons() > result)
            {
            result = getTotalImportInTons();
            }
        if (getTotalImportInTons() > result)
            {
            result = getTotalImportInTons();
            }
        if (getTotalImportInTons() > result)
            {
            result = getTotalImportInTons();
            }
        return result;
        }

    /**
     * @return The total amount of food produced by the country itself
     */
    public long getTotalFoodAvailableInTons()
        {
        return getTotalProductionInTons() + getTotalImportInTons() - getTotalExportInTons();
        }


    /**
     * @return The total amount of food produced by the country itself
     */
    public long getTotalFoodConsumedInTons()
        {
        return getTotalProductionInTons() + getTotalImportInTons() - getTotalExportInTons();
        }


    public long getEndResultValue()
        {
        return getTotalFoodAvailableInTons() - getTotalFoodInTons();
        }

    }

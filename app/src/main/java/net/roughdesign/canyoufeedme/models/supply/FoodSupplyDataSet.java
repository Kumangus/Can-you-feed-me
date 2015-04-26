/**
 *
 */
package net.roughdesign.canyoufeedme.models.supply;

import net.roughdesign.canyoufeedme.models.DataSet;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rough
 *
 */
public class FoodSupplyDataSet extends DataSet
    {
    // ================================================
    // CLASS VARIABLES ================================
    // ================================================

    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================
    protected final HashMap<Integer, FoodSupplyValueSet> entries = new HashMap<Integer, FoodSupplyValueSet>();


    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================

    // ================================================
    // OVERRIDES ======================================
    // ================================================

    // ================================================
    // CLASS METHODS ==================================
    // ================================================

    // ================================================
    // MEMBER METHODS =================================
    // ================================================

    // ================================================
    // GETTERS & SETTERS ==============================
    // ================================================
    public FoodSupplyValueSet getFoodSupplyValueSet(final int key)
	{
	return entries.get(key);
	}


    public double getTotalFatSupplyInGramPerPersonPerDay()
	{
	double result = 0;
	for (final FoodSupplyValueSet valueSet : entries.values())
	    {
	    result += valueSet.fatSupplyInGramPerPersonPerDay;
	    }
	return result;
	}


    public double getTotalFoodSupplyInCalPerPersonPerDay()
	{
	double result = 0;
	for (final FoodSupplyValueSet valueSet : entries.values())
	    {
	    result += valueSet.foodSupplyInCalPerPersonPerDay;
	    }
	return result;
	}


    public double getTotalFoodSupplyInGramPerPersonPerDay()
	{
	double result = 0;
	for (final FoodSupplyValueSet valueSet : entries.values())
	    {
	    result += valueSet.foodSupplyInGramPerPersonPerDay;
	    }
	return result;
	}


    public double getTotalFoodSupplyInKiloPerPersonPerYear()
	{
	double result = 0;
	for (final FoodSupplyValueSet valueSet : entries.values())
	    {
	    result += valueSet.foodSupplyInKiloPerPersonPerYear;
	    }
	return result;
	}


    public double getTotalFoodSupplyInTons()
	{
	double result = 0;
	for (final FoodSupplyValueSet valueSet : entries.values())
	    {
	    result += valueSet.foodSupplyInTonsTotal;
	    }
	return result;
	}


    public double getTotalProteinSupplyInGramPerPersonPerDay()
	{
	double result = 0;
	for (final FoodSupplyValueSet valueSet : entries.values())
	    {
	    result += valueSet.proteinSupplyInGramPerPersonPerDay;
	    }
	return result;
	}


    @Override
    public String toString()
	{
	final StringBuilder stringBuilder = new StringBuilder();
	for (final Map.Entry<Integer, FoodSupplyValueSet> entry : entries
		.entrySet())
	    {
	    stringBuilder.append(entry.getValue().displayName);
	    stringBuilder.append("\n");
	    stringBuilder
		    .append(entry.getValue().fatSupplyInGramPerPersonPerDay);
	    stringBuilder.append("\n");
	    stringBuilder
		    .append(entry.getValue().foodSupplyInGramPerPersonPerDay);
	    stringBuilder.append("\n");
	    stringBuilder.append(entry.getValue().foodSupplyInTonsTotal);
	    stringBuilder.append("\n");
	    }
	return stringBuilder.toString();
	}


    // ================================================
    // INNER CLASSES ==================================
    // ================================================
    public class FoodSupplyValueSet
	{
	// ================================================
	// Measures, see:
	// http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/measures.xml?page=1&pageSize=50&fields=mnemonic%2Clabel%40en&sort=label%40en
	// ================================================
	static private final String KEY_DISPLAY_NAME = "Item";
	static private final String KEY_FAT_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY = "m684";
	static private final String KEY_FOOD_SUPPLY_IN_CAL_PER_PERSON_PER_DAY = "m664";
	static private final String KEY_FOOD_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY = "m646";
	static private final String KEY_FOOD_SUPPLY_IN_KILO_PER_PERSON_PER_YEAR = "m645";
	static private final String KEY_FOOD_SUPPLY_IN_TONS_TOTAL = "m641";
	static private final String KEY_PROTEIN_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY = "m674";

	// ================================================
	// MEMBER VARIABLES ===============================
	// ================================================
	public final String displayName;
	public final double fatSupplyInGramPerPersonPerDay;
	public final double foodSupplyInCalPerPersonPerDay;
	public final double foodSupplyInGramPerPersonPerDay;
	public final double foodSupplyInKiloPerPersonPerYear;
	public final double foodSupplyInTonsTotal;
	public final double proteinSupplyInGramPerPersonPerDay;


	// ================================================
	// CONSTRUCTOR ====================================
	// ================================================
	public FoodSupplyValueSet(final JSONObject entry) throws JSONException
        {
	    displayName = entry.getString(KEY_DISPLAY_NAME);
	    fatSupplyInGramPerPersonPerDay = entry.optDouble(
		    KEY_FAT_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY, 0);
	    foodSupplyInCalPerPersonPerDay = entry.optDouble(
		    KEY_FOOD_SUPPLY_IN_CAL_PER_PERSON_PER_DAY, 0);
	    foodSupplyInGramPerPersonPerDay = entry.optDouble(
		    KEY_FOOD_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY, 0);
	    foodSupplyInKiloPerPersonPerYear = entry.optDouble(
		    KEY_FOOD_SUPPLY_IN_KILO_PER_PERSON_PER_YEAR, 0);
	    foodSupplyInTonsTotal = entry.optDouble(
		    KEY_FOOD_SUPPLY_IN_TONS_TOTAL, 0);
	    proteinSupplyInGramPerPersonPerDay = entry.optDouble(
		    KEY_PROTEIN_SUPPLY_IN_GRAM_PER_PERSON_PER_DAY, 0);
	    }

	}

    }

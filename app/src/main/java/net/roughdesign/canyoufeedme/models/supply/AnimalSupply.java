/**
 *
 */
package net.roughdesign.canyoufeedme.models.supply;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;

/**
 * @author Rough
 *
 */
public class AnimalSupply extends FoodSupplyDataSet
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/item/members.xml?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================
    static public final int KEY_ANIMAL_FATS = 2946;
    static public final int KEY_ANIMAL_PRODUCTS = 2941;
    static public final int KEY_AQUATIC_ANIMALS_OTHERS = 2769;
    static public final int KEY_AQUATIC_PLANTS = 2775;
    static public final int KEY_AQUATIC_PRODUCTS_OTHER = 2961;
    static public final int KEY_BOVINE_MEAT = 2731;
    static public final int KEY_BUTTER_GHEE = 2740;
    static public final int KEY_CEPHALOPODS = 2766;
    static public final int KEY_CHEESE = 2741;
    static public final int KEY_CREAM = 2743;
    static public final int KEY_CRUSTACEANS = 2765;
    static public final int KEY_DEMERSAL_FISH = 2762;
    static public final int KEY_EGGS_1 = 2744;
    static public final int KEY_EGGS_2 = 2949;
    static public final int KEY_FATS_ANIMALS_RAW = 2737;
    static public final int KEY_FISH_MEAL = 2855;
    static public final int KEY_FISH_BODY_OIL = 2781;
    static public final int KEY_FISH_LIVER_OIL = 2782;
    static public final int KEY_FISH_SEAFOOD = 2960;
    static public final int KEY_FRESHWATER_FISH = 2761;
    static public final int KEY_GRAND_TOTAL = 2901;
    static public final int KEY_HIDES_AND_SKINS = 2748;
    static public final int KEY_HONEY = 2745;
    static public final int KEY_MARINE_FISH_OTHER = 2764;
    static public final int KEY_MEAT = 2943;
    static public final int KEY_MEAT_MEAL = 2749;
    static public final int KEY_MEAT_AQUATIC_MAMMALS = 2768;
    static public final int KEY_MEAT_OTHER = 2735;
    static public final int KEY_MILK_EXCLUDING_BUTTER_1 = 2848;
    static public final int KEY_MILK_EXCLUDING_BUTTER_2 = 2948;
    static public final int KEY_MILK_WHOLE = 2738;
    static public final int KEY_MOLLUSCS_OTHER = 2767;
    static public final int KEY_MUTTON_AND_GOAT_MEAT = 2732;
    static public final int KEY_OFFALS = 2945;
    static public final int KEY_OFFALS_EDIBLE = 2736;
    static public final int KEY_PELAGIC_FISH = 2763;
    static public final int KEY_PIGMEAT = 2733;
    static public final int KEY_POULTRY_MEAT = 2734;
    static public final int KEY_WHEY = 2742;

    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/facts.json?page=1&pageSize=200";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m684, m664, m646, m645, m641, m674";


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private AnimalSupply(final String jsonString) throws JSONException
        {
	final JSONObject jsonObject = new JSONObject(jsonString);
	final JSONObject result = jsonObject.getJSONObject("result");
	final JSONObject list = result.getJSONObject("list");
        // TODO fix this
        if(!result.has("items"))
            return;
	final JSONArray entryArray = list.getJSONArray("items");

	for (int i = 0; i < entryArray.length(); i++)
	    {
	    final JSONObject entry = entryArray.getJSONObject(i);
	    final FoodSupplyValueSet foodValueSet = new FoodSupplyValueSet(
		    entry);
	    entries.put(entry.getInt("item_code"), foodValueSet);
	    }
	}


    // ================================================
    // OVERRIDES ======================================
    // ================================================

    // ================================================
    // CLASS METHODS ==================================
    // ================================================
    static public AnimalSupply getFromWeb(final String countryCode,
	    final int year) throws IOException, JSONException
        {
	final String webAddress = constructUrl(countryCode, year);
	final String webContent = readWebAddress(webAddress);
	return new AnimalSupply(webContent);
	}


    static private String constructUrl(final String countryCode, final int year)
	{
	String result = LINK_BASE;
	final String filter = String.format(LINK_FILTER, countryCode, year);
	result += filter.replace(" ", "%20");
	result += LINK_FIELDS.replace(",", "%2C").replace(" ", "%20");

	return result;
	}


    // ================================================
    // MEMBER METHODS =================================
    // ================================================

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
    // GETTERS & SETTERS ==============================
    // ================================================

    // ================================================
    // INNER CLASSES ==================================
    // ================================================

    }

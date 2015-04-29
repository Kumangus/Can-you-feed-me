/**
 *
 */
package net.roughdesign.canyoufeedme.models.supply;

import net.roughdesign.canyoufeedme.models.DataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Rough
 */
public class AnimalSupply extends DataSet
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/item/members.xml?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================

    // ================================================
    // Keys: Meat
    // ================================================
    static public final int KEY_MEAT = 2943;  // Meat total
    static public final int KEY_BOVINE_MEAT = 2731;
    static public final int KEY_MEAT_MEAL = 2749;
    static public final int KEY_MEAT_AQUATIC_MAMMALS = 2768;
    static public final int KEY_MEAT_OTHER = 2735;
    static public final int KEY_PIGMEAT = 2733;
    static public final int KEY_POULTRY_MEAT = 2734;
    static public final int KEY_MUTTON_AND_GOAT_MEAT = 2732;
    static public final int KEY_OFFALS_EDIBLE = 2736;  // needs to be double checked
    static public final int KEY_OFFALS = 2945;

    // ================================================
    // Keys: Fish
    // ================================================
    static public final int KEY_FISH_SEAFOOD = 2960;  // Fish total
    static public final int KEY_AQUATIC_ANIMALS_OTHERS = 2769;
    static public final int KEY_AQUATIC_PLANTS = 2775;
    static public final int KEY_AQUATIC_PRODUCTS_OTHER = 2961;
    static public final int KEY_CEPHALOPODS = 2766;
    static public final int KEY_CRUSTACEANS = 2765;
    static public final int KEY_DEMERSAL_FISH = 2762;
    static public final int KEY_FISH_BODY_OIL = 2781;
    static public final int KEY_FISH_LIVER_OIL = 2782;
    static public final int KEY_FRESHWATER_FISH = 2761;
    static public final int KEY_MARINE_FISH_OTHER = 2764;
    static public final int KEY_MOLLUSCS_OTHER = 2767;
    static public final int KEY_PELAGIC_FISH = 2763;
    static public final int KEY_FISH_MEAL = 2855;


    // ================================================
    // Keys: Milk products
    // Doesn't add up. Example, USA 2005:
    //
    // Milk - Excluding Butter 76.895.000
    // Milk - Excluding Butter2 76.894.581
    // Milk, Whole 34.829.053
    // Butter, Ghee 633.412
    // Cheese 4.619.559
    // Cream 10.929
    // Whey 2.637.800
    // ================================================
    static public final int KEY_MILK_EXCLUDING_BUTTER_1 = 2848;  // approximate
    static public final int KEY_MILK_EXCLUDING_BUTTER_2 = 2948;  // exact
    static public final int KEY_MILK_WHOLE = 2738;
    static public final int KEY_BUTTER_GHEE = 2740;
    static public final int KEY_CHEESE = 2741;
    static public final int KEY_CREAM = 2743;
    static public final int KEY_WHEY = 2742;


    // ================================================
    // Keys: Edible byproducts
    // ================================================
    static public final int KEY_ANIMAL_FATS = 2946;
    static public final int KEY_ANIMAL_PRODUCTS = 2941;
    static public final int KEY_EGGS_1 = 2744;  // exact
    static public final int KEY_EGGS_2 = 2949;  // approximate
    static public final int KEY_FATS_ANIMALS_RAW = 2737;
    static public final int KEY_HONEY = 2745;

    // ================================================
    // Keys: the remaining keys
    // ================================================
    static public final int KEY_HIDES_AND_SKINS = 2748;
    static public final int KEY_GRAND_TOTAL = 2901;


    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/facts.json?page=1&pageSize=200";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m684, m664, m646, m645, m641, m674";


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================
    private final HashMap<Integer, FoodSupplyValueSet> entries = new HashMap<>();


    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private AnimalSupply(final String jsonString) throws JSONException
        {
        final JSONObject jsonObject = new JSONObject(jsonString);
        final JSONObject result = jsonObject.getJSONObject("result");
        final JSONObject list = result.getJSONObject("list");
        final JSONArray entryArray = list.getJSONArray("items");

        for (int i = 0; i < entryArray.length(); i++)
            {
            final JSONObject entry = entryArray.getJSONObject(i);
            final FoodSupplyValueSet foodValueSet = FoodSupplyValueSet.getFromJSONObject(entry);
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


    /**
     * @return Total supply of meat.
     */
    public FoodSupplyValueSet getMeatSupply()
        {
        return entries.get(KEY_MEAT);
        }


    /**
     * @return Total supply of seafood.
     */
    public FoodSupplyValueSet getSeafoodSupply()
        {
        return entries.get(KEY_FISH_SEAFOOD);
        }


    /**
     * @return Total supply of milk products.
     */
    public FoodSupplyValueSet getMilkProductsSupply()
        {
        return FoodSupplyValueSet.combine(
                entries.get(KEY_MILK_EXCLUDING_BUTTER_2),
                entries.get(KEY_MILK_WHOLE),
                entries.get(KEY_BUTTER_GHEE),
                entries.get(KEY_CHEESE),
                entries.get(KEY_CREAM),
                entries.get(KEY_FISH_SEAFOOD),
                entries.get(KEY_WHEY)
        );
        }


    /**
     * @return Total supply of seafood.
     */
    public FoodSupplyValueSet getEdibleByProducts()
        {
        return FoodSupplyValueSet.combine(
                entries.get(KEY_ANIMAL_FATS),
                entries.get(KEY_ANIMAL_PRODUCTS),
                entries.get(KEY_EGGS_1),
                entries.get(KEY_HONEY));
        }


    /**
     * @return Total supply of food.
     */
    public FoodSupplyValueSet getTotalEdibleSupply()
        {
        return FoodSupplyValueSet.combine(
                getMeatSupply(),
                getSeafoodSupply(),
                getMilkProductsSupply(),
                getEdibleByProducts());
        }


    // ================================================
    // GETTERS & SETTERS ==============================
    // ================================================

    // ================================================
    // INNER CLASSES ==================================
    // ================================================

    }

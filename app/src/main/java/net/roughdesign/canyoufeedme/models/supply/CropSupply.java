/**
 *
 */
package net.roughdesign.canyoufeedme.models.supply;

import android.util.Log;

import net.roughdesign.canyoufeedme.models.DataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Rough
 */
public class CropSupply extends DataSet
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-crop/item/members.json?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================

    // TODO the sums have to be tested

    // ================================================
    // Keys: Cereals
    // ================================================
    static public final int KEY_CEREALS___EXCLUDING_BEER = 2905;
    static public final int KEY_BARLEY = 2513;
    static public final int KEY_CEREALS__OTHER = 2520;
    static public final int KEY_MAIZE = 2514;
    static public final int KEY_MAIZE_GERM_OIL = 2582;
    static public final int KEY_MILLET = 2517;
    static public final int KEY_OATS = 2516;
    static public final int KEY_RYE = 2515;
    static public final int KEY_SESAMESEED = 2561;
    static public final int KEY_SESAMESEED_OIL = 2579;
    static public final int KEY_WHEAT = 2511;
    static public final int KEY_RICE___MILLED_EQUIVALENT = 2805;
    static public final int KEY_RICE___PADDY_EQUIVALENT = 2804;
    static public final int KEY_RICEBRAN_OIL = 2581;
    static public final int KEY_SUNFLOWERSEED = 2557;
    static public final int KEY_SUNFLOWERSEED_OIL = 2573;


    // ================================================
    // Keys: Fruit
    // ================================================
    static public final int KEY_FRUITS___EXCLUDING_WINE = 2919;
    static public final int KEY_APPLES = 2617;
    static public final int KEY_BANANAS = 2615;
    static public final int KEY_CITRUS__OTHER = 2614;
    static public final int KEY_DATES = 2619;
    static public final int KEY_FRUITS__OTHER = 2625;
    static public final int KEY_GRAPEFRUIT = 2613;
    static public final int KEY_GRAPES = 2620;
    static public final int KEY_LEMONS__LIMES = 2612;
    static public final int KEY_OLIVE_OIL = 2580;
    static public final int KEY_OLIVES = 2563;
    static public final int KEY_ORANGES__MANDARINES = 2611;
    static public final int KEY_PINEAPPLES = 2618;
    static public final int KEY_PLANTAINS = 2616;
    static public final int KEY_TOMATOES = 2601;


    // ================================================
    // Keys: Vegetables
    // ================================================
    static public final int KEY_VEGETABLES = 2918;
    static public final int KEY_BEANS = 2546;
    static public final int KEY_ONIONS = 2602;
    static public final int KEY_PEAS = 2547;
    static public final int KEY_POTATOES = 2531;
    static public final int KEY_PULSES = 2911;
    static public final int KEY_PULSES__OTHER = 2549;
    static public final int KEY_SOYABEAN_OIL = 2571;
    static public final int KEY_SOYABEANS = 2555;
    static public final int KEY_SWEET_POTATOES = 2533;
    static public final int KEY_VEGETABLE_OILS = 2914;
    static public final int KEY_VEGETABLES__OTHER = 2605;
    static public final int KEY_YAMS = 2535;


    // ================================================
    // Keys: Nuts
    // ================================================
    static public final int KEY_NUTS = 2551;
    static public final int KEY_COCONUT_OIL = 2578;
    static public final int KEY_COCONUTS___INCL_COPRA = 2560;
    static public final int KEY_GROUNDNUT_OIL = 2572;
    static public final int KEY_GROUNDNUTS___SHELLED_EQ = 2556;
    static public final int KEY_GROUNDNUTS___IN_SHELL_EQ = 2820;
    static public final int KEY_TREENUTS = 2912;


    // ================================================
    // Keys: Spices
    // ================================================
    static public final int KEY_SPICES = 2923;
    static public final int KEY_CLOVES = 2642;
    static public final int KEY_PEPPER = 2640;
    static public final int KEY_PIMENTO = 2641;
    static public final int KEY_SPICES__OTHER = 2645;

    // ================================================
    // Keys: Sugar, sweeteners
    // ================================================
    static public final int KEY_SUGAR_AND_SWEETENERS = 2909;
    static public final int KEY_SUGAR___RAW_EQUIVALENT = 2542;
    static public final int KEY_SUGAR_BEET = 2537;
    static public final int KEY_SUGAR_CANE = 2536;
    static public final int KEY_SUGAR__NON_CENTRIFUGAL = 2541;
    static public final int KEY_SUGAR__RAW_EQUIVALENT = 2827;
    static public final int KEY_SUGAR__REFINED_EQUIV = 2818;
    static public final int KEY_SUGARCROPS = 2908;
    static public final int KEY_SWEETENERS__OTHER = 2543;


    // ================================================
    // Keys: Beverages
    // ================================================
    static public final int KEY_ALCOHOLIC_BEVERAGES = 2924;
    static public final int KEY_BEER = 2656;
    static public final int KEY_BEVERAGES__ALCOHOLIC = 2658;
    static public final int KEY_BEVERAGES__FERMENTED = 2657;
    static public final int KEY_COFFEE = 2630;
    static public final int KEY_TEA = 2635;
    static public final int KEY_WINE = 2655;


    // ================================================
    // Keys: Other
    // ================================================
    static public final int KEY_CASSAVA = 2532;
    static public final int KEY_COCOA_BEANS = 2633;
    static public final int KEY_COTTONSEED_OIL = 2575;
    static public final int KEY_GRAND_TOTAL = 2901;
    static public final int KEY_MISCELLANEOUS = 2928;
    static public final int KEY_MOLASSES = 2544;
    static public final int KEY_OILCROPS = 2913;
    static public final int KEY_OILCROPS_OIL__OTHER = 2586;
    static public final int KEY_OILCROPS__OTHER = 2570;
    static public final int KEY_PALM_OIL = 2577;
    static public final int KEY_PALMKERNEL_OIL = 2576;
    static public final int KEY_RAPE_AND_MUSTARD_OIL = 2574;
    static public final int KEY_ROOTS_AND_TUBER_DRY_EQUIV = 2815;
    static public final int KEY_ROOTS__OTHER = 2534;
    static public final int KEY_SORGHUM = 2518;
    static public final int KEY_STARCHY_ROOTS = 2907;
    static public final int KEY_STIMULANTS = 2922;
    static public final int KEY_VEGETAL_PRODUCTS = 2903;

    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-crop/facts.json?page=1&pageSize=200";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m684, m664, m646, m645, m641, m674";


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================
    private final HashMap<Integer, FoodSupplyValueSet> entries = new HashMap<>();


    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private CropSupply(final String jsonString) throws JSONException
        {
        Log.e("CropSupply", jsonString);
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
    static public CropSupply getFromWeb(final String countryCode,
                                        final int year) throws IOException, JSONException
        {
        final String webAddress = constructUrl(countryCode, year);
        Log.e("CropSupply", webAddress);
        final String webContent = readWebAddress(webAddress);
        return new CropSupply(webContent);
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
     * @return Total supply of edible cereals.
     */
    public FoodSupplyValueSet getEdibleCereals()
        {
        return entries.get(KEY_CEREALS___EXCLUDING_BEER);
        }


    /**
     * @return Total supply of fruit.
     */
    public FoodSupplyValueSet getEdibleFruits()
        {
        return entries.get(KEY_FRUITS___EXCLUDING_WINE);
        }


    /**
     * @return Total supply of milk products.
     */
    public FoodSupplyValueSet getNuts()
        {
        return entries.get(KEY_NUTS);
        }


    /**
     * @return Total supply of seafood.
     */
    public FoodSupplyValueSet getVegetables()
        {
        return entries.get(KEY_VEGETABLES);
        }


    /**
     * @return Total supply of planty food.
     */
    public FoodSupplyValueSet getTotalEdibleSupply()
        {
        return FoodSupplyValueSet.combine(
                getEdibleCereals(),
                getEdibleFruits(),
                getNuts(),
                getVegetables());
        }


    // ================================================
    // GETTERS & SETTERS ==============================
    // ================================================

    // ================================================
    // INNER CLASSES ==================================
    // ================================================

    }

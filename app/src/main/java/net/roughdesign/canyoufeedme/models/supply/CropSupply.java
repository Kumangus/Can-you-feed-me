/**
 *
 */
package net.roughdesign.canyoufeedme.models.supply;

import android.util.Log;

import net.roughdesign.roughlib.Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author Rough
 */
public class CropSupply extends Web
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-crop/item/members.json?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================

    // TODO the sums have to be tested
    // TODO supply handled in FoodBalance now?

    // ================================================
    // Keys: Cereals
    // ================================================
    static private final int KEY_CEREALS___EXCLUDING_BEER = 2905;
    @SuppressWarnings("unused")
    static private final int KEY_BARLEY = 2513;
    @SuppressWarnings("unused")
    static private final int KEY_CEREALS__OTHER = 2520;
    @SuppressWarnings("unused")
    static private final int KEY_MAIZE = 2514;
    @SuppressWarnings("unused")
    static private final int KEY_MAIZE_GERM_OIL = 2582;
    @SuppressWarnings("unused")
    static private final int KEY_MILLET = 2517;
    @SuppressWarnings("unused")
    static private final int KEY_OATS = 2516;
    @SuppressWarnings("unused")
    static private final int KEY_RYE = 2515;
    @SuppressWarnings("unused")
    static private final int KEY_SESAMESEED = 2561;
    @SuppressWarnings("unused")
    static private final int KEY_SESAMESEED_OIL = 2579;
    @SuppressWarnings("unused")
    static private final int KEY_WHEAT = 2511;
    @SuppressWarnings("unused")
    static private final int KEY_RICE___MILLED_EQUIVALENT = 2805;
    @SuppressWarnings("unused")
    static private final int KEY_RICE___PADDY_EQUIVALENT = 2804;
    @SuppressWarnings("unused")
    static private final int KEY_RICEBRAN_OIL = 2581;
    @SuppressWarnings("unused")
    static private final int KEY_SUNFLOWERSEED = 2557;
    @SuppressWarnings("unused")
    static private final int KEY_SUNFLOWERSEED_OIL = 2573;


    // ================================================
    // Keys: Fruit
    // ================================================
    static private final int KEY_FRUITS___EXCLUDING_WINE = 2919;
    @SuppressWarnings("unused")
    static private final int KEY_APPLES = 2617;
    @SuppressWarnings("unused")
    static private final int KEY_BANANAS = 2615;
    @SuppressWarnings("unused")
    static private final int KEY_CITRUS__OTHER = 2614;
    @SuppressWarnings("unused")
    static private final int KEY_DATES = 2619;
    @SuppressWarnings("unused")
    static private final int KEY_FRUITS__OTHER = 2625;
    @SuppressWarnings("unused")
    static private final int KEY_GRAPEFRUIT = 2613;
    @SuppressWarnings("unused")
    static private final int KEY_GRAPES = 2620;
    @SuppressWarnings("unused")
    static private final int KEY_LEMONS__LIMES = 2612;
    @SuppressWarnings("unused")
    static private final int KEY_OLIVE_OIL = 2580;
    @SuppressWarnings("unused")
    static private final int KEY_OLIVES = 2563;
    @SuppressWarnings("unused")
    static private final int KEY_ORANGES__MANDARINES = 2611;
    @SuppressWarnings("unused")
    static private final int KEY_PINEAPPLES = 2618;
    @SuppressWarnings("unused")
    static private final int KEY_PLANTAINS = 2616;
    @SuppressWarnings("unused")
    static private final int KEY_TOMATOES = 2601;


    // ================================================
    // Keys: Vegetables
    // ================================================
    static private final int KEY_VEGETABLES = 2918;
    @SuppressWarnings("unused")
    static private final int KEY_BEANS = 2546;
    @SuppressWarnings("unused")
    static private final int KEY_ONIONS = 2602;
    @SuppressWarnings("unused")
    static private final int KEY_PEAS = 2547;
    @SuppressWarnings("unused")
    static private final int KEY_POTATOES = 2531;
    @SuppressWarnings("unused")
    static private final int KEY_PULSES = 2911;
    @SuppressWarnings("unused")
    static private final int KEY_PULSES__OTHER = 2549;
    @SuppressWarnings("unused")
    static private final int KEY_SOYABEAN_OIL = 2571;
    @SuppressWarnings("unused")
    static private final int KEY_SOYABEANS = 2555;
    @SuppressWarnings("unused")
    static private final int KEY_SWEET_POTATOES = 2533;
    @SuppressWarnings("unused")
    static private final int KEY_VEGETABLE_OILS = 2914;
    @SuppressWarnings("unused")
    static private final int KEY_VEGETABLES__OTHER = 2605;
    @SuppressWarnings("unused")
    static private final int KEY_YAMS = 2535;


    // ================================================
    // Keys: Nuts
    // ================================================
    static private final int KEY_NUTS = 2551;
    @SuppressWarnings("unused")
    static private final int KEY_COCONUT_OIL = 2578;
    @SuppressWarnings("unused")
    static private final int KEY_COCONUTS___INCL_COPRA = 2560;
    @SuppressWarnings("unused")
    static private final int KEY_GROUNDNUT_OIL = 2572;
    @SuppressWarnings("unused")
    static private final int KEY_GROUNDNUTS___SHELLED_EQ = 2556;
    @SuppressWarnings("unused")
    static private final int KEY_GROUNDNUTS___IN_SHELL_EQ = 2820;
    @SuppressWarnings("unused")
    static private final int KEY_TREENUTS = 2912;


    // ================================================
    // Keys: Spices
    // ================================================
    @SuppressWarnings("unused")
    static private final int KEY_SPICES = 2923;
    @SuppressWarnings("unused")
    static private final int KEY_CLOVES = 2642;
    @SuppressWarnings("unused")
    static private final int KEY_PEPPER = 2640;
    @SuppressWarnings("unused")
    static private final int KEY_PIMENTO = 2641;
    @SuppressWarnings("unused")
    static private final int KEY_SPICES__OTHER = 2645;

    // ================================================
    // Keys: Sugar, sweeteners
    // ================================================
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR_AND_SWEETENERS = 2909;
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR___RAW_EQUIVALENT = 2542;
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR_BEET = 2537;
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR_CANE = 2536;
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR__NON_CENTRIFUGAL = 2541;
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR__RAW_EQUIVALENT = 2827;
    @SuppressWarnings("unused")
    static private final int KEY_SUGAR__REFINED_EQUIV = 2818;
    @SuppressWarnings("unused")
    static private final int KEY_SUGARCROPS = 2908;
    @SuppressWarnings("unused")
    static private final int KEY_SWEETENERS__OTHER = 2543;


    // ================================================
    // Keys: Beverages
    // ================================================
    @SuppressWarnings("unused")
    static private final int KEY_ALCOHOLIC_BEVERAGES = 2924;
    @SuppressWarnings("unused")
    static private final int KEY_BEER = 2656;
    @SuppressWarnings("unused")
    static private final int KEY_BEVERAGES__ALCOHOLIC = 2658;
    @SuppressWarnings("unused")
    static private final int KEY_BEVERAGES__FERMENTED = 2657;
    @SuppressWarnings("unused")
    static private final int KEY_COFFEE = 2630;
    @SuppressWarnings("unused")
    static private final int KEY_TEA = 2635;
    @SuppressWarnings("unused")
    static private final int KEY_WINE = 2655;


    // ================================================
    // Keys: Other
    // ================================================
    @SuppressWarnings("unused")
    static private final int KEY_CASSAVA = 2532;
    @SuppressWarnings("unused")
    static private final int KEY_COCOA_BEANS = 2633;
    @SuppressWarnings("unused")
    static private final int KEY_COTTONSEED_OIL = 2575;
    @SuppressWarnings("unused")
    static private final int KEY_GRAND_TOTAL = 2901;
    @SuppressWarnings("unused")
    static private final int KEY_MISCELLANEOUS = 2928;
    @SuppressWarnings("unused")
    static private final int KEY_MOLASSES = 2544;
    @SuppressWarnings("unused")
    static private final int KEY_OILCROPS = 2913;
    @SuppressWarnings("unused")
    static private final int KEY_OILCROPS_OIL__OTHER = 2586;
    @SuppressWarnings("unused")
    static private final int KEY_OILCROPS__OTHER = 2570;
    @SuppressWarnings("unused")
    static private final int KEY_PALM_OIL = 2577;
    @SuppressWarnings("unused")
    static private final int KEY_PALMKERNEL_OIL = 2576;
    @SuppressWarnings("unused")
    static private final int KEY_RAPE_AND_MUSTARD_OIL = 2574;
    @SuppressWarnings("unused")
    static private final int KEY_ROOTS_AND_TUBER_DRY_EQUIV = 2815;
    @SuppressWarnings("unused")
    static private final int KEY_ROOTS__OTHER = 2534;
    @SuppressWarnings("unused")
    static private final int KEY_SORGHUM = 2518;
    @SuppressWarnings("unused")
    static private final int KEY_STARCHY_ROOTS = 2907;
    @SuppressWarnings("unused")
    static private final int KEY_STIMULANTS = 2922;
    @SuppressWarnings("unused")
    static private final int KEY_VEGETAL_PRODUCTS = 2903;

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
    private FoodSupplyValueSet getEdibleCereals()
        {
        return entries.get(KEY_CEREALS___EXCLUDING_BEER);
        }


    /**
     * @return Total supply of fruit.
     */
    private FoodSupplyValueSet getEdibleFruits()
        {
        return entries.get(KEY_FRUITS___EXCLUDING_WINE);
        }


    /**
     * @return Total supply of milk products.
     */
    private FoodSupplyValueSet getNuts()
        {
        return entries.get(KEY_NUTS);
        }


    /**
     * @return Total supply of seafood.
     */
    private FoodSupplyValueSet getVegetables()
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

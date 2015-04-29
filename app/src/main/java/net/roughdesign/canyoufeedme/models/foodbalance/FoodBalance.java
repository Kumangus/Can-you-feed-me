package net.roughdesign.canyoufeedme.models.foodbalance;

import net.roughdesign.roughlib.Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rough on 29/04/2015.
 * See: http://faostat3.fao.org/browse/FB/FBS/E
 */
public class FoodBalance
    {
    // =============================================================================================
    // Dataset members, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fbs/item/members.xml?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // =============================================================================================

    static public final int KEY_ALCOHOL__NON_FOOD = 2659;
    @SuppressWarnings("unused")
    static public final int KEY_APPLES = 2617;
    @SuppressWarnings("unused")
    static public final int KEY_AQUATIC_ANIMALS__OTHERS = 2769;
    @SuppressWarnings("unused")
    static public final int KEY_AQUATIC_PLANTS = 2775;
    @SuppressWarnings("unused")
    static public final int KEY_BANANAS = 2615;
    @SuppressWarnings("unused")
    static public final int KEY_BARLEY = 2513;
    @SuppressWarnings("unused")
    static public final int KEY_BEANS = 2546;
    static public final int KEY_BEER = 2656;
    static public final int KEY_BEVERAGES__ALCOHOLIC = 2658;
    static public final int KEY_BEVERAGES__FERMENTED = 2657;
    @SuppressWarnings("unused")
    static public final int KEY_BOVINE_MEAT = 2731;
    @SuppressWarnings("unused")
    static public final int KEY_BUTTER__GHEE = 2740;
    @SuppressWarnings("unused")
    static public final int KEY_CASSAVA = 2532;
    @SuppressWarnings("unused")
    static public final int KEY_CEPHALOPODS = 2766;
    @SuppressWarnings("unused")
    static public final int KEY_CEREALS__OTHER = 2520;
    @SuppressWarnings("unused")
    static public final int KEY_CITRUS__OTHER = 2614;
    @SuppressWarnings("unused")
    static public final int KEY_CLOVES = 2642;
    static public final int KEY_COCOA_BEANS = 2633;
    @SuppressWarnings("unused")
    static public final int KEY_COCONUT_OIL = 2578;
    @SuppressWarnings("unused")
    static public final int KEY_COCONUTS___INCL_COPRA = 2560;
    static public final int KEY_COFFEE = 2630;
    static public final int KEY_COTTONSEED = 2559;
    static public final int KEY_COTTONSEED_OIL = 2575;
    @SuppressWarnings("unused")
    static public final int KEY_CREAM = 2743;
    @SuppressWarnings("unused")
    static public final int KEY_CRUSTACEANS = 2765;
    @SuppressWarnings("unused")
    static public final int KEY_DATES = 2619;
    @SuppressWarnings("unused")
    static public final int KEY_DEMERSAL_FISH = 2762;
    @SuppressWarnings("unused")
    static public final int KEY_FATS__ANIMALS__RAW = 2737;
    static public final int KEY_FISH__BODY_OIL = 2781;
    static public final int KEY_FISH__LIVER_OIL = 2782;
    @SuppressWarnings("unused")
    static public final int KEY_FRESHWATER_FISH = 2761;
    @SuppressWarnings("unused")
    static public final int KEY_FRUITS__OTHER = 2625;
    @SuppressWarnings("unused")
    static public final int KEY_GRAPEFRUIT = 2613;
    @SuppressWarnings("unused")
    static public final int KEY_GRAPES = 2620;
    static public final int KEY_GROUNDNUT_OIL = 2572;
    @SuppressWarnings("unused")
    static public final int KEY_GROUNDNUTS___SHELLED_EQ = 2556;
    @SuppressWarnings("unused")
    static public final int KEY_HONEY = 2745;
    @SuppressWarnings("unused")
    static public final int KEY_LEMONS__LIMES = 2612;
    @SuppressWarnings("unused")
    static public final int KEY_MAIZE = 2514;
    @SuppressWarnings("unused")
    static public final int KEY_MAIZE_GERM_OIL = 2582;
    @SuppressWarnings("unused")
    static public final int KEY_MARINE_FISH__OTHER = 2764;
    @SuppressWarnings("unused")
    static public final int KEY_MEAT__AQUATIC_MAMMALS = 2768;
    @SuppressWarnings("unused")
    static public final int KEY_MEAT__OTHER = 2735;
    @SuppressWarnings("unused")
    static public final int KEY_MILLET = 2517;
    static public final int KEY_MISCELLANEOUS = 2928;
    @SuppressWarnings("unused")
    static public final int KEY_MOLLUSCS__OTHER = 2767;
    @SuppressWarnings("unused")
    static public final int KEY_MUTTON_AND_GOAT_MEAT = 2732;
    @SuppressWarnings("unused")
    static public final int KEY_OATS = 2516;
    static public final int KEY_OILCROPS_OIL__OTHER = 2586;
    static public final int KEY_OILCROPS__OTHER = 2570;
    @SuppressWarnings("unused")
    static public final int KEY_OLIVE_OIL = 2580;
    @SuppressWarnings("unused")
    static public final int KEY_OLIVES = 2563;
    @SuppressWarnings("unused")
    static public final int KEY_ONIONS = 2602;
    @SuppressWarnings("unused")
    static public final int KEY_ORANGES__MANDARINES = 2611;
    @SuppressWarnings("unused")
    static public final int KEY_PALM_OIL = 2577;
    static public final int KEY_PALMKERNEL_OIL = 2576;
    static public final int KEY_PALMKERNELS = 2562;
    @SuppressWarnings("unused")
    static public final int KEY_PEAS = 2547;
    @SuppressWarnings("unused")
    static public final int KEY_PELAGIC_FISH = 2763;
    static public final int KEY_PEPPER = 2640;
    @SuppressWarnings("unused")
    static public final int KEY_PIGMEAT = 2733;
    static public final int KEY_PIMENTO = 2641;
    @SuppressWarnings("unused")
    static public final int KEY_PINEAPPLES = 2618;
    @SuppressWarnings("unused")
    static public final int KEY_PLANTAINS = 2616;
    static public final int KEY_POPULATION = 2501;
    @SuppressWarnings("unused")
    static public final int KEY_POTATOES = 2531;
    @SuppressWarnings("unused")
    static public final int KEY_POULTRY_MEAT = 2734;
    @SuppressWarnings("unused")
    static public final int KEY_PULSES__OTHER = 2549;
    static public final int KEY_RAPE_AND_MUSTARD_OIL = 2574;
    static public final int KEY_RAPE_AND_MUSTARDSEED = 2558;
    @SuppressWarnings("unused")
    static public final int KEY_RICE___MILLED_EQUIVALENT = 2805;
    static public final int KEY_RICEBRAN_OIL = 2581;
    @SuppressWarnings("unused")
    static public final int KEY_ROOTS__OTHER = 2534;
    @SuppressWarnings("unused")
    static public final int KEY_RYE = 2515;
    @SuppressWarnings("unused")
    static public final int KEY_SESAMESEED = 2561;
    @SuppressWarnings("unused")
    static public final int KEY_SESAMESEED_OIL = 2579;
    static public final int KEY_SORGHUM = 2518;
    @SuppressWarnings("unused")
    static public final int KEY_SOYABEAN_OIL = 2571;
    @SuppressWarnings("unused")
    static public final int KEY_SOYABEANS = 2555;
    static public final int KEY_SPICES__OTHER = 2645;
    static public final int KEY_SUGAR___RAW_EQUIVALENT = 2542;
    static public final int KEY_SUGAR_BEET = 2537;
    static public final int KEY_SUGAR_CANE = 2536;
    static public final int KEY_SUGAR__NON_CENTRIFUGAL = 2541;
    @SuppressWarnings("unused")
    static public final int KEY_SUNFLOWERSEED = 2557;
    @SuppressWarnings("unused")
    static public final int KEY_SUNFLOWERSEED_OIL = 2573;
    @SuppressWarnings("unused")
    static public final int KEY_SWEET_POTATOES = 2533;
    static public final int KEY_SWEETENERS__OTHER = 2543;
    static public final int KEY_TEA = 2635;
    @SuppressWarnings("unused")
    static public final int KEY_TOMATOES = 2601;
    @SuppressWarnings("unused")
    static public final int KEY_VEGETABLES__OTHER = 2605;
    @SuppressWarnings("unused")
    static public final int KEY_WHEAT = 2511;
    static public final int KEY_WINE = 2655;
    @SuppressWarnings("unused")
    static public final int KEY_YAMS = 2535;


    // =============================================================================================
    // Class variables
    // =============================================================================================
    static public final int ADVISED_KCAL_PER_PERSON_PER_DAY = 2200;  // TODO check if correct
    static private final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/fbs/facts.json?page=1&pageSize=200";
    static private final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    static private final String LINK_FIELDS = "&fields=item, item.bk as item_code, m5301, m5911, m684, m5521, m5142, m664, m645, m5611, m5154, m5131, m5511, m674, m5527, m5072, m511, m5123";

    @SuppressWarnings("unused")
    static private final String TAG = "FoodBalance";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private final HashMap<Integer, FoodBalanceValueSet> entries = new HashMap<>();


    // =============================================================================================
    // Constructor
    // =============================================================================================
    private FoodBalance(final String jsonString) throws JSONException
        {
        final JSONObject jsonObject = new JSONObject(jsonString);
        final JSONObject result = jsonObject.getJSONObject("result");
        final JSONObject list = result.getJSONObject("list");
        final JSONArray entryArray = list.getJSONArray("items");

        for (int i = 0; i < entryArray.length(); i++)
            {
            final JSONObject entry = entryArray.getJSONObject(i);
            final FoodBalanceValueSet foodValueSet = FoodBalanceValueSet.getFromJSONObject(entry);
            entries.put(entry.getInt("item_code"), foodValueSet);
            }
        }


    // =============================================================================================
    // Class methods
    // =============================================================================================
    static private String constructUrl(final String countryCode, final int year)
        {
        String result = LINK_BASE;
        final String filter = String.format(LINK_FILTER, countryCode, year);
        result += filter.replace(" ", "%20");
        result += LINK_FIELDS.replace(",", "%2C").replace(" ", "%20");

        return result;
        }


    static public FoodBalance getFromWeb(final String countryCode,
                                         final int year) throws IOException, JSONException
        {
        final String webAddress = constructUrl(countryCode, year);
        final String webContent = Web.readWebAddress(webAddress);
        return new FoodBalance(webContent);
        }


    // =============================================================================================
    // Overridden methods
    // =============================================================================================


    // =============================================================================================
    // Member methods
    // =============================================================================================
    public FoodBalanceValueSet getEdibleFood()
        {
        FoodBalanceValueSet result = FoodBalanceValueSet.getEmptyValueSet();
        for (Map.Entry<Integer, FoodBalanceValueSet> entry : entries.entrySet())
            {
            // TODO check through this list of "non-foods"
            if (entry.getKey() != KEY_ALCOHOL__NON_FOOD &&
                    entry.getKey() != KEY_BEER &&
                    entry.getKey() != KEY_BEVERAGES__ALCOHOLIC &&
                    entry.getKey() != KEY_BEVERAGES__FERMENTED &&
                    entry.getKey() != KEY_COCOA_BEANS &&
                    entry.getKey() != KEY_COFFEE &&
                    entry.getKey() != KEY_COTTONSEED &&
                    entry.getKey() != KEY_COTTONSEED_OIL &&
                    entry.getKey() != KEY_FISH__BODY_OIL &&
                    entry.getKey() != KEY_FISH__LIVER_OIL &&
                    entry.getKey() != KEY_GROUNDNUT_OIL &&
                    entry.getKey() != KEY_MISCELLANEOUS &&
                    entry.getKey() != KEY_OILCROPS_OIL__OTHER &&
                    entry.getKey() != KEY_OILCROPS__OTHER &&
                    entry.getKey() != KEY_PALMKERNEL_OIL &&
                    entry.getKey() != KEY_PALMKERNELS &&
                    entry.getKey() != KEY_PEPPER &&
                    entry.getKey() != KEY_PIMENTO &&
                    entry.getKey() != KEY_POPULATION &&
                    entry.getKey() != KEY_RAPE_AND_MUSTARD_OIL &&
                    entry.getKey() != KEY_RAPE_AND_MUSTARDSEED &&
                    entry.getKey() != KEY_RICEBRAN_OIL &&
                    entry.getKey() != KEY_SORGHUM &&
                    entry.getKey() != KEY_SPICES__OTHER &&
                    entry.getKey() != KEY_SUGAR___RAW_EQUIVALENT &&
                    entry.getKey() != KEY_SUGAR_BEET &&
                    entry.getKey() != KEY_SUGAR_CANE &&
                    entry.getKey() != KEY_SUGAR__NON_CENTRIFUGAL &&
                    entry.getKey() != KEY_SWEETENERS__OTHER &&
                    entry.getKey() != KEY_TEA &&
                    entry.getKey() != KEY_WINE
                    )
                {
                result = result.add(entry.getValue());
                }
            }
        return result;
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

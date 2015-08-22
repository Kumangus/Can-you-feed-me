package net.roughdesign.ownserverapi;


import net.roughdesign.roughlib.Web;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;



/**
 * Created by Rough on 20/08/2015.
 */
public class OwnServerCountryData {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "OwnServerCountryData";


    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    static private final int RDA = 2250;

    static private final String URL = "http://canyoufeedme.com/cgi-bin/get_data.php/";

    static private final int ELEMENT_SUPPLY = 664;
    static private final int ELEMENT_PRODUCTION = 5511;
    static private final int ELEMENT_IMPORT = 5611;
    static private final int ELEMENT_EXPORT = 5911;
    static private final int ELEMENT_WASTE = 5123;

    static private final int ITEM_GRAND_TOTAL = 2901;
    static private final int ITEM_CEREALS = 2905;
    static private final int ITEM_ROOTS = 2907;
    static private final int ITEM_SUGAR_CROPS = 2908;
    static private final int ITEM_SWEETNERS = 2909;
    static private final int ITEM_PULSES = 2911;
    static private final int ITEM_TREENUTS = 2912;
    static private final int ITEM_OILCROPS = 2913;
    static private final int ITEM_VEGETABLE_OILS = 2914;
    static private final int ITEM_VEGETABLES = 2918;
    static private final int ITEM_FRUITS_NON_WINE = 2919;
    static private final int ITEM_ALCOHOLIC_BEVERAGES = 2924;
    static private final int ITEM_MEAT = 2943;
    static private final int ITEM_OFFALS = 2945;
    static private final int ITEM_ANIMAL_FAT = 2946;
    static private final int ITEM_MILK = 2948;
    static private final int ITEM_EGGS = 2949;
    static private final int ITEM_FISH = 2960;
    static private final int ITEM_AQUATIC_PRODUCTS = 2961;
    static private final int ITEM_SPICES = 2923;
    static private final int ITEM_STIMULANTS = 2922;
    static private final int ITEM_MISC = 2928;

    // ================================================
    // CATEGORIES =====================================
    // ================================================
    static public final List<Integer> CATEGORY_CEREALS =
            Arrays.asList(ITEM_CEREALS, ITEM_ROOTS, ITEM_SUGAR_CROPS, ITEM_PULSES, ITEM_TREENUTS);

    static public final List<Integer> CATEGORY_MEAT =
            Arrays.asList(ITEM_MEAT, ITEM_OFFALS);

    static public final List<Integer> CATEGORY_FISH =
            Arrays.asList(ITEM_FISH, ITEM_AQUATIC_PRODUCTS);

    static public final List<Integer> CATEGORY_ANIMAL_BYPRODUCTS =
            Arrays.asList(ITEM_ANIMAL_FAT, ITEM_MILK, ITEM_EGGS);

    static public final List<Integer> CATEGORY_PRODUCE =
            Arrays.asList(ITEM_OILCROPS, ITEM_VEGETABLE_OILS, ITEM_VEGETABLES, ITEM_FRUITS_NON_WINE);

    static public final List<Integer> CATEGORY_NON_ESSENTIALS =
            Arrays.asList(ITEM_SWEETNERS, ITEM_ALCOHOLIC_BEVERAGES, ITEM_SPICES, ITEM_STIMULANTS, ITEM_MISC);


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    public final HashMap<Integer, Long> supplyInKcal = new HashMap<>();
    public final HashMap<Integer, Long> productionInTons = new HashMap<>();
    public final HashMap<Integer, Long> importQuantityInTons = new HashMap<>();
    public final HashMap<Integer, Long> exportQuantityInTons = new HashMap<>();


    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================

    // ================================================
    // CLASS METHODS ==================================
    // ================================================


    static public OwnServerCountryData download(String faostatCode, int year) throws IOException, JSONException {
        OwnServerCountryData result = new OwnServerCountryData();

        String response = Web.getAsBrowser(URL + "?country=" + faostatCode + "&year=" + year);
        JSONArray responseAsJSON = new JSONArray(response);

        for (int i = 0; i < responseAsJSON.length(); i++) {
            JSONArray row = responseAsJSON.getJSONArray(i);
            int element = row.getInt(0);
            if (element == ELEMENT_PRODUCTION) {
                result.productionInTons.put(row.getInt(2), row.getLong(4));
            }
            else if (element == ELEMENT_IMPORT) {
                result.importQuantityInTons.put(row.getInt(2), row.getLong(4));
            }
            else if (element == ELEMENT_EXPORT) {
                result.exportQuantityInTons.put(row.getInt(2), row.getLong(4));
            }
            else if (element == ELEMENT_SUPPLY) {
                result.supplyInKcal.put(row.getInt(2), row.getLong(4));
            }

        }

        return result;
    }

    // ================================================
    // OVERRIDES ======================================
    // ================================================

    // ================================================
    // MEMBER METHODS =================================
    // ================================================


    public boolean providesSufficientCalories() {
        return supplyInKcal.get(ITEM_GRAND_TOTAL) > RDA;
    }


    public long getFoodProducedInTons() {
        long result = 0;
        for (HashMap.Entry<Integer, Long> entry : productionInTons.entrySet()) {
            if (!CATEGORY_NON_ESSENTIALS.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        return result;
    }


    public long getFoodImportedInTons() {
        long result = 0;
        for (HashMap.Entry<Integer, Long> entry : importQuantityInTons.entrySet()) {
            if (!CATEGORY_NON_ESSENTIALS.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        return result;
    }


    public long getFoodExportedInTons() {
        long result = 0;
        for (HashMap.Entry<Integer, Long> entry : exportQuantityInTons.entrySet()) {
            if (!CATEGORY_NON_ESSENTIALS.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        return result;
    }


    public long getFoodNeededInTons() {
        double ratio = RDA / (double) supplyInKcal.get(ITEM_GRAND_TOTAL);
        return (long) (getAvailableEdibleTotalInTons() * ratio);
    }


    public long getFoodBalanceInTons() {
        return getAvailableEdibleTotalInTons() - getFoodNeededInTons();
    }


    public long getAvailableInCategoryInTons(List<Integer> category) {
        long result = 0;
        for (HashMap.Entry<Integer, Long> entry : productionInTons.entrySet()) {
            if (category.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        for (HashMap.Entry<Integer, Long> entry : importQuantityInTons.entrySet()) {
            if (category.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        for (HashMap.Entry<Integer, Long> entry : exportQuantityInTons.entrySet()) {
            if (category.contains(entry.getKey())) {
                result -= entry.getValue();
            }
        }
        return result;
    }


    public long getAvailableEdibleTotalInTons() {
        long result = 0;
        for (HashMap.Entry<Integer, Long> entry : productionInTons.entrySet()) {
            if (!CATEGORY_NON_ESSENTIALS.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        for (HashMap.Entry<Integer, Long> entry : importQuantityInTons.entrySet()) {
            if (!CATEGORY_NON_ESSENTIALS.contains(entry.getKey())) {
                result += entry.getValue();
            }
        }
        for (HashMap.Entry<Integer, Long> entry : exportQuantityInTons.entrySet()) {
            if (!CATEGORY_NON_ESSENTIALS.contains(entry.getKey())) {
                result -= entry.getValue();
            }
        }
        return result;
    }


    // ================================================
    // INNER CLASSES ==================================
    // ================================================

}

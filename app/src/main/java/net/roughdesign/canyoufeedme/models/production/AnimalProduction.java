/**
 *
 */
package net.roughdesign.canyoufeedme.models.production;

import android.util.Log;

import net.roughdesign.roughlib.Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rough
 */
public class AnimalProduction extends Web
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/item/members.xml?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================
    static public final int KEY_BEEF_AND_BUFFALO_MEAT = 1806;
    static public final int KEY_BEEFANDBUFFALO_MEAT_INDIG = 1747;
    static public final int KEY_BEESWAX = 1183;
    static public final int KEY_EGGS_PRIMARY = 1783;
    static public final int KEY_EGGS__HEN__IN_SHELL = 1062;
    static public final int KEY_EGGS__HEN__IN_SHELL___NUMBER = 1067;
    static public final int KEY_EGGS__OTHER_BIRD__IN_SHELL = 1091;
    static public final int KEY_EGGS__OTHER_BIRD__IN_SHELL___NUMBER = 1092;
    static public final int KEY_HAIR__HORSE = 1100;
    static public final int KEY_HIDES__BUFFALO__FRESH = 957;
    static public final int KEY_HIDES__CATTLE__FRESH = 919;
    static public final int KEY_HONEY__NATURAL = 1182;
    static public final int KEY_MEAT_INDIGENOUS__TOTAL = 1770;
    static public final int KEY_MEAT_INDIGENOUS__ASS = 1122;
    static public final int KEY_MEAT_INDIGENOUS__BIRD_NES = 1084;
    static public final int KEY_MEAT_INDIGENOUS__BUFFALO = 972;
    static public final int KEY_MEAT_INDIGENOUS__CAMEL = 1137;
    static public final int KEY_MEAT_INDIGENOUS__CATTLE = 944;
    static public final int KEY_MEAT_INDIGENOUS__CHICKEN = 1094;
    static public final int KEY_MEAT_INDIGENOUS__DUCK = 1070;
    static public final int KEY_MEAT_INDIGENOUS__GEESE = 1077;
    static public final int KEY_MEAT_INDIGENOUS__GOAT = 1032;
    static public final int KEY_MEAT_INDIGENOUS__HORSE = 1120;
    static public final int KEY_MEAT_INDIGENOUS__MULE = 1124;
    static public final int KEY_MEAT_INDIGENOUS__OTHER_CAMELIDS = 1161;
    static public final int KEY_MEAT_INDIGENOUS__PIG = 1055;
    static public final int KEY_MEAT_INDIGENOUS__RABBIT = 1144;
    static public final int KEY_MEAT_INDIGENOUS__RODENTS = 1154;
    static public final int KEY_MEAT_INDIGENOUS__SHEEP = 1012;
    static public final int KEY_MEAT_INDIGENOUS__TURKEY = 1087;
    static public final int KEY_MEAT__TOTAL = 1765;
    static public final int KEY_MEAT__ASS = 1108;
    static public final int KEY_MEAT__BIRD_NES = 1089;
    static public final int KEY_MEAT__BUFFALO = 947;
    static public final int KEY_MEAT__CAMEL = 1127;
    static public final int KEY_MEAT__CATTLE = 867;
    static public final int KEY_MEAT__CHICKEN = 1058;
    static public final int KEY_MEAT__DUCK = 1069;
    static public final int KEY_MEAT__GAME = 1163;
    static public final int KEY_MEAT__GOAT = 1017;
    static public final int KEY_MEAT__GOOSE_AND_GUINEA_FOWL = 1073;
    static public final int KEY_MEAT__HORSE = 1097;
    static public final int KEY_MEAT__MULE = 1111;
    static public final int KEY_MEAT__NES = 1166;
    static public final int KEY_MEAT__OTHER_CAMELIDS = 1158;
    static public final int KEY_MEAT__OTHER_RODENTS = 1151;
    static public final int KEY_MEAT__PIG = 1035;
    static public final int KEY_MEAT__RABBIT = 1141;
    static public final int KEY_MEAT__SHEEP = 977;
    static public final int KEY_MEAT__TURKEY = 1080;
    static public final int KEY_MILK__WHOLE_FRESH_BUFFALO = 951;
    static public final int KEY_MILK__WHOLE_FRESH_CAMEL = 1130;
    static public final int KEY_MILK__WHOLE_FRESH_COW = 882;
    static public final int KEY_MILK__WHOLE_FRESH_GOAT = 1020;
    static public final int KEY_MILK__WHOLE_FRESH_SHEEP = 982;
    static public final int KEY_MILK_TOTAL = 1780;
    static public final int KEY_MUTTONANDGOAT_MEAT_INDIG = 1748;
    static public final int KEY_OFFALS__NES = 1167;
    static public final int KEY_PIGEONS__OTHER_BIRDS = 1083;
    static public final int KEY_POULTRY_INDIGENOUS_TOTAL = 1775;
    static public final int KEY_POULTRY_MEAT = 1808;
    static public final int KEY_SHEEP_AND_GOAT_MEAT = 1807;
    static public final int KEY_SILK_WORM_COCOONS__REELABLE = 1185;
    static public final int KEY_SKINS__FURS = 1195;
    static public final int KEY_SKINS__GOAT__FRESH = 1025;
    static public final int KEY_SKINS__SHEEP__FRESH = 995;
    static public final int KEY_SKINS__SHEEP__WITH_WOOL = 999;
    static public final int KEY_SNAILS__NOT_SEA = 1176;
    static public final int KEY_WOOL__GREASY = 987;

    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/live-prim/facts.json?page=1&pageSize=200";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m5313, m5318, m5314, m5319, m5321, m5320, m5323, m5513, m5322, m5510, m5410, m5413, m5420, m5422, m5424, m5417";

    private final HashMap<Integer, FoodProductionValueSet> entries = new HashMap<Integer, FoodProductionValueSet>();


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private AnimalProduction(final String jsonString) throws JSONException
        {
        Log.w("AnimalProduction", jsonString);
        final JSONObject jsonObject = new JSONObject(jsonString);
        final JSONObject result = jsonObject.getJSONObject("result");
        final JSONObject list = result.getJSONObject("list");
        // TODO sometimes, "items" is not in the JSON object. What's up with that?
        if(!result.has("items"))
            return;
        final JSONArray entryArray = list.getJSONArray("items");

        for (int i = 0; i < entryArray.length(); i++)
            {
            final JSONObject entry = entryArray.getJSONObject(i);
            final FoodProductionValueSet foodValueSet = new FoodProductionValueSet(
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
    static public AnimalProduction getFromWeb(final String countryCode,
                                              final int year) throws IOException, JSONException
        {
        final String webAddress = constructUrl(countryCode, year);
        final String webContent = readWebAddress(webAddress);
        return new AnimalProduction(webContent);
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

    public double getTotalProductionInT()
        {
        double result = 0;
        for (final FoodProductionValueSet valueSet : entries.values())
            {
            result += valueSet.productionInTons;

            }
        return result;
        }


    @Override
    public String toString()
        {
        final StringBuilder stringBuilder = new StringBuilder();
        for (final Map.Entry<Integer, FoodProductionValueSet> entry : entries
                .entrySet())
            {
            stringBuilder.append(entry.getValue().displayName);
            stringBuilder.append("\n");
            stringBuilder.append(entry.getValue().productionInTons);
            stringBuilder.append(" | ");

            stringBuilder.append(entry.getValue().prodPopulationInNo);
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
    public class FoodProductionValueSet
        {
        // ================================================
        // Measures, see:
        // http://data.fao.org/developers/api/v1/en/resources/faostat/crop-prod/measures.xml?page=1&pageSize=50&fields=mnemonic%2Clabel%40en&sort=label%40en
        // ================================================
        static public final String KEY_DISPLAY_NAME = "Item";
        static public final String KEY_LAYING___1000_HEADS = "m5313";
        static public final String KEY_MILK_ANIMALS___HEADS = "m5318";
        static public final String KEY_PROD_POPULATION___NO = "m5314";
        static public final String KEY_PROD_POPULATION___HEADS = "m5319";
        static public final String KEY_PRODUCING_ANIMALS_PER_SLAUGHTERED___1000_HEADS = "m5321";
        static public final String KEY_PRODUCING_ANIMALS_PER_SLAUGHTERED___HEADS = "m5320";
        static public final String KEY_PRODUCTION___1000_HEADS = "m5323";
        static public final String KEY_PRODUCTION___1000 = "m5513";
        static public final String KEY_PRODUCTION___HEADS = "m5322";
        static public final String KEY_PRODUCTION___T = "m5510";
        static public final String KEY_YIELD___100_MG_PER_HEAD = "m5410";
        static public final String KEY_YIELD___NO_PER_HEAD = "m5413";
        static public final String KEY_YIELD___HG_PER_HEAD = "m5420";
        static public final String KEY_YIELD___HG = "m5422";
        static public final String KEY_YIELD_PER_CARCASS_WEIGHT___01_G_PER_HEAD = "m5424";
        static public final String KEY_YIELD_PER_CARCASS_WEIGHT___HG_PER_HEAD = "m5417";

        // ================================================
        // MEMBER VARIABLES ===============================
        // ================================================
        public final String displayName;
        public final double layingInThousandHeads;
        public final double milkAnimalsInHeads;
        public final double prodPopulationInNo;
        public final double prodPopulationInHeads;
        public final double producingAnimalSlaughteredInThousandHeads;
        public final double producingAnimalSlaughteredInHeads;
        public final double productionInThousandHeads;
        public final double productionInThousand;
        public final double productionInHeads;
        public final double productionInTons;
        public final double yieldInHundredMilligramPerHead;
        public final double yieldInNoPerHead;
        public final double yieldInHgPerHead;
        public final double yieldInHg;
        public final double yieldPerCarcassWeightInTenthGramPerHead;
        public final double yieldPerCarcassWeightInHgPerHead;


        // ================================================
        // CONSTRUCTOR ====================================
        // ================================================
        public FoodProductionValueSet(final JSONObject entry) throws JSONException
            {
            System.out.println(entry);
            displayName = entry.getString(KEY_DISPLAY_NAME);

            layingInThousandHeads = entry.optDouble(KEY_LAYING___1000_HEADS, 0);
            milkAnimalsInHeads = entry.optDouble(KEY_MILK_ANIMALS___HEADS, 0);
            prodPopulationInNo = entry.optDouble(KEY_PROD_POPULATION___NO, 0);
            prodPopulationInHeads = entry.optDouble(
                    KEY_PROD_POPULATION___HEADS, 0);
            producingAnimalSlaughteredInThousandHeads = entry.optDouble(
                    KEY_PRODUCING_ANIMALS_PER_SLAUGHTERED___1000_HEADS, 0);
            producingAnimalSlaughteredInHeads = entry.optDouble(
                    KEY_PRODUCING_ANIMALS_PER_SLAUGHTERED___HEADS, 0);
            productionInThousandHeads = entry.optDouble(
                    KEY_PRODUCTION___1000_HEADS, 0);
            productionInThousand = entry.optDouble(KEY_PRODUCTION___1000, 0);
            productionInHeads = entry.optDouble(KEY_PRODUCTION___HEADS, 0);
            productionInTons = entry.optDouble(KEY_PRODUCTION___T, 0);
            yieldInHundredMilligramPerHead = entry.optDouble(
                    KEY_YIELD___100_MG_PER_HEAD, 0);
            yieldInNoPerHead = entry.optDouble(KEY_YIELD___NO_PER_HEAD, 0);
            yieldInHgPerHead = entry.optDouble(KEY_YIELD___HG_PER_HEAD, 0);
            yieldInHg = entry.optDouble(KEY_YIELD___HG, 0);
            yieldPerCarcassWeightInTenthGramPerHead = entry.optDouble(
                    KEY_YIELD_PER_CARCASS_WEIGHT___01_G_PER_HEAD, 0);
            yieldPerCarcassWeightInHgPerHead = entry.optDouble(
                    KEY_YIELD_PER_CARCASS_WEIGHT___HG_PER_HEAD, 0);
            }

        }

    }

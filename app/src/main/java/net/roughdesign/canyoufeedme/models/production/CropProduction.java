/**
 *
 */
package net.roughdesign.canyoufeedme.models.production;

import net.roughdesign.roughlib.Web;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rough
 *
 */
@SuppressWarnings("unused")
public class CropProduction extends Web
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/fd-sup-live-fish/item/members.xml?page=1&pageSize=100&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================
    static public final int KEY_AGAVE_FIBRES_NES = 800;
    static public final int KEY_ALMONDS__WITH_SHELL = 221;
    static public final int KEY_ANISE__BADIAN__FENNEL__CORIANDER = 711;
    static public final int KEY_APPLES = 515;
    static public final int KEY_APRICOTS = 526;
    static public final int KEY_ARECA_NUTS = 226;
    static public final int KEY_ARTICHOKES = 366;
    static public final int KEY_ASPARAGUS = 367;
    static public final int KEY_AVOCADOS = 572;
    static public final int KEY_BAMBARA_BEANS = 203;
    static public final int KEY_BANANAS = 486;
    static public final int KEY_BARLEY = 44;
    static public final int KEY_BASTFIBRES__OTHER = 782;
    static public final int KEY_BEANS__DRY = 176;
    static public final int KEY_BEANS__GREEN = 414;
    static public final int KEY_BERRIES_NES = 558;
    static public final int KEY_BLUEBERRIES = 552;
    static public final int KEY_BRAZIL_NUTS__WITH_SHELL = 216;
    static public final int KEY_BROAD_BEANS__HORSE_BEANS__DRY = 181;
    static public final int KEY_BUCKWHEAT = 89;
    static public final int KEY_CABBAGES_AND_OTHER_BRASSICAS = 358;
    static public final int KEY_CANARY_SEED = 101;
    static public final int KEY_CAROBS = 461;
    static public final int KEY_CARROTS_AND_TURNIPS = 426;
    static public final int KEY_CASHEW_NUTS__WITH_SHELL = 217;
    static public final int KEY_CASHEWAPPLE = 591;
    static public final int KEY_CASSAVA = 125;
    static public final int KEY_CASSAVA_LEAVES = 378;
    static public final int KEY_CASTOR_OIL_SEED = 265;
    static public final int KEY_CAULIFLOWERS_AND_BROCCOLI = 393;
    static public final int KEY_CEREALS___RICE_MILLED_EQV = 1817;
    static public final int KEY_CEREALS__NES = 108;
    static public final int KEY_CEREALS_TOTAL = 1717;
    static public final int KEY_CHERRIES = 531;
    static public final int KEY_CHERRIES__SOUR = 530;
    static public final int KEY_CHESTNUT = 220;
    static public final int KEY_CHICK_PEAS = 191;
    static public final int KEY_CHICORY_ROOTS = 459;
    static public final int KEY_CHILLIES_AND_PEPPERS__DRY = 689;
    static public final int KEY_CHILLIES_AND_PEPPERS__GREEN = 401;
    static public final int KEY_CINNAMON___CANELLA = 693;
    static public final int KEY_CITRUS_FRUIT_TOTAL = 1804;
    static public final int KEY_CLOVES = 698;
    static public final int KEY_COARSE_GRAIN__TOTAL = 1814;
    static public final int KEY_COCOA__BEANS = 661;
    static public final int KEY_COCONUTS = 249;
    static public final int KEY_COFFEE__GREEN = 656;
    static public final int KEY_COIR = 813;
    static public final int KEY_COTTON_LINT = 767;
    static public final int KEY_COTTONSEED = 329;
    static public final int KEY_COW_PEAS__DRY = 195;
    static public final int KEY_CRANBERRIES = 554;
    static public final int KEY_CUCUMBERS_AND_GHERKINS = 397;
    static public final int KEY_CURRANTS = 550;
    static public final int KEY_DATES = 577;
    static public final int KEY_EGGPLANTS___AUBERGINES = 399;
    static public final int KEY_FIBRE_CROPS_PRIMARY = 1753;
    static public final int KEY_FIBRE_CROPS_NES = 821;
    static public final int KEY_FIGS = 569;
    static public final int KEY_FLAX_FIBRE_AND_TOW = 773;
    static public final int KEY_FONIO = 94;
    static public final int KEY_FRUIT_EXCL_MELONS_TOTAL = 1801;
    static public final int KEY_FRUIT__CITRUS_NES = 512;
    static public final int KEY_FRUIT__FRESH_NES = 619;
    static public final int KEY_FRUIT__POME_NES = 542;
    static public final int KEY_FRUIT__STONE_NES = 541;
    static public final int KEY_FRUIT__TROPICAL_FRESH_NES = 603;
    static public final int KEY_GARLIC = 406;
    static public final int KEY_GINGER = 720;
    static public final int KEY_GOOSEBERRIES = 549;
    static public final int KEY_GRAIN__MIXED = 103;
    static public final int KEY_GRAPEFRUIT___INC_POMELOS = 507;
    static public final int KEY_GRAPES = 560;
    static public final int KEY_GROUNDNUTS__WITH_SHELL = 242;
    static public final int KEY_GUMS__NATURAL = 839;
    static public final int KEY_HAZELNUTS__WITH_SHELL = 225;
    static public final int KEY_HEMP_TOW_WASTE = 777;
    static public final int KEY_HEMPSEED = 336;
    static public final int KEY_HOPS = 677;
    static public final int KEY_JOJOBA_SEED = 277;
    static public final int KEY_JUTE = 780;
    static public final int KEY_JUTE_AND_JUTE_LIKE_FIBRES = 1751;
    static public final int KEY_KAPOK_FIBRE = 778;
    static public final int KEY_KAPOK_FRUIT = 310;
    static public final int KEY_KAPOKSEED_IN_SHELL = 311;
    static public final int KEY_KARITE_NUTS___SHEANUTS = 263;
    static public final int KEY_KIWI_FRUIT = 592;
    static public final int KEY_KOLA_NUTS = 224;
    static public final int KEY_LEEKS__OTHER_ALLIACEOUS_VEGETABLES = 407;
    static public final int KEY_LEMONS_AND_LIMES = 497;
    static public final int KEY_LENTILS = 201;
    static public final int KEY_LETTUCE_AND_CHICORY = 372;
    static public final int KEY_LINSEED = 333;
    static public final int KEY_LUPINS = 210;
    static public final int KEY_MAIZE = 56;
    static public final int KEY_MAIZE__GREEN = 446;
    static public final int KEY_MANGOES__MANGOSTEENS__GUAVAS = 571;
    static public final int KEY_MANILA_FIBRE___ABACA = 809;
    static public final int KEY_MATÉ = 671;
    static public final int KEY_MELONS__OTHER___INCCANTALOUPES = 568;
    static public final int KEY_MELONSEED = 299;
    static public final int KEY_MILLET = 79;
    static public final int KEY_MUSHROOMS_AND_TRUFFLES = 449;
    static public final int KEY_MUSTARD_SEED = 292;
    static public final int KEY_NUTMEG__MACE_AND_CARDAMOMS = 702;
    static public final int KEY_NUTS__NES = 234;
    static public final int KEY_OATS = 75;
    static public final int KEY_OIL__PALM = 257;
    static public final int KEY_OIL__PALM_FRUIT = 254;
    static public final int KEY_OILCAKES_EQUIVALENT = 1841;
    static public final int KEY_OILCROPS_PRIMARY = 1732;
    static public final int KEY_OILSEEDS_NES = 339;
    static public final int KEY_OKRA = 430;
    static public final int KEY_OLIVES = 260;
    static public final int KEY_ONIONS__DRY = 403;
    static public final int KEY_ONIONS__SHALLOTS__GREEN = 402;
    static public final int KEY_ORANGES = 490;
    static public final int KEY_PALM_KERNELS = 256;
    static public final int KEY_PAPAYAS = 600;
    static public final int KEY_PEACHES_AND_NECTARINES = 534;
    static public final int KEY_PEARS = 521;
    static public final int KEY_PEAS__DRY = 187;
    static public final int KEY_PEAS__GREEN = 417;
    static public final int KEY_PEPPER___PIPER_SPP = 687;
    static public final int KEY_PEPPERMINT = 748;
    static public final int KEY_PERSIMMONS = 587;
    static public final int KEY_PIGEON_PEAS = 197;
    static public final int KEY_PINEAPPLES = 574;
    static public final int KEY_PISTACHIOS = 223;
    static public final int KEY_PLANTAINS = 489;
    static public final int KEY_PLUMS_AND_SLOES = 536;
    static public final int KEY_POPCORN = 68;
    static public final int KEY_POPPY_SEED = 296;
    static public final int KEY_POTATOES = 116;
    static public final int KEY_PULSES__NES = 211;
    static public final int KEY_PULSES_TOTAL = 1726;
    static public final int KEY_PUMPKINS__SQUASH_AND_GOURDS = 394;
    static public final int KEY_PYRETHRUM__DRIED = 754;
    static public final int KEY_QUINCES = 523;
    static public final int KEY_QUINOA = 92;
    static public final int KEY_RAMIE = 788;
    static public final int KEY_RAPESEED = 270;
    static public final int KEY_RASPBERRIES = 547;
    static public final int KEY_RICE__PADDY = 27;
    static public final int KEY_ROOTS_AND_TUBERS_TOTAL = 1720;
    static public final int KEY_ROOTS_AND_TUBERS__NES = 149;
    static public final int KEY_RUBBER__NATURAL = 836;
    static public final int KEY_RYE = 71;
    static public final int KEY_SAFFLOWER_SEED = 280;
    static public final int KEY_SEED_COTTON = 328;
    static public final int KEY_SESAME_SEED = 289;
    static public final int KEY_SISAL = 789;
    static public final int KEY_SORGHUM = 83;
    static public final int KEY_SOYBEANS = 236;
    static public final int KEY_SPICES__NES = 723;
    static public final int KEY_SPINACH = 373;
    static public final int KEY_STRAWBERRIES = 544;
    static public final int KEY_STRING_BEANS = 423;
    static public final int KEY_SUGAR_BEET = 157;
    static public final int KEY_SUGAR_CANE = 156;
    static public final int KEY_SUGAR_CROPS__NES = 161;
    static public final int KEY_SUNFLOWER_SEED = 267;
    static public final int KEY_SWEET_POTATOES = 122;
    static public final int KEY_TALLOWTREE_SEED = 305;
    static public final int KEY_TANGERINES__MANDARINS__CLEMENTINES__SATSUMAS = 495;
    static public final int KEY_TARO___COCOYAM = 136;
    static public final int KEY_TEA = 667;
    static public final int KEY_TOBACCO__UNMANUFACTURED = 826;
    static public final int KEY_TOMATOES = 388;
    static public final int KEY_TREENUTS_TOTAL = 1729;
    static public final int KEY_TRITICALE = 97;
    static public final int KEY_TUNG_NUTS = 275;
    static public final int KEY_VANILLA = 692;
    static public final int KEY_VEGETABLES_PRIMARY = 1735;
    static public final int KEY_VEGETABLESANDMELONS__TOTAL = 1800;
    static public final int KEY_VEGETABLES__FRESH_NES = 463;
    static public final int KEY_VEGETABLES__LEGUMINOUS_NES = 420;
    static public final int KEY_VETCHES = 205;
    static public final int KEY_WALNUTS__WITH_SHELL = 222;
    static public final int KEY_WATERMELONS = 567;
    static public final int KEY_WHEAT = 15;
    static public final int KEY_YAMS = 137;
    static public final int KEY_YAUTIA___COCOYAM = 135;

    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/crop-prod/facts.json?page=1&pageSize=200";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m5312, m5510, m5525, m5419";

    private final HashMap<Integer, FoodProductionValueSet> entries = new HashMap<>();


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private CropProduction(final String jsonString) throws JSONException
        {
	final JSONObject jsonObject = new JSONObject(jsonString);
	final JSONObject result = jsonObject.getJSONObject("result");
	final JSONObject list = result.getJSONObject("list");
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
    static public CropProduction getFromWeb(final String countryCode,
	    final int year) throws IOException, JSONException
        {
	final String webAddress = constructUrl(countryCode, year);
	final String webContent = readWebAddress(webAddress);
	return new CropProduction(webContent);
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
    public double getTotalAreaHarvestedInHectar()
	{
	double result = 0;
	for (final FoodProductionValueSet valueSet : entries.values())
	    {
	    result += valueSet.areaHarvestedInHectar;
	    }
	return result;
	}


    public double getTotalProductionInT()
	{
	double result = 0;
	for (final FoodProductionValueSet valueSet : entries.values())
	    {
	    result += valueSet.productionInT;

	    }
	return result;
	}


    public double getTotalSeedInT()
	{
	double result = 0;
	for (final FoodProductionValueSet valueSet : entries.values())
	    {
	    result += valueSet.seedInT;
	    }
	return result;
	}


    public double getTotalYieldInHgPerHectar()
	{
	double result = 0;
	for (final FoodProductionValueSet valueSet : entries.values())
	    {
	    result += valueSet.yieldInHgPerHectar;
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
	    stringBuilder.append(entry.getValue().areaHarvestedInHectar);
	    stringBuilder.append(" | ");

	    stringBuilder.append(entry.getValue().seedInT);
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
	static private final String KEY_DISPLAY_NAME = "Item";
	static private final String KEY_AREA_HARVESTED_IN_HECTAR = "m5312";
	static private final String KEY_PRODUCTION_IN_T = "m5510";
	static private final String KEY_SEED_IN_T = "m5525";
	static private final String KEY_YIELD_IN_HG_PER_HECTAR = "m5419";

	// ================================================
	// MEMBER VARIABLES ===============================
	// ================================================
	public final String displayName;
	public final double areaHarvestedInHectar;
	public final double productionInT;
	public final double seedInT;
	public final double yieldInHgPerHectar;


	// ================================================
	// CONSTRUCTOR ====================================
	// ================================================
	public FoodProductionValueSet(final JSONObject entry) throws JSONException
        {
	    displayName = entry.getString(KEY_DISPLAY_NAME);
	    areaHarvestedInHectar = entry.optDouble(
		    KEY_AREA_HARVESTED_IN_HECTAR, 0);
	    productionInT = entry.optDouble(KEY_PRODUCTION_IN_T, 0);
	    seedInT = entry.optDouble(KEY_SEED_IN_T, 0);
	    yieldInHgPerHectar = entry.optDouble(KEY_YIELD_IN_HG_PER_HECTAR, 0);
	    }

	}

    }

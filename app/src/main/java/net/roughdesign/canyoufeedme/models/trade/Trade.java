/**
 *
 */
package net.roughdesign.canyoufeedme.models.trade;

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
public class Trade extends Web
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/prod-trade/item/members.xml?page=1&pageSize=500&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================
    static public final int KEY_AGRICULTPRODUCTS_TOTAL = 1882;
    static public final int KEY_ALFALFA_MEAL_AND_PELLETS = 862;
    static public final int KEY_ALMONDS_SHELLED = 231;
    static public final int KEY_ANIMAL_FATS = 1904;
    static public final int KEY_ANIMAL_OIL_AND_FAT_AND_GRS = 1976;
    static public final int KEY_ANIMAL_VEGETABLE_OIL = 1903;
    static public final int KEY_ANISE__BADIAN__FENNEL__CORIANDER = 711;
    static public final int KEY_APPLES = 515;
    static public final int KEY_APRICOTS = 526;
    static public final int KEY_APRICOTS__DRY = 527;
    static public final int KEY_ARTICHOKES = 366;
    static public final int KEY_ASPARAGUS = 367;
    static public final int KEY_AVOCADOS = 572;
    static public final int KEY_BACON_AND_HAM = 1039;
    static public final int KEY_BAMBARA_BEANS = 203;
    static public final int KEY_BANANAS = 486;
    static public final int KEY_BANANAS_AND_PLANTAINS = 1951;
    static public final int KEY_BARLEY = 44;
    static public final int KEY_BARLEY__PEARLED = 46;
    static public final int KEY_BEANS__DRY = 176;
    static public final int KEY_BEANS__GREEN = 414;
    static public final int KEY_BEER = 1967;
    static public final int KEY_BEER_OF_BARLEY = 51;
    static public final int KEY_BEER_OF_SORGHUM = 86;
    static public final int KEY_BEESWAX = 1183;
    static public final int KEY_BEET_PULP = 169;
    static public final int KEY_BEVERAGES = 1895;
    static public final int KEY_BEVERAGES_AND_TOBACCO = 1894;
    static public final int KEY_BEVERAGES__DISTILLED_ALCOHOLIC = 634;
    static public final int KEY_BEVERAGES__FERMENTED_RICE = 39;
    static public final int KEY_BEVERAGES__NON_ALCOHOLIC = 633;
    static public final int KEY_BLUEBERRIES = 552;
    static public final int KEY_BOVINE_MEAT = 2071;
    static public final int KEY_BRAN__BUCKWHEAT = 91;
    static public final int KEY_BRAN__FONIO = 96;
    static public final int KEY_BRAN__MAIZE = 59;
    static public final int KEY_BRAN__MILLET = 81;
    static public final int KEY_BRAN__RICE = 35;
    static public final int KEY_BRAN__SORGHUM = 85;
    static public final int KEY_BRAN__WHEAT = 17;
    static public final int KEY_BRAZIL_NUTS__SHELLED = 229;
    static public final int KEY_BREAD = 20;
    static public final int KEY_BROAD_BEANS__HORSE_BEANS__DRY = 181;
    static public final int KEY_BUCKWHEAT = 89;
    static public final int KEY_BULGUR = 21;
    static public final int KEY_BUTTER = 1938;
    static public final int KEY_BUTTER_OF_KARITE_NUTS = 264;
    static public final int KEY_BUTTER__COW_MILK = 886;
    static public final int KEY_BUTTERMILK__CURDLED__ACIDIFIED_MILK = 893;
    static public final int KEY_CABBAGES_AND_OTHER_BRASSICAS = 358;
    static public final int KEY_CAKE__COPRA = 253;
    static public final int KEY_CAKE__COTTONSEED = 332;
    static public final int KEY_CAKE__GROUNDNUTS = 245;
    static public final int KEY_CAKE__HEMPSEED = 338;
    static public final int KEY_CAKE__KAPOK = 314;
    static public final int KEY_CAKE__LINSEED = 335;
    static public final int KEY_CAKE__MAIZE = 61;
    static public final int KEY_CAKE__MUSTARD = 294;
    static public final int KEY_CAKE__PALM_KERNEL = 259;
    static public final int KEY_CAKE__RAPESEED = 272;
    static public final int KEY_CAKE__RICE_BRAN = 37;
    static public final int KEY_CAKE__SAFFLOWER = 282;
    static public final int KEY_CAKE__SESAME_SEED = 291;
    static public final int KEY_CAKE__SOYBEANS = 238;
    static public final int KEY_CAKE__SUNFLOWER = 269;
    static public final int KEY_CANARY_SEED = 101;
    static public final int KEY_CANE_TOPS = 630;
    static public final int KEY_CANNED_MEAT_NES = 1931;
    static public final int KEY_CARROTS_AND_TURNIPS = 426;
    static public final int KEY_CASHEW_NUTS__SHELLED = 230;
    static public final int KEY_CASHEW_NUTS__WITH_SHELL = 217;
    static public final int KEY_CASHEWAPPLE = 591;
    static public final int KEY_CASSAVA = 125;
    static public final int KEY_CASSAVA_EQUIVALENT = 1953;
    static public final int KEY_CASSAVA_DRIED = 128;
    static public final int KEY_CAULIFLOWERS_AND_BROCCOLI = 393;
    static public final int KEY_CEREAL_PREPARATIONS__NES = 113;
    static public final int KEY_CEREALS = 1944;
    static public final int KEY_CEREALS_AND_PREPARATIONS = 1888;
    static public final int KEY_CEREALS__BREAKFAST = 41;
    static public final int KEY_CHEESE_AND_CURD = 1939;
    static public final int KEY_CHEESE__PROCESSED = 907;
    static public final int KEY_CHEESE__SHEEP_MILK = 984;
    static public final int KEY_CHEESE__WHOLE_COW_MILK = 901;
    static public final int KEY_CHERRIES = 531;
    static public final int KEY_CHERRIES__SOUR = 530;
    static public final int KEY_CHESTNUT = 220;
    static public final int KEY_CHICK_PEAS = 191;
    static public final int KEY_CHILLIES_AND_PEPPERS__DRY = 689;
    static public final int KEY_CHILLIES_AND_PEPPERS__GREEN = 401;
    static public final int KEY_CHOCOLATE_PRODUCTS_NES = 666;
    static public final int KEY_CIDER_ETC = 517;
    static public final int KEY_CIGARETTES = 828;
    static public final int KEY_CIGARS__CHEROOTS = 829;
    static public final int KEY_CINNAMON___CANELLA = 693;
    static public final int KEY_CLOVES = 698;
    static public final int KEY_COCOA__BEANS = 661;
    static public final int KEY_COCOA__BUTTER = 664;
    static public final int KEY_COCOA__PASTE = 662;
    static public final int KEY_COCOA__POWDER_AND_CAKE = 665;
    static public final int KEY_COCONUTS = 249;
    static public final int KEY_COCONUTS__DESICCATED = 250;
    static public final int KEY_COCOONS__UNREELABLE_AND_WASTE = 1187;
    static public final int KEY_COFFEE_GREEN_AND_ROAST = 1956;
    static public final int KEY_COFFEE_AND_TEA_AND_COCOA_AND_SP = 1891;
    static public final int KEY_COFFEE__EXTRACTS = 659;
    static public final int KEY_COFFEE__GREEN = 656;
    static public final int KEY_COFFEE__HUSKS_AND_SKINS = 660;
    static public final int KEY_COFFEE__ROASTED = 657;
    static public final int KEY_COFFEE__SUBSTITUTES_CONTAINING_COFFEE = 658;
    static public final int KEY_COPRA = 251;
    static public final int KEY_COTTON_LINT = 767;
    static public final int KEY_COTTON_LINTER = 770;
    static public final int KEY_COTTON_WASTE = 769;
    static public final int KEY_COTTON__CARDED__COMBED = 768;
    static public final int KEY_COTTONSEED = 329;
    static public final int KEY_CRANBERRIES = 554;
    static public final int KEY_CREAM_FRESH = 885;
    static public final int KEY_CRUDE_MATERIALS__EX2 = 1897;
    static public final int KEY_CRUDE_MATERIALS_NES = 1902;
    static public final int KEY_CRUDE_MATERIALS = 1293;
    static public final int KEY_CUCUMBERS_AND_GHERKINS = 397;
    static public final int KEY_CURRANTS = 550;
    static public final int KEY_DAIRY_PRODUCTS_AND_EGGS = 1886;
    static public final int KEY_DATES = 577;
    static public final int KEY_DREGS_FROM_BREWING__DISTILLATION = 654;
    static public final int KEY_EGGPLANTS___AUBERGINES = 399;
    static public final int KEY_EGGS_LIQUID_DRIED = 1943;
    static public final int KEY_EGGS_IN_THE_SHELL = 1942;
    static public final int KEY_EGGS__DRIED = 1064;
    static public final int KEY_EGGS__HEN__IN_SHELL = 1062;
    static public final int KEY_EGGS__LIQUID = 1063;
    static public final int KEY_EGGS__OTHER_BIRD__IN_SHELL = 1091;
    static public final int KEY_FAT__CAMELS = 1129;
    static public final int KEY_FAT__CATTLE = 869;
    static public final int KEY_FAT__LIVER_PREPARED___FOIE_GRAS = 1060;
    static public final int KEY_FAT__NES__PREPARED = 1243;
    static public final int KEY_FAT__PIGS = 1037;
    static public final int KEY_FATTY_ACIDS = 1276;
    static public final int KEY_FATTY_SUBSTANCE_RESIDUES = 1277;
    static public final int KEY_FEED_AND_MEAL__GLUTEN = 846;
    static public final int KEY_FEED_MINERALS = 855;
    static public final int KEY_FEED_SUPPLEMENTS = 850;
    static public final int KEY_FEED__COMPOUND__NES = 845;
    static public final int KEY_FEED__PULP_OF_FRUIT = 628;
    static public final int KEY_FEED__VEGETABLE_PRODUCTS_NES = 652;
    static public final int KEY_FIGS = 569;
    static public final int KEY_FIGS_DRIED = 570;
    static public final int KEY_FIXED_VEGETABLE_OILS = 1905;
    static public final int KEY_FLAX_FIB_AND_TOW_AND_W = 1973;
    static public final int KEY_FLAX_FIBRE_AND_TOW = 773;
    static public final int KEY_FLAX_FIBRE_RAW = 771;
    static public final int KEY_FLAX_TOW_WASTE = 774;
    static public final int KEY_FLOUR__CEREALS = 111;
    static public final int KEY_FLOUR__FONIO = 95;
    static public final int KEY_FLOUR__MAIZE = 58;
    static public final int KEY_FLOUR__MIXED_GRAIN = 104;
    static public final int KEY_FLOUR__MUSTARD = 295;
    static public final int KEY_FLOUR__POTATOES = 117;
    static public final int KEY_FLOUR__PULSES = 212;
    static public final int KEY_FLOUR__ROOTS_AND_TUBERS_NES = 150;
    static public final int KEY_FLOUR__WHEAT = 16;
    static public final int KEY_FODDER_AND_FEEDING_STUFF = 1892;
    static public final int KEY_FONIO = 94;
    static public final int KEY_FOOD_EXCL_FISH = 1982;
    static public final int KEY_FOOD_AND_ANIMALS = 1883;
    static public final int KEY_FOOD_PREP_NES = 1232;
    static public final int KEY_FOOD_PREPARATIONS__FLOUR__MALT_EXTRACT = 115;
    static public final int KEY_FOOD_WASTES = 653;
    static public final int KEY_FORAGE_AND_SILAGE__CLOVER = 640;
    static public final int KEY_FORAGE_AND_SILAGE__GRASSES_NES = 639;
    static public final int KEY_FORAGE_AND_SILAGE__LEGUMES = 643;
    static public final int KEY_FORAGE_PRODUCTS = 651;
    static public final int KEY_FRUCTOSE_AND_SYRUP__OTHER = 166;
    static public final int KEY_FRUIT__AND__VEGETABLES = 1889;
    static public final int KEY_FRUIT__COOKED__HOMOGENIZED_PREPARATIONS = 626;
    static public final int KEY_FRUIT__DRIED_NES = 620;
    static public final int KEY_FRUIT__FRESH_NES = 619;
    static public final int KEY_FRUIT__PREPARED_NES = 623;
    static public final int KEY_FRUIT__TROPICAL_FRESH_NES = 603;
    static public final int KEY_GARLIC = 406;
    static public final int KEY_GERM__MAIZE = 57;
    static public final int KEY_GHEE__OF_BUFFALO_MILK = 953;
    static public final int KEY_GINGER = 720;
    static public final int KEY_GLUCOSE_AND_DEXTROSE = 172;
    static public final int KEY_GOOSEBERRIES = 549;
    static public final int KEY_GRAIN__MIXED = 103;
    static public final int KEY_GRAPEFRUIT___INC_POMELOS = 507;
    static public final int KEY_GRAPES = 560;
    static public final int KEY_GREASE_INCL_LANOLIN_WOOL = 994;
    static public final int KEY_GROUNDNUTS_TOTAL_SHELLED = 1968;
    static public final int KEY_GROUNDNUTS__SHELLED = 243;
    static public final int KEY_HAIR__FINE = 1218;
    static public final int KEY_HAIR__GOAT__COARSE = 1031;
    static public final int KEY_HAY___CLOVER__LUCERNE_ETC = 858;
    static public final int KEY_HAY___UNSPECIFIED = 859;
    static public final int KEY_HAZELNUTS__SHELLED = 233;
    static public final int KEY_HIDES_AND_SKINS_NES__FRESH = 1213;
    static public final int KEY_HIDES__BUFFALO__DRY_SALTED = 959;
    static public final int KEY_HIDES__BUFFALO__FRESH = 957;
    static public final int KEY_HIDES__BUFFALO__WET_SALTED = 958;
    static public final int KEY_HIDES__CAMEL__NES = 1136;
    static public final int KEY_HIDES__CAMEL__WET_SALTED = 1134;
    static public final int KEY_HIDES__CATTLE__FRESH = 919;
    static public final int KEY_HIDES__CATTLE__WET_SALTED = 920;
    static public final int KEY_HIDES__HORSE__DRY_SALTED = 1104;
    static public final int KEY_HIDES__NES = 1216;
    static public final int KEY_HONEY__NATURAL = 1182;
    static public final int KEY_HOPS = 677;
    static public final int KEY_ICE_CREAM_AND_EDIBLE_ICE = 910;
    static public final int KEY_INFANT_FOOD = 109;
    static public final int KEY_JUICE__CITRUS__CONCENTRATED = 514;
    static public final int KEY_JUICE__CITRUS__SINGLE_STRENGTH = 513;
    static public final int KEY_JUICE__FRUIT_NES = 622;
    static public final int KEY_JUICE__GRAPE = 562;
    static public final int KEY_JUICE__GRAPEFRUIT = 509;
    static public final int KEY_JUICE__GRAPEFRUIT__CONCENTRATED = 510;
    static public final int KEY_JUICE__LEMON__CONCENTRATED = 499;
    static public final int KEY_JUICE__ORANGE__CONCENTRATED = 492;
    static public final int KEY_JUICE__ORANGE__SINGLE_STRENGTH = 491;
    static public final int KEY_JUICE__PINEAPPLE = 576;
    static public final int KEY_JUICE__PINEAPPLE__CONCENTRATED = 580;
    static public final int KEY_JUICE__PLUM__CONCENTRATED = 539;
    static public final int KEY_JUICE__PLUM__SINGLE_STRENGTH = 538;
    static public final int KEY_JUICE__TOMATO = 390;
    static public final int KEY_JUTE = 780;
    static public final int KEY_JUTE_AND_BAST_FIBRES = 1980;
    static public final int KEY_KAPOK_FIBRE = 778;
    static public final int KEY_KAPOKSEED_IN_SHELL = 311;
    static public final int KEY_KAPOKSEED_SHELLED = 312;
    static public final int KEY_KIWI_FRUIT = 592;
    static public final int KEY_KOLA_NUTS = 224;
    static public final int KEY_LACTOSE = 173;
    static public final int KEY_LARD = 1043;
    static public final int KEY_LEEKS__OTHER_ALLIACEOUS_VEGETABLES = 407;
    static public final int KEY_LEMONS_AND_LIMES = 497;
    static public final int KEY_LENTILS = 201;
    static public final int KEY_LETTUCE_AND_CHICORY = 372;
    static public final int KEY_LINSEED = 333;
    static public final int KEY_MACARONI = 18;
    static public final int KEY_MAIZE = 56;
    static public final int KEY_MAIZE__GREEN = 446;
    static public final int KEY_MALT = 49;
    static public final int KEY_MANGOES__MANGOSTEENS__GUAVAS = 571;
    static public final int KEY_MANILA_FIBRE___ABACA = 809;
    static public final int KEY_MAPLE_SUGAR_AND_SYRUPS = 160;
    static public final int KEY_MARGARINE__LIQUID = 1241;
    static public final int KEY_MARGARINE__SHORT = 1242;
    static public final int KEY_MATÉ = 671;
    static public final int KEY_MEAL__MEAT = 1173;
    static public final int KEY_MEAT_BOVINE_FRESH = 1924;
    static public final int KEY_MEAT_FRESH_AND_CH_AND_FROZEN = 1923;
    static public final int KEY_MEAT_POULTRY_FRESH = 1926;
    static public final int KEY_MEAT_PREPARED_PRES = 1933;
    static public final int KEY_MEAT_SHEEP_FRESH = 1925;
    static public final int KEY_MEAT_AND_MEAT_PREPARATIONS = 1885;
    static public final int KEY_MEAT_OF_SWINE = 2027;
    static public final int KEY_MEAT__ASS = 1108;
    static public final int KEY_MEAT__BEEF_AND_VEAL_SAUSAGES = 874;
    static public final int KEY_MEAT__BEEF__PREPARATIONS = 875;
    static public final int KEY_MEAT__CATTLE = 867;
    static public final int KEY_MEAT__CATTLE__BONELESS___BEEF_AND_VEAL = 870;
    static public final int KEY_MEAT__CHICKEN = 1058;
    static public final int KEY_MEAT__CHICKEN__CANNED = 1061;
    static public final int KEY_MEAT__DRIED_NES = 1164;
    static public final int KEY_MEAT__DUCK = 1069;
    static public final int KEY_MEAT__GAME = 1163;
    static public final int KEY_MEAT__GOAT = 1017;
    static public final int KEY_MEAT__GOOSE_AND_GUINEA_FOWL = 1073;
    static public final int KEY_MEAT__HORSE = 1097;
    static public final int KEY_MEAT__NES = 1166;
    static public final int KEY_MEAT__PIG = 1035;
    static public final int KEY_MEAT__PIG_SAUSAGES = 1041;
    static public final int KEY_MEAT__PIG__PREPARATIONS = 1042;
    static public final int KEY_MEAT__PORK = 1038;
    static public final int KEY_MEAT__RABBIT = 1141;
    static public final int KEY_MEAT__SHEEP = 977;
    static public final int KEY_MEAT__TURKEY = 1080;
    static public final int KEY_MELONS__OTHER___INCCANTALOUPES = 568;
    static public final int KEY_MILK_CONDENSED__AND__EVAPORATED = 1935;
    static public final int KEY_MILK_CONDENSED_AND_DRY_AND_FRESH = 1934;
    static public final int KEY_MILK_DRY = 1936;
    static public final int KEY_MILK_EQUIVALENT = 2030;
    static public final int KEY_MILK_FRESH = 1937;
    static public final int KEY_MILK__PRODUCTS_OF_NATURAL_CONSTITUENTS_NES = 909;
    static public final int KEY_MILK__RECONSTITUTED = 908;
    static public final int KEY_MILK__SKIMMED_COW = 888;
    static public final int KEY_MILK__SKIMMED_DRIED = 898;
    static public final int KEY_MILK__WHOLE_CONDENSED = 889;
    static public final int KEY_MILK__WHOLE_DRIED = 897;
    static public final int KEY_MILK__WHOLE_EVAPORATED = 894;
    static public final int KEY_MILK__WHOLE_FRESH_COW = 882;
    static public final int KEY_MILK__WHOLE_FRESH_SHEEP = 982;
    static public final int KEY_MILLET = 79;
    static public final int KEY_MISCELLANEOUS_FOOD = 1893;
    static public final int KEY_MIXES_AND_DOUGHS = 114;
    static public final int KEY_MOLASSES = 165;
    static public final int KEY_MUSHROOMS_AND_TRUFFLES = 449;
    static public final int KEY_MUSHROOMS__CANNED = 451;
    static public final int KEY_MUSTARD_SEED = 292;
    static public final int KEY_NATURAL_RUBBER = 1900;
    static public final int KEY_NUTMEG__MACE_AND_CARDAMOMS = 702;
    static public final int KEY_NUTS__NES = 234;
    static public final int KEY_NUTS__PREPARED___EXC_GROUNDNUTS = 235;
    static public final int KEY_OATS = 75;
    static public final int KEY_OATS_ROLLED = 76;
    static public final int KEY_OFFALS_EDIBL_FRESH = 1927;
    static public final int KEY_OFFALS__EDIBLE__CATTLE = 868;
    static public final int KEY_OFFALS__EDIBLE__GOATS = 1018;
    static public final int KEY_OFFALS__LIVER_CHICKEN = 1059;
    static public final int KEY_OFFALS__LIVER_DUCK = 1075;
    static public final int KEY_OFFALS__LIVER_GEESE = 1074;
    static public final int KEY_OFFALS__OTHER_CAMELIDS = 1159;
    static public final int KEY_OFFALS__PIGS__EDIBLE = 1036;
    static public final int KEY_OFFALS__SHEEP_EDIBLE = 978;
    static public final int KEY_OIL__BOILED_ETC = 1274;
    static public final int KEY_OIL__CASTOR_BEANS = 266;
    static public final int KEY_OIL__CITRONELLA = 737;
    static public final int KEY_OIL__COCONUT___COPRA = 252;
    static public final int KEY_OIL__COTTONSEED = 331;
    static public final int KEY_OIL__ESSENTIAL_NES = 753;
    static public final int KEY_OIL__GROUNDNUT = 244;
    static public final int KEY_OIL__KAPOK = 313;
    static public final int KEY_OIL__LINSEED = 334;
    static public final int KEY_OIL__MAIZE = 60;
    static public final int KEY_OIL__OLIVE_RESIDUES = 274;
    static public final int KEY_OIL__OLIVE__VIRGIN = 261;
    static public final int KEY_OIL__PALM = 257;
    static public final int KEY_OIL__PALM_KERNEL = 258;
    static public final int KEY_OIL__POPPY = 297;
    static public final int KEY_OIL__RAPESEED = 271;
    static public final int KEY_OIL__RICE_BRAN = 36;
    static public final int KEY_OIL__SAFFLOWER = 281;
    static public final int KEY_OIL__SESAME = 290;
    static public final int KEY_OIL__SOYBEAN = 237;
    static public final int KEY_OIL__SUNFLOWER = 268;
    static public final int KEY_OIL__VEGETABLE_ORIGIN_NES = 340;
    static public final int KEY_OILS__FATS_OF_ANIMAL_NES = 1168;
    static public final int KEY_OILSEED_CAKE_MEAL = 1960;
    static public final int KEY_OILSEED_CAKE_NES = 1962;
    static public final int KEY_OILSEEDS = 1899;
    static public final int KEY_OILSEEDS_NES = 339;
    static public final int KEY_OLIVE_OIL_TOTAL = 1999;
    static public final int KEY_OLIVES = 260;
    static public final int KEY_OLIVES_PRESERVED = 262;
    static public final int KEY_ONIONS = 1940;
    static public final int KEY_ONIONS__DRY = 403;
    static public final int KEY_ONIONS__SHALLOTS__GREEN = 402;
    static public final int KEY_ORANGES = 490;
    static public final int KEY_ORANGES_AND_TANG_AND_CLEM = 1949;
    static public final int KEY_OTH_CITRUS_FRT = 1950;
    static public final int KEY_OTHER_MEAT = 2076;
    static public final int KEY_OVINE_MEAT = 2072;
    static public final int KEY_PAPAYAS = 600;
    static public final int KEY_PASTRY = 22;
    static public final int KEY_PEACHES_AND_NECTARINES = 534;
    static public final int KEY_PEANUT_BUTTER = 247;
    static public final int KEY_PEARS = 521;
    static public final int KEY_PEAS__DRY = 187;
    static public final int KEY_PEAS__GREEN = 417;
    static public final int KEY_PEPPER___PIPER_SPP = 687;
    static public final int KEY_PEPPERMINT = 748;
    static public final int KEY_PERSIMMONS = 587;
    static public final int KEY_PET_FOOD = 843;
    static public final int KEY_PIG_MEAT = 2073;
    static public final int KEY_PINEAPPLES = 574;
    static public final int KEY_PINEAPPLES_CANNED = 575;
    static public final int KEY_PISTACHIOS = 223;
    static public final int KEY_PLANTAINS = 489;
    static public final int KEY_PLUMS_AND_SLOES = 536;
    static public final int KEY_PLUMS_DRIED___PRUNES = 537;
    static public final int KEY_POPCORN = 68;
    static public final int KEY_POPPY_SEED = 296;
    static public final int KEY_POTATO_OFFALS = 120;
    static public final int KEY_POTATOES = 116;
    static public final int KEY_POTATOES__FROZEN = 118;
    static public final int KEY_POULTRY_MEAT = 2074;
    static public final int KEY_PULSES = 1954;
    static public final int KEY_PUMPKINS__SQUASH_AND_GOURDS = 394;
    static public final int KEY_PYRETHRUM__DRIED = 754;
    static public final int KEY_PYRETHRUM__EXTRACTION = 755;
    static public final int KEY_QUINCES = 523;
    static public final int KEY_RAISINS = 561;
    static public final int KEY_RAPE_AND_MUSTARD_OILS = 1977;
    static public final int KEY_RAPE_AND_MUSTARD_SEED = 1969;
    static public final int KEY_RAPESEED = 270;
    static public final int KEY_RICE = 1946;
    static public final int KEY_RICE___TOTAL___RICE_MILLED_EQUIVALENT = 30;
    static public final int KEY_RICE__MILLED_PER_HUSKED = 29;
    static public final int KEY_ROOTS_AND_TUBERS__NES = 149;
    static public final int KEY_RUBBER_NATURAL_DRY = 837;
    static public final int KEY_RUBBER__NATURAL = 836;
    static public final int KEY_RYE = 71;
    static public final int KEY_SESAME_SEED = 289;
    static public final int KEY_SILK = 1971;
    static public final int KEY_SILK_RAW = 1186;
    static public final int KEY_SILK_WORM_COCOONS__REELABLE = 1185;
    static public final int KEY_SKINS__CALVE__WET_SALTED = 928;
    static public final int KEY_SKINS__GOAT__FRESH = 1025;
    static public final int KEY_SKINS__GOAT__WET_SALTED = 1026;
    static public final int KEY_SKINS__SHEEP__DRY_SALTED = 997;
    static public final int KEY_SKINS__SHEEP__FRESH = 995;
    static public final int KEY_SKINS__SHEEP__WET_SALTED = 996;
    static public final int KEY_SKINS__SHEEP__WITH_WOOL = 999;
    static public final int KEY_SORGHUM = 83;
    static public final int KEY_SOYA_CURD = 241;
    static public final int KEY_SOYA_PASTE = 240;
    static public final int KEY_SOYA_SAUCE = 239;
    static public final int KEY_SOYBEANS = 236;
    static public final int KEY_SPICES__NES = 723;
    static public final int KEY_SPINACH = 373;
    static public final int KEY_STARCH__CASSAVA = 129;
    static public final int KEY_STRAW_HUSKS = 635;
    static public final int KEY_STRAWBERRIES = 544;
    static public final int KEY_SUGAR_RAW_CENTRIFUGAL = 162;
    static public final int KEY_SUGAR_AND_HONEY = 1890;
    static public final int KEY_SUGAR_BEET = 157;
    static public final int KEY_SUGAR_CONFECTIONERY = 168;
    static public final int KEY_SUGAR_CROPS__NES = 161;
    static public final int KEY_SUGAR_FLAVOURED = 171;
    static public final int KEY_SUGAR_NON_CENTRIFUGAL = 163;
    static public final int KEY_SUGAR_REFINED = 164;
    static public final int KEY_SUGAR__NES = 167;
    static public final int KEY_SUGAR_TOTAL___RAW_EQUIV = 1955;
    static public final int KEY_SUNFLOWER_SEED = 267;
    static public final int KEY_SWEET_CORN_FROZEN = 447;
    static public final int KEY_SWEET_CORN_PREP_OR_PRESERVED = 448;
    static public final int KEY_SWEET_POTATOES = 122;
    static public final int KEY_TALLOW = 1225;
    static public final int KEY_TANGERINES__MANDARINS__CLEMENTINES__SATSUMAS = 495;
    static public final int KEY_TEA = 667;
    static public final int KEY_TEA__MATE_EXTRACTS = 672;
    static public final int KEY_TEXTILE_FIBRES = 1901;
    static public final int KEY_TOBACCO = 1896;
    static public final int KEY_TOBACCO_PRODUCTS_NES = 831;
    static public final int KEY_TOBACCO__UNMANUFACTURED = 826;
    static public final int KEY_TOMATOES = 388;
    static public final int KEY_TOMATOES__PASTE = 391;
    static public final int KEY_TOMATOES__PEELED = 392;
    static public final int KEY_TOTAL_MEAT = 2077;
    static public final int KEY_TOTAL_MERCHANDISE_TRADE = 10;
    static public final int KEY_TRITICALE = 97;
    static public final int KEY_TURNIPS_FOR_FODDER = 646;
    static public final int KEY_VANILLA = 692;
    static public final int KEY_VEGETABLE_TALLOW = 306;
    static public final int KEY_VEGETABLES_IN_VINEGAR = 471;
    static public final int KEY_VEGETABLES__CANNED_NES = 465;
    static public final int KEY_VEGETABLES__DEHYDRATED = 469;
    static public final int KEY_VEGETABLES__DRIED_NES = 464;
    static public final int KEY_VEGETABLES__FRESH_NES = 463;
    static public final int KEY_VEGETABLES__FRESH_OR_DRIED_PRODUCTS_NES = 460;
    static public final int KEY_VEGETABLES__FROZEN = 473;
    static public final int KEY_VEGETABLES__HOMOGENIZED_PREPARATIONS = 476;
    static public final int KEY_VEGETABLES__PRESERVED_NES = 472;
    static public final int KEY_VEGETABLES__PRESERVED__FROZEN = 475;
    static public final int KEY_VEGETABLES__TEMPORARILY_PRESERVED = 474;
    static public final int KEY_VERMOUTHS_AND_SIMILAR = 565;
    static public final int KEY_VETCHES = 205;
    static public final int KEY_VITAMINS = 853;
    static public final int KEY_WAFERS = 110;
    static public final int KEY_WALNUTS__SHELLED = 232;
    static public final int KEY_WALNUTS__WITH_SHELL = 222;
    static public final int KEY_WATERMELONS = 567;
    static public final int KEY_WATERS_ICE_ETC = 631;
    static public final int KEY_WAXES_VEGETABLE = 1296;
    static public final int KEY_WHEAT = 15;
    static public final int KEY_WHEAT_AND_FLOUR_WHEAT_EQUIVALENT = 1945;
    static public final int KEY_WHEY__PRES_AND_CONCEN = 1947;
    static public final int KEY_WHEY__CONDENSED = 890;
    static public final int KEY_WHEY__DRY = 900;
    static public final int KEY_WINE = 564;
    static public final int KEY_WINE_AND_VERMOUTH_AND_SIM = 1966;
    static public final int KEY_WOOL__DEGREASED = 988;
    static public final int KEY_WOOL__GREASY = 987;
    static public final int KEY_WOOL__HAIR_WASTE = 1009;
    static public final int KEY_YOGHURT__CONCENTRATED_OR_NOT = 892;

    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/prod-trade/facts.json?page=1&pageSize=500";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m5910, m5922, m5610, m5622";

    private final HashMap<Integer, FoodProductionValueSet> entries = new HashMap<Integer, FoodProductionValueSet>();


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private Trade(final String jsonString) throws JSONException
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
    static public Trade getFromWeb(final String countryCode, final int year)
            throws IOException, JSONException
        {
	final String webAddress = constructUrl(countryCode, year);
	final String webContent = readWebAddress(webAddress);
	return new Trade(webContent);
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

    public double getTotalExportInTons()
	{
	double result = 0;
	for (final FoodProductionValueSet valueSet : entries.values())
	    {
	    result += valueSet.exportQuantityInTons;

	    }
	return result;
	}


    public double getTotalImportInTons()
	{
	double result = 0;
	for (final FoodProductionValueSet valueSet : entries.values())
	    {
	    result += valueSet.importQuantityInTons;

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
	    stringBuilder.append(entry.getValue().exportQuantityInTons);
	    stringBuilder.append(" | ");

	    stringBuilder.append(entry.getValue().importQuantityInTons);
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
	static public final String KEY_EXPORT_QUANTITY_IN_TONS = "m5910";
	static public final String KEY_EXPORT_VALUE_IN_THOUSAND_US_DOLLAR = "m5922";
	static public final String KEY_IMPORT_QUANTITY_IN_TONS = "m5610";
	static public final String KEY_IMPORT_VALUE_IN_THOUSAND_US_DOLLAR = "m5622";

	// ================================================
	// MEMBER VARIABLES ===============================
	// ================================================
	public final String displayName;
	public final double exportQuantityInTons;
	public final double exportValueInThousandUsDollar;
	public final double importQuantityInTons;
	public final double importValueInThousandUsDollar;


	// ================================================
	// CONSTRUCTOR ====================================
	// ================================================
	public FoodProductionValueSet(final JSONObject entry) throws JSONException
        {
	    displayName = entry.getString(KEY_DISPLAY_NAME);

	    exportQuantityInTons = entry.optDouble(KEY_EXPORT_QUANTITY_IN_TONS,
		    0);
	    exportValueInThousandUsDollar = entry.optDouble(
		    KEY_EXPORT_VALUE_IN_THOUSAND_US_DOLLAR, 0);
	    importQuantityInTons = entry.optDouble(KEY_IMPORT_QUANTITY_IN_TONS,
		    0);
	    importValueInThousandUsDollar = entry.optDouble(
		    KEY_IMPORT_VALUE_IN_THOUSAND_US_DOLLAR, 0);
	    }

	}

    }

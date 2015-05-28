/**
 *
 */
package net.roughdesign.canyoufeedme.models.population;

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
@SuppressWarnings("unused")
public class Population extends Web
    {
    // ================================================
    // Member keys, see:
    // http://data.fao.org/developers/api/v1/en/resources/faostat/pop/item/members.xml?page=1&pageSize=10&fields=mnemonic%2Clabel%40en%2Cproperties.*&sort=label%40en
    // ================================================

    static private final int KEY_RURAL_POPULATION_IN_THOUSANDS = 551;
    static private final int KEY_TOTAL_POPULATION_BOTH_SEXES_IN_THOUSANDS = 511;
    static private final int KEY_TOTAL_POPULATION_FEMALE_IN_THOUSANDS = 513;
    static private final int KEY_TOTAL_POPULATION_MALE_IN_THOUSANDS = 512;
    static private final int KEY_URBAN_POPULATION_IN_THOUSANDS = 561;


    // ================================================
    // CLASS VARIABLES ================================
    // ================================================
    private static final String LINK_BASE = "http://data.fao.org/developers/api/v1/en/resources/faostat/pop/facts.json?page=1&pageSize=200";
    private static final String LINK_FILTER = "&filter=cnt.iso2 eq %s and year eq %d";
    private static final String LINK_FIELDS = "&fields=item, item.bk as item_code, m3010";

    private final HashMap<Integer, PopulationValueSet> entries = new HashMap<>();


    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================
    private Population(final String jsonString) throws JSONException
        {
        Log.w("Population" , jsonString);
        final JSONObject jsonObject = new JSONObject(jsonString);
        final JSONObject result = jsonObject.getJSONObject("result");
        final JSONObject list = result.getJSONObject("list");
        final JSONArray entryArray = list.getJSONArray("items");

        for (int i = 0; i < entryArray.length(); i++)
            {
            final JSONObject entry = entryArray.getJSONObject(i);
            final PopulationValueSet foodValueSet = new PopulationValueSet(
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
    static public Population getFromWeb(final String countryCode,
                                        final int year) throws IOException, JSONException
        {
        final String webAddress = constructUrl(countryCode, year);
        final String webContent = readWebAddress(webAddress);
        return new Population(webContent);
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
        for (final Map.Entry<Integer, PopulationValueSet> entry : entries
                .entrySet())
            {
            stringBuilder.append(entry.getValue().displayName);
            stringBuilder.append(" | ");
            stringBuilder.append(entry.getValue().populationInThousands);
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
    public class PopulationValueSet
        {
        // ================================================
        // Measures, see:
        // http://data.fao.org/developers/api/v1/en/resources/faostat/crop-prod/measures.xml?page=1&pageSize=50&fields=mnemonic%2Clabel%40en&sort=label%40en
        // ================================================
        static public final String KEY_DISPLAY_NAME = "Item";
        static public final String KEY_POPULATION_IN_THOUSANDS = "m3010";

        // ================================================
        // MEMBER VARIABLES ===============================
        // ================================================
        public final String displayName;
        public final double populationInThousands;


        // ================================================
        // CONSTRUCTOR ====================================
        // ================================================
        public PopulationValueSet(final JSONObject entry) throws JSONException
            {
            System.out.println(entry);
            displayName = entry.getString(KEY_DISPLAY_NAME);

            populationInThousands = entry.optDouble(KEY_POPULATION_IN_THOUSANDS, 0);
            }

        }

    }

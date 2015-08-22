package net.roughdesign.ownserverapi;


import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

import net.roughdesign.api.Country;
import net.roughdesign.api.Database;
import net.roughdesign.canyoufeedme.helper.TheCSVHelper;
import net.roughdesign.roughlib.Web;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * Created by Rough on 20/08/2015.
 */
public class OwnServerDatabase implements Database {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "OwnServerDatabase";
    static private final String CSV_PATH_COUNTRY_CODES = "csv/countries.csv";
    static private final String CSV_PATH_COUNTRY_BORDERS = "csv/country_borders.csv";
    static private final String FAO_URL = "http://faostat3.fao.org/faostat-api/rest/procedures/countries/faostat/FBS/E";

    static private OwnServerDatabase instance = null;

    // =============================================================================================
    // Member variables
    // =============================================================================================

    private final List<Country> allCountries = new ArrayList<>();

    // =============================================================================================
    // Constructor
    // =============================================================================================

    private OwnServerDatabase(){

    }

    // =============================================================================================
    // Class methods
    // =============================================================================================

    static public Database get(){
        if (instance == null){
            instance = new OwnServerDatabase();
        }
        return instance;
    }


    // =============================================================================================
    // Overridden methods
    // =============================================================================================


    @Override
    public void prepare(Context context) throws JSONException, IOException {
        createCountries(context);
        downloadFaostatCodes();
    }


    @Override
    public Country getForIsoCode(String code) {
        for (Country country : allCountries)
        {
            if (country.getIsoCode().equals(code))
            {
                return country;
            }
        }
        return null;
    }


    @Override
    public List<Country> getAll() {
        return allCountries;
    }

    // =============================================================================================
    // Member methods
    // =============================================================================================


    private void createCountries(Context context) throws IOException {
        List<List<String>> countryCodeTable = TheCSVHelper.readFromDirectory(context, CSV_PATH_COUNTRY_CODES, true);
        List<List<String>> countryBorderTable = TheCSVHelper.readFromDirectory(context, CSV_PATH_COUNTRY_BORDERS, false);

        for (List<String> codeRow : countryCodeTable) {
            String countryCode = codeRow.get(1);
            String countryName = codeRow.get(0);
            LatLngBounds rectangle = null;

            for (List<String> borderRow : countryBorderTable) {
                if (borderRow.get(2).equals(countryCode)) {
                    double south = Double.parseDouble(borderRow.get(5));
                    double west = Double.parseDouble(borderRow.get(6));
                    double north = Double.parseDouble(borderRow.get(7));
                    double east = Double.parseDouble(borderRow.get(8));
                    LatLng southwest = new LatLng(south, west);
                    LatLng northeast = new LatLng(north, east);
                    rectangle = new LatLngBounds(southwest, northeast);
                }
            }
            allCountries.add(new OwnServerCountry(countryCode, countryName, rectangle));
        }
    }


    private void downloadFaostatCodes() throws JSONException, IOException {
        String webString = Web.get(FAO_URL);
        JSONArray jsonArray = new JSONArray(webString);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray countryData = jsonArray.getJSONArray(i);
            for (Country country : allCountries) {
                if (country.getName().equals(countryData.getString(1))) {
                    ((OwnServerCountry) country).faostatCode = countryData.getString(0);
                }
            }
        }
    }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

}

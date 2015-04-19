package net.roughdesign.canyoufeedme.models.country;

import android.content.Context;

import com.opencsv.CSVReader;

import net.roughdesign.roughlib.database.Manager;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Rough on 13/04/2015.
 */
public class CountryManager extends Manager<Country>
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private String TAG = "CountryManager";
    static private String CSV_PATH = "csv/countries.csv";


    // =============================================================================================
    // Constructor
    // =============================================================================================


    // =============================================================================================
    // Methods
    // =============================================================================================
    public void populateFromCsvFile(Context context) throws IOException
        {
        InputStream inputStream = context.getAssets().open(CSV_PATH);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        CSVReader csvReader = new CSVReader(inputStreamReader);

        String[] nextLine;
        csvReader.readNext();  // Skip header row
        int counter = 0;
        while ((nextLine = csvReader.readNext()) != null)
            {
            counter++;
            Country country = new Country(counter, nextLine[1], nextLine[0]);
            if (country.code.equals("NL") || country.code.equals("CA--"))
                this.models.add(country);
            }
        }


    /**
     * @return The Country with the given country code, or null if none can be found
     */
    public Country getForCountryCode(String countryCode)
        {
        for (Country country : this.models)
            {
            if (country.code.equals(countryCode))
                {
                return country;
                }
            }
        return null;
        }

    }

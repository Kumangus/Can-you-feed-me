package net.roughdesign.canyoufeedme.helper;

import android.content.Context;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Rough on 30/04/2015.
 * Helper class for using the {@link CSVReader}.
 */
public class TheCSVHelper
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CsvReader";

    // =============================================================================================
    // Member variables
    // =============================================================================================

    // =============================================================================================
    // Constructor
    // =============================================================================================


    // =============================================================================================
    // Class methods
    // =============================================================================================
    /**
     * @param skipHeader Should a header row be skipped?
     * @return A List of rows, containing a List of columns.
     * @throws IOException
     */
    static public List<List<String>> readFromDirectory(
            Context context, String path, boolean skipHeader) throws IOException
        {
        InputStream inputStream = context.getAssets().open(path);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        CSVReader csvReader = new CSVReader(inputStreamReader);

        if (skipHeader)
            {
            csvReader.readNext();
            }

        List<List<String>> result = new ArrayList<>();
        String[] nextLine;
        while ((nextLine = csvReader.readNext()) != null)
            {
            result.add(Arrays.asList(nextLine));
            }

        return result;
        }

    // =============================================================================================
    // Overridden methods
    // =============================================================================================

    // =============================================================================================
    // Member methods
    // =============================================================================================

    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

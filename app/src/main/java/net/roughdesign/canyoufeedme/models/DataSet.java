/**
 *
 */
package net.roughdesign.canyoufeedme.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Rough
 *
 */
public class DataSet
    {
    // ================================================
    // CLASS VARIABLES ================================
    // ================================================

    // ================================================
    // MEMBER VARIABLES ===============================
    // ================================================

    // ================================================
    // CONSTRUCTORS ===================================
    // ================================================

    // ================================================
    // OVERRIDES ======================================
    // ================================================

    // ================================================
    // CLASS METHODS ==================================
    // ================================================

    static protected String readWebAddress(final String webAddress)
	    throws IOException
	{
	final URL url = new URL(webAddress);
	final BufferedReader bufferedReader = new BufferedReader(
		new InputStreamReader(url.openStream()));
	final StringBuilder stringBuilder = new StringBuilder();
	String inputLine;
	while ((inputLine = bufferedReader.readLine()) != null)
	    {
	    stringBuilder.append(inputLine);
	    }
	bufferedReader.close();
	return stringBuilder.toString();

	}

    // ================================================
    // MEMBER METHODS =================================
    // ================================================

    // ================================================
    // GETTERS & SETTERS ==============================
    // ================================================

    // ================================================
    // INNER CLASSES ==================================
    // ================================================

    }

/**
 *
 */
package net.roughdesign.roughlib;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;



/**
 * @author Rough
 */
public class Web
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


    /**
     * @return true if an internet connection is available
     */
    static public boolean internetConnectionAvailable(Activity activity)
        {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
        }


    static public String get(final String webAddress) throws IOException
        {
        final URL url = new URL(webAddress);
        InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
        final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String result = readBufferedReader(bufferedReader);
        bufferedReader.close();
        return result;
        }


    static public String getAsBrowser(final String webAddress) throws IOException
        {
        URL url = new URL(webAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setUseCaches(false);

        if (connection.getResponseCode() != 200)
            {
            throw new IOException("Response isoCode is not 200, but " + connection.getResponseCode());
            }

        BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis, "UTF-8"));
        String result = readBufferedReader(bufferedReader);
        bufferedReader.close();
        bis.close();

        return result;
        }


    static public String post(final String webAddress, Map<String, String> parameters) throws IOException
        {
        byte[] postData = formatPOSTParameters(parameters);
        int postDataLength = postData.length;
        URL url = new URL(webAddress);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestProperty("charset", "utf-8");
        connection.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        connection.setUseCaches(false);
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.write(postData);


        if (connection.getResponseCode() != 200)
            {
            throw new IOException("Response isoCode is not 200, but " + connection.getResponseCode());
            }

        BufferedInputStream bis = new BufferedInputStream(connection.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bis, "UTF-8"));
        String result = readBufferedReader(bufferedReader);
        bufferedReader.close();
        bis.close();

        return result;
        }


    static private String readBufferedReader(BufferedReader bufferedReader) throws IOException
        {
        final StringBuilder stringBuilder = new StringBuilder();
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            {
            stringBuilder.append(inputLine);
            }
        return stringBuilder.toString();
        }


    static private byte[] formatPOSTParameters(Map<String, String> parameters)
        {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : parameters.entrySet())
            {
            if (stringBuilder.length() > 0)
                {
                stringBuilder.append('&');
                }
            stringBuilder.append(entry.getKey());
            stringBuilder.append('=');
            stringBuilder.append(entry.getValue());
            }
        return stringBuilder.toString().getBytes(Charset.forName("UTF-8"));
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

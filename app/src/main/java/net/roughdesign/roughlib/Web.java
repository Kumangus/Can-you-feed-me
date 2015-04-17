package net.roughdesign.roughlib;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.AbstractMap;

/**
 * Created by Rough on 16/04/2015.
 */
public class Web
    {

    /**
     * @param URL The webaddress to retrieve
     * @param arguments The URL parameters
     * @return the website content as String
     * @throws IOException
     */
    static public String readWebAddress(String URL,
                                        AbstractMap.SimpleEntry<String, String>... arguments) throws IOException
        {
        final HttpGet httpGet = new HttpGet(URL);
        HttpParams params = new BasicHttpParams();
        for (AbstractMap.SimpleEntry<String, String> entry : arguments)
            {
            params.setParameter(entry.getKey(), entry.getValue());
            }
        httpGet.setParams(params);
        final HttpResponse response = new DefaultHttpClient().execute(httpGet);

        final StringBuilder stringBuilder = new StringBuilder();
        final InputStream inputStream = response.getEntity().getContent();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"), 8);
        String line;
        while ((line = reader.readLine()) != null)
            {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            }
        inputStream.close();

        return stringBuilder.toString();
        }
    }

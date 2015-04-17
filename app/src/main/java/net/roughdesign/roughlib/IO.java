package net.roughdesign.roughlib;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Rough on 14/04/2015.
 */
public class IO
    {
    static public String stringFromFile(Context context, int fileResourceId) throws IOException
        {
        InputStream inputStream = context.getResources().openRawResource(fileResourceId);

        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        return new String(data);
        }


    static public ArrayList<String> readLinesFromStream(InputStream inputStream) throws IOException
        {
        ArrayList<String> result = new ArrayList<String>();

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String line;
        while ((line = bufferedReader.readLine()) != null)
            {
            result.add(line);
            }
        inputStreamReader.close();
        bufferedReader.close();
        return result;
        }


    }

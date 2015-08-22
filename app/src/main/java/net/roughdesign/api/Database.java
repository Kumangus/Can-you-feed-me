package net.roughdesign.api;


import android.content.Context;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;



/**
 * Created by Rough on 20/08/2015.
 */
public interface Database {

    void prepare(Context context) throws JSONException, IOException;

    Country getForIsoCode(String code);

    List<Country> getAll();


}

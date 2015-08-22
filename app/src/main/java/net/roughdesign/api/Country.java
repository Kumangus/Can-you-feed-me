package net.roughdesign.api;


import com.google.android.gms.maps.CameraUpdate;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;



/**
 * Created by Rough on 20/08/2015.
 */
public interface Country {

    /**
     * @return The most accurate CameraUpdate possible with the existing information.
     */
    CameraUpdate getCameraUpdate();

    void downloadData(int year) throws IOException, JSONException;

    List<Integer> getAvailableYears();


    String getName();

    String getIsoCode();

    boolean providesSufficientCalories();

    long getFoodProducedInTons();

    long getFoodImportedInTons();

    long getFoodExportedInTons();

    long getFoodNeededInTons();

    long getFoodBalanceInTons();



    long getAvailableCerealsInTons();

    long getAvailableMeatInTons();

    long getAvailableFishInTons();

    long getAvailableAnimalByproductsInTons();

    long getAvailableNonEssentialsInTons();

    long getAvailableProduceInTons();

    long getAvailableEdibleTotalInTons();


}

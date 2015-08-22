package net.roughdesign.ownserverapi;


import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLngBounds;

import net.roughdesign.api.Country;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;



/**
 * Created by Rough on 20/08/2015.
 */
public class OwnServerCountry implements Country {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "OwnServerCountry";


    // =============================================================================================
    // Member variables
    // =============================================================================================
    public String faostatCode;

    private final String isoCode;
    private final String name;
    private List<Integer> availableYears;
    private OwnServerCountryData data;
    private final LatLngBounds rectangle;

    // =============================================================================================
    // Constructor
    // =============================================================================================


    public OwnServerCountry(String isoCode, String name, LatLngBounds rectangle) {
        this.isoCode = isoCode;
        this.name = name;
        this.rectangle = rectangle;
    }
    // =============================================================================================
    // Class methods
    // =============================================================================================

    // =============================================================================================
    // Overridden methods
    // =============================================================================================


    public String getName() {
        return name;
    }


    public String getIsoCode() {
        return isoCode;
    }


    @Override
    public CameraUpdate getCameraUpdate() {
        if (rectangle == null) {
            //LatLng southWest = new LatLng(-185, -360);
            //LatLng northEast = new LatLng(185, 360);
            //return CameraUpdateFactory.newLatLngBounds(new LatLngBounds(southWest, northEast), 100);
            //return CameraUpdateFactory.newLatLngZoom(new LatLng(0, 0), -50);  // Whole map view
            return CameraUpdateFactory.zoomBy(0);  // "Whole map view doesnt work
        }
        return CameraUpdateFactory.newLatLngBounds(rectangle, 20);
    }


    @Override
    public void downloadData(int year) throws IOException, JSONException {
        data = OwnServerCountryData.download(faostatCode, year);
    }


    @Override
    public List<Integer> getAvailableYears() {
        return availableYears;
    }


    @Override
    public boolean providesSufficientCalories() {
        return data.providesSufficientCalories();
    }


    @Override
    public long getFoodProducedInTons() {
        return data.getFoodProducedInTons();
    }


    @Override
    public long getFoodImportedInTons() {
        return data.getFoodImportedInTons();
    }


    @Override
    public long getFoodExportedInTons() {
        return data.getFoodExportedInTons();
    }


    @Override
    public long getFoodNeededInTons() {
        return data.getFoodNeededInTons();
    }


    @Override
    public long getFoodBalanceInTons() {
        return data.getFoodBalanceInTons();
    }


    @Override
    public long getAvailableCerealsInTons() {
        return data.getAvailableInCategoryInTons(OwnServerCountryData.CATEGORY_CEREALS);
    }


    @Override
    public long getAvailableMeatInTons() {
        return data.getAvailableInCategoryInTons(OwnServerCountryData.CATEGORY_MEAT);
    }


    @Override
    public long getAvailableFishInTons() {
        return data.getAvailableInCategoryInTons(OwnServerCountryData.CATEGORY_FISH);
    }


    @Override
    public long getAvailableAnimalByproductsInTons() {
        return data.getAvailableInCategoryInTons(OwnServerCountryData.CATEGORY_ANIMAL_BYPRODUCTS);
    }


    @Override
    public long getAvailableNonEssentialsInTons() {
        return data.getAvailableInCategoryInTons(OwnServerCountryData.CATEGORY_NON_ESSENTIALS);
    }


    @Override
    public long getAvailableProduceInTons() {
        return data.getAvailableInCategoryInTons(OwnServerCountryData.CATEGORY_PRODUCE);
    }


    @Override
    public long getAvailableEdibleTotalInTons() {
        return data.getAvailableEdibleTotalInTons();
    }


    @Override
    public String toString() {
        return name;
    }


    // =============================================================================================
    // Member methods
    // =============================================================================================

    // =============================================================================================
    // Inner classes
    // =============================================================================================

}

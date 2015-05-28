package net.roughdesign.canyoufeedme.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.CountryData;
import net.roughdesign.canyoufeedme.models.foodbalance.FoodBalance;



public class AssessmentFragment extends AbsCountryDataFragment
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "AssessmentFragment";

    private TextView produced;
    //private TextView imported;
    //private TextView exported;
    private TextView needed;
    private TextView resultView;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
        View result = inflater.inflate(R.layout.fragment_country_data__assessment, container, false);
        assignViews(result);
        return result;
        }


    @Override
    public void onCountryDataRetrieved(CountryData result)
        {
        AssessmentChartFragment chart = (AssessmentChartFragment) getChildFragmentManager()
                .findFragmentById(R.id.country_data__assessment__graphic);
        chart.onCountryDataRetrieved(result);
        produced.setText(result.foodBalance.getEdibleFood().getFoodSupplyInKcalPerPersonPerDay() + "");
        //imported.setText(Long.toString(countryData.getTotalImportInTons()) + " t");
        //exported.setText(Long.toString(countryData.getTotalExportInTons()) + " t");
        needed.setText(FoodBalance.ADVISED_KCAL_PER_PERSON_PER_DAY + "");
        resultView.setText(result.foodBalance.getSurplusOrDeficitInKcalPerPersonPerDay() + "");
        }

    // =============================================================================================
    // Methods
    // =============================================================================================


    private void assignViews(View result)
        {
        produced = (TextView) result.findViewById(R.id.country_data__assessment_produced_value);
        //imported = (TextView)result. findViewById(R.id.country_detail__amount_import_value);
        //exported = (TextView) result.findViewById(R.id.country_detail__amount_exported_value);
        needed = (TextView) result.findViewById(R.id.country_data__assessment_needed_value);
        resultView = (TextView) result.findViewById(R.id.country_data__assessment_result_value);
        }

    }

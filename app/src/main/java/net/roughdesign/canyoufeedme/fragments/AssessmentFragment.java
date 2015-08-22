package net.roughdesign.canyoufeedme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.roughdesign.api.Country;
import net.roughdesign.canyoufeedme.R;



public class AssessmentFragment extends AbsCountryDataFragment {
    // =============================================================================================
    // Variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "AssessmentFragment";

    private TextView produced;
    private TextView imported;
    private TextView exported;
    private TextView needed;
    private TextView resultView;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.fragment_country_data__assessment, container, false);
        Log.e(TAG, "GNOCCI 1: " + result);
        assignViews(result);
        return result;
    }


    @Override
    public void onCountryDataRetrieved(Country result) {

        Fragment debug = getChildFragmentManager()
                .findFragmentById(R.id.country_data__assessment__graphic);
        Log.e(TAG, "PIZZA: " + debug);

        AssessmentChartFragment chart = (AssessmentChartFragment) getChildFragmentManager()
                .findFragmentById(R.id.country_data__assessment__graphic);
        chart.onCountryDataRetrieved(result);
        produced.setText(Long.toString(result.getFoodProducedInTons()) + " t");
        imported.setText(Long.toString(result.getFoodImportedInTons()) + " t");
        exported.setText(Long.toString(result.getFoodExportedInTons()) + " t");
        needed.setText(result.getFoodNeededInTons() + " t");
        resultView.setText(result.getFoodBalanceInTons() + " t");
    }

    // =============================================================================================
    // Methods
    // =============================================================================================


    private void assignViews(View result) {
        produced = (TextView) result.findViewById(R.id.country_data__assessment_produced_value);
        imported = (TextView) result.findViewById(R.id.country_data__assessment_import_value);
        exported = (TextView) result.findViewById(R.id.country_data__assessment_exported_value);
        needed = (TextView) result.findViewById(R.id.country_data__assessment_needed_value);
        resultView = (TextView) result.findViewById(R.id.country_data__assessment_result_value);
    }

}

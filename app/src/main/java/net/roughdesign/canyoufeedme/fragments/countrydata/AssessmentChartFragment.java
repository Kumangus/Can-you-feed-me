package net.roughdesign.canyoufeedme.fragments.countrydata;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.country.CountryData;
import net.roughdesign.canyoufeedme.models.foodbalance.FoodBalance;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;



/**
 * Created by Rough on 02/05/2015.
 * Fragment handling a barchart.
 */
public class AssessmentChartFragment extends Fragment
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "AssessmentChartFragment";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private FrameLayout chartFrame;
    private GraphicalView chartView;

    private XYMultipleSeriesDataset xyDataset = new XYMultipleSeriesDataset();
    private XYMultipleSeriesRenderer xyRenderer = new XYMultipleSeriesRenderer();


    // =============================================================================================
    // Constructor
    // =============================================================================================


    // =============================================================================================
    // Class methods
    // =============================================================================================


    // =============================================================================================
    // Overridden methods
    // =============================================================================================
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
        {
        chartFrame = (FrameLayout) inflater.inflate(R.layout.layout_frame, container);

        return chartFrame;
        }


    @Override
    public void onResume()
        {
        super.onResume();

        if (chartView == null)
            {
            chartView = ChartFactory.getBarChartView(getActivity(),
                    xyDataset, xyRenderer, BarChart.Type.STACKED);
            //defaultRenderer.setClickEnabled(true);
            //defaultRenderer.setSelectableBuffer(10);
            chartFrame.addView(chartView, 0);
            }
        else
            {
            chartView.repaint();
            }
        }

    // =============================================================================================
    // Member methods
    // =============================================================================================


    public void onCountryDataRetrieved(CountryData countryData)
        {
        setupChartData(countryData);
        setupRenderer();
        }


    /**
     * Prepare the data for the chart.
     */
    private void setupChartData(CountryData countryData)
        {
        FoodBalance foodBalance = countryData.foodBalance;
        addValue(1, foodBalance.getEdibleFood().foodSupplyInKcalPerPersonPerDay);
        addValue(2, FoodBalance.ADVISED_KCAL_PER_PERSON_PER_DAY);
        addValue(3, foodBalance.getSurplusOrDeficitInKcalPerPersonPerDay());
        addValue(4, foodBalance.getSurplusOrDeficitInKcalPerPersonPerDay());
        Log.e(TAG, "foodSupplyInKcalPerPersonPerDay" + foodBalance.getEdibleFood().foodSupplyInKcalPerPersonPerDay
        + "ADVISED_KCAL_PER_PERSON_PER_DAY" + FoodBalance.ADVISED_KCAL_PER_PERSON_PER_DAY
        + "getSurplusOrDeficitInKcalPerPersonPerDay" + foodBalance.getSurplusOrDeficitInKcalPerPersonPerDay());
        //addData(3, R.string.country_detail__amount_exported, -countryData.getTotalExportInTons());
        //addData(4, R.string.country_detail__amount_needed, -countryData.getTotalFoodConsumedInTons());
        //addData(5, R.string.country_detail__amount_result, countryData.getEndResultValue());

        //xyRenderer.setXAxisMax(xyRenderer.getSeriesRenderers().length);
        }


    /**
     * DRY method for setupChartData().
     */
    private void addValue(int xPos, double value)
        {
        XYSeries xySeries = new XYSeries("");
        xySeries.add(xPos, value);
        xyDataset.addSeries(xySeries);

        XYSeriesRenderer xySeriesRenderer = new XYSeriesRenderer();
        int[] colours = CanYouFeedMeApp.from(getActivity()).getPrimaryColours();
        xySeriesRenderer.setColor(colours[(xPos - 1) % colours.length]);
        xyRenderer.addSeriesRenderer(xySeriesRenderer);
        }


    /**
     * Set up the options for the chart renderer.
     */
    private void setupRenderer()
        {
        xyRenderer.setShowAxes(false);
        xyRenderer.setShowGrid(true);
        xyRenderer.setShowGridY(false);
        xyRenderer.setShowLegend(false);
        xyRenderer.setZoomEnabled(false);
        xyRenderer.setApplyBackgroundColor(true);


        xyRenderer.setXAxisMax(xyRenderer.getSeriesRenderers().length);
        xyRenderer.setXAxisMin(-1);
        xyRenderer.setBarWidth(100f);
        xyRenderer.setBarSpacing(400);

        xyRenderer.setLabelsTextSize(40);
        xyRenderer.setMargins(new int[]{50, 125, 50, 50});
        xyRenderer.setXLabels(0);
        xyRenderer.setYLabels(5);
        //xyRenderer.setXLabels();

        xyRenderer.setBackgroundColor(getResources().getColor(R.color.cyfm_background_dark));
        xyRenderer.setMarginsColor(getResources().getColor(R.color.cyfm_background_dark));
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

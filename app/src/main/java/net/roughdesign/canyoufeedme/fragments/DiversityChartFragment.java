package net.roughdesign.canyoufeedme.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import net.roughdesign.api.Country;
import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;



/**
 * Created by Rough on 02/05/2015.
 * A Fragment to render the chart in the diversity screen.
 */
public class DiversityChartFragment extends Fragment
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "DiversityChartFragment";

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private FrameLayout chartFrame;
    private GraphicalView chartView;

    private final DefaultRenderer defaultRenderer = new DefaultRenderer();
    private final CategorySeries categorySeries = new CategorySeries("LOL");

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
            chartView = ChartFactory.getPieChartView(getActivity(), categorySeries, defaultRenderer);
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
    public void onCountryDataRetrieved(Country country)
        {
        setupChartData(country);
        setupRenderer();
        }


    /**
     * Prepare the data for the chart.
     */
    private void setupChartData(Country country)
        {
        // TODO reimplement
        addDataItem(R.string.country_data__diversity__fish, country.getAvailableFishInTons());
        addDataItem(R.string.country_data__diversity__meat, country.getAvailableMeatInTons());
        addDataItem(R.string.country_data__diversity__animal_byproducts, country.getAvailableAnimalByproductsInTons());
        addDataItem(R.string.country_data__diversity__cereals, country.getAvailableCerealsInTons());
        addDataItem(R.string.country_data__diversity__produce, country.getAvailableProduceInTons());
        }


    /**
     * DRY method for setupChartData().
     */
    private void addDataItem(int labelResourceId, double value)
        {
        categorySeries.add(getResources().getString(labelResourceId), value);

        SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
        int[] colours = CanYouFeedMeApp.from(getActivity()).getPrimaryColours();
        renderer.setColor(colours[(categorySeries.getItemCount() - 1) % colours.length]);
        defaultRenderer.addSeriesRenderer(renderer);
        }


    private void setupRenderer()
        {
        defaultRenderer.setShowLegend(false);

        defaultRenderer.setChartTitleTextSize(20);
        defaultRenderer.setLabelsTextSize(40);
        defaultRenderer.setLegendTextSize(0);
        defaultRenderer.setMargins(new int[]{20, 30, 15, 0});
        defaultRenderer.setZoomButtonsVisible(true);
        defaultRenderer.setStartAngle(90);

        defaultRenderer.setApplyBackgroundColor(true);
        defaultRenderer.setBackgroundColor(getResources().getColor(R.color.cyfm_background_dark));
        }


    // =============================================================================================
    // Inner classes
    // =============================================================================================

    }

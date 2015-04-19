package net.roughdesign.canyoufeedme.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.countrydata.CountryData;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;

public class CountryDetailDiversityActivity extends FragmentActivity
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "CountryDetailActivity";


    private FrameLayout chartFrame;
    private ProgressBar progressBar;
    private GraphicalView chartView;

    private DefaultRenderer defaultRenderer = new DefaultRenderer();
    private CategorySeries categorySeries = new CategorySeries("LOL");


    // =============================================================================================
    // Methods
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_detail__diversity);

        assignGuiElements();
        setupChartRenderer();
        setupDataSeries(CanYouFeedMeApp.countryData);
        }

    @Override
    protected void onResume()
        {
        super.onResume();
        new Handler().postDelayed(new Runnable()
        {
        public void run()
            {
            updateChartView();
            }
        }, 500);
        }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignGuiElements()
        {
        chartFrame = (FrameLayout) findViewById(R.id.country_detail__diversity_graphic);
        progressBar = (ProgressBar) findViewById(R.id.country_detail__diversity__progress_bar);
        }

    private void setupChartRenderer()
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


    private void setupDataSeries(CountryData countryData)
        {
        addDataItem(R.string.country_detail__diversity_fish, countryData.fish.getAvailablePerPersonPerDay());
        addDataItem(R.string.country_detail__diversity_meat, countryData.animals.getAvailablePerPersonPerDay());
        addDataItem(R.string.country_detail__diversity_animal_byproducts, countryData.animalByProduce.getAvailablePerPersonPerDay());
        addDataItem(R.string.country_detail__diversity_cereals, countryData.cereals.getAvailablePerPersonPerDay());
        addDataItem(R.string.country_detail__diversity_produce, countryData.produce.getAvailablePerPersonPerDay());
        addDataItem(R.string.country_detail__diversity_non_essentials, countryData.nonEssentials.getAvailablePerPersonPerDay());
        }


    private void addDataItem(int labelResourceId, double value)
        {
        categorySeries.add(getResources().getString(labelResourceId), value);

        SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
        int[] colours = CanYouFeedMeApp.from(this).getPrimaryColours();
        renderer.setColor(colours[(categorySeries.getItemCount() - 1) % colours.length]);
        defaultRenderer.addSeriesRenderer(renderer);
        }


    private void updateChartView()
        {
        if (chartView == null)
            {
            chartView = ChartFactory.getPieChartView(this, categorySeries, defaultRenderer);
            progressBar.setVisibility(View.GONE);
            chartFrame.addView(chartView, 0);
            }
        else
            {
            chartView.repaint();
            }
        }

    }

package net.roughdesign.canyoufeedme.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.countrydata.CountryData;

import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

public class CountryDetailAmountActivity extends FragmentActivity
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "CountryDetailAmountA";
    private static int[] COLORS = new int[]{Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.CYAN};

    private FrameLayout chartFrame;
    private GraphicalView chartView;
    private TextView produced;
    private TextView imported;
    private TextView exported;
    private TextView needed;
    private TextView resultView;

    XYMultipleSeriesDataset xyMultipleSeriesDataset = new XYMultipleSeriesDataset();
    XYMultipleSeriesRenderer xyMultipleSeriesRenderer = new XYMultipleSeriesRenderer();


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_detail__amount);

        assignGuiElements();
        populateGuiElements(CanYouFeedMeApp.countryData);
        setupChartRenderer(CanYouFeedMeApp.countryData);
        setupChartData(CanYouFeedMeApp.countryData);
        }

    @Override
    protected void onResume()
        {
        super.onResume();
        updateChartView();
        }

    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignGuiElements()
        {
        chartFrame = (FrameLayout) findViewById(R.id.country_detail__amount_graphic);
        produced = (TextView) findViewById(R.id.country_detail__amount_produced_value);
        imported = (TextView) findViewById(R.id.country_detail__amount_import_value);
        exported = (TextView) findViewById(R.id.country_detail__amount_exported_value);
        needed = (TextView) findViewById(R.id.country_detail__amount_needed_value);
        resultView = (TextView) findViewById(R.id.country_detail__amount_result_value);
        }


    private void populateGuiElements(CountryData countryData)
        {
        // TODO reimplement
        /*produced.setText(Long.toString(countryData.getTotalProductionInTons()) + " t");
        imported.setText(Long.toString(countryData.getTotalImportInTons()) + " t");
        exported.setText(Long.toString(countryData.getTotalExportInTons()) + " t");
        needed.setText(Long.toString(countryData.getTotalFoodConsumedInTons()) + " t");
        resultView.setText(Long.toString(countryData.getEndResultValue()) + " t");*/
        }


    private void setupChartRenderer(CountryData countryData)
        {
        xyMultipleSeriesRenderer.setShowAxes(false);
        xyMultipleSeriesRenderer.setShowGrid(true);
        xyMultipleSeriesRenderer.setShowGridY(false);
        xyMultipleSeriesRenderer.setShowLegend(false);
        xyMultipleSeriesRenderer.setApplyBackgroundColor(true);


        //xyMultipleSeriesRenderer.setXAxisMax(countryData.getFoodDataList().size());
        xyMultipleSeriesRenderer.setXAxisMin(-1);
        xyMultipleSeriesRenderer.setBarWidth(100f);
        xyMultipleSeriesRenderer.setBarSpacing(400);


        xyMultipleSeriesRenderer.setLabelsTextSize(40);
        xyMultipleSeriesRenderer.setMargins(new int[]{50, 125, 50, 50});
        xyMultipleSeriesRenderer.setXLabels(0);
        xyMultipleSeriesRenderer.setYLabels(5);
        //xyMultipleSeriesRenderer.setXLabels();

        xyMultipleSeriesRenderer.setBackgroundColor(getResources().getColor(R.color.cyfm_background_dark));
        xyMultipleSeriesRenderer.setMarginsColor(getResources().getColor(R.color.cyfm_background_dark));
        }


    private void setupChartData(CountryData countryData)
        {
        // TODO reimplement
        /*addData(1, R.string.country_detail__amount_produced, countryData.getTotalProductionInTons());
        addData(2, R.string.country_detail__amount_imported, countryData.getTotalImportInTons());
        addData(3, R.string.country_detail__amount_exported, -countryData.getTotalExportInTons());
        addData(4, R.string.country_detail__amount_needed, -countryData.getTotalFoodConsumedInTons());
        addData(5, R.string.country_detail__amount_result, countryData.getEndResultValue());*/
        }

    private void addData(int xPos, int labelResourceId, double value)
        {
        XYSeries xySeries = new XYSeries(getResources().getString(labelResourceId));
        xySeries.add(xPos, value);
        xyMultipleSeriesDataset.addSeries(xySeries);

        XYSeriesRenderer xySeriesRenderer = new XYSeriesRenderer();
        int[] colours = CanYouFeedMeApp.from(this).getPrimaryColours();
        xySeriesRenderer.setColor(colours[(xPos - 1) % colours.length]);
        xyMultipleSeriesRenderer.addSeriesRenderer(xySeriesRenderer);
        }


    private void updateChartView()
        {
        if (chartView == null)
            {
            chartView = ChartFactory.getBarChartView(this, xyMultipleSeriesDataset, xyMultipleSeriesRenderer, BarChart.Type.STACKED);
            //defaultRenderer.setClickEnabled(true);
            //defaultRenderer.setSelectableBuffer(10);
            chartFrame.addView(chartView, 0);
            }
        else
            {
            chartView.repaint();
            }
        }


    }

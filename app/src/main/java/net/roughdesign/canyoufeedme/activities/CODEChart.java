package net.roughdesign.canyoufeedme.activities;

import android.app.Activity;

/**
 * Created by Rough on 11/04/2015.
 */
public class CODEChart extends Activity
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    /*static private final String TAG = "CountryDetailActivity";
    private static int[] COLORS = new int[]{Color.GREEN, Color.BLUE, Color.MAGENTA, Color.CYAN};

    private CategorySeries series = new CategorySeries("");
    private DefaultRenderer renderer = new DefaultRenderer();
    private GraphicalView chartView;

    private TextView available;
    private TextView consumption;
    private TextView result;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_overview);

        assignViews();
        setupRenderer();






        CountryIdentifier countryIdentifier = new CountryIdentifier();
        countryIdentifier.countryId = 1;
        countryIdentifier.year = 2000;

        new GetCountryDetailsAsyncTask().execute(countryIdentifier);


        try
            {
            String jsonData = stringFromFile(R.raw.example);
            fillSeries(jsonData);

            } catch (IOException e)
            {
            e.printStackTrace();
            } catch (JSONException e)
            {
            e.printStackTrace();
            }
        }

    @Override
    protected void onResume()
        {
        super.onResume();
        if (chartView == null)
            {
            LinearLayout layout = (LinearLayout) findViewById(R.id.chart);
            chartView = ChartFactory.getPieChartView(this, series, renderer);
            renderer.setClickEnabled(true);
            renderer.setSelectableBuffer(10);


            layout.addView(chartView, new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
            }
        else
            {
            chartView.repaint();
            }
        }

    @Override
    public void onBackPressed()
        {
        super.onBackPressed();
        overridePendingTransition(R.anim.country_detail__zoom__in, R.anim.country_detail__zoom__out);
        }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignViews()
        {
        consumption = (TextView) findViewById(R.id.country__consumption);
        available = (TextView) findViewById(R.id.country__available);
        populationFed = (TextView) findViewById(R.id.country__potential);
        imported = (TextView) findViewById(R.id.country__imported);
        exported = (TextView) findViewById(R.id.country__exported);
        }

    private void setupRenderer()
        {
        renderer.setApplyBackgroundColor(true);
        renderer.setBackgroundColor(Color.argb(100, 50, 50, 50));
        renderer.setChartTitleTextSize(20);
        renderer.setLabelsTextSize(15);
        renderer.setLegendTextSize(15);
        renderer.setMargins(new int[]{20, 30, 15, 0});
        renderer.setZoomButtonsVisible(true);
        renderer.setStartAngle(90);
        }


    private String stringFromFile(int fileResourceId) throws IOException
        {
        InputStream inputStream = getResources().openRawResource(fileResourceId);

        byte[] data = new byte[inputStream.available()];
        inputStream.read(data);
        inputStream.close();
        return new String(data);
        }

    private void fillSeries(String jsonString) throws JSONException
        {
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray array = jsonObject.getJSONArray("body");

        for (int i = 0; i < array.length(); i++)
            {
            JSONObject entry = array.getJSONObject(i);
            String category = entry.getString("name");
            double value = entry.getDouble("value");
            series.add(category, value);

            SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();
            renderer.setColor(COLORS[(series.getItemCount() - 1) % COLORS.length]);
            this.renderer.addSeriesRenderer(renderer);
            }

        }

    private class CountryIdentifier
        {
        public int countryId;
        public int year;
        }



    */
    }

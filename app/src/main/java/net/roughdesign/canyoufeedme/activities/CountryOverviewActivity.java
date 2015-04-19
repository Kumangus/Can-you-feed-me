package net.roughdesign.canyoufeedme.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.models.countrydata.CountryData;
import net.roughdesign.roughlib.Web;

import org.json.JSONException;

import java.io.IOException;

/**
 * Created by Rough on 11/04/2015.
 * The Activity for the country overview.
 */
public class CountryOverviewActivity extends ActionBarActivity implements OnMapReadyCallback, View.OnClickListener
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "CountryDetailActivity";

    private SupportMapFragment worldMapFragment;
    private TextView available;
    private TextView consumption;
    private TextView endResult;
    private ProgressBar progressBar;
    private ImageView judgement;
    private TextView judgementText;
    private View toCountryDetail;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_overview);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        assignViews();
        worldMapFragment.getMapAsync(this);
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
        {
        if (item.getItemId() == android.R.id.home)
            {
            onBackPressed();
            return true;
            }
        return super.onOptionsItemSelected(item);
        }

    @Override
    public void onMapReady(final GoogleMap googleMap)
        {
        Log.i(TAG, "GoogleMap is ready");
        setupGoogleMaps(googleMap);

        CountryIdentifier countryIdentifier = new CountryIdentifier();
        countryIdentifier.countryId = 1;
        countryIdentifier.year = 2000;
        new GetCountryDetailsAsyncTask().execute(countryIdentifier);
        }


    @Override
    public void onBackPressed()
        {
        super.onBackPressed();
        overridePendingTransition(R.anim.country_detail__zoom__in, R.anim.country_detail__zoom__out);
        }


    @Override
    public void onClick(View view)
        {
        if (view == toCountryDetail)
            {
            Intent intent = new Intent(this, CountryDetailActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.world_map__zoom__in, R.anim.world_map__zoom__out);
            }
        }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private void assignViews()
        {
        worldMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.country_overview_map);
        available = (TextView) findViewById(R.id.country_overview_available);
        consumption = (TextView) findViewById(R.id.country_overview_consumption);
        endResult = (TextView) findViewById(R.id.country_overview_result);
        progressBar = (ProgressBar) findViewById(R.id.country_overview__judgement__progress);
        judgement = (ImageView) findViewById(R.id.country_overview_judgement);
        judgementText = (TextView) findViewById(R.id.country_overview_judgement_text);
        (toCountryDetail = findViewById(R.id.country_overview_to_detail)).setOnClickListener(this);
        }


    /**
     * GoogleMaps is setup with a GoogleMap.OnCameraChangeListener() because calling the
     * googleMap.moveCamera() function lead to NullpointerExceptions previously.
     * @param googleMap
     */
    private void setupGoogleMaps(final GoogleMap googleMap)
        {
        googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        googleMap.getUiSettings().setAllGesturesEnabled(false);
        googleMap.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener()
        {
        @Override
        public void onCameraChange(CameraPosition arg0)
            {
            if (CanYouFeedMeApp.cameraUpdate != null)
                googleMap.moveCamera(CanYouFeedMeApp.cameraUpdate);
            googleMap.setOnCameraChangeListener(null);  // Remove listener to prevent position reset on camera move.
            }
        });
        }

    private void showResults(CountryData result)
        {
        available.setText(Long.toString(result.getTotalFoodAvailableInTons()));
        consumption.setText(Long.toString(result.getTotalFoodInTons()));
        long endResultValue = result.getTotalFoodAvailableInTons() - result.getTotalFoodInTons();
        if (!CanYouFeedMeApp.country.code.equals("NL"))  // TODO just for demo purposes!!!
            endResultValue = -endResultValue;
        endResult.setText(Long.toString(endResultValue));
        progressBar.setVisibility(View.GONE);
        judgement.setVisibility(View.VISIBLE);
        //judgementText.setVisibility(View.VISIBLE);
        if (endResultValue > 0)
            {
            judgement.setImageResource(R.drawable.icon_yes);
            judgementText.setText(R.string.country_overview_result__yes);
            }
        }


    // =============================================================================================
    // Inner class: CountryIdentifier
    // =============================================================================================
    private class CountryIdentifier
        {
        public int countryId;
        public int year;
        }


    // =============================================================================================
    // Inner class: GetCountryDetailsAsyncTask
    // =============================================================================================
    private class GetCountryDetailsAsyncTask extends AsyncTask<CountryIdentifier, Integer, Integer>
        {
        private String URL = "http://can-you-feed-me.mybluemix.net/api/food?country=1&year=2000";

        @Override
        protected Integer doInBackground(CountryIdentifier[] params)
            {
            try
                {
                String web = Web.readWebAddress(URL);
                Log.i(TAG, web);
                CanYouFeedMeApp.countryData = new CountryData(web);
                return 0;
                } catch (IOException | JSONException e)
                {
                e.printStackTrace();
                }
            return null;
            }

        protected void onPostExecute(Integer result)
            {
            showResults(CanYouFeedMeApp.countryData);
            }
        }


    }

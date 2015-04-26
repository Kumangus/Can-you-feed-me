package net.roughdesign.canyoufeedme.activities;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.dialogs.CountryOverviewYearDialog;
import net.roughdesign.canyoufeedme.models.countrydata.CountryData;

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
    static private final int LOAD_ANIMATOR_ANIMATION = 1;
    static private final int LOAD_ANIMATOR_CONTENT = 0;

    private SupportMapFragment worldMapFragment;
    private TextView countryTitleText;
    private ViewAnimator loadAnimator;
    private TextView available;
    private TextView consumption;
    private TextView endResult;
    private ImageView judgement;
    private View toCountryDetail;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_overview);


        assignViews();
        setupViews();
        worldMapFragment.getMapAsync(this);
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
        {
        getMenuInflater().inflate(R.menu.menu__country_overview, menu);
        return true;
        }



    @Override
    public boolean onOptionsItemSelected(MenuItem item)
        {
        // TODO check this
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home)
            {
            onBackPressed();
            return true;
            }

        if (id == R.id.country_overview__settings__change_year)
            {
            new CountryOverviewYearDialog().show(getSupportFragmentManager(), TAG);
            return true;
            }

        return super.onOptionsItemSelected(item);
        }



    @Override
    public void onMapReady(final GoogleMap googleMap)
        {
        Log.i(TAG, "GoogleMap is ready");
        setupGoogleMaps(googleMap);
        new GetCountryDetailsAsyncTask().execute(0);
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
        countryTitleText = (TextView) findViewById(R.id.country_overview__title__text);
        loadAnimator = (ViewAnimator) findViewById(R.id.country_overview__load_animator);
        available = (TextView) findViewById(R.id.country_overview_available);
        consumption = (TextView) findViewById(R.id.country_overview_needed);
        endResult = (TextView) findViewById(R.id.country_overview_result);
        judgement = (ImageView) findViewById(R.id.country_overview_judgement);
        toCountryDetail = findViewById(R.id.country_overview_to_detail);
        }


    private void setupViews()
        {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        countryTitleText.setText(CanYouFeedMeApp.country.name);
        loadAnimator.setDisplayedChild(LOAD_ANIMATOR_ANIMATION);
        toCountryDetail.setOnClickListener(this);
        }


    /**
     * GoogleMaps is setup with a GoogleMap.OnCameraChangeListener() because calling the
     * googleMap.moveCamera() function lead to NullpointerExceptions previously.
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


    // =============================================================================================
    // Inner class: GetCountryDetailsAsyncTask
    // =============================================================================================
    private class GetCountryDetailsAsyncTask extends AsyncTask<Integer, Integer, Integer>
        {

        @Override
        protected Integer doInBackground(Integer[] params)
            {
            try
                {
                CanYouFeedMeApp.countryData = CountryData.readFromWeb(CanYouFeedMeApp.country.code, CanYouFeedMeApp.year);
                return 0;
                } catch (IOException | JSONException e)
                {
                e.printStackTrace();
                }
            return null;
            }

        protected void onPostExecute(Integer result)
            {
            available.setText(Double.toString(CanYouFeedMeApp.countryData.getKcalPerPersonPerDay()));
            consumption.setText(Long.toString(CanYouFeedMeApp.ADVISED_KCAL_PER_PERSON_PER_DAY));
            double endResultValue = CanYouFeedMeApp.countryData.getKcalPerPersonPerDay() -
                    CanYouFeedMeApp.ADVISED_KCAL_PER_PERSON_PER_DAY;
            endResult.setText(Double.toString(endResultValue));
            if (endResultValue > 0)
                {
                judgement.setImageResource(R.drawable.icon_yes);
                }
            loadAnimator.setDisplayedChild(LOAD_ANIMATOR_CONTENT);
            }
        }


    }

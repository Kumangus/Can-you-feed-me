package net.roughdesign.canyoufeedme.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.asynctasks.GetCountryDataAsyncTask;
import net.roughdesign.canyoufeedme.fragments.countrydata.AbsCountryDataFragment;
import net.roughdesign.canyoufeedme.fragments.countrydata.AssessmentFragment;
import net.roughdesign.canyoufeedme.fragments.countrydata.MapFragment;
import net.roughdesign.canyoufeedme.models.country.Country;
import net.roughdesign.canyoufeedme.models.country.CountryData;

import java.util.ArrayList;



public class CountryDataActivity extends ActionBarActivity implements ViewPager.OnPageChangeListener, GetCountryDataAsyncTask.OnCountryDataRetrievedListener
    {
    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "CountryDataActivity";

    static private final int LOAD_ANIMATOR_ANIMATION = 1;
    static private final int LOAD_ANIMATOR_CONTENT = 0;

    static private final int VIEWPAGER_MAP = 0;
    static private final int VIEWPAGER_ASSESSMENT = 1;
    static private final int VIEWPAGER_PIE_CHART = 2;

    // =============================================================================================
    // Member variables
    // =============================================================================================
    private ViewAnimator loadAnimator;
    private ViewPager viewPager;
    private ImageView toMap;
    private ImageView toAssessment;
    //private ImageView pieChart;


    private final ArrayList<AbsCountryDataFragment> fragments = new ArrayList<>();


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
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_data);

        setupTitle();
        loadAnimator = (ViewAnimator) findViewById(R.id.country_data__loading_animator);
        loadAnimator.setDisplayedChild(LOAD_ANIMATOR_ANIMATION);

        setupViewPager();
        setupToMap();
        setupToAssessment();
        //setupToPieChart();
        loadCountryData();
        }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {

        }


    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position)
        {
        if (position == VIEWPAGER_MAP)
            {
            toMap.getDrawable().setAlpha(100);
            toAssessment.getDrawable().setAlpha(255);
            //pieChart.getDrawable().setAlpha(255);
            }
        else if (position == VIEWPAGER_ASSESSMENT)
            {
            toMap.getDrawable().setAlpha(255);
            toAssessment.getDrawable().setAlpha(100);
            //pieChart.getDrawable().setAlpha(255);
            }
        else if (position == VIEWPAGER_PIE_CHART)
            {
            toMap.getDrawable().setAlpha(255);
            toAssessment.getDrawable().setAlpha(255);
            //pieChart.getDrawable().setAlpha(100);
            }
        }


    @Override
    public void onPageScrollStateChanged(int state)
        {

        }


    @Override
    public void onCountryDataRetrieved(CountryData result)
        {
        loadAnimator.setDisplayedChild(LOAD_ANIMATOR_CONTENT);
        }


    // =============================================================================================
    // Member methods
    // =============================================================================================


    private void setupTitle()
        {
        TextView titleCountry = (TextView) findViewById(R.id.country_data__title__country);
        titleCountry.setText(Country.current.name);
        TextView titleYear = (TextView) findViewById(R.id.country_data__title__year);
        titleYear.setText(Integer.toString(Country.current.year));
        }


    private void setupViewPager()
        {
        fragments.add(new MapFragment());
        fragments.add(new AssessmentFragment());
        // fragments.add(new DiversityFragment());

        viewPager = (ViewPager) findViewById(R.id.country_data__viewpager);
        viewPager.setOnPageChangeListener(this);
        viewPager.setAdapter(new CountryDataAdapter(getSupportFragmentManager()));
        }


    private void setupToMap()
        {
        toMap = (ImageView) findViewById(R.id.country_data__icons__map);
        toMap.setOnClickListener(
                new View.OnClickListener()
                {

                @Override
                public void onClick(View v)
                    {
                    viewPager.setCurrentItem(VIEWPAGER_MAP);
                    toMap.getDrawable().setAlpha(100);
                    toAssessment.getDrawable().setAlpha(255);
                    //pieChart.getDrawable().setAlpha(255);
                    }
                }
        );
        toMap.getDrawable().setAlpha(100);
        }


    private void setupToAssessment()
        {
        toAssessment = (ImageView) findViewById(R.id.country_data__icons__graph);
        toAssessment.setOnClickListener(
                new View.OnClickListener()
                {
                @Override
                public void onClick(View v)
                    {
                    viewPager.setCurrentItem(VIEWPAGER_ASSESSMENT);
                    toMap.getDrawable().setAlpha(255);
                    toAssessment.getDrawable().setAlpha(100);
                    //pieChart.getDrawable().setAlpha(255);
                    }
                }
        );
        }


    /*private void setupToPieChart()
        {
        pieChart = (ImageView) findViewById(R.id.country_data__icons__pie_chart);
        pieChart.setOnClickListener(
                new View.OnClickListener()
                {
                @Override
                public void onClick(View v)
                    {
                    viewPager.setCurrentItem(VIEWPAGER_PIE_CHART);
                    toMap.getDrawable().setAlpha(255);
                    toAssessment.getDrawable().setAlpha(255);
                    pieChart.getDrawable().setAlpha(100);
                    }
                }
        );
        }*/


    private void loadCountryData()
        {
        GetCountryDataAsyncTask asyncTask = new GetCountryDataAsyncTask();
        asyncTask.addListener(this);
        for (AbsCountryDataFragment fragment : fragments)
            {
            asyncTask.addListener(fragment);
            }
        asyncTask.execute(Country.current);
        }

    // =============================================================================================
    // Inner classes
    // =============================================================================================



    private class CountryDataAdapter extends FragmentPagerAdapter
        {
        public CountryDataAdapter(FragmentManager fm)
            {
            super(fm);
            }


        @Override
        public int getCount()
            {
            return fragments.size();
            }


        @Override
        public Fragment getItem(int position)
            {
            return fragments.get(position);
            }

        }
    }

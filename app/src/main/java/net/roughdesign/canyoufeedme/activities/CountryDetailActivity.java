package net.roughdesign.canyoufeedme.activities;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TextView;

import net.roughdesign.canyoufeedme.R;

public class CountryDetailActivity extends TabActivity

    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "CountryDetailActivity";


    // =============================================================================================
    // Methods
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_detail);

        setupTabHost();
        }


    // =============================================================================================
    // Methods
    // =============================================================================================
    private void setupTabHost()
        {
        Resources resources = getResources();
        TabHost tabHost = getTabHost();

        TabHost.TabSpec spec = tabHost.newTabSpec("Amount");
        spec.setIndicator(resources.getString(R.string.country_detail_amount));
        spec.setContent(new Intent(this, CountryDetailAmountActivity.class));
        tabHost.addTab(spec);

        spec = tabHost.newTabSpec("Diversity");
        spec.setIndicator(resources.getString(R.string.country_detail_diversity));
        spec.setContent(new Intent().setClass(this, CountryDetailDiversityActivity.class));
        tabHost.addTab(spec);

        for(int i=0;i<tabHost.getTabWidget().getChildCount();i++)
            {
            TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setTextColor(getResources().getColor(R.color.cyfm_white));
            }
        }



    }

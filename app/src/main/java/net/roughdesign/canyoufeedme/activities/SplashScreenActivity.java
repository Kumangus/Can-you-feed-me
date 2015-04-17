package net.roughdesign.canyoufeedme.activities;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.fragments.NoInternetFragment;
import net.roughdesign.canyoufeedme.models.country.Country;

import java.io.IOException;

/**
 * Created by Rough on 11/04/2015.
 */
public class SplashScreenActivity extends FragmentActivity implements NoInternetFragment.Listener
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "SplashScreenActivity";

    private boolean secondIsOver = false;
    private boolean codeIsDone = false;


    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        startTimer();
        onRetryToGetInternet();
        }

    @Override
    public void onCancelTryingToGetInternet()
        {
        finish();
        }

    @Override
    public void onRetryToGetInternet()
        {
        if (!isConnectedToInternet())
            {
            new NoInternetFragment().setListener(this).show(getSupportFragmentManager(), NoInternetFragment.TAG);
            }
        else
            {
            new PrepareDataAsyncTask().execute();
            }
        }

    // =============================================================================================
    // Methods
    // =============================================================================================
    private void startTimer()
        {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
        public void run()
            {
            secondIsOver = true;
            onTaskDone();
            }
        }, 1000);
        }

    private boolean isConnectedToInternet()
        {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
        }


    private void onTaskDone()
        {
        if(codeIsDone && secondIsOver)
            {
            Intent intent = new Intent(this, WorldMapActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.move_up__in, R.anim.move_up__out);
            finish();
            }
        }

    // =============================================================================================
    // Inner Class: PrepareDataAsyncTask
    // =============================================================================================
    private class PrepareDataAsyncTask extends AsyncTask<Integer, Integer, Integer>
        {

        @Override
        protected Integer doInBackground(Integer... params)
            {
            try
                {
                Country.objects.populateFromCsvFile(SplashScreenActivity.this);
                } catch (IOException e)
                {
                Log.e(TAG, "Issues reading CSV file");
                e.printStackTrace();
                }
            return 0;
            }

        @Override
        protected void onPostExecute(Integer result)
            {
            codeIsDone = true;
            onTaskDone();
            }
        }


    }

package net.roughdesign.canyoufeedme.activities;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.dialogs.NoInternetFragment;
import net.roughdesign.ownserverapi.OwnServerDatabase;
import net.roughdesign.roughlib.Web;

import org.json.JSONException;

import java.io.IOException;



/**
 * Created by Rough on 11/04/2015.
 * The Activity for the first visible screen, which reads the CSV files for countries before it
 * goes on to the next screen.
 */
public class SplashScreenActivity extends FragmentActivity implements NoInternetFragment.Listener {
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        startTimer();
        onRetryToGetInternet();
    }


    @Override
    public void onCancelTryingToGetInternet() {
        finish();
    }


    @Override
    public void onRetryToGetInternet() {
        if (Web.internetConnectionAvailable(this)) {
            new PrepareDataAsyncTask().execute();
        }
        else {
            new NoInternetFragment().setListener(this).show(getSupportFragmentManager(), NoInternetFragment.TAG);
        }
    }


    // =============================================================================================
    // Methods
    // =============================================================================================


    private void startTimer() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                secondIsOver = true;
                onTaskDone();
            }
        }, 1000);
    }


    private void onTaskDone() {
        if (codeIsDone && secondIsOver) {
            Intent intent = new Intent(this, WorldMapActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.move_up__in, R.anim.move_up__out);
            finish();
        }
    }


    // =============================================================================================
    // Inner Class: PrepareDataAsyncTask
    // =============================================================================================
    private class PrepareDataAsyncTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... params) {
            try {
                OwnServerDatabase.get().prepare(SplashScreenActivity.this);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return 0;
        }


        @Override
        protected void onPostExecute(Integer result) {
            codeIsDone = true;
            onTaskDone();
        }
    }


}

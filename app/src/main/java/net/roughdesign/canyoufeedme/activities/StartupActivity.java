package net.roughdesign.canyoufeedme.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import net.roughdesign.canyoufeedme.R;


public class StartupActivity extends Activity
    {

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Intent intent = new Intent(this, SplashScreenActivity.class);
        startActivity(intent);
        finish();
        }

    }

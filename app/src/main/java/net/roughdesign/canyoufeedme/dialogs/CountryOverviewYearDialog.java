package net.roughdesign.canyoufeedme.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import net.roughdesign.canyoufeedme.CanYouFeedMeApp;
import net.roughdesign.canyoufeedme.R;

/**
 * Created by Rough on 11/04/2015.
 */
public class CountryOverviewYearDialog extends DialogFragment
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static private final String TAG = "CountryOverviewYearDial";
    static private final String[] YEARS = new String[]{"2000", "2001", "2002"};


    // =============================================================================================
    // Constructor
    // =============================================================================================
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
        {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.country_overview__dialog__year__title);
        builder.setItems(YEARS, new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int which)
            {
            CanYouFeedMeApp.year = Integer.parseInt(YEARS[which]);
            Intent intent = getActivity().getIntent();
            getActivity().finish();
            startActivity(intent);
            Log.i(TAG, "Year selected: " + CanYouFeedMeApp.year);
            }
        });
        return builder.create();
        }


    // =============================================================================================
    // Variables
    // =============================================================================================

    }

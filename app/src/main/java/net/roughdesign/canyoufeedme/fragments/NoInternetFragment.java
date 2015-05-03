package net.roughdesign.canyoufeedme.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

import net.roughdesign.canyoufeedme.R;


public class NoInternetFragment extends DialogFragment
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static public String TAG = "NoInternetFragment";

    private Listener listener;

    // =============================================================================================
    // Overrides
    // =============================================================================================
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
        {
        if (listener == null)
            {
            Log.e(TAG, "Listener not set!");
            }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_no_internet_message);
        builder.setNegativeButton(R.string.global__cancel, new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int id)
            {
            listener.onCancelTryingToGetInternet();
            }
        });
        builder.setPositiveButton(R.string.dialog_no_internet_positive_button, new DialogInterface.OnClickListener()
                {
                public void onClick(DialogInterface dialog, int id)
                    {
                    listener.onRetryToGetInternet();
                    }
                });
        return builder.create();
        }

    // =============================================================================================
    // Methods
    // =============================================================================================
    public NoInternetFragment setListener(Listener listener)
        {
        this.listener = listener;
        return this;
        }

    // =============================================================================================
    // Inner classes
    // =============================================================================================
    public interface Listener
        {
        public void onCancelTryingToGetInternet();

        public void onRetryToGetInternet();
        }

    }

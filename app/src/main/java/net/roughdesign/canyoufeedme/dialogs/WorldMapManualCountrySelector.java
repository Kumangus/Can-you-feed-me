package net.roughdesign.canyoufeedme.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.ListView;

import net.roughdesign.canyoufeedme.R;

/**
 * Created by Rough on 11/04/2015.
 */
public class WorldMapManualCountrySelector extends DialogFragment
    {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
        {

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //View dialogView = LayoutInflater.from(WorldMapActivity.this).inflate(R.layout.world_map__manual_selection, null);
        /*ListView listView = new ListView(WorldMapActivity.this);


        builder.setView(listView)
        builder.setMessage(R.string.dialog_fire_missiles)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener()
                {
                public void onClick(DialogInterface dialog, int id)
                    {
                    // FIRE ZE MISSILES!
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener()
                {
                public void onClick(DialogInterface dialog, int id)
                    {
                    // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it*/
        return builder.create();
        }

    }

package net.roughdesign.canyoufeedme.dialogs;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import net.roughdesign.canyoufeedme.R;
import net.roughdesign.canyoufeedme.activities.CountryDataActivity;
import net.roughdesign.canyoufeedme.models.country.Country;



/**
 * Created by Rough on 05/05/2015.
 * A dialog to select the year for which to show data.
 */
public class YearSelectorFragment extends DialogFragment
        //implements
        //AdapterViewCompat.OnItemClickListener,
        // GetYearListAsyncTask.OnYearListRetrievedListener
    {

    // =============================================================================================
    // Class variables
    // =============================================================================================
    @SuppressWarnings("unused")
    static private final String TAG = "YearSelectorFragment";


    // =============================================================================================
    // Member variables
    // =============================================================================================

    // =============================================================================================
    // Constructor
    // =============================================================================================

    // =============================================================================================
    // Class methods
    // =============================================================================================


    // =============================================================================================
    // Overridden methods
    // =============================================================================================


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
        {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_year_selector__title);

        YearAdapter yearAdapter = new YearAdapter(Country.current.data.availableYears);
        builder.setSingleChoiceItems(yearAdapter, -1, new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int which)
            {
            String yearString = Country.current.data.availableYears[which];
            Country.current.year = Integer.parseInt(yearString);
            ((CountryDataActivity) getActivity()).loadCountryData();

            //Intent intent = getActivity().getIntent();
            //getActivity().finish();
            //startActivity(intent);
            dismiss();
            }
        });

        return builder.create();
        }


    // =============================================================================================
    // Member methods
    // =============================================================================================


    // =============================================================================================
    // Inner classes
    // =============================================================================================



    private class YearAdapter extends ArrayAdapter<String>
        {

        public YearAdapter(String[] objects)
            {
            super(getActivity(), R.layout.dialog_year_selector__listitem, R.id.year_selector__item__text, objects);
            }


        @Override
        public View getView(int position, View convertView, ViewGroup parent)
            {
            View view = super.getView(position, convertView, parent);
            TextView text1 = (TextView) view.findViewById(R.id.year_selector__item__text);
            text1.setTextColor(getResources().getColor(R.color.cyfm_white));
            return view;
            }
        }
    }

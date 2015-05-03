package net.roughdesign.canyoufeedme.helper;

import android.content.Context;

import net.roughdesign.canyoufeedme.R;

/**
 * Created by Rough on 16/04/2015.
 */
@Deprecated
public class ColourManager
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    private int[] colours = new int[16];


    

    // =============================================================================================
    // Constructor
    // =============================================================================================
    public ColourManager(Context context)
        {
        setupColours(context);
        }

    // =============================================================================================
    // Constants
    // =============================================================================================
    public int getBlack()
        {
        return colours[0];
        }
    /*
    public int get()
        {

        }
    public int get()
        {

        }
    public int get()
        {

        }

    <color name="cyfm_black">#000</color>
    <color name="cyfm_white">#FFF</color>
    <color name="cyfm_background_light">#607D8B</color>
    <color name="cyfm_background_dark">#263238</color>

    <color name="cyfm_red_light">#F44336</color>
    <color name="cyfm_red_dark">#D32F2F</color>

    <color name="cyfm_indigo_light">#3F51B5</color>
    <color name="cyfm_indigo_dark">#303F9F</color>

    <color name="cyfm_yellow_light">#FFEB3B</color>
    <color name="cyfm_yellow_dark">#FBC02D</color>

    <color name="cyfm_orange_light">#Ff5722</color>
    <color name="cyfm_orange_dark">#E64A19</color>

    <color name="cyfm_green_light">#009688</color>
    <color name="cyfm_green_dark">#00796B</color>

    <color name="cyfm_blue_light">#03A9F4</color>
    <color name="cyfm_blue_dark">#0288D1</color>


    
    
    
    public int[] getPrimaryColours(Context context)
        {
        int[] result = new int[6];
        getResources().getColor(R.color.cyfm_indigo_light);
        getResources().getColor(R.color.cyfm_yellow_light);
        getResources().getColor(R.color.cyfm_green_light);
        getResources().getColor(R.color.cyfm_red_light);
        getResources().getColor(R.color.cyfm_blue_light);
        getResources().getColor(R.color.cyfm_orange_light);
        return result;
        }*/
    
    
    private void setupColours(Context context)
        {
        colours[0] = context.getResources().getColor(R.color.cyfm_indigo_light);
        colours[1] = context.getResources().getColor(R.color.cyfm_yellow_light);
        colours[2] = context.getResources().getColor(R.color.cyfm_green_light);
        colours[3] = context.getResources().getColor(R.color.cyfm_red_light);
        colours[4] = context.getResources().getColor(R.color.cyfm_blue_light);
        colours[5] = context.getResources().getColor(R.color.cyfm_orange_light);
        colours[6] = context.getResources().getColor(R.color.cyfm_indigo_light);
        colours[7] = context.getResources().getColor(R.color.cyfm_yellow_light);
        colours[8] = context.getResources().getColor(R.color.cyfm_green_light);
        colours[9] = context.getResources().getColor(R.color.cyfm_red_light);
        colours[10] = context.getResources().getColor(R.color.cyfm_blue_light);
        colours[11] = context.getResources().getColor(R.color.cyfm_orange_light);
        colours[12] = context.getResources().getColor(R.color.cyfm_indigo_light);
        colours[13] = context.getResources().getColor(R.color.cyfm_yellow_light);
        colours[14] = context.getResources().getColor(R.color.cyfm_green_light);
        colours[15] = context.getResources().getColor(R.color.cyfm_red_light);
        }






    // =============================================================================================
    // Constants
    // =============================================================================================


    }

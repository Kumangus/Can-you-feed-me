package net.roughdesign.canyoufeedme.models.country;

import net.roughdesign.roughlib.database.Model;

/**
 * Created by Rough on 13/04/2015.
 */
public class Country extends Model
    {
    // =============================================================================================
    // Variables
    // =============================================================================================
    static public CountryManager objects = new CountryManager();

    // =============================================================================================
    // Model fields
    // =============================================================================================
    public String code;
    public String name;

    // =============================================================================================
    // Constructors
    // =============================================================================================
    public Country(int id, String code, String name)
        {
        super(id);
        this.code = code;
        this.name = name;
        }

    // =============================================================================================
    // Methods
    // =============================================================================================
    @Override
    public String toString()
        {
        return name;
        }

    public void writeToDatabase()
        {

        }

    }

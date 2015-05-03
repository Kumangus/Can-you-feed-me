package net.roughdesign.canyoufeedme.models.OLDSTUFF;

import net.roughdesign.roughlib.database.Model;

/**
 * Created by Rough on 13/04/2015.
 */
@Deprecated
public class OLDCountry extends Model
    {
    // TODO maybe this can be combined with country data - it would be logical at least
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
    public OLDCountry(int id, String code, String name)
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

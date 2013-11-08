package org.sage42.devfest.f.main;

import java.util.Map;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * POJO for the Job Object
 */
public class Job
{
    private static final int    TOTAL_FIELDS   = 6;

    private static final String KEY_BOOKING_ID = "bookingId"; //$NON-NLS-1$
    private static final String KEY_PICK_UP    = "pickUp";   //$NON-NLS-1$
    private static final String KEY_DROP_OFF   = "dropOff";  //$NON-NLS-1$
    private static final String KEY_NAME       = "name";     //$NON-NLS-1$
    private static final String KEY_PHONE      = "phone";    //$NON-NLS-1$
    private static final String KEY_STATUS     = "status";   //$NON-NLS-1$

    public long                 bookingId      = 0l;

    public String               pickUp         = "";         //$NON-NLS-1$

    public String               dropOff        = "";         //$NON-NLS-1$

    public String               name           = "";         //$NON-NLS-1$

    public String               phone          = "";         //$NON-NLS-1$

    public int                  status         = 0;

    public Job()
    {
        super();
    }

    public static boolean isInstance(final String json)
    {
        try
        {
            final JsonParser parser = new JsonParser();
            final JsonElement jsonElement = parser.parse(json);

            // Perform any custom validation
            if ((jsonElement == null) || !jsonElement.isJsonObject())
            {
                return false;
            }

            final JsonObject jsonObject = jsonElement.getAsJsonObject();
            final Set<Map.Entry<String, JsonElement>> members = jsonObject.entrySet();

            if ((members.size() == Job.TOTAL_FIELDS) && jsonObject.has(Job.KEY_BOOKING_ID)
                            && jsonObject.has(Job.KEY_PICK_UP) && jsonObject.has(Job.KEY_DROP_OFF)
                            && jsonObject.has(Job.KEY_NAME) && jsonObject.has(Job.KEY_PHONE)
                            && jsonObject.has(Job.KEY_STATUS))
            {
                return true;
            }

        }
        catch (final JsonSyntaxException e)
        {
            return false;
        }
        catch (final JsonParseException e)
        {
            return false;
        }

        return false;
    }

}

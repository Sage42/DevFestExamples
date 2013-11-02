package org.sage42.devfest.e.main;

import java.util.Map;
import java.util.Set;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

/**
 * POJO for the Job Object
 */
public class Job implements Parcelable
{
    private static final int    TOTAL_FIELDS           = 23;

    private static final String KEY_BOOKING_ID         = "bookingId";  //$NON-NLS-1$
    private static final String KEY_PICK_UP            = "pickUp";     //$NON-NLS-1$
    private static final String KEY_DROP_OFF           = "dropOff";    //$NON-NLS-1$
    private static final String KEY_JOBTIME            = "jobTime";    //$NON-NLS-1$
    private static final String KEY_REMARKS            = "remarks";    //$NON-NLS-1$
    private static final String KEY_PICK_UP_LATITUDE   = "pickUpLat";  //$NON-NLS-1$
    private static final String KEY_PICK_UP_LONGITUDE  = "pickUpLng";  //$NON-NLS-1$
    private static final String KEY_DROP_OFF_LATITUDE  = "dropOffLat"; //$NON-NLS-1$
    private static final String KEY_DROP_OFF_LONGITUDE = "dropOffLng"; //$NON-NLS-1$
    private static final String KEY_SURFACE_TIME       = "surfaceTime"; //$NON-NLS-1$
    private static final String KEY_CLOSE_TIME         = "closeTime";  //$NON-NLS-1$
    private static final String KEY_CONFIRM_TIME       = "confirmTime"; //$NON-NLS-1$
    private static final String KEY_SOURCE             = "source";     //$NON-NLS-1$
    private static final String KEY_NAME               = "name";       //$NON-NLS-1$
    private static final String KEY_PHONE              = "phone";      //$NON-NLS-1$
    private static final String KEY_STATUS             = "status";     //$NON-NLS-1$
    private static final String KEY_FARE_LOWER         = "fareLower";  //$NON-NLS-1$
    private static final String KEY_FARE_UPPER         = "fareUpper";  //$NON-NLS-1$
    private static final String KEY_TIP                = "tip";        //$NON-NLS-1$
    private static final String KEY_COMMISSION         = "commission"; //$NON-NLS-1$
    private static final String KEY_DISTANCE           = "distance";   //$NON-NLS-1$
    private static final String KEY_IMMEDIATE          = "immediate";  //$NON-NLS-1$
    private static final String KEY_TAGS               = "tags";       //$NON-NLS-1$

    public long                 bookingId              = 0l;

    public String               pickUp                 = "";           //$NON-NLS-1$

    public String               dropOff                = "";           //$NON-NLS-1$

    public long                 jobTime                = 0l;

    public String               remarks                = "";           //$NON-NLS-1$

    public double               pickUpLat              = 0d;

    public double               pickUpLng              = 0d;

    public double               dropOffLat             = 0d;

    public double               dropOffLng             = 0d;

    public long                 surfaceTime            = 0l;

    public long                 closeTime              = 0l;

    public long                 confirmTime            = 0l;

    public String               source                 = "";           //$NON-NLS-1$

    public String               name                   = "";           //$NON-NLS-1$

    public String               phone                  = "";           //$NON-NLS-1$

    public int                  status                 = 0;

    public double               fareLower              = 0d;

    public double               fareUpper              = 0d;

    public double               tip                    = 0d;

    public double               commission             = 0d;

    public double               distance               = 0d;

    // 0 = false, 1 for true, default = 1
    public int                  immediate              = 1;

    // list of tags separated by '|'
    public String               tags;

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

            if ((members.size() == TOTAL_FIELDS) && jsonObject.has(Job.KEY_BOOKING_ID)
                            && jsonObject.has(Job.KEY_PICK_UP) && jsonObject.has(Job.KEY_DROP_OFF)
                            && jsonObject.has(Job.KEY_JOBTIME) && jsonObject.has(Job.KEY_REMARKS)
                            && jsonObject.has(Job.KEY_PICK_UP_LATITUDE) && jsonObject.has(Job.KEY_PICK_UP_LONGITUDE)
                            && jsonObject.has(Job.KEY_DROP_OFF_LATITUDE) && jsonObject.has(Job.KEY_DROP_OFF_LONGITUDE)
                            && jsonObject.has(Job.KEY_SURFACE_TIME) && jsonObject.has(Job.KEY_CLOSE_TIME)
                            && jsonObject.has(Job.KEY_CONFIRM_TIME) && jsonObject.has(Job.KEY_SOURCE)
                            && jsonObject.has(Job.KEY_NAME) && jsonObject.has(Job.KEY_PHONE)
                            && jsonObject.has(Job.KEY_STATUS) && jsonObject.has(Job.KEY_FARE_LOWER)
                            && jsonObject.has(Job.KEY_FARE_UPPER) && jsonObject.has(Job.KEY_TIP)
                            && jsonObject.has(Job.KEY_COMMISSION) && jsonObject.has(Job.KEY_DISTANCE)
                            && jsonObject.has(Job.KEY_IMMEDIATE) && jsonObject.has(Job.KEY_TAGS))
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

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + (int) (this.bookingId ^ (this.bookingId >>> 32));
        result = (prime * result) + (int) (this.closeTime ^ (this.closeTime >>> 32));
        long temp;
        temp = Double.doubleToLongBits(this.commission);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + (int) (this.confirmTime ^ (this.confirmTime >>> 32));
        temp = Double.doubleToLongBits(this.distance);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + ((this.dropOff == null) ? 0 : this.dropOff.hashCode());
        temp = Double.doubleToLongBits(this.dropOffLat);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.dropOffLng);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.fareLower);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.fareUpper);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + this.immediate;
        result = (prime * result) + (int) (this.jobTime ^ (this.jobTime >>> 32));
        result = (prime * result) + ((this.name == null) ? 0 : this.name.hashCode());
        result = (prime * result) + ((this.phone == null) ? 0 : this.phone.hashCode());
        result = (prime * result) + ((this.pickUp == null) ? 0 : this.pickUp.hashCode());
        temp = Double.doubleToLongBits(this.pickUpLat);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(this.pickUpLng);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        result = (prime * result) + ((this.remarks == null) ? 0 : this.remarks.hashCode());
        result = (prime * result) + ((this.source == null) ? 0 : this.source.hashCode());
        result = (prime * result) + this.status;
        result = (prime * result) + (int) (this.surfaceTime ^ (this.surfaceTime >>> 32));
        result = (prime * result) + ((this.tags == null) ? 0 : this.tags.hashCode());

        temp = Double.doubleToLongBits(this.tip);
        result = (prime * result) + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(final Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof Job))
        {
            return false;
        }
        final Job other = (Job) obj;
        if (this.bookingId != other.bookingId)
        {
            return false;
        }
        if (this.closeTime != other.closeTime)
        {
            return false;
        }
        if (Double.doubleToLongBits(this.commission) != Double.doubleToLongBits(other.commission))
        {
            return false;
        }
        if (this.confirmTime != other.confirmTime)
        {
            return false;
        }
        if (Double.doubleToLongBits(this.distance) != Double.doubleToLongBits(other.distance))
        {
            return false;
        }
        if (this.dropOff == null)
        {
            if (other.dropOff != null)
            {
                return false;
            }
        }
        else if (!this.dropOff.equals(other.dropOff))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.dropOffLat) != Double.doubleToLongBits(other.dropOffLat))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.dropOffLng) != Double.doubleToLongBits(other.dropOffLng))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.fareLower) != Double.doubleToLongBits(other.fareLower))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.fareUpper) != Double.doubleToLongBits(other.fareUpper))
        {
            return false;
        }
        if (this.immediate != other.immediate)
        {
            return false;
        }
        if (this.jobTime != other.jobTime)
        {
            return false;
        }
        if (this.name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!this.name.equals(other.name))
        {
            return false;
        }
        if (this.phone == null)
        {
            if (other.phone != null)
            {
                return false;
            }
        }
        else if (!this.phone.equals(other.phone))
        {
            return false;
        }
        if (this.pickUp == null)
        {
            if (other.pickUp != null)
            {
                return false;
            }
        }
        else if (!this.pickUp.equals(other.pickUp))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.pickUpLat) != Double.doubleToLongBits(other.pickUpLat))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.pickUpLng) != Double.doubleToLongBits(other.pickUpLng))
        {
            return false;
        }
        if (this.remarks == null)
        {
            if (other.remarks != null)
            {
                return false;
            }
        }
        else if (!this.remarks.equals(other.remarks))
        {
            return false;
        }
        if (this.source == null)
        {
            if (other.source != null)
            {
                return false;
            }
        }
        else if (!this.source.equals(other.source))
        {
            return false;
        }
        if (this.status != other.status)
        {
            return false;
        }
        if (this.surfaceTime != other.surfaceTime)
        {
            return false;
        }
        if (this.tags == null)
        {
            if (other.tags != null)
            {
                return false;
            }
        }
        else if (!this.tags.equals(other.tags))
        {
            return false;
        }
        if (Double.doubleToLongBits(this.tip) != Double.doubleToLongBits(other.tip))
        {
            return false;
        }
        return true;
    }

    Job(final Parcel in)
    {
        super();

        // Order is important here and must match writeToParcel()
        this.bookingId = in.readLong();
        this.pickUp = in.readString();
        this.dropOff = in.readString();
        this.jobTime = in.readLong();
        this.remarks = in.readString();
        this.pickUpLat = in.readDouble();
        this.pickUpLng = in.readDouble();
        this.dropOffLat = in.readDouble();
        this.dropOffLng = in.readDouble();
        this.surfaceTime = in.readLong();
        this.closeTime = in.readLong();
        this.confirmTime = in.readLong();
        this.source = in.readString();
        this.name = in.readString();
        this.phone = in.readString();
        this.status = in.readInt();
        this.fareLower = in.readDouble();
        this.fareUpper = in.readDouble();
        this.tip = in.readDouble();
        this.commission = in.readDouble();
        this.distance = in.readDouble();
        this.immediate = in.readInt();
        this.tags = in.readString();
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags)
    {
        // Order is important here and must match the constructor
        dest.writeLong(this.bookingId);
        dest.writeString(this.pickUp);
        dest.writeString(this.dropOff);
        dest.writeLong(this.jobTime);
        dest.writeString(this.remarks);
        dest.writeDouble(this.pickUpLat);
        dest.writeDouble(this.pickUpLng);
        dest.writeDouble(this.dropOffLat);
        dest.writeDouble(this.dropOffLng);
        dest.writeLong(this.surfaceTime);
        dest.writeLong(this.closeTime);
        dest.writeLong(this.confirmTime);
        dest.writeString(this.source);
        dest.writeString(this.name);
        dest.writeString(this.phone);
        dest.writeInt(this.status);
        dest.writeDouble(this.fareLower);
        dest.writeDouble(this.fareUpper);
        dest.writeDouble(this.tip);
        dest.writeDouble(this.commission);
        dest.writeDouble(this.distance);
        dest.writeInt(this.immediate);
        dest.writeString(this.tags);
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Parcelable.Creator<Job> CREATOR = new Parcelable.Creator<Job>()
                                                        {
                                                            @Override
                                                            public Job createFromParcel(final Parcel in)
                                                            {
                                                                return new Job(in);
                                                            }

                                                            @Override
                                                            public Job[] newArray(final int size)
                                                            {
                                                                return new Job[size];
                                                            }
                                                        };

    @SuppressWarnings("nls")
    @Override
    public String toString()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append("Job [bookingId=");
        builder.append(this.bookingId);
        builder.append(", ");
        if (this.pickUp != null)
        {
            builder.append("pickUp=");
            builder.append(this.pickUp);
            builder.append(", ");
        }
        if (this.dropOff != null)
        {
            builder.append("dropOff=");
            builder.append(this.dropOff);
            builder.append(", ");
        }
        builder.append("jobTime=");
        builder.append(this.jobTime);
        builder.append(", ");
        if (this.remarks != null)
        {
            builder.append("remarks=");
            builder.append(this.remarks);
            builder.append(", ");
        }
        builder.append("pickUpLat=");
        builder.append(this.pickUpLat);
        builder.append(", pickUpLng=");
        builder.append(this.pickUpLng);
        builder.append(", dropOffLat=");
        builder.append(this.dropOffLat);
        builder.append(", dropOffLng=");
        builder.append(this.dropOffLng);
        builder.append(", surfaceTime=");
        builder.append(this.surfaceTime);
        builder.append(", closeTime=");
        builder.append(this.closeTime);
        builder.append(", confirmTime=");
        builder.append(this.confirmTime);
        builder.append(", ");
        if (this.source != null)
        {
            builder.append("source=");
            builder.append(this.source);
            builder.append(", ");
        }
        if (this.name != null)
        {
            builder.append("name=");
            builder.append(this.name);
            builder.append(", ");
        }
        if (this.phone != null)
        {
            builder.append("phone=");
            builder.append(this.phone);
            builder.append(", ");
        }
        builder.append("status=");
        builder.append(this.status);
        builder.append(", fareLower=");
        builder.append(this.fareLower);
        builder.append(", fareUpper=");
        builder.append(this.fareUpper);
        builder.append(", tip=");
        builder.append(this.tip);
        builder.append(", commission=");
        builder.append(this.commission);
        builder.append(", distance=");
        builder.append(this.distance);
        builder.append(", immediate=");
        builder.append(this.immediate);
        builder.append(", ");
        if (this.tags != null)
        {
            builder.append("tags=");
            builder.append(this.tags);
        }
        builder.append("]");
        return builder.toString();
    }

}

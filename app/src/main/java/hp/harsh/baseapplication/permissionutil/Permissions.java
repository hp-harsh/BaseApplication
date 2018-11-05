package hp.harsh.baseapplication.permissionutil;

import android.Manifest;

/**
 * Created by Harsh Patel on 2/23/2017.
 */

public class Permissions {

    public static final String[] GROUP_PERMISSIONS = new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.READ_CALENDAR,
            Manifest.permission.WRITE_CALENDAR,
            Manifest.permission.CAMERA
    };

    public static final String[] CONTACT_PERMISSIONS = new String[]{
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.WRITE_CALENDAR
    };

    public static final String[] RECORD_PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO
    };
}

package jbink.appnapps.jbinkpermission;

import java.util.ArrayList;

/**
 * Created by user on 2016-10-14.
 */
public interface PermissionListener {
    void onPermissionGranted();
    void onPermissionDenied(ArrayList<String> deniedPermission);
}

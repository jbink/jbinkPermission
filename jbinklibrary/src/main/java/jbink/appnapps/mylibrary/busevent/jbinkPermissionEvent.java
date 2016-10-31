package jbink.appnapps.mylibrary.busevent;

import java.util.ArrayList;

/**
 * Created by user on 2016-10-14.
 */
public class jbinkPermissionEvent {
    public boolean permission;
    public ArrayList<String> deniedPermissions;

    public jbinkPermissionEvent(boolean permission, ArrayList<String> deniedPermissions) {
        this.permission = permission;
        this.deniedPermissions = deniedPermissions;
    }

    public boolean hasPermission() {
        return permission;
    }


    public ArrayList<String> getDeniedPermissions() {
        return deniedPermissions;
    }

}

package jbink.appnapps.jbinkpermission;

import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;

import jbink.appnapps.jbinkpermission.util.ObjectUtils;

/**
 * Created by user on 2016-10-14.
 */
public class jbinkPermission {
    private static jbinkInstance instance;

    public jbinkPermission(Context context) {
        instance = new jbinkInstance(context);
    }

    public jbinkPermission setPermissionListener(PermissionListener listener){
        instance.listener = listener;
        return this;
    }

    public jbinkPermission setPermission(String... permission){//가변인수 : 인자가 몇개든 상관없음
        instance.permissions = permission;
        return this;
    }

    public jbinkPermission setRationaleMessage(@StringRes int stringRes){
        if(stringRes <= 0 ){
            throw new IllegalArgumentException("Invalid value for RationaleMessage");
        }
        instance.rationalMessagea = instance.context.getString(stringRes);
        return this;
    }

    public jbinkPermission setDeniedMessage(String denyMessage) {
        instance.denyMessage = denyMessage;
        return this;
    }



    public jbinkPermission setDeniedMessage(@StringRes int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for DeniedMessage");

        instance.denyMessage = instance.context.getString(stringRes);
        return this;
    }


    public jbinkPermission setGotoSettingButton(boolean hasSettingBtn) {
        instance.hasSettingBtn = hasSettingBtn;
        return this;
    }

    public jbinkPermission setGotoSettingButtonText(String rationaleConfirmText) {
        instance.settingButtonText = rationaleConfirmText;
        return this;
    }


    public jbinkPermission setGotoSettingButtonText(@StringRes int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for setGotoSettingButtonText");

        instance.settingButtonText = instance.context.getString(stringRes);
        return this;
    }

    public jbinkPermission setRationaleConfirmText(String rationaleConfirmText) {
        instance.rationaleConfirmText = rationaleConfirmText;
        return this;
    }


    public jbinkPermission setRationaleConfirmText(@StringRes int stringRes) {

        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for RationaleConfirmText");

        instance.rationaleConfirmText = instance.context.getString(stringRes);
        return this;
    }

    public jbinkPermission setDeniedCloseButtonText(String deniedCloseButtonText) {

        instance.deniedCloseButtonText = deniedCloseButtonText;
        return this;
    }

    public jbinkPermission setDeniedCloseButtonText(@StringRes int stringRes) {

        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for DeniedCloseButtonText");

        instance.deniedCloseButtonText = instance.context.getString(stringRes);

        return this;
    }

    public void check(){
        if (instance.listener == null){
            throw new NullPointerException("You must setPermissionListener() on jbinkPermission");
        } else if (ObjectUtils.isEmpty(instance.permissions)) {
            throw new NullPointerException("You must setPermissions() on jbinkPermission");
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            instance.listener.onPermissionGranted();

        } else {
            instance.checkPermissions();
        }
    }

}

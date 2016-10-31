package jbink.appnapps.mylibrary;

import android.content.Context;
import android.content.Intent;

import com.squareup.otto.Subscribe;

import jbink.appnapps.mylibrary.busevent.jbinkBusProvider;
import jbink.appnapps.mylibrary.busevent.jbinkPermissionEvent;


/**
 * Created by user on 2016-10-14.
 */
public class jbinkInstance {
    public PermissionListener listener;
    public String[] permissions;
    public String rationalMessagea;
    public String denyMessage;
    public String settingButtonText;
    public boolean hasSettingBtn = true;

    public String deniedCloseButtonText;
    public String rationaleConfirmText;
    Context context;

    public jbinkInstance(Context context) {
        this.context = context;

        jbinkBusProvider.getInstance().register(this);

        deniedCloseButtonText = context.getString(R.string.jbinkpermission_close);
        rationaleConfirmText = context.getString(R.string.jbinkpermission_confirm);
    }

    public void checkPermissions(){
        Intent intent = new Intent(context, jbinkPermissionActivity.class);
        intent.putExtra(jbinkPermissionActivity.EXTRA_PERMISSIONS, permissions);

        intent.putExtra(jbinkPermissionActivity.EXTRA_RATIONALE_MESSAGE, rationalMessagea);
        intent.putExtra(jbinkPermissionActivity.EXTRA_DENY_MESSAGE, denyMessage);
        intent.putExtra(jbinkPermissionActivity.EXTRA_PACKAGE_NAME, context.getPackageName());
        intent.putExtra(jbinkPermissionActivity.EXTRA_SETTING_BUTTON, hasSettingBtn);
        intent.putExtra(jbinkPermissionActivity.EXTRA_DENIED_DIALOG_CLOSE_TEXT, deniedCloseButtonText);
        intent.putExtra(jbinkPermissionActivity.EXTRA_RATIONALE_CONFIRM_TEXT, rationaleConfirmText);
        intent.putExtra(jbinkPermissionActivity.EXTRA_SETTING_BUTTON_TEXT, settingButtonText);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    @Subscribe
    public void onPermissionResult(jbinkPermissionEvent event){
        if(event.hasPermission()){
            listener.onPermissionGranted();
        }else{
            listener.onPermissionDenied(event.getDeniedPermissions());
        }
        jbinkBusProvider.getInstance().unregister(this);
    }
}

package jbink.appnapps.jbinkpermission.busevent;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

/**
 * Created by user on 2016-10-14.
 */
public class jbinkBusProvider extends Bus{
    private static jbinkBusProvider instance;

    public static jbinkBusProvider getInstance() {
        if(instance == null){
            instance = new jbinkBusProvider();
        }
        return instance;
    }

    private final Handler mHandler = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()){
            super.post(event);
        }else{
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    jbinkBusProvider.getInstance().post(event);
                }
            });
        }
    }
}

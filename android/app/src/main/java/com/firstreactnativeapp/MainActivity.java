package com.firstreactnativeapp;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.firstreactnativeapp.utils.DeviceUtils;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "RNDemo";
    }

    public static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String KEY_BRAND = "brand";
    public static final String KEY_MODEL = "model";

    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new ReactActivityDelegate(this, getMainComponentName()) {
            @Nullable
            @Override
            protected Bundle getLaunchOptions() {
                Bundle bundle = new Bundle();
                bundle.putInt(KEY_SDK_VERSION, DeviceUtils.getSDKVersion());
                bundle.putString(KEY_BRAND, DeviceUtils.getDeviceBrand());
                bundle.putString(KEY_MODEL, DeviceUtils.getModel());
                return bundle;
            }
        };
    }



}

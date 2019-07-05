package com.firstreactnativeapp.module;

import android.os.Build;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by Bruce on 2019/7/4.
 */

public class BuildVersionModule extends ReactContextBaseJavaModule {

  public BuildVersionModule(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  @Override
  public String getName() {
    return BuildVersionModule.class.getName();
  }

  public static final int LOLLIPOP = 21;
  public static final int LOLLIPOP_MR1 = 22;

  @ReactMethod
  public void getAndroidVersion(Callback callback) {
    callback.invoke(Build.VERSION.SDK_INT);
  }

}

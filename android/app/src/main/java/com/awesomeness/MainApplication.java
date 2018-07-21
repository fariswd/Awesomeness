package com.awesomeness;

import android.support.multidex.MultiDexApplication;

import com.facebook.react.ReactPackage;

import java.util.Arrays;
import java.util.List;

// Needed for `react-native link`
// import com.facebook.react.ReactApplication;

import com.facebook.react.ReactNativeHost;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

public class MainApplication extends MultiDexApplication {
  private static CallbackManager mCallbackManager = CallbackManager.Factory.create();
  // Needed for `react-native link`
  public List<ReactPackage> getPackages() {
    
    return Arrays.<ReactPackage>asList(
        // Add your own packages here!
        // TODO: add cool native modules

        // Needed for `react-native link` text search
        // new MainReactPackage(),
    );
  }



  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(

      );
    }
  };
  protected static CallbackManager getCallbackManager() {
    return mCallbackManager;
  }
  @Override
  public void onCreate() {
    super.onCreate();
    // If you want to use AppEventsLogger to log events.
    AppEventsLogger.activateApp(this);
  }

}

package com.awesomeness;

import android.os.Bundle;
import android.content.Intent;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.Nullable;

import com.facebook.react.ReactPackage;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.awesomeness.generated.ExponentBuildConstants;
import host.exp.expoview.ExponentActivity;

public class MainActivity extends ExponentActivity implements PermissionAwareActivity {
  
  @Nullable private PermissionListener mPermissionListener;

  // dont forget to change app.json & constants
  @Override
  public String publishedUrl() {
    return "exp://exp.host/@capungorori/awesomeness";
  }

  @Override
  public String developmentUrl() {
    // return "exp://exp.host/@capungorori/emas"; //staging
    return ExponentBuildConstants.DEVELOPMENT_URL;
  }

  @Override
  public List<String> sdkVersions() {
    return new ArrayList<>(Arrays.asList("20.0.0"));
  }

  @Override
  public List<ReactPackage> reactPackages() {
    return ((MainApplication) getApplication()).getPackages();
  }

  @Override
  public boolean isDebug() {
    return BuildConfig.DEBUG;
  }

  @Override
  public Bundle initialProps(Bundle expBundle) {
    // Add extra initialProps here
    return expBundle;
  }
  
  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    MainApplication.getCallbackManager().onActivityResult(requestCode, resultCode, data);
  }

  // Allow using PermissionsAndroid in react-native-background-location library
    // Didn't work with Expo. See https://github.com/expo/expo/issues/784
    // Copied solution from https://github.com/wix/react-native-navigation/pull/470/files
    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissions(String[] permissions, int requestCode, PermissionListener listener) {
        mPermissionListener = listener;
        requestPermissions(permissions, requestCode);
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (mPermissionListener != null && mPermissionListener.onRequestPermissionsResult(requestCode, permissions, grantResults)) {
            mPermissionListener = null;
        }
    }

}

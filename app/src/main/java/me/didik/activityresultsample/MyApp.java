package me.didik.activityresultsample;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by didik on 12/30/16.
 * M
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        ActiveAndroid.initialize(this);
    }
}

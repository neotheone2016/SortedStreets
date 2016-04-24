package com.example.developer.sortedstreets;

import android.app.Application;

public class SortedStreetsApplication extends Application {

    private static SortedStreetsApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static SortedStreetsApplication getInstance() {
        return sInstance;
    }
}

package com.github.anrimian.viewpagermvpexample;

import android.app.Application;

import com.github.anrimian.viewpagermvpexample.di.Components;


/**
 * Created on 20.10.2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Components.init(getApplicationContext());
    }
}

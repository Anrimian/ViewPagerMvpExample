package com.github.anrimian.viewpagermvpexample.di;


import android.content.Context;


import com.github.anrimian.viewpagermvpexample.di.app.AppComponent;
import com.github.anrimian.viewpagermvpexample.di.app.AppModule;
import com.github.anrimian.viewpagermvpexample.di.app.DaggerAppComponent;
import com.github.anrimian.viewpagermvpexample.di.app.color_mode_screen.ColorModeComponent;

import javax.annotation.Nullable;


/**
 * Created on 11.02.2017.
 */

public class Components {

    private static Components instance;

    private AppComponent appComponent;
    private ColorModeComponent colorModeComponent;

    public static void init(Context appContext) {
        instance = new Components(appContext);
    }

    private static Components getInstance() {
        if (instance == null) {
            throw new IllegalStateException("components must be init first");
        }
        return instance;
    }

    private Components(Context appContext) {
        appComponent = buildAppComponent(appContext);
    }

    public static AppComponent getAppComponent() {
        return getInstance().appComponent;
    }

    public static ColorModeComponent getColorModeComponent() {
        return getInstance().buildColorModeComponent();
    }

    public static void destroyColorModeComponent() {
        getInstance().colorModeComponent = null;
    }

    private ColorModeComponent buildColorModeComponent() {
        if (colorModeComponent == null) {
            colorModeComponent = getAppComponent().colorModeComponent();
        }
        return colorModeComponent;
    }

    private AppComponent buildAppComponent(Context appContext) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(appContext))
                .build();
    }

}

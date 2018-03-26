package com.github.anrimian.viewpagermvpexample.di.app;


import com.github.anrimian.viewpagermvpexample.di.app.color_mode_screen.ColorModeComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created on 11.02.2017.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        SchedulerModule.class
})
public interface AppComponent {

    ColorModeComponent colorModeComponent();
}
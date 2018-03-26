package com.github.anrimian.viewpagermvpexample.di.app;

import android.support.annotation.NonNull;

import java.util.concurrent.Executors;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@Module
public class SchedulerModule {

    public static final String UI_SCHEDULER = "ui_scheduler";

    @Provides
    @NonNull
    @Named(UI_SCHEDULER)
    Scheduler provideUiScheduler() {
        return AndroidSchedulers.mainThread();
    }
}

package com.github.anrimian.viewpagermvpexample.domain.business;

import com.github.anrimian.viewpagermvpexample.domain.models.ColorMode;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

/**
 * Created on 11.03.2018.
 */

public class MainScreenInteractor {

    private BehaviorSubject<ColorMode> colorModeSubject = BehaviorSubject.createDefault(ColorMode.RED);

    public Observable<ColorMode> getColorModeObservable() {
        return colorModeSubject;
    }

    public void setColorMode(ColorMode colorMode) {
        colorModeSubject.onNext(colorMode);
    }
}

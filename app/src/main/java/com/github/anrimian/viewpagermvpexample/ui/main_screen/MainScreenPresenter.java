package com.github.anrimian.viewpagermvpexample.ui.main_screen;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.anrimian.viewpagermvpexample.di.Components;
import com.github.anrimian.viewpagermvpexample.domain.business.MainScreenInteractor;
import com.github.anrimian.viewpagermvpexample.domain.models.ColorMode;

import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created on 11.03.2018.
 */

@InjectViewState
public class MainScreenPresenter extends MvpPresenter<MainScreenView> {

    private MainScreenInteractor mainScreenInteractor;
    private Scheduler uiScheduler;

    private CompositeDisposable presenterDisposable = new CompositeDisposable();

    public MainScreenPresenter(MainScreenInteractor mainScreenInteractor,
                               Scheduler uiScheduler) {
        this.mainScreenInteractor = mainScreenInteractor;
        this.uiScheduler = uiScheduler;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        subscribeOnColorModeChanging();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenterDisposable.dispose();
        Components.destroyColorModeComponent();
    }

    void onRedColorModeButtonClicked() {
        mainScreenInteractor.setColorMode(ColorMode.RED);
    }

    private void subscribeOnColorModeChanging() {
        presenterDisposable.add(mainScreenInteractor.getColorModeObservable()
                .observeOn(uiScheduler)
                .subscribe(this::onColorModeChanged));
    }

    private void onColorModeChanged(ColorMode colorMode) {
        getViewState().showColorMode(colorMode);
    }
}

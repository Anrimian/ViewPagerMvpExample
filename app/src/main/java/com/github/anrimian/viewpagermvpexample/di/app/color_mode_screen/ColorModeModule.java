package com.github.anrimian.viewpagermvpexample.di.app.color_mode_screen;

import com.github.anrimian.viewpagermvpexample.domain.business.MainScreenInteractor;
import com.github.anrimian.viewpagermvpexample.ui.left_tab_screen.LeftTabScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.main_screen.MainScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.main_tab_screen.MainTabScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.right_tab_screen.RightTabScreenPresenter;

import javax.annotation.Nonnull;
import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;

import static com.github.anrimian.viewpagermvpexample.di.app.SchedulerModule.UI_SCHEDULER;

@Module
public class ColorModeModule {

    @Provides
    @Nonnull
    @ColorModeScope
    MainScreenInteractor mainScreenInteractor() {
        return new MainScreenInteractor();
    }

    @Provides
    @Nonnull
    LeftTabScreenPresenter leftTabScreenPresenter(MainScreenInteractor mainScreenInteractor,
                                                  @Named(UI_SCHEDULER) Scheduler uiScheduler) {
        return new LeftTabScreenPresenter(mainScreenInteractor, uiScheduler);
    }

    @Provides
    @Nonnull
    MainScreenPresenter mainScreenPresenter(MainScreenInteractor mainScreenInteractor,
                                               @Named(UI_SCHEDULER) Scheduler uiScheduler) {
        return new MainScreenPresenter(mainScreenInteractor, uiScheduler);
    }

    @Provides
    @Nonnull
    MainTabScreenPresenter mainTabScreenPresenter(MainScreenInteractor mainScreenInteractor,
                                                  @Named(UI_SCHEDULER) Scheduler uiScheduler) {
        return new MainTabScreenPresenter(mainScreenInteractor, uiScheduler);
    }

    @Provides
    @Nonnull
    RightTabScreenPresenter rightTabScreenPresenter(MainScreenInteractor mainScreenInteractor,
                                                   @Named(UI_SCHEDULER) Scheduler uiScheduler) {
        return new RightTabScreenPresenter(mainScreenInteractor, uiScheduler);
    }
}

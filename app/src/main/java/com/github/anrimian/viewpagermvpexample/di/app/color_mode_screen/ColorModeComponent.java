package com.github.anrimian.viewpagermvpexample.di.app.color_mode_screen;

import com.github.anrimian.viewpagermvpexample.ui.left_tab_screen.LeftTabScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.main_screen.MainScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.main_tab_screen.MainTabScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.right_tab_screen.RightTabScreenPresenter;

import dagger.Subcomponent;

@ColorModeScope
@Subcomponent(modules = {
        ColorModeModule.class
})
public interface ColorModeComponent {

    LeftTabScreenPresenter leftTabScreenPresenter();
    MainScreenPresenter mainScreenPresenter();
    MainTabScreenPresenter mainTabScreenPresenter();
    RightTabScreenPresenter rightTabScreenPresenter();
}

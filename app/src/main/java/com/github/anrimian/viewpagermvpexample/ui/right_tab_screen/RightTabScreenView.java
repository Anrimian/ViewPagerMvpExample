package com.github.anrimian.viewpagermvpexample.ui.right_tab_screen;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.github.anrimian.viewpagermvpexample.domain.models.ColorMode;

/**
 * Created on 11.03.2018.
 */

public interface RightTabScreenView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void showColorMode(ColorMode colorMode);
}

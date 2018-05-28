package com.github.anrimian.viewpagermvpexample.ui.right_tab_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.anrimian.viewpagermvpexample.R;
import com.github.anrimian.viewpagermvpexample.di.Components;
import com.github.anrimian.viewpagermvpexample.domain.models.ColorMode;
import com.github.anrimian.viewpagermvpexample.ui.left_tab_screen.LeftTabScreenPresenter;
import com.github.anrimian.viewpagermvpexample.ui.left_tab_screen.LeftTabScreenView;
import com.github.anrimian.viewpagermvpexample.ui.main_tab_screen.MainTabScreenPresenter;

public class RightTabFragment extends MvpAppCompatFragment implements RightTabScreenView{

    @InjectPresenter
    RightTabScreenPresenter presenter;

    private Button btnSwitchToBlue;

    @ProvidePresenter
    RightTabScreenPresenter providePresenter() {
        return Components.getColorModeComponent().rightTabScreenPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_right_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSwitchToBlue = view.findViewById(R.id.btn_switch_to_blue);
        btnSwitchToBlue.setOnClickListener(v -> presenter.onBlueColorModeButtonClicked());
    }

    @Override
    public void showColorMode(ColorMode colorMode) {
        btnSwitchToBlue.setEnabled(colorMode != ColorMode.BLUE);
    }
}

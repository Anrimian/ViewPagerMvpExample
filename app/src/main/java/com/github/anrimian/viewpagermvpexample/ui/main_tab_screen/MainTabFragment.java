package com.github.anrimian.viewpagermvpexample.ui.main_tab_screen;

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

public class MainTabFragment extends MvpAppCompatFragment implements MainTabScreenView {

    @InjectPresenter
    MainTabScreenPresenter presenter;

    private Button btnSwitchToGreen;

    @ProvidePresenter
    MainTabScreenPresenter providePresenter() {
        return Components.getColorModeComponent().mainTabScreenPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSwitchToGreen = view.findViewById(R.id.btn_switch_to_green);
        btnSwitchToGreen.setOnClickListener(v -> presenter.onSwitchToGreenButtonClicked());
    }

    @Override
    public void showColorMode(ColorMode colorMode) {
        btnSwitchToGreen.setEnabled(colorMode != ColorMode.GREEN);
    }
}

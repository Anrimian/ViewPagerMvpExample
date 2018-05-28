package com.github.anrimian.viewpagermvpexample.ui.left_tab_screen;

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

public class LeftTabFragment extends MvpAppCompatFragment implements LeftTabScreenView{

    @InjectPresenter
    LeftTabScreenPresenter presenter;

    private Button btnSwitchToRed;

    @ProvidePresenter
    LeftTabScreenPresenter providePresenter() {
        return Components.getColorModeComponent().leftTabScreenPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_left_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnSwitchToRed = view.findViewById(R.id.btn_switch_to_red);
        btnSwitchToRed.setOnClickListener(v -> presenter.onRedColorModeButtonClicked());
    }

    @Override
    public void showColorMode(ColorMode colorMode) {
        btnSwitchToRed.setEnabled(colorMode != ColorMode.RED);
    }
}

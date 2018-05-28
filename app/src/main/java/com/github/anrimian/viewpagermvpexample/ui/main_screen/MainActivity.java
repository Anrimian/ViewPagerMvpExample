package com.github.anrimian.viewpagermvpexample.ui.main_screen;

import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;
import android.view.WindowManager;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.anrimian.viewpagermvpexample.R;
import com.github.anrimian.viewpagermvpexample.di.Components;
import com.github.anrimian.viewpagermvpexample.domain.models.ColorMode;
import com.github.anrimian.viewpagermvpexample.ui.left_tab_screen.LeftTabFragment;
import com.github.anrimian.viewpagermvpexample.ui.main_tab_screen.MainTabFragment;
import com.github.anrimian.viewpagermvpexample.ui.right_tab_screen.RightTabFragment;
import com.github.anrimian.viewpagermvpexample.ui.utils.view_pager.ViewPagerAdapter;

import static com.github.anrimian.viewpagermvpexample.ui.common.ColorModeUtils.getAccentColor;
import static com.github.anrimian.viewpagermvpexample.ui.common.ColorModeUtils.getPrimaryColor;
import static com.github.anrimian.viewpagermvpexample.ui.common.ColorModeUtils.getPrimaryDarkColor;

public class MainActivity extends MvpAppCompatActivity implements MainScreenView {

    @InjectPresenter
    MainScreenPresenter presenter;

    @ProvidePresenter
    MainScreenPresenter providePresenter() {
        return Components.getColorModeComponent().mainScreenPresenter();
    }

    private Toolbar toolbar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(LeftTabFragment::new, "left tab");
        pagerAdapter.addFragment(MainTabFragment::new, "main tab");
        pagerAdapter.addFragment(RightTabFragment::new, "right tab");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void showColorMode(ColorMode colorMode) {
        toolbar.setSubtitle("Selected color mode: " + colorMode.toString().toLowerCase());
        int backgroundColor = ContextCompat.getColor(this, getPrimaryColor(colorMode));
        toolbar.setBackgroundColor(backgroundColor);
        tabLayout.setBackgroundColor(backgroundColor);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        int statusBarColor = ContextCompat.getColor(this, getPrimaryDarkColor(colorMode));
        window.setStatusBarColor(statusBarColor);

        int accentColor = ContextCompat.getColor(this, getAccentColor(colorMode));
        tabLayout.setSelectedTabIndicatorColor(accentColor);
    }
}

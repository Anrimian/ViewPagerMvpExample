package com.github.anrimian.viewpagermvpexample.ui.main_screen;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.anrimian.viewpagermvpexample.R;
import com.github.anrimian.viewpagermvpexample.ui.left_tab_screen.LeftTabFragment;
import com.github.anrimian.viewpagermvpexample.ui.main_tab_screen.MainTabFragment;
import com.github.anrimian.viewpagermvpexample.ui.right_tab_screen.RightTabFragment;
import com.github.anrimian.viewpagermvpexample.ui.utils.view_pager.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pagerAdapter.addFragment(LeftTabFragment::new, "left tab");
        pagerAdapter.addFragment(MainTabFragment::new, "main tab");
        pagerAdapter.addFragment(RightTabFragment::new, "right tab");
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

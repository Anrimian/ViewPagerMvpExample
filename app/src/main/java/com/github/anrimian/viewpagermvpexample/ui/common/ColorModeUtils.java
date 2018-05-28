package com.github.anrimian.viewpagermvpexample.ui.common;

import android.content.Context;

import com.github.anrimian.viewpagermvpexample.R;
import com.github.anrimian.viewpagermvpexample.domain.models.ColorMode;

public class ColorModeUtils {

    public static int getPrimaryColor(ColorMode colorMode) {
        switch (colorMode) {
            case RED: return R.color.colorPrimaryRed;
            case BLUE: return R.color.colorPrimaryBlue;
            case GREEN: return R.color.colorPrimaryGreen;
            default: throw new IllegalStateException("unexpected color mode: " + colorMode);
        }
    }

    public static int getPrimaryDarkColor(ColorMode colorMode) {
        switch (colorMode) {
            case RED: return R.color.colorPrimaryDarkRed;
            case BLUE: return R.color.colorPrimaryDarkBlue;
            case GREEN: return R.color.colorPrimaryDarkGreen;
            default: throw new IllegalStateException("unexpected color mode: " + colorMode);
        }
    }

    public static int getAccentColor(ColorMode colorMode) {
        switch (colorMode) {
            case RED: return R.color.colorAccentRed;
            case BLUE: return R.color.colorAccentBlue;
            case GREEN: return R.color.colorAccentGreen;
            default: throw new IllegalStateException("unexpected color mode: " + colorMode);
        }
    }
}

package com.infosys.demo;

import android.content.res.AssetManager;
import android.graphics.Typeface;

public class CustomFont {


    public static final String ROBOTO_BOLD = "fonts/Roboto-Medium.ttf";
    public static final String RUBIK_REGULAR = "fonts/Roboto-Regular.ttf";
    public static final String DROID_KUFL_REGULAR = "fonts/DroidKufi-Regular.ttf";
    public static final String DROID_KUFL_BOLD = "fonts/DroidKufi-Bold.ttf";

    public static Typeface getTypeface(AssetManager assetManager, String type) {
        return Typeface.createFromAsset(assetManager, type);
    }
}

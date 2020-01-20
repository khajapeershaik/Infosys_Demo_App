package com.infosys.demo;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;


public class CustomTextView extends AppCompatTextView {

    private Typeface mTypeface = null;


    public CustomTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }



    private void applyCustomFont(Context context) {
        if (!isInEditMode()) {
                setTypeface(CustomFont.getTypeface(getContext().getAssets(), CustomFont.DROID_KUFL_REGULAR));

        }
    }
}

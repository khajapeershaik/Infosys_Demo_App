package com.infosys.demo;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;


public class CustomBoldTextView extends AppCompatTextView {

    private Typeface mTypeface = null;


    public CustomBoldTextView(Context context) {
        super(context);

        applyCustomFont(context);
    }

    public CustomBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);
    }

    public CustomBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    @TargetApi(21)
    public CustomBoldTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        if (!isInEditMode()) {
                setTypeface(CustomFont.getTypeface(getContext().getAssets(), CustomFont.DROID_KUFL_BOLD));

        }
    }
}
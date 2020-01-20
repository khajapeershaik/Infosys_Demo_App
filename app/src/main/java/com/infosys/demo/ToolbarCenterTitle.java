package com.infosys.demo;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.ImageView;

import androidx.annotation.StringRes;
import androidx.appcompat.widget.Toolbar;


public class ToolbarCenterTitle extends Toolbar {

    CustomTextView toolbarTitle;

    public ToolbarCenterTitle(Context context) {
        super(context);
        init(context, null);
    }

    public ToolbarCenterTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ToolbarCenterTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        final TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.custom_toolbar, 0, 0);
        final ColorStateList titleColor = a.getColorStateList(R.styleable.custom_toolbar_title_color);
        int backArrowResourceId;
            backArrowResourceId = a.getResourceId(R.styleable.custom_toolbar_navigation_icon, R.drawable.ic_blue_back);


        setNavigationIcon(backArrowResourceId);

        toolbarTitle = (CustomTextView) inflate(context, R.layout.custom_text_view_centered, null);


        final LayoutParams params = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT, Gravity.CENTER);

        toolbarTitle.setLayoutParams(params);

        addView(toolbarTitle);
    }

    public void setTitleTextColor(int titleTextColor) {
        if (toolbarTitle != null) {
            toolbarTitle.setTextColor(titleTextColor);
        }
    }

    @Override
    public void setTitle(CharSequence title) {
        if (toolbarTitle != null) {
            toolbarTitle.setText(title);
        }
    }

    @Override
    public void setTitle(@StringRes int resId) {
        setTitle(getContext().getText(resId));
    }
}


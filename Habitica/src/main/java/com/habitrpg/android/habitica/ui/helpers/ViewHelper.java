package com.habitrpg.android.habitica.ui.helpers;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class ViewHelper {

    public static void SetBackgroundTint(Button b, int tint) {
        ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{tint});

        if (b instanceof AppCompatButton) {
            AppCompatButton compatButton = (AppCompatButton) b;

            compatButton.setSupportBackgroundTintList(csl);

            return;
        }

        if (android.os.Build.VERSION.SDK_INT >= 21) {
            SetBackgroundTintV21(b, tint);
        }
    }

    @TargetApi(21)
    public static void SetBackgroundTintV21(Button b, int tint) {

        ColorStateList csl = new ColorStateList(new int[][]{new int[0]}, new int[]{tint});

        b.setBackgroundTintList(csl);
    }

    public static void SetBackgroundTint(View v, int tint) {
        v.getBackground().setColorFilter(tint, PorterDuff.Mode.SRC_OVER);
    }

    public static void SetBackgroundTint(CheckBox c, int tint) {
        if (c != null) {
            c.setBackgroundColor(tint);
        }
    }

    public static void SetBackground(View v, Drawable d) {
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            setBackgroundV16Plus(v, d);
        } else {
            setBackgroundV16Minus(v, d);
        }
    }

    @TargetApi(16)
    private static void setBackgroundV16Plus(View view, Drawable drawable) {
        view.setBackground(drawable);

    }

    @SuppressWarnings("deprecation")
    private static void setBackgroundV16Minus(View view, Drawable drawable) {
        view.setBackgroundDrawable(drawable);
    }

}

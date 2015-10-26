package com.framgia.app.customtypeface;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A Utility class which provides functionality for doing common operations on one or more
 * {@link View} or {@link android.view.ViewGroup} e.g. setting the {@link android.graphics.Typeface}.
 */
public class ViewUtils {
    private static boolean DO_SUBPIXEL_RENDERING = true;

    /**
     * Sets the {@link Typeface} <code> typeFace</code> for all{@link TextView}'s in the view-hierarchy of {@link ViewGroup}<code>parent<code/>
     *
     * @param typeFace
     * @param parent
     */
    public static void setTypeFace(Typeface typeFace, ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View v = parent.getChildAt(i);
            if (v instanceof ViewGroup) {
                setTypeFace(typeFace, (ViewGroup) v);
            } else if (v instanceof TextView) {
                TextView tv = (TextView) v;
                if (DO_SUBPIXEL_RENDERING) {
                    tv.setPaintFlags(tv.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
                }
                tv.setTypeface(typeFace);
            }
        }
    }

    /**
     * @param typeFace
     * @param views
     * @see ViewUtil#setTypeFace(Typeface, ViewGroup)
     * <p/>
     * Sets the type face for n-views, but NOT for their children.
     */
    public static void setTypeFace(Typeface typeFace, TextView... views) {
        for (TextView view : views) {
            view.setTypeface(typeFace);
            if (DO_SUBPIXEL_RENDERING) {
                System.out.println("do subpixel rendering");
                view.setPaintFlags(view.getPaintFlags() | Paint.SUBPIXEL_TEXT_FLAG);
            }
        }
    }

    /**
     * Sets visibility of n{@link View}<code>views</code> to {@link View#VISIBLE}
     *
     * @param views
     */
    public static void showViews(View... views) {
        setViewVisibility(View.VISIBLE, views);
    }

    /**
     * Sets visibility of n{@link View}<code>vies</code> to{@link View#GONE}
     *
     * @param views
     */
    public static void hideViews(View... views) {
        setViewVisibility(View.GONE, views);
    }

    /**
     * Sets visibility of n{@link View} <code>views</code> to {@link View#INVISIBLE}
     *
     * @param views
     */

    public static void setShowViewsInvisible(View... views) {
        setViewVisibility(View.INVISIBLE, views);
    }

    /**
     * @param visibility {@link View#GONE}, {@link View#VISIBLE}, {@link View#INVISIBLE}
     * @param views
     */
    public static void setViewVisibility(int visibility, View... views) {
        for (View v : views) {
            v.setVisibility(visibility);
        }
    }

    public static void setOnClickListenerForViews(View.OnClickListener onClickListener, View... views) {
        for (View view : views) {
            view.setOnClickListener(onClickListener);
        }
    }

    public static void setDoSubpixelRendering(boolean enabled) {
        DO_SUBPIXEL_RENDERING = enabled;
    }

}

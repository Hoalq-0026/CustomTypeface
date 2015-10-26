package com.framgia.app.customtypeface;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author HoaLeQuang
 * @since 2015/10/26
 */
public class CustomTypefaceActivity extends Activity {
    private static final boolean USE_CUSTOM_TYPEFACE = true;
    private static final boolean USE_SUBPIXEL_TEXT_FLAG = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_typeface);

        MyApplication app = (MyApplication) getApplication();

        final Typeface typeface = app.getCustomTypeface();

        // Sub-pixel on
        TextView subpixelOn = (TextView) findViewById(R.id.subpixel_on);
        subpixelOn.setTypeface(typeface);
        subpixelOn.setPaintFlags(Paint.SUBPIXEL_TEXT_FLAG);

        // Sub-pixel off
        TextView subpixelOff = (TextView) findViewById(R.id.subpixel_off);
        subpixelOff.setTypeface(typeface);

        // Sub-pixel mix
        TextView subpixelMix = (TextView) findViewById(R.id.subpixel_mix);
        subpixelMix.setTypeface(typeface);
        final int originalPaintFlags = subpixelMix.getPaintFlags();
        subpixelMix.setPaintFlags( originalPaintFlags | Paint.SUBPIXEL_TEXT_FLAG);

    }
}

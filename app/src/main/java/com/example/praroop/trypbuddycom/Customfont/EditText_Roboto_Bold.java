package com.example.praroop.trypbuddycom.Customfont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class EditText_Roboto_Bold extends android.support.v7.widget.AppCompatEditText {

    public EditText_Roboto_Bold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditText_Roboto_Bold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditText_Roboto_Bold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Roboto-Bold.ttf");
            setTypeface(tf);
        }
    }

}
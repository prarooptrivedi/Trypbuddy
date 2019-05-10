package com.example.praroop.trypbuddycom.Customfont;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

@SuppressLint("AppCompatCustomView")
public class EditTextRobotoRegular extends EditText {
    public EditTextRobotoRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextRobotoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextRobotoRegular(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "Roboto-Regular.ttf");
            setTypeface(tf);
        }
    }

}

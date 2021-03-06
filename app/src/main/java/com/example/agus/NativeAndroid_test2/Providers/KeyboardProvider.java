package com.example.agus.NativeAndroid_test2.Providers;

import android.app.Activity;
import android.content.Context;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by agus on 01/09/17.
 */

public class KeyboardProvider
{

    private static KeyboardProvider instance = null;
    protected KeyboardProvider() {}
    public static KeyboardProvider getInstance()
    {
        if(instance == null)
            instance = new KeyboardProvider();
        return instance;
    }

    public static void showKeyboard(Context context)
    {
        ((InputMethodManager) (context).getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
    }

    public static void hideKeyboard(Context context)
    {
        try
        {
            ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
            if ((((Activity) context).getCurrentFocus() != null) && (((Activity) context).getCurrentFocus().getWindowToken() != null))
            {
                ((InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(((Activity) context).getCurrentFocus().getWindowToken(), 0);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

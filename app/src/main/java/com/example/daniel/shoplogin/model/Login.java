package com.example.daniel.shoplogin.model;

import android.databinding.BindingConversion;
import android.databinding.ObservableBoolean;
import android.view.View;

public class Login {

    public final ObservableBoolean setAutoLogin = new ObservableBoolean();

    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }


}

package com.example.daniel.shoplogin.model;

import android.database.Observable;
import android.databinding.BindingConversion;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableChar;
import android.databinding.ObservableField;
import android.view.View;

public class Login {

    public final ObservableBoolean setAutoLogin = new ObservableBoolean();

    public final ObservableField<String> loginStatus = new ObservableField<>();



    @BindingConversion
    public static int convertBooleanToVisibility(boolean visible) {
        return visible ? View.VISIBLE : View.GONE;
    }


}

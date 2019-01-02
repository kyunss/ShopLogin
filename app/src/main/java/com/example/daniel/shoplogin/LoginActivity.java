package com.example.daniel.shoplogin;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.daniel.shoplogin.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();
    private ActivityLoginBinding mBinding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this , R.layout.activity_login);

    }

    public void onLoginButtonClicked(View view) {
        Log.d(TAG , "LoginButtonClicked");
    }
}

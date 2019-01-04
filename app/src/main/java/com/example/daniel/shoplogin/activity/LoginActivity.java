package com.example.daniel.shoplogin.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.daniel.shoplogin.R;
import com.example.daniel.shoplogin.databinding.ActivityLoginBinding;
import com.example.daniel.shoplogin.model.Login;
import com.example.daniel.shoplogin.util.MyPreference;


public class LoginActivity extends AppCompatActivity {

    private final String TAG = getClass().getName();
    private ActivityLoginBinding mBinding = null;
    private Login loginModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loginModel = new Login();

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        mBinding.setLogin(loginModel);
        mBinding.setActivity(this);

        //약관 동의 여부
        if (MyPreference.getAutoLoginValue(LoginActivity.this))
            loginModel.setAutoLoginView.set(true);
        else
            loginModel.setAutoLoginView.set(false);

    }

    public void onLoginButtonClicked(View view) {

        //기존 사용자인 경우
        if (MyPreference.getAutoLoginValue(LoginActivity.this)) {

            login();

        } else {
            //처음 로그인하는 경우
            if (mBinding.checkboxAutoLogin.isChecked()) {

                login();

            } else {
                Toast.makeText(LoginActivity.this, getString(R.string.msg_uncheck_term), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void login() {

        String id = mBinding.etId.getText().toString();
        String password = mBinding.etPw.getText().toString();

        if (!id.isEmpty() && !password.isEmpty()) {

            mBinding.tvCenter.setText(getString(R.string.center_text_login_ing));
            mBinding.tvMsg2.setVisibility(View.INVISIBLE);
            mBinding.btnLogin.setText("");
            mBinding.progressBar.bringToFront();
            mBinding.progressBar.setVisibility(View.VISIBLE);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    //자동 로그인 설정
                    if (!MyPreference.getAutoLoginValue(LoginActivity.this)){
                        MyPreference.putAutoLoginValue(LoginActivity.this, true);
                        loginModel.setAutoLoginView.set(true);
                    }

                    mBinding.tvCenter.setText(getString(R.string.center_text_login_success));
                    mBinding.progressBar.setVisibility(View.GONE);
                    mBinding.btnLogin.setText(getString(R.string.login_button));

                }
            }, 5000);

        } else {
            Toast.makeText(LoginActivity.this, getString(R.string.msg_empty_id_pw), Toast.LENGTH_SHORT).show();
        }
    }
}

package com.example.daniel.shoplogin.activity;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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
    private boolean isCheckButtonSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        loginModel = new Login();
        loginModel.setAutoLogin.set(true);

        mBinding.setLogin(loginModel);
        mBinding.setActivity(this);

        //약관에 동의한 경우
        if (MyPreference.getAutoLoginValue(LoginActivity.this)) {
            loginModel.setAutoLogin.set(true);
//            mBinding.viewLogin.setVisibility(View.GONE);
//            mBinding.btnAutoLoginTerms.setVisibility(View.VISIBLE);
        } else {
            loginModel.setAutoLogin.set(false);
//            mBinding.viewLogin.setVisibility(View.VISIBLE);
//            mBinding.btnAutoLoginTerms.setVisibility(View.GONE);
        }
    }

    public void onCheckButtonClicked(View view){
        if(isCheckButtonSelected){
            isCheckButtonSelected = false;
//            mBinding.btnCheck.setImageResource(R.drawable.unchecked_normal);
        }
        else{
            isCheckButtonSelected = true;
//            mBinding.btnCheck.setImageResource(R.drawable.checked_pressed);

        }


        Log.d(TAG , "isPressed : " + view.isPressed());
        Log.d(TAG , "isSelected : " + view.isSelected());

    }

    public void onLoginButtonClicked(View view) {
        Log.d(TAG, "LoginButtonClicked");

        /** 약관 동의 여부 확인 **/
        boolean isAutoLogin = MyPreference.getAutoLoginValue(LoginActivity.this);
        if (isAutoLogin) {

            String id = mBinding.etId.getText().toString();
            String password = mBinding.etId.getText().toString();

            if (!id.isEmpty() && !password.isEmpty()) {
                if (mBinding.checkboxAutoLogin.isChecked()) {

                    //5초동안 로그인 중.. 띄우기
                    //5초 후 로그인 완료
                }
            }

        } else {
            Toast.makeText(LoginActivity.this, getString(R.string.msg_uncheck_term), Toast.LENGTH_SHORT).show();
            return;
        }
    }
}

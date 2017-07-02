package com.cetc.training.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.androidquery.AQuery;
import com.cetc.training.R;
import com.cetc.training.base.BaseActivity;

import butterknife.Bind;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {
    AQuery aQuery;
    @Bind(R.id.login_progress)
    ProgressBar loginProgress;
    @Bind(R.id.iv_logo)
    ImageView ivLogo;
    @Bind(R.id.username)
    AutoCompleteTextView username;
    @Bind(R.id.password)
    EditText password;
    @Bind(R.id.cb_remember)
    CheckBox cbRemember;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_register)
    Button btnRegister;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initVariables() {
        aQuery = new AQuery(this);
    }

    @Override
    protected void initData(Bundle saveInstanceState) {

    }

    @OnClick({R.id.btn_login, R.id.iv_logo})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                attemptLogin();
                break;
            case R.id.iv_logo:
                break;
        }
    }

    /**
     * 登录
     */
    private void attemptLogin() {
        checkInput();
    }

    /**
     * 检查输入
     */
    private void checkInput() {
        String userName = username.getText().toString().trim();
        String passWord = password.getText().toString().trim();
//        if(TextUtils.isEmpty(userName)){
//            ToastUtils.show(context,"请输入用户名");
//            return;
//        }
//        if(TextUtils.isEmpty(passWord)){
//            ToastUtils.show(context,"请输入密码");
//            return;
//        }
    
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}


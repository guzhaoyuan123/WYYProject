package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wyyproject.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.btn_login_phone)
    Button btnLoginPhone;
    @BindView(R.id.btn_login_log)
    Button btnLoginLog;
    @BindView(R.id.img_login_weixin)
    ImageView imgLoginWeixin;
    @BindView(R.id.img_login_qq)
    ImageView imgLoginQq;
    @BindView(R.id.img_login_weibo)
    ImageView imgLoginWeibo;
    @BindView(R.id.img_login_wangyiyun)
    ImageView imgLoginWangyiyun;
    @BindView(R.id.cx_apply)
    CheckBox cxApply;
    @BindView(R.id.tx_login_yonghuzhengce)
    TextView txLoginYonghuzhengce;
    @BindView(R.id.tx_login_yinsizhengce)
    TextView txLoginYinsizhengce;
    @BindView(R.id.tx_login_ertongyinsizhengce)
    TextView txLoginErtongyinsizhengce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_login_phone, R.id.btn_login_log, R.id.img_login_weixin, R.id.img_login_qq, R.id.img_login_weibo, R.id.img_login_wangyiyun, R.id.cx_apply, R.id.tx_login_yonghuzhengce, R.id.tx_login_yinsizhengce, R.id.tx_login_ertongyinsizhengce})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login_phone:
                if (cxApply.isChecked()) {//判断单选框是否勾选
                    Intent intent = new Intent(LoginActivity.this, PhoneLoginActivity.class);
                    startActivity(intent);
                    //进场动画
                    overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                } else {
                    Toast.makeText(this, "请勾选同意《用户协议》《隐私政策》《儿童隐私政策》", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_login_log:
                if (cxApply.isChecked()) {//判断单选框是否勾选
                    Intent intent = new Intent(LoginActivity.this, NavigationActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                } else {
                    Toast.makeText(this, "请勾选同意《用户协议》《隐私政策》《儿童隐私政策》", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.img_login_weixin:
                break;
            case R.id.img_login_qq:
                break;
            case R.id.img_login_weibo:
                break;
            case R.id.img_login_wangyiyun:
                break;
            case R.id.cx_apply:
                break;
            case R.id.tx_login_yonghuzhengce:
                break;
            case R.id.tx_login_yinsizhengce:
                break;
            case R.id.tx_login_ertongyinsizhengce:
                break;
        }
    }


}

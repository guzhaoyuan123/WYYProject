package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.wyyproject.R;

import java.util.regex.Pattern;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PhoneLoginActivity extends AppCompatActivity {


    @BindView(R.id.et_phonelogin_phone)
    EditText etPhoneloginPhone;
    @BindView(R.id.btn_phonelogin_next)
    Button btnPhoneloginNext;
    @BindView(R.id.img_loginphone_fanhui)
    ImageView imgLoginphoneFanhui;
    //手机号码的正则表达式
    public static final String REGEX_MOBILE = "^1[3|4|5|8|9][0-9]\\d{8}$";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_login);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.et_phonelogin_phone, R.id.btn_phonelogin_next,R.id.img_loginphone_fanhui})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_phonelogin_next:
                if (isMobile(etPhoneloginPhone.getText().toString())) {//判断得到的手机号码是否通过
                    Intent intent = new Intent(PhoneLoginActivity.this, CodeActivity.class);
                    intent.putExtra("phonename", etPhoneloginPhone.getText().toString());//将手机号码传到CodeActivity中
                    startActivity(intent);
                } else {
                    Toast.makeText(PhoneLoginActivity.this, "请输入11位数字的手机号", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.img_loginphone_fanhui:
                PhoneLoginActivity.this.finish();
                break;
        }
    }

//    判断是否是手机号码
    public static boolean isMobile(String mobile) {
        return Pattern.matches(REGEX_MOBILE, mobile);
    }
}

package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.example.url.shoujihaozhuce.Singin;
import com.example.url.yanzhengma.CodeApi;
import com.example.wyyproject.MainActivity;
import com.example.wyyproject.R;
import com.example.wyyproject.util.Http;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CodeActivity extends AppCompatActivity {

    @BindView(R.id.img_loginphone_fanhui)
    ImageView imgLoginphoneFanhui;
    @BindView(R.id.tx_code_phone)
    TextView txCodePhone;
    @BindView(R.id.tx_code_daojishi)
    TextView txCodeDaojishi;
    @BindView(R.id.et_code_mi1)
    EditText etCodeMi1;
    @BindView(R.id.et_code_mi2)
    EditText etCodeMi2;
    @BindView(R.id.et_code_mi3)
    EditText etCodeMi3;
    @BindView(R.id.et_code_mi4)
    EditText etCodeMi4;
    @BindView(R.id.btn_code_login)
    Button btnCodeLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code);
        ButterKnife.bind(this);

        initData();
    }

    private void sucess() {
        String phonename;
        Intent intent = getIntent();
        phonename = intent.getStringExtra("phonename");
        String code = etCodeMi1.getText().toString()
                + etCodeMi2.getText().toString()
                + etCodeMi3.getText().toString()
                + etCodeMi4.getText().toString();
        Log.e(">>>>>>>>>>>>","???"+code);
        test(code,phonename);
    }

    //    /captcha/verify?phone=13xxx&captcha=1597
    //    /captcha/sent?phone=18851767683
    private void initData() {
        String phonename;
        Intent intent = getIntent();
        phonename = intent.getStringExtra("phonename");
        Log.e(">>>>>>>>>>>>","???"+phonename);

        sss(phonename);
        txCodePhone.setText(phonename.substring(0, 3) + "****" + phonename.substring(7, phonename.length()));

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Http.get2("http://10.0.2.2:3000/captcha/sent?phone="+phonename+"");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }


    private void sss(String phonename) {
        if (phonename != " ") {
            new CountDownTimer(60000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    txCodeDaojishi.setText(millisUntilFinished / 1000 + "s");
                }

                @Override
                public void onFinish() {
                    txCodeDaojishi.setClickable(true);
                    txCodeDaojishi.setText("重新获取");
                    txCodeDaojishi.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sss(phonename);
                        }
                    });
                }
            }.start();
            Toast.makeText(CodeActivity.this, "验证码发送成功，请尽快验证", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(CodeActivity.this, "验证码发送失败", Toast.LENGTH_SHORT).show();
        }
    }


    //验证验证码
    private void test(String phonecode,String phonename) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String json = Http.get("http://10.0.2.2:3000/captcha/verify?phone="+phonename+"&captcha=" + phonecode + "");
                    CodeApi codeApi = JSON.parseObject(json, CodeApi.class);
                    Log.e(">>>>>>>>>>>>","???"+codeApi.getCode()+"?????"+phonecode);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (codeApi.getCode() == 200) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                          String  json2 = Http.get("http://10.0.2.2:3000/cellphone/existence/check?phone="+phonename+"");
                                            Singin singin = JSON.parseObject(json2,Singin.class);
                                            runOnUiThread(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (singin.getExist()==1){
                                                        Intent intent = new Intent(CodeActivity.this, MainActivity.class);
                                                        startActivity(intent);
                                                    }
                                                    else {
                                                        Intent intent = new Intent(CodeActivity.this, SignInActivity.class);
                                                        intent.putExtra("shoujihaoma",phonename);
                                                        intent.putExtra("yanzhengma",phonecode);
                                                        startActivity(intent);
                                                    }
                                                }
                                            });

                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }).start();

                            } else
                                Toast.makeText(CodeActivity.this, "验证码错误", Toast.LENGTH_SHORT).show();
                        }
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @OnClick({R.id.img_loginphone_fanhui, R.id.btn_code_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_loginphone_fanhui:
                CodeActivity.this.finish();
                break;
            case R.id.btn_code_login:
                sucess();
                break;
        }
    }
}

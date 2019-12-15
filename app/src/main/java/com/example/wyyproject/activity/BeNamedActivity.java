package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.example.url.zhuce.ZhuCeApi;
import com.example.wyyproject.MainActivity;
import com.example.wyyproject.R;
import com.example.wyyproject.util.Http;

import java.io.IOException;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BeNamedActivity extends AppCompatActivity {

    @BindView(R.id.img_beNamed_fanhui)
    ImageView imgBeNamedFanhui;
    @BindView(R.id.et_beNamed_mima)
    EditText etBeNamedMima;
    @BindView(R.id.btn_beNamed_next)
    Button btnBeNamedNext;
    private String mima,shouji,yanzhengma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_be_named);
        ButterKnife.bind(this);

        Intent intent= getIntent();
        mima=intent.getStringExtra("getMima");
        shouji=intent.getStringExtra("getShoujihaoma");
        yanzhengma=intent.getStringExtra("getYanzhengma");
    }

    @OnClick({R.id.img_beNamed_fanhui, R.id.btn_beNamed_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_beNamed_fanhui:
                BeNamedActivity.this.finish();
                break;
            case R.id.btn_beNamed_next:
                zhuce();
                break;
        }
    }

//    /register/cellphone?phone=13xxx&password=xxxxx&captcha=1234&nickname=binary1345
    private void zhuce() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String  json2 = Http.get("http://10.0.2.2:3000/register/cellphone?phone="+shouji+"&password="+mima+"&captcha="+yanzhengma+"&nickname="+etBeNamedMima.getText().toString()+"");
                    ZhuCeApi zhuCeApi = JSON.parseObject(json2,ZhuCeApi.class);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (zhuCeApi.getCode()==505){
                                String s=etBeNamedMima.getText().toString()+"kionajgizl_ljia";
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            String  json2 = Http.get("http://10.0.2.2:3000/register/cellphone?phone="+shouji+"&password="+mima+"&captcha="+yanzhengma+"&nickname="+s+"");
                                            Intent intent = new Intent(BeNamedActivity.this,MainActivity.class);
                                              startActivity(intent);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                });

                            }
                            else {
                                Intent intent = new Intent(BeNamedActivity.this,MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

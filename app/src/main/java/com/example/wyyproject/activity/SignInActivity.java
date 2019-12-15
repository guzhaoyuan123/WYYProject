package com.example.wyyproject.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.wyyproject.R;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends AppCompatActivity {

    @BindView(R.id.img_signin_fanhui)
    ImageView imgSigninFanhui;
    @BindView(R.id.et_signin_mima)
    EditText etSigninMima;
    @BindView(R.id.btn_signin_next)
    Button btnSigninNext;
    private  String shoujihaoma,yanzhengma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        shoujihaoma=intent.getStringExtra("shoujihaoma");
        yanzhengma=intent.getStringExtra("yanzhengma");
    }

    @OnClick({R.id.img_signin_fanhui, R.id.btn_signin_next})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_signin_fanhui:
                SignInActivity.this.finish();
                break;
            case R.id.btn_signin_next:
                Intent intent = new Intent(SignInActivity.this,BeNamedActivity.class);
                intent.putExtra("getMima",etSigninMima.getText().toString());
                intent.putExtra("getShoujihaoma",shoujihaoma);
                intent.putExtra("getYanzhengma",yanzhengma);
                startActivity(intent);
                break;
        }
    }
}

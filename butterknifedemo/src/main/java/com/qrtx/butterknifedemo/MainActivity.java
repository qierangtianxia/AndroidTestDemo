package com.qrtx.butterknifedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


//    @BindView(R.id.image)
//    ImageView image;
//    @BindView(R.id.edittext)
//    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

//    @OnClick(R.id.btn_test)
//    public void onClick() {
//        if (image.getVisibility() == View.VISIBLE) {
//            image.setVisibility(View.GONE);
//        } else {
//            image.setVisibility(View.VISIBLE);
//        }
//    }
}

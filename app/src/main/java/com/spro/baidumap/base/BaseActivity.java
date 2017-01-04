package com.spro.baidumap.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/12/29.
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getLayout()==0){
            return;
        }
        setContentView(getLayout());
        ButterKnife.bind(this);
        data();
    }

    public abstract int getLayout();

    public abstract void data();


}

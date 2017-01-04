package com.spro.baidumap.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;

import com.spro.baidumap.R;
import com.spro.baidumap.activity.login.LoginActivity;
import com.spro.baidumap.activity.regist.RegisterActivity;
import com.spro.baidumap.base.BaseActivity;
import com.spro.baidumap.commons.ActivityUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    public static final String MAIN_ACTION = "register_to_main";
    private ActivityUtils activityUtils;

    /**
     * 初始化一个广播接收器
     */
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //接收广播
            finish();
        }
    };

    @Override
    public int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void data() {
        activityUtils = new ActivityUtils(this);

        //注册一个本地广播(比之全局，本地只在本App中发送,更加安全)
        IntentFilter intentFilter = new IntentFilter(MAIN_ACTION);
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter);
    }


    @OnClick({R.id.btn_Register, R.id.btn_Login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Register:
                Log.e("TAH", "111");
                activityUtils.startActivity(RegisterActivity.class);
                break;
            case R.id.btn_Login:
                Log.e("TAH", "222");
                activityUtils.startActivity(LoginActivity.class);
                break;
        }
    }
}

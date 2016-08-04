package com.swroom.autowifidaily;

import android.app.Application;
import com.taobao.weex.InitConfig;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;

/**
 * Created by Ray on 2016/8/1.
 */
public class WXApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WXEnvironment.addCustomOptions("appName","TBSample");
        WXSDKEngine.initialize(this, new InitConfig.Builder().setImgAdapter(new ImageAdapter()).build());
    }
}
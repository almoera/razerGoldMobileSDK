package com.razer.goldsdk.app;

import android.app.Application;

import com.razer.goldsdk.exception.KqwException;

import me.goldze.mvvmhabit.base.BaseApplication;
import me.goldze.mvvmhabit.crash.CaocConfig;
import me.goldze.mvvmhabit.utils.KLog;

public class GoldSDKAppLication extends Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static synchronized void setApplication(Application application) {
        instance = application;

        /**
         * 做初始化
         */
        initException();
        initHbit();
    }

    private static void initException() {
        //全局异常捕获
        KqwException handler = KqwException.getInstance(instance);
        Thread.setDefaultUncaughtExceptionHandler(handler);
    }

    private static void initHbit() {
        BaseApplication.setApplication(instance);
        //是否开启日志打印
        KLog.init(true);
        //配置全局异常崩溃操作
        CaocConfig.Builder.create()
                .backgroundMode(CaocConfig.BACKGROUND_MODE_SILENT) //背景模式,开启沉浸式
                .enabled(true) //是否启动全局异常捕获
                .showErrorDetails(true) //是否显示错误详细信息
                .showRestartButton(true) //是否显示重启按钮
                .trackActivities(true) //是否跟踪Activity
                .minTimeBetweenCrashesMs(2000) //崩溃的间隔时间(毫秒)
//                .errorDrawable(R.mipmap.ic_launcher) //错误图标
//                .restartActivity(LoginActivity.class) //重新启动后的activity
                //.errorActivity(YourCustomErrorActivity.class) //崩溃后的错误activity
                //.eventListener(new YourCustomEventListener()) //崩溃后的错误监听
                .apply();
    }
}

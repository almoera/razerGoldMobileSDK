package com.razer.goldsdk.exception;

import android.content.Context;
import androidx.annotation.Keep;
import android.util.Log;

/**
 * Created by kongqw on 2015/11/3.
 */
@Keep
public class KqwException implements Thread.UncaughtExceptionHandler {
    private static KqwException myCrashHandler;

    private Context mContext;

    private KqwException(Context context) {
        mContext = context;
    }

    public static synchronized KqwException getInstance(Context context) {
        if (null == myCrashHandler) {
            myCrashHandler = new KqwException(context);
        }
        return myCrashHandler;
    }

    public void uncaughtException(Thread thread, Throwable throwable) {
        long threadId = thread.getId();
        String message = throwable.getMessage();
        String localizedMessage = throwable.getLocalizedMessage();
        Log.i("KqwException", "------------------------------------------------------");
        Log.i("KqwException", "threadId = " + threadId);
        Log.i("KqwException", "message = " + message);
        Log.i("KqwException", "localizedMessage = " + localizedMessage);
        Log.i("KqwException", "------------------------------------------------------");
        throwable.printStackTrace();
        Log.i("KqwException", "------------------------------------------------------");

        // TODO 下面捕获到异常以后要做的事情，可以重启应用，获取手机信息上传到服务器等
        Log.i("KqwException", "------------------应用被重启----------------");
        // 重启应用
        mContext.startActivity(mContext.getPackageManager().getLaunchIntentForPackage(mContext.getPackageName()));
        //干掉当前的程序
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
package com.razer.goldsdk;

import android.content.Context;
import android.os.Bundle;

import com.razer.goldsdk.view.main.RazerMainActivity;

public class RazerPayment {

    public static void onlinePay(Context context, Bundle bundle) {
        RazerMainActivity.getInatnce(context, bundle);
    }
}

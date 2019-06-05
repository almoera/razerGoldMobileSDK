package com.razer.goldsdk.view.main;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.razer.goldsdk.R;
import com.razer.goldsdk.databinding.RazerActivityMainBinding;

import me.goldze.mvvmhabit.BR;
import me.goldze.mvvmhabit.base.BaseActivity;

public class RazerMainActivity extends BaseActivity<RazerActivityMainBinding,RazerMainViewModel> {

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
//        super.onCreate(savedInstanceState, persistentState);
//        setContentView(R.layout.razer_activity_main);
//        initData();
//    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.razer_activity_main;
    }

    @Override
    public int initVariableId() {
        return BR.viewmodel;
    }

    @Override
    public RazerMainViewModel initViewModel() {
        return ViewModelProviders.of(this).get(RazerMainViewModel.class);
    }

    @Override
    public void initData() {
        BottomNavigationView buttom_nav = findViewById(R.id.buttom_nav);
        buttom_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int i = menuItem.getItemId();
                if (i == R.id.menu_recent) {
                    Toast.makeText(RazerMainActivity.this, "点击成功", Toast.LENGTH_LONG).show();
                } else if (i == R.id.menu_recent1) {

                } else if (i == R.id.menu_recent2) {

                } else if (i == R.id.menu_recent3) {

                }
                return true;
            }
        });

    }

    public static void getInatnce(Context context, Bundle bundle) {
        Intent intent = new Intent(context, RazerMainActivity.class);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);
    }
}

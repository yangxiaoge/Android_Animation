package com.yang.bruce.android_animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-09-14 14:33
 * Version: 1.0
 * TaskId:
 * Description:
 */
public class EntryActivity extends BaseActivity implements View.OnClickListener {
    private Button btn1, btn2, btn3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entry);
        btn1 = $(R.id.button);
        btn2 = $(R.id.button2);
        btn3 = $(R.id.button3);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case R.id.button2:
                break;
            case R.id.button3:
                break;
        }
    }
}

package com.yang.bruce.android_animation;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-09-14 10:07
 * Version: 1.0
 * TaskId:
 * Description:
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 子类实现该方法用于替代 findViewById
     * @param id
     * @param <T>
     * @return
     */
    protected <T extends View> T $(@IdRes int id) {
        return (T)findViewById(id);
    }
}

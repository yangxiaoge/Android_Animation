package com.yang.bruce.android_animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 详情见郭霖公众号以及博客:
 * Android属性动画完全解析(上)，初识属性动画的基本用法
 * http://blog.csdn.net/guolin_blog/article/details/43536355
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {
    private TextView textView;
    private Button valueBtn, objAlphaBtn, objRotationBtn, objTransactionXBtn, objScaleXBtn, objSetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = $(R.id.textView);
        valueBtn = $(R.id.value_animator);
        objAlphaBtn = $(R.id.object_animator_alpha);
        objRotationBtn = $(R.id.object_animator_rotation);
        objTransactionXBtn = $(R.id.object_animator_translationX);
        objScaleXBtn = $(R.id.object_animator_scale);
        objSetBtn = $(R.id.object_animator_Set);
        valueBtn.setOnClickListener(this);
        objAlphaBtn.setOnClickListener(this);
        objRotationBtn.setOnClickListener(this);
        objTransactionXBtn.setOnClickListener(this);
        objScaleXBtn.setOnClickListener(this);
        objSetBtn.setOnClickListener(this);

    }

    private void doValueAnimator() {
        // ValueAnimator
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 0f, 1f); //浮点值
        //ValueAnimator valueAnimator = ValueAnimator.ofInt(0,100); //整数值
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                Log.d("MainActivity", "current ValueAnimator value is " + (float) valueAnimator.getAnimatedValue());
            }
        });
        valueAnimator.start();
        // ValueAnimator
    }

    //ObjectAnimator
    private void doObjectAnimatorAlpha() {
        /*相比于ValueAnimator，ObjectAnimator可能才是我们最常接触到的类，因为ValueAnimator只不过是对值进行了一个平滑的动画过渡，
        但我们实际使用到这种功能的场景好像并不多。而ObjectAnimator则就不同了，
        它是可以直接对任意对象的任意属性进行动画操作的，比如说View的alpha属性。*/
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        objectAnimator.setDuration(5000);
        objectAnimator.start();
    }

    private void doObjectAnimatorRotation() {
        // 旋转360°
        ObjectAnimator oa = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        oa.setDuration(5000);
        oa.start();
    }

    private void doObjectAnimatorTranslationX() {
        // 向左平移,移出屏幕.再回来
        float original = textView.getTranslationX();
        ObjectAnimator oa = ObjectAnimator.ofFloat(textView, "translationX", original, -500f, original);
        oa.setDuration(5000);
        oa.start();
    }

    private void doObjectAnimatorScaleY() {
        //"scaleY"，表示在垂直方向上进行缩放
        ObjectAnimator oa = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f);
        oa.setDuration(5000);
        oa.start();
    }

    private void doObjectAnimatorSet() {
        /**
         * AnimatorSet.Builder中包括以下四个方法：
         after(Animator anim) 将现有动画插入到传入的动画之后执行
         after(long delay) 将现有动画延迟指定毫秒后执行
         before(Animator anim) 将现有动画插入到传入的动画之前执行
         with(Animator anim) 将现有动画和传入的动画同时执行
         */
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
        ObjectAnimator sacleY = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
        AnimatorSet at = new AnimatorSet();
        at.play(rotate).with(fadeInOut).with(sacleY).after(moveIn);
        at.setDuration(5000);
        at.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
                Toast.makeText(MainActivity.this, "组合动画开始", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                Toast.makeText(MainActivity.this, "组合动画结束~", Toast.LENGTH_SHORT).show();
            }
        });
        at.start();
    }

    //ObjectAnimator

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.value_animator:
                doValueAnimator();
                break;
            case R.id.object_animator_alpha: // 改变alpha值
                doObjectAnimatorAlpha();
                break;
            case R.id.object_animator_rotation: //旋转360°
                doObjectAnimatorRotation();
                break;
            case R.id.object_animator_translationX: //水平移动
                doObjectAnimatorTranslationX();
                break;
            case R.id.object_animator_scale: //拉伸
                doObjectAnimatorScaleY();
                break;
            case R.id.object_animator_Set: //组合动画
                doObjectAnimatorSet();
                break;
        }
    }

}

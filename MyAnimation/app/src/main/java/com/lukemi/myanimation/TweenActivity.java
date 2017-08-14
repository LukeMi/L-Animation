package com.lukemi.myanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.xml_alpha, R.id.xml_rotate, R.id.xml_translate, R.id.xml_scale, R.id.xml_set, R.id.java_alpha, R.id.java_rotate, R.id.java_translate, R.id.java_scale, R.id.java_set})
    public void onClick(View view) {
        Animation animation = null;
        switch (view.getId()) {
            case R.id.xml_alpha:
                animation = AnimationUtils.loadAnimation(this, R.anim.xml_alpha);
                break;
            case R.id.xml_rotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.xml_rotate);
                break;
            case R.id.xml_translate:
                animation = AnimationUtils.loadAnimation(this, R.anim.xml_translate);
                break;
            case R.id.xml_scale:
                animation = AnimationUtils.loadAnimation(this, R.anim.xml_scale);
                break;
            case R.id.xml_set:
                animation = AnimationUtils.loadAnimation(this, R.anim.xml_set);
                break;
            case R.id.java_alpha:
                animation = new AlphaAnimation(0.0f, 1.0f);
                animation.setFillAfter(true);
                animation.setDuration(3000);
                animation.setInterpolator(this, android.R.anim.accelerate_interpolator);
                animation.setRepeatCount(3);
                animation.setRepeatMode(Animation.RESTART);
                break;
            case R.id.java_rotate:
                animation = new RotateAnimation(0, 359, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setFillAfter(true);
                animation.setDuration(3000);
                animation.setRepeatCount(3);
                animation.setRepeatMode(Animation.RESTART);
                break;
            case R.id.java_translate:
                RelativeLayout parent = (RelativeLayout) img.getParent();
                int left = parent.getLeft();
                int top = parent.getTop();
                int right = parent.getRight();
                int bottom = parent.getBottom();

                int left1 = img.getLeft();
                int width = img.getWidth();
                int height = img.getHeight();
                animation = new TranslateAnimation(0, right + left1 - left, 0, bottom - height);

//                animation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0,
//                                                          Animation.RELATIVE_TO_SELF, 1.0f,
//                                                          Animation.RELATIVE_TO_SELF, 0,
//                                                          Animation.RELATIVE_TO_SELF, 1.0f);
                animation.setFillAfter(false);
                animation.setDuration(1000);
                animation.setRepeatCount(3);
                animation.setRepeatMode(Animation.RESTART);
                break;
            case R.id.java_scale:
                animation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
                animation.setFillAfter(true);
                animation.setDuration(3000);
                break;
            case R.id.java_set:
                AnimationSet aset = new AnimationSet(true);
                TranslateAnimation ta = new TranslateAnimation(0, 200, 0, 200);
                ta.setDuration(3000);
                AlphaAnimation aa = new AlphaAnimation(0.0f, 1.0f);
                aa.setDuration(1000);
                aset.addAnimation(ta);
                aset.addAnimation(aa);
                animation = aset;
                break;
        }

        if (animation != null) {
            startAnimation(animation);
        }
    }

    private void startAnimation(@Nullable Animation animation) {
        img.startAnimation(animation);
    }
}

package com.lukemi.myanimation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

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
                break;
            case R.id.java_alpha:
                break;
            case R.id.java_rotate:
                break;
            case R.id.java_translate:
                break;
            case R.id.java_scale:
                break;
            case R.id.java_set:
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

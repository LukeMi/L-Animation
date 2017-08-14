package com.lukemi.myanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EnterAnimationActivity extends AppCompatActivity {

    @BindView(R.id.img)
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_enter_animation);
        ButterKnife.bind(this);
    }


    private void enterAnimation() {

    }

    private void exitAnimation() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                                                                              Animation.RELATIVE_TO_SELF, 1.0f,
                                                                              Animation.RELATIVE_TO_SELF, 0.0f,
                                                                              Animation.RELATIVE_TO_SELF, 1.0f
        );
        translateAnimation.setInterpolator(new LinearInterpolator());
        translateAnimation.setDuration(2000);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        img.startAnimation(translateAnimation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitAnimation();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}

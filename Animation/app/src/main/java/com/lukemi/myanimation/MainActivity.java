package com.lukemi.myanimation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.Tween, R.id.frame, R.id.property})
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.Tween:
                intent = new Intent(this,TweenActivity.class);
                break;
            case R.id.frame:
                break;
            case R.id.property:
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

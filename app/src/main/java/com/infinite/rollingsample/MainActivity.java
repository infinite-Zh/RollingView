package com.infinite.rollingsample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.infinite.rollingoverview.RollingOverView;

public class MainActivity extends AppCompatActivity {

    RollingOverView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view= (RollingOverView) findViewById(R.id.rollingView);
        String[] content=new String[]{"From class android.widget.ViewAnimator ","比如我们正在开发一个看漫画的应用,","计算机软件及应用"};
        view.setContents(content);
        view.setChildFlipInterval(2000);
        view.setAnimDuration(500);
        view.setContentTextColor(Color.WHITE);
        view.setContentTextSize(16);
        view.start();
    }
}

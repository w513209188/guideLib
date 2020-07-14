package com.example.guidetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wb.guidelib.GuideBuilds;
import com.wb.guidelib.GuideManger;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button test1,test2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test1=findViewById(R.id.test1);
        test2=findViewById(R.id.test2);


        List<View> views=new ArrayList<>();
        List<Integer> integers=new ArrayList<>();
        views.add(test1);
        views.add(test2);
        integers.add(R.layout.layout_guidetest);
        integers.add(R.layout.layout_guidetest);
        GuideBuilds guideBuilds=new GuideBuilds();
        guideBuilds.setStepView1(views);
        guideBuilds.setTargetId(R.mipmap.ic_launcher);
        guideBuilds.setStepViewRes(integers);
        guideBuilds.createGuilde().show(MainActivity.this);

    }
}

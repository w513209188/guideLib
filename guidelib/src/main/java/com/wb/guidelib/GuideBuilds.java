package com.wb.guidelib;

import android.view.View;

import com.wb.guidelib.model.GuideBean;

import java.util.List;

public class GuideBuilds {
    private List<View> stepView1;
    private List<Integer> stepViewRes;
    private GuideBean guideBean;
    private int targetImg;

    public GuideBuilds setTargetId(int targetImg) {
        guideBean.targetImg=targetImg;
        return this;
    }

    public GuideBuilds() {
        guideBean=new GuideBean();
    }

    public GuideBuilds setStepViewRes(List<Integer> stepViewRes) {
        guideBean.mTargetViewId=stepViewRes;
        return this;
    }

    public GuideBuilds setStepView1(List<View> stepView1) {
        guideBean.steps=stepView1;
        return this;
    }
    public GuideManger createGuilde(){
        GuideManger guideManger=GuideManger.getInstance();
        guideManger.setGuideBuilds(guideBean);
        return guideManger;
    }
}

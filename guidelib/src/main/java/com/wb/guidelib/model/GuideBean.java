package com.wb.guidelib.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;

import java.util.List;

public class GuideBean {
     public List<View> steps;
     public List<Integer> mTargetViewId;
     public int xOffSet=0;
     public int yOffSet=10;
     public int targetImg;
}

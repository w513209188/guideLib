package com.wb.guidelib;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import com.binioter.guideview.Guide;
import com.binioter.guideview.GuideBuilder;
import com.wb.guidelib.call.DialogCall;
import com.wb.guidelib.call.GuideCall;
import com.wb.guidelib.component.StepComponent;
import com.wb.guidelib.model.GuideBean;
import com.wb.guidelib.view.InfoDialog;

import java.util.List;

/**
 * 新手引导管理器
 */
public class GuideManger {
    private static  GuideManger guideManger;
    private Activity mContext;
    private GuideBean guideBuilds;

    public void setGuideBuilds(GuideBean guideBuilds) {
        this.guideBuilds = guideBuilds;
    }

    public static GuideManger getInstance(){
        synchronized (GuideManger.class){
            if(guideManger==null){
                return guideManger=new GuideManger();
            }
        }
        return guideManger;
    }
        public void show(Activity activity){
            openGuideDesView(activity);
        }
    private void openGuideDesView(Context context){
        mContext= (Activity) context;
        final InfoDialog infoDialog= new InfoDialog.Builder(context).create();
        infoDialog.setMainImage(guideBuilds.targetImg);
        if(infoDialog.isShowing())
            return;
        infoDialog.show();
        infoDialog.setDialogCall(new DialogCall() {
            @Override
            public void userDismiss() {
                if(infoDialog.isShowing()){
                    infoDialog.dismiss();
                }
                showGuideView(guideBuilds.steps);
            }
        });
    }

    /**
     * 单调也没步骤显示
     */
    private void showGuideView(List<View> stepView) {
           showGuidesView(stepView,0);
    }
    private void showGuidesView(final List<View> stepView , final int flags){
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(stepView.get(flags))
                .setAlpha(150)
                .setHighTargetCorner(20)
                .setHighTargetPadding(10);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
            }
            @Override
            public void onDismiss() {
                if(flags<stepView.size()-1){
                    int xb=flags+1;
                    showGuidesView(stepView,xb);
                }
            }
        });
        builder.addComponent(new StepComponent(guideBuilds.mTargetViewId.get(flags),guideBuilds.xOffSet,guideBuilds.yOffSet));
        Guide guide = builder.createGuide();
        guide.show(mContext);
    }
}

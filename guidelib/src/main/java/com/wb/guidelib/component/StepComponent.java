package com.wb.guidelib.component;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.binioter.guideview.Component;
import com.wb.guidelib.R;
public class StepComponent implements Component {
    private int layouts;
    private int xOff,yOff;

    public StepComponent(int layouts, int xOff, int yOff) {
        this.layouts = layouts;
        this.xOff = xOff;
        this.yOff = yOff;
    }

    @Override public View getView(LayoutInflater inflater) {

        LinearLayout ll = (LinearLayout) inflater.inflate(layouts, null);
        ll.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
            }
        });
        return ll;
    }

    @Override public int getAnchor() {
        return Component.ANCHOR_BOTTOM;
    }

    @Override public int getFitPosition() {
        return Component.FIT_START;
    }

    @Override public int getXOffset() {
        return xOff;
    }

    @Override public int getYOffset() {
        return yOff;
    }
}

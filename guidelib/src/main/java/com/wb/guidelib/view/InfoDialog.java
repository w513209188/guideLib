package com.wb.guidelib.view;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.wb.guidelib.R;
import com.wb.guidelib.call.DialogCall;
public class InfoDialog extends Dialog {
    private View mView;
    private RelativeLayout main_rel;
    private DialogCall dialogCall;
    private ImageView main_img;
    public void setDialogCall(DialogCall dialogCall) {
        this.dialogCall = dialogCall;
    }
    private InfoDialog(Context context, int themeResId, View view) {
        super(context, themeResId);
        mView=view;
        main_rel=mView.findViewById(R.id.main_rel);
        main_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dialogCall==null)
                    return;
                dialogCall.userDismiss();
            }
        });
        main_img=mView.findViewById(R.id.main_img);
    }
    public void setMainImage(int res){
        main_img.setImageResource(res);
    }
    public static class Builder {
        private View mLayout;
        private InfoDialog mDialog;
        public Builder(Context context) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //加载布局文件
            mLayout = inflater.inflate(R.layout.dialog, null, false);
            mDialog = new InfoDialog(context, R.style.MyDialog,mLayout);
            DisplayMetrics outMetrics = new DisplayMetrics();
            //添加布局文件到 Dialog
            mDialog.addContentView(mLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT));
            WindowManager.LayoutParams p = mDialog.getWindow().getAttributes();//用户不可以点击外部来关闭 Dialog
            p.width = getScreenWidth(context);
            p.height = getScreenHeight(context);
            mDialog.getWindow().setAttributes(p);
        }
        public InfoDialog create() {
            mDialog.setContentView(mLayout);
            mDialog.setCancelable(true);                //用户可以点击后退键关闭 Dialog
            mDialog.setCanceledOnTouchOutside(false);
            return mDialog;
        }

    }
    private static   int getScreenWidth(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE );
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics( outMetrics);
        return outMetrics .widthPixels ;
    }
    private static  int getScreenHeight(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE );
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics( outMetrics);
        return outMetrics .heightPixels ;
    }
}
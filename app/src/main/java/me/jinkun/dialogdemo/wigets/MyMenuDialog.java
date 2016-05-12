package me.jinkun.dialogdemo.wigets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import me.jinkun.dialogdemo.R;

/**
 * Description: Do one thing at a time, and do well.</br>
 * Autor: Created by jinkun on 2016/5/11.
 */
public class MyMenuDialog extends Dialog {
    public MyMenuDialog(Context context) {
        this(context, R.style.MyDialog);
    }

    public MyMenuDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 预先设置Dialog的一些属性
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        //获取屏幕的高度和宽带
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        d.getMetrics(outMetrics);
        //设置WindowManager.LayoutParams
//        p.height = (int) (outMetrics.heightPixels * 0.6);
//        p.width = (int) (outMetrics.widthPixels * 0.4);
        //根据s随意来的高度来设置x轴偏移量
        p.x = (int) (15 * outMetrics.density);
        //根据Title的高度来设置y轴偏移量
        p.y = (int) (45 * outMetrics.density);
        p.gravity = Gravity.RIGHT | Gravity.TOP;
        dialogWindow.setAttributes(p);
    }
}

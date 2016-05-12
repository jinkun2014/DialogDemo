package me.jinkun.dialogdemo.wigets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import me.jinkun.dialogdemo.R;

/**
 * Description: Do one thing at a time, and do well.</br>
 * Autor: Created by jinkun on 2016/5/11.
 */
public class MyAnimDialog extends Dialog {
    public MyAnimDialog(Context context) {
        this(context, R.style.MyAnimDialog);
    }

    public MyAnimDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        /*
         * lp.x与lp.y表示相对于原始位置的偏移.
         * 当参数值包含Gravity.LEFT时,对话框出现在左边,所以lp.x就表示相对左边的偏移,负值忽略.
         * 当参数值包含Gravity.RIGHT时,对话框出现在右边,所以lp.x就表示相对右边的偏移,负值忽略.
         * 当参数值包含Gravity.TOP时,对话框出现在上边,所以lp.y就表示相对上边的偏移,负值忽略.
         * 当参数值包含Gravity.BOTTOM时,对话框出现在下边,所以lp.y就表示相对下边的偏移,负值忽略.
         * 当参数值包含Gravity.CENTER_HORIZONTAL时,对话框水平居中,所以lp.x就表示在水平居中的位置移动lp.x像素,正值向右移动,负值向左移动.
         * 当参数值包含Gravity.CENTER_VERTICAL时,对话框垂直居中,所以lp.y就表示在垂直居中的位置移动lp.y像素,正值向右移动,负值向左移动.
         * gravity的默认值为Gravity.CENTER,即Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL.
         *
         * 本来setGravity的参数值为Gravity.LEFT | Gravity.TOP时对话框应出现在程序的左上角,但在
         * 我手机上测试时发现距左边与上边都有一小段距离,而且垂直坐标把程序标题栏也计算在内了,
         * Gravity.LEFT, Gravity.TOP, Gravity.BOTTOM与Gravity.RIGHT都是如此,据边界有一小段距离
         */

//        p.x = 100;
//        p.y = 100;
//        p.gravity = Gravity.LEFT | Gravity.TOP;
        p.gravity = Gravity.CENTER;
        p.alpha = 0.5f;
        dialogWindow.setAttributes(p);
    }
}

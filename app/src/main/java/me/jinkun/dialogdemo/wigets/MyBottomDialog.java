package me.jinkun.dialogdemo.wigets;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import me.jinkun.dialogdemo.R;

/**
 * Description: Do one thing at a time, and do well.</br>
 * Autor: Created by jinkun on 2016/5/11.
 */
public class MyBottomDialog extends Dialog {
    public MyBottomDialog(Context context) {
        this(context, R.style.MyAnimDialog);
    }

    public MyBottomDialog(Context context, int themeResId) {
        super(context, themeResId);
        //加载布局并给布局的控件设置点击事件
        View contentView = getLayoutInflater().inflate(R.layout.dialog_custom3, null);
        contentView.findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "你好", Toast.LENGTH_SHORT).show();
            }
        });
        super.setContentView(contentView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 预先设置Dialog的一些属性
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams p = dialogWindow.getAttributes();
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        getWindow().setAttributes(p);
        p.height = (int) (d.getHeight() * 0.6);
        p.width = d.getWidth();
        p.gravity = Gravity.LEFT | Gravity.BOTTOM;
        dialogWindow.setAttributes(p);
    }
}

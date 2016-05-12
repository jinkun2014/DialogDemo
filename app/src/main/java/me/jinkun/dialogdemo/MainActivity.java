package me.jinkun.dialogdemo;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import me.jinkun.dialogdemo.wigets.MyAnimDialog;
import me.jinkun.dialogdemo.wigets.MyBottomDialog;
import me.jinkun.dialogdemo.wigets.MyDialog;
import me.jinkun.dialogdemo.wigets.MyMenuDialog;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//普通的AlertDialog对话框
findViewById(R.id.btn_common).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("普通的对话框的标题");
        builder.setMessage("这是一个普通的对话框的内容");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("取消");
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("确定");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
});
//改变位置，大小，透明度的AlertDialog对话框
findViewById(R.id.btn_custom1).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("普通的对话框");
        builder.setMessage("这是一个普通的对话框");
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("取消");
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                toast("确定");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        //放在show()之后，不然没有效果
        Window dialogWindow = dialog.getWindow();
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
        WindowManager.LayoutParams p = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        //设置高度和宽度
        p.height = (int) (d.getHeight() * 0.4); // 高度设置为屏幕的0.6
        p.width = (int) (d.getWidth() * 0.6); // 宽度设置为屏幕的0.65
        //设置位置
        p.gravity = Gravity.BOTTOM;
        //设置透明度
        p.alpha = 0.5f;
        dialogWindow.setAttributes(p);
    }
});
// 使用普通的dialog来添加自定义布局
findViewById(R.id.btn_custom2).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.MyCommonDialog);
        builder.setView(R.layout.dialog_custom1);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
});

        //继承Dialog来实现Dialog
        findViewById(R.id.btn_custom3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dialog = new MyDialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_custom2);
                dialog.show();
            }
        });

        //继承Dialog来实现有动画Dialog
        findViewById(R.id.btn_custom4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAnimDialog dialog = new MyAnimDialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_custom2);
                dialog.show();
            }
        });

        //继承Dialog来实现底部弹出Dialog
        findViewById(R.id.btn_custom5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyBottomDialog dialog = new MyBottomDialog(MainActivity.this);
                dialog.show();
            }
        });

        findViewById(R.id.ibtn_menu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMenuDialog dialog = new MyMenuDialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_custom2);
                dialog.show();
            }
        });
    }

    private void toast(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}

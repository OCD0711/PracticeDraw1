package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    Paint paint = new Paint();
    Path path = new Path(); // 初始化 Path 对象

    {
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
        path.addArc(200, 200, 400, 400, -225, 225);
        path.arcTo(400, 200, 600, 400, -180, 225, false);
        path.lineTo(400, 542);
    }


    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(100, 100);
        path.lineTo(200, 100);
        path.lineTo(150, 150);
        // path封口
        path.close();

        canvas.drawPath(path, paint);

//        paint.setStyle(Paint.Style.STROKE);
//        // 0, 0 开始
//        path.lineTo(100, 100);
//        // 相对移动
//        path.rLineTo(100, 0);
//        canvas.drawPath(path, paint);

//        练习内容：使用 canvas.drawPath() 方法画心形
    }
}

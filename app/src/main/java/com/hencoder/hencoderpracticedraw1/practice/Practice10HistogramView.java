package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.Data;

import java.util.ArrayList;
import java.util.List;

public class Practice10HistogramView extends View {

//    Paint paint = new Paint();
//    Path path = new Path();

//    {
//        paint.setAntiAlias(true);
//        paint.setStyle(Paint.Style.STROKE);
//    }

    public Practice10HistogramView(Context context) {
        super(context);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private final static String NAME = "直方图";
    private List<Data> datas;
    private Paint paint;
    private float startX;
    private float space;
    private float width;
    private float max;

    private void init() {
        datas = new ArrayList<>();
        Data data = new Data("Froyo", 10.0f, Color.CYAN);
        datas.add(data);
        data = new Data("ICS", 18.0f, Color.CYAN);
        datas.add(data);
        data = new Data("JB", 22.0f, Color.CYAN);
        datas.add(data);
        data = new Data("KK", 27.0f, Color.CYAN);
        datas.add(data);
        data = new Data("L", 40.0f, Color.CYAN);
        datas.add(data);
        data = new Data("M", 60.0f, Color.CYAN);
        datas.add(data);
        data = new Data("N", 33.5f, Color.CYAN);
        datas.add(data);
        max = Float.MIN_VALUE;
        for (Data d : datas) {
            max = Math.max(max, d.getNumber());
        }
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStrokeWidth(2);
    }

//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
////        path.lineTo(100, 100);
//        // forceMoveTo false:连笔带过去 true:提起再落笔
////        path.arcTo(100, 100, 300, 300, -90, 90, true);
//
////        canvas.drawPath(path, paint);
//
//        paint.setColor(Color.WHITE);
//        paint.setTextSize(72);
//        canvas.drawText(NAME, (canvas.getWidth() - paint.measureText(NAME)) / 2, canvas.getHeight() * 0.9f, paint);
//
//        canvas.translate(canvas.getWidth() * 0.1f, canvas.getHeight() * 0.7f); // 将画图原点移动直方图的原点位置
//
//        width = (canvas.getWidth() * 0.8f - 100) / datas.size() * 0.8f;
//        space = (canvas.getWidth() * 0.8f - 100) / datas.size() * 0.2f;
//
//        paint.setStyle(Paint.Style.STROKE);
//        canvas.drawLine(0, 0, canvas.getWidth() * 0.8f, 0, paint);   // 画x轴
//        canvas.drawLine(0, 0, 0, -canvas.getHeight() * 0.6f, paint); // 画y轴
//
//        startX = 0f;
//
//        paint.setTextSize(36);
//        paint.setStyle(Paint.Style.FILL);
//        for (Data data : datas) {
//            paint.setColor(data.getColor());
//            canvas.drawRect(startX + space, -(data.getNumber() / max * canvas.getHeight() * 0.6f), startX + space + width, 0, paint);
//            paint.setColor(Color.WHITE);
//            canvas.drawText(data.getName(), startX + space + (width - paint.measureText(data.getName())) / 2, 40, paint);
//            startX += width + space;
//        }
//
////        综合练习
////        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
//    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        paint.setColor(Color.WHITE);
        paint.setTextSize(50);
        canvas.drawText(NAME, (canvasWidth - paint.measureText(NAME)) / 2, canvasHeight * 0.9f, paint);

        float sWidth = canvasWidth * 0.8f / datas.size() * 0.8f;
        float space = canvasWidth * 0.8f / datas.size() * 0.2f;
        float startX = canvasWidth * 0.1f;

        // 画X轴
        canvas.drawLine(canvasWidth * 0.1f, canvasHeight * 0.8f, canvasWidth * 0.9f, canvasHeight * 0.8f, paint);
        // 画Y轴
        canvas.drawLine(canvasWidth * 0.1f, canvasHeight * 0.2f, canvasWidth * 0.1f, canvasHeight * 0.8f, paint);

        for (Data data : datas) {
            paint.setColor(data.getColor());
            canvas.drawRect(startX + space, data.getNumber(), startX + space + sWidth, canvasHeight * 0.8f, paint);
            paint.setColor(Color.WHITE);
            paint.setTextSize(30);
            canvas.drawText(data.getName(), startX + space + (sWidth - paint.measureText(data.getName())) / 2, canvasHeight * 0.8f + 25, paint);
            startX += sWidth + space;
        }

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
    }
}

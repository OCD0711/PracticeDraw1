package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

import java.util.ArrayList;
import java.util.List;

public class Practice11PieChartView extends View {

//    private float radius;
//    private List<Data> datas;
//    private Paint paint;
//    private RectF rectF;
//    private float total;
//    private float max;
//
//    float startAngle = 0f; // 开始的角度
//    float sweepAngle;      // 扫过的角度
//    float lineAngle;       // 当前扇形一半的角度
//
//    float lineStartX = 0f; // 直线开始的X坐标
//    float lineStartY = 0f; // 直线开始的Y坐标
//    float lineEndX;        // 直线结束的X坐标
//    float lineEndY;        // 直线结束的Y坐标
//
//    public Practice11PieChartView(Context context) {
//        super(context);
//        init();
//    }
//
//    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }
//
//    private void init() {
//        radius = 300;
//        datas = new ArrayList<>();
//        Data data = new Data("Gingerbread", 10.0f, Color.WHITE);
//        datas.add(data);
//        data = new Data("Ice Cream Sandwich", 18.0f, Color.MAGENTA);
//        datas.add(data);
//        data = new Data("Jelly Bean", 22.0f, Color.GRAY);
//        datas.add(data);
//        data = new Data("KitKat", 27.0f, Color.GREEN);
//        datas.add(data);
//        data = new Data("Lollipop", 40.0f, Color.BLUE);
//        datas.add(data);
//        data = new Data("Marshmallow", 60.0f, Color.RED);
//        datas.add(data);
//        data = new Data("Nougat", 33.5f, Color.YELLOW);
//        datas.add(data);
//        total = 0.0f;
//        max = Float.MIN_VALUE;
//        for (Data d : datas) {
//            total += d.getNumber();
//            max = Math.max(max, d.getNumber());
//        }
//        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
////        paint.setAntiAlias(true);
//        paint.setStrokeWidth(2);
//        paint.setTextSize(30);
//        rectF = new RectF(-300, -300, 300, 300);
//    }
//
//    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        canvas.translate(canvas.getWidth() / 2, canvas.getHeight() / 2);  // 将画布(0，0)坐标点移到画布的中心
//        startAngle = 0f; //这句代码很重要，不然有bug
//        paint.setStyle(Paint.Style.FILL);
//        for (Data data : datas) {
//            paint.setColor(data.getColor());
//            // 计算所占百分比
//            sweepAngle = data.getNumber() / total * 360f;
//            // 线所在的角度
//            lineAngle = startAngle + sweepAngle / 2;
//            // 线起始x, y坐标      角度/180*PI（角度换算弧度）
//            lineStartX = radius * (float) Math.cos(lineAngle / 180 * Math.PI);
//            lineStartY = radius * (float) Math.sin(lineAngle / 180 * Math.PI);
//            lineEndX = (radius + 50) * (float) Math.cos(lineAngle / 180 * Math.PI);
//            lineEndY = (radius + 50) * (float) Math.sin(lineAngle / 180 * Math.PI);
//            if (data.getNumber() == max) {
//                canvas.save();
//                canvas.translate(lineStartX * 0.1f, lineStartY * 0.1f);
//                canvas.drawArc(rectF, startAngle, sweepAngle, true, paint);
//            } else {
//                canvas.drawArc(rectF, startAngle, sweepAngle - 1.0f, true, paint);
//            }
//            paint.setColor(Color.WHITE);
//            paint.setStyle(Paint.Style.STROKE);
//            canvas.drawLine(lineStartX, lineStartY, lineEndX, lineEndY, paint);
//            if (lineAngle > 90 && lineAngle <= 270) {
//                canvas.drawLine(lineEndX, lineEndY, lineEndX - 50, lineEndY, paint);
//                paint.setStyle(Paint.Style.FILL);
//                canvas.drawText(data.getName(), lineEndX - 50 - 10 - paint.measureText(data.getName()), lineEndY, paint);
//            } else {
//                canvas.drawLine(lineEndX, lineEndY, lineEndX + 50, lineEndY, paint);
//                paint.setStyle(Paint.Style.FILL);
//                canvas.drawText(data.getName(), lineEndX + 50 + 10, lineEndY, paint);
//            }
//            if (data.getNumber() == max) {
////                canvas.restore();
//            }
//            startAngle += sweepAngle;
//        }
//
////        综合练习
////        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
//    }

    Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint txtPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    RectF mRectF = new RectF();
    Path mPath = new Path();

    List<PhoneModel> phoneModels = new ArrayList<>();

    {
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_huawei), R.color.colorHuawei, 48));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_samsung), R.color.colorSamsung, 10));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_lenovo), R.color.colorLenovo, 21));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_mi), R.color.colorMi, 26));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_oppo), R.color.colorOppo, 12));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_vivo), R.color.colorVivo, 6));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_meizu), R.color.colorMeizu, 9));
        phoneModels.add(new PhoneModel(getContext().getResources().getString(R.string.phone_brand_other), R.color.colorOther, 10));
    }

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int marginBottom = 40;
        // 绘制标题
        String title = "2019上半年安卓手机市场占比";
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(48);
        mPaint.setColor(Color.WHITE);
        canvas.drawText(title, getWidth() / 2, getHeight() - marginBottom, mPaint);

        float allData = 0;
        for (PhoneModel data : phoneModels) {
            allData += data.percent;
        }

        // 分割倍率
        float to360 = 360 / allData;

        // 默认扇形中心坐标
        float xO = getWidth() / 2, yO = (getHeight() - marginBottom) / 2;

        // 半径
        float r = 280;

        // 起始位置
        float startAngle = 0;

        float intSet = -188;

        // 椭圆四边
        float left, right, top, bottom;

        int offset;

        // 扇形弧线中点坐标
        float midX, midY;

        // 线xy
        float line2X, line2Y, line1X, line1Y, line2, txtX, txtY;

        float marginPhone = 200;

        for (int i = 0; i < phoneModels.size(); i++) {
            PhoneModel phoneModel = phoneModels.get(i);

            boolean isFirst = phoneModel.brand.equals(getContext().getString(R.string.phone_brand_huawei));

            offset = isFirst ? 20 : 0;

            if (isFirst) {
                startAngle = intSet;
            } else {
                startAngle += phoneModels.get(i - 1).percent * to360;
            }

            double lineAngle = startAngle + phoneModel.percent / 2;

            // 确定圆心
            if (isFirst) {
                xO += offset * Math.cos(lineAngle * Math.PI / 180);
                yO += offset * Math.sin(lineAngle * Math.PI / 180);
            } else {
                xO = getWidth() / 2;
                yO = (getHeight() - marginBottom) / 2;
            }

            // 第一条线起始位置
            midX = (float) (xO + Math.cos(lineAngle * Math.PI / 180) * r);
            midY = (float) (yO + Math.sin(lineAngle * Math.PI / 180) * r);

            // 第一条线结束位置
            line1X = (float) (xO + Math.cos(lineAngle * Math.PI / 180) * (r + 25));
            line1Y = (float) (yO + Math.sin(lineAngle * Math.PI / 180) * (r + 25));

            if (line1X > xO) {
                // 线在右侧
                line2 = (int) (getWidth() - line1X - marginPhone);
            } else {
                // 线在左侧
                line2 = (int) (getWidth() / 2 - (getWidth() / 2 - line1X) - marginPhone);
            }

            // 取绝对值判断
            line2X = Math.abs(lineAngle) <= 90 ? line1X + line2 : line1X - line2;
            line2Y = line1Y;

            txtX = Math.abs(lineAngle) <= 90 ? line2X + 20 : line2X - 20;
            txtY = line1Y;

            // 绘制折线
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setColor(Color.WHITE);
            mPath.moveTo(midX, midY);
            mPath.lineTo(line1X, line1Y);
            mPath.lineTo(line2X, line2Y);
            canvas.drawPath(mPath, mPaint);

            // 绘制手机厂商名
            txtPaint.setStyle(Paint.Style.STROKE);
            txtPaint.setColor(Color.WHITE);
            txtPaint.setTextSize(24);
            if (Math.abs(lineAngle) <= 90) {
                txtPaint.setTextAlign(Paint.Align.LEFT);
            } else {
                txtPaint.setTextAlign(Paint.Align.RIGHT);
            }
            String name = phoneModels.get(i).brand + " " + phoneModels.get(i).percent + " %";
            canvas.drawText(name, txtX, txtY, txtPaint);

            left = xO - r;
            right = xO + r;
            top = yO - r;
            bottom = yO + r;

            mRectF.set(left, top, right, bottom);

            mPaint.setColor(getResources().getColor(phoneModel.color));
            mPaint.setStyle(Paint.Style.FILL);

            canvas.drawArc(mRectF, startAngle, (float) phoneModel.percent * to360, true, mPaint);
        }
    }

    //    @Override
//    protected void onDraw(Canvas canvas) {
//        super.onDraw(canvas);
//
//        int marginBottom = 40;
//        int marginPhone = 200;
//
//        // 绘制标题
//        String title = "2019上半年安卓手机市场占比";
//        mPaint.setTextAlign(Paint.Align.CENTER);
//        mPaint.setTextSize(48);
//        mPaint.setColor(Color.WHITE);
//        canvas.drawText(title, getWidth() / 2, getHeight() - marginBottom, mPaint);
//
//        // 扇形绘制起点
//        int outset = -188;
//
//        // 对比 360 度转换倍率
//        double to360 = 3.43;
//
//        // 手机占比
//        double percent;
//
//        // 扇形开始角度、划过一半角度
//        float startAngle = 0, midAngle;
//
//        // 折线两段线
//        int line1 = 25, line2;
//
//        // 椭圆四边
//        float left, right, top, bottom;
//
//        // 圆的半径及坐标
//        float r = 280, oX, oY;
//        oX = getWidth() / 2;
//        oY = (getHeight() - marginBottom) / 2;
//
//        // 扇形弧线中点坐标
//        float midX, midY;
//
//        // 文字坐标
//        float txtX, txtY;
//
//        // 折线坐标
//        float line1X, line1Y, line2X, line2Y;
//
//        boolean isSelected;
//
//        int offset;
//
//        for (int i = 0; i < phoneModels.size(); i++) {
//
//            // 选择哪个手机品牌
//            isSelected = i == 0;
//
//            offset = isSelected ? 20 : 0;
//
//            percent = phoneModels.get(i).percent * to360;
//
//            if (i == 0) {
//                startAngle = outset;
//            } else {
//                startAngle += phoneModels.get(i - 1).percent * to360 + 2;
//            }
//
//            // 画线角度位置
//            midAngle = startAngle + (float) (percent / 2);
//
//            // 定位圆心
//            if (isSelected) {
//                oX += offset * Math.cos(midAngle * Math.PI / 180);
//                oY += offset * Math.sin(midAngle * Math.PI / 180);
//            } else {
//                oX = getWidth() / 2;
//                oY = (getHeight() - marginBottom) / 2;
//            }
//
//            left = oX - r;
//            right = oX + r;
//            top = oY - r;
//            bottom = oY + r;
//
//            midX = (float) (oX + Math.cos(midAngle * Math.PI / 180) * r);
//            midY = (float) (oY + Math.sin(midAngle * Math.PI / 180) * r);
//
//            line1X = (float) (oX + Math.cos(midAngle * Math.PI / 180) * (r + line1));
//            line1Y = (float) (oY + Math.sin(midAngle * Math.PI / 180) * (r + line1));
//
//            if (line1X > oX) {
//                // 线在右侧
//                line2 = (int) (getWidth() - line1X - marginPhone);
//            } else {
//                // 线在左侧
//                line2 = (int) (getWidth() / 2 - (getWidth() / 2 - line1X) - marginPhone);
//            }
//
//            line2X = Math.abs(midAngle) <= 90 ? line1X + line2 : line1X - line2;
//            line2Y = line1Y;
//
//            txtX = Math.abs(midAngle) <= 90 ? line2X + 20 : line2X - 20;
//            txtY = line1Y;
//
//            // 绘制折线
//            mPaint.setStyle(Paint.Style.STROKE);
//            mPaint.setColor(Color.WHITE);
//            mPath.moveTo(midX, midY);
//            mPath.lineTo(line1X, line1Y);
//            mPath.lineTo(line2X, line2Y);
//            canvas.drawPath(mPath, mPaint);
//
//            // 绘制手机厂商名
//            txtPaint.setStyle(Paint.Style.STROKE);
//            txtPaint.setColor(Color.WHITE);
//            txtPaint.setTextSize(24);
//            if (Math.abs(midAngle) <= 90) {
//                txtPaint.setTextAlign(Paint.Align.LEFT);
//            } else {
//                txtPaint.setTextAlign(Paint.Align.RIGHT);
//            }
//            String name = phoneModels.get(i).brand + " " + phoneModels.get(i).percent + " %";
//            canvas.drawText(name, txtX, txtY, txtPaint);
//
//            // 绘制扇形
//            mPaint.setStyle(Paint.Style.FILL);
//            mPaint.setColor(getResources().getColor(phoneModels.get(i).color));
//            mRectF.set(left, top, right, bottom);
//            canvas.drawArc(mRectF, startAngle, (float) percent, true, mPaint);
//        }
//    }

    private class PhoneModel {

        String brand;
        @ColorRes
        int color;
        double percent;

        PhoneModel(String brand, @ColorRes int color, double percent) {
            this.brand = brand;
            this.color = color;
            this.percent = percent;
        }

    }
}

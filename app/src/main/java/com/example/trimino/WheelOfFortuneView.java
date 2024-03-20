package com.example.trimino;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

class WheelOfFortuneView extends View {
    private Paint sectorPaint;
    private Paint textPaint;
    private RectF bounds;
    private String[] labels = {"Stack", "10", "200", "50", "100", "5", "500"};

    public WheelOfFortuneView(Context context) {
        super(context);
        init();
    }

    public WheelOfFortuneView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        sectorPaint = new Paint();
        sectorPaint.setStyle(Paint.Style.FILL);
        textPaint = new Paint();
        textPaint.setColor(Color.WHITE);
        textPaint.setTextSize(30);
        textPaint.setTextAlign(Paint.Align.RIGHT);
        bounds = new RectF();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int totalSectors = labels.length;
        float startAngle = 0;
        float sweepAngle = 360f / totalSectors;

        for (int i = 0; i < totalSectors; i++) {
            sectorPaint.setColor(Color.parseColor(getSectorColor(i)));
            canvas.drawArc(bounds, startAngle, sweepAngle, true, sectorPaint);

            float textAngle = (float) Math.toRadians(startAngle + sweepAngle / 2);
            float x = (float) (getWidth() / 2 + Math.cos(textAngle) * (getWidth() / 2 - 10));
            float y = (float) (getHeight() / 2 + Math.sin(textAngle) * (getHeight() / 2 - 10));
            canvas.drawText(labels[i], x, y, textPaint);

            startAngle += sweepAngle;
        }
    }

    private String getSectorColor(int index) {
        switch (index) {
            case 0:
                return "#f82";
            case 1:
                return "#0bf";
            case 2:
                return "#fb0";
            case 3:
                return "#0fb";
            case 4:
                return "#b0f";
            case 5:
                return "#f0b";
            case 6:
                return "#bf0";
            default:
                return "#000000";
        }
    }
}

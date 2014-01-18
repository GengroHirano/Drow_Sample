package com.example.draw_andsave;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class TouchPaint extends View {

    private float oldX = 0f, oldY = 0f;
    private Paint paint;

    public TouchPaint(Context context) {
        super(context);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.LTGRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeJoin(Paint.Join.ROUND);
    }

    Bitmap _bitmap;
    Canvas _canvas;

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        _bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        _canvas = new Canvas(_bitmap);
    }

    public int changeColor(int n){
    	switch(n)
    	{
    		case 0: paint.setColor(Color.GREEN); n++; break;
    		case 1: paint.setColor(Color.RED); n++; break;
    		case 2: paint.setColor(Color.MAGENTA); n++; break;
    		case 3: paint.setColor(Color.YELLOW); n++; break;
    		case 4: paint.setColor(Color.BLUE); n++; break;
    		default : paint.setColor(Color.LTGRAY); n=0; break;
    	}
    	return n;
    }



    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction()) {
        case MotionEvent.ACTION_DOWN:
            oldX = e.getX();
            oldY = e.getY();
            break;
        case MotionEvent.ACTION_MOVE:
            _canvas.drawLine(oldX, oldY, e.getX(), e.getY(), paint);
            oldX = e.getX();
            oldY = e.getY();
            invalidate();
            break;
        default:
            break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(_bitmap, 0, 0, null);
    }
}

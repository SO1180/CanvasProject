package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Board extends View {

    float x,y,r;
    float deltax, deltay;
    Paint p;
    Context context;

    public Board(Context context) {
        super(context);
        this.context = context;

        y=100;
        deltax=10;
        deltay=5;
        r=60;
        x=r;
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(12);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x,y,r,p);
        x = x + deltax;
        y = y + deltay;

        if(x<r || x>canvas.getWidth() - r)
            deltax = -deltax;
        if(y<r || y>canvas.getHeight() - r)
            deltay = -deltay;
        invalidate();
    }
}



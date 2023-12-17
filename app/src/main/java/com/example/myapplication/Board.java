package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class Board extends View {

    Bitmap bitmap;
    float x, y, r;
    float deltax, deltay;
    Paint p;
    Context context;

    public Board(Context context) {
        super(context);
        this.context = context;

        y = 100;
        deltax = 10;
        deltay = 5;
        r = 10;
        x = r;
        p = new Paint();
        p.setColor(Color.BLUE);
        p.setStrokeWidth(12);

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bamba_snack);
        bitmap = Bitmap.createScaledBitmap(bitmap, 300, 300, false);

    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // canvas.drawCircle(x,y,r,p);
        x = x + deltax;
        y = y + deltay;

        canvas.drawBitmap(bitmap, x - r, y - r, null);

        if (x < r || x > canvas.getWidth() - bitmap.getWidth())
            deltax = -deltax;
        if (y < r || y > canvas.getHeight() - bitmap.getHeight() - canvas.getHeight()/10)
            deltay = -deltay;

        canvas.drawColor(R.color.mypurple);
        Paint paintTitle = new Paint();
        paintTitle.setARGB(50, 20, 50, 100);
        paintTitle.setTextAlign(Paint.Align.CENTER);
        paintTitle.setTextSize(70);
        canvas.drawText("Shira is here", canvas.getWidth() / 2, 75, paintTitle);

        //Rect r = new Rect((int)x, (int)y,  (int)x + 200,  (int)y + 200);
        //canvas.drawRect(r, paintTitle);
        canvas.drawBitmap(bitmap, x - r, y - r, null);



        invalidate();
    }
}


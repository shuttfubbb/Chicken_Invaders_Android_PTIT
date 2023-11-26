package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Circle extends GameObject{
    protected double radius;
    protected Paint paint;
    public Circle(Context context, int color, double positionX, double positionY, double radius) {
        super(positionX, positionY);
        this.radius = radius;
        this.paint = new Paint();
        this.paint.setColor(color);
    }

    public static boolean isColliding(Circle obj1, Circle obj2) {
        return getDistanceBetweenObjects(obj1, obj2) <= obj1.getRadius() + obj2.getRadius();
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle((float) positionX, (float) positionY, (float) radius, paint);
    }

    public double getRadius(){
        return radius;
    }


}

package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;

import androidx.core.content.ContextCompat;

public class Spell extends Circle{

    public static final double SPEED_PIXELS_PER_SECOND = 1000;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private double direction;

    public Spell(Context context, double positionX, double positionY, double MAX_SPEED, int direction) {
        super(context , ContextCompat.getColor(context, R.color.spell), positionX, positionY, 20);
        this.direction = direction;
        double radians = Math.toRadians(direction);
        double sinR = Math.sin(radians);
        double cosR = Math.cos(radians);
        verlocityX = sinR * MAX_SPEED;
        verlocityY = cosR * MAX_SPEED;
    }

    @Override
    public void update() {
        positionX -= verlocityX;
        positionY -= verlocityY;
//        positionX += 0;
//        positionY += -30;
    }
}

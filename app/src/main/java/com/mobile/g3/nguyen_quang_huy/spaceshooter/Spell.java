package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Spell extends Circle{

    public static final double SPEED_PIXELS_PER_SECOND = 1000;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private double direction;
    private Sprite sprite;

    public Spell(Context context, double positionX, double positionY, double MAX_SPEED, int direction) {
        super(context , ContextCompat.getColor(context, R.color.spell), positionX, positionY, 20);
        this.direction = direction;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.pbullet);
        Matrix matrix = new Matrix();
        matrix.postRotate(direction);

        Bitmap rotatedBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true);
        frames.add(rotatedBitmap);
        this.sprite = new Sprite(frames, 1, true);
        double radians = Math.toRadians(direction);
        double sinR = Math.sin(radians);
        double cosR = Math.cos(radians);
        verlocityX = sinR * MAX_SPEED;
        verlocityY = cosR * MAX_SPEED;
    }

    @Override
    public void update() {
        positionX += verlocityX;
        positionY -= verlocityY;
    }
    public void draw(Canvas canvas){
        sprite.draw(canvas, this);
    }
}

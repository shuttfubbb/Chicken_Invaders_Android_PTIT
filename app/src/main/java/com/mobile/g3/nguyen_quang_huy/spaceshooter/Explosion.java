package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Explosion extends Circle{
    public Sprite sprite;

    public Explosion(Context context, double positionX, double positionY) {
        super(context, ContextCompat.getColor(context, R.color.explosion), positionX, positionY, 30);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion1));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion2));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion3));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion4));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion5));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion6));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion7));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion8));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.explosion9));
        this.sprite = new Sprite(frames, 15, false);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(Canvas canvas) {
        sprite.draw(canvas, this);
    }
}

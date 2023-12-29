package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Cherry extends Circle{
    private Sprite sprite;

    public Cherry(Context context, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.spell), positionX, positionY, radius);

        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry1));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry2));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry3));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry4));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry5));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry6));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry7));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry8));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.cherry9));

        this.sprite = new Sprite(frames, 10, true);
    }
    @Override
    public void update() {
        positionY += 4;
    }
    public void draw(Canvas canvas){
        sprite.draw(canvas, this);
    }
}

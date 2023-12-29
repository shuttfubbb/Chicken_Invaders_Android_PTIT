package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Star extends Circle{

    private Sprite sprite;
    public Star(Context context, double positionX, double positionY, double radius) {
        super(context, ContextCompat.getColor(context, R.color.spell), positionX, positionY, radius);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.star1));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.star2));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.star3));
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.star4));

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

package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Bullet extends Circle{
    public static final double SPEED_PIXELS_PER_SECOND = 1000;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private Sprite sprite;
    public Bullet(Context context, Player spellcaster) {
        super(context , ContextCompat.getColor(context, R.color.spell), spellcaster.getPositionX(), spellcaster.getPositionY(), 20);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.pbullet));
        this.sprite = new Sprite(frames, 1, true);
        verlocityX = spellcaster.getDirectionX()*MAX_SPEED;
        verlocityY = spellcaster.getDirectionY()*MAX_SPEED;
    }

    @Override
    public void update() {
//        positionX += verlocityX;
//        positionY += verlocityY;
        positionX += 0;
        positionY += -30;
    }
    public void draw(Canvas canvas){
        sprite.draw(canvas, this);
    }
}

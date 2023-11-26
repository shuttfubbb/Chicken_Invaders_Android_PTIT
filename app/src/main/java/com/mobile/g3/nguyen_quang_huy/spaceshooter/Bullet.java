package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;

import androidx.core.content.ContextCompat;

public class Bullet extends Circle{

    public static final double SPEED_PIXELS_PER_SECOND = 1000;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;

    public Bullet(Context context, Player spellcaster) {
        super(context , ContextCompat.getColor(context, R.color.spell), spellcaster.getPositionX(), spellcaster.getPositionY(), 20);
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
}

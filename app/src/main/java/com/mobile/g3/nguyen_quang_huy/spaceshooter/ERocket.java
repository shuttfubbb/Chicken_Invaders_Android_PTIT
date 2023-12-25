package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.util.ArrayList;
import java.util.List;

public class ERocket extends Bullet{
    protected Player player;
    private int effDurationRemain = 120;
    public ERocket(Context context, Player player, double positionX, double positionY, double radius, double MAX_SPEED) {
        super(context, positionX, positionY, radius, MAX_SPEED);
        this.player = player;
        this.radius = radius;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy3));
        this.sprite = new Sprite(frames, 15, true);
    }

    public int getEffDurationRemain() {
        return effDurationRemain;
    }

    public void setEffDurationRemain(int effDurationRemain) {
        this.effDurationRemain = effDurationRemain;
    }

    public void update() {
        effDurationRemain -= 1;

        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);

        double directionX = distanceToPlayerX/distanceToPlayer;
        double directionY = distanceToPlayerY/distanceToPlayer;

        if(distanceToPlayer > 0) { // Avoid division by zero
            verlocityX = directionX*MAX_SPEED;
            verlocityY = directionY*MAX_SPEED;
        } else {
            verlocityX = 0;
            verlocityY = 0;
        }

        positionX += verlocityX;
        positionY += verlocityY;

        direction = Math.asin(directionX);
    }
}

package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

public class Enemy3 extends Enemy{
    private int state = 0;
    private int changeStatetimeRemain = 1;

    public Enemy3(Context context, Player player) {
        super(context, player);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy2));
        this.sprite = new Sprite(frames, 1, true);
        this.SPAWNS_PER_MINUTE = 10;
        verlocityX = 8;
        verlocityY = 2;
        this.hp = 15;
        this.reward = 15;
    }

    public Enemy3(Context context, Player player, double radius) {
        super(context, player, radius);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy2));
        this.sprite = new Sprite(frames, 1, true);
        this.SPAWNS_PER_MINUTE = 10;
        verlocityX = 8;
        verlocityY = 2;
        this.hp = 15;
        this.reward = 15;
    }

    public Enemy3(Context context, Player player, double radius, double speedCoeff) {
        super(context, player, radius, speedCoeff);
        this.positionY = 20;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy2));
        this.sprite = new Sprite(frames, 1, true);
        this.SPAWNS_PER_MINUTE = 10;
        verlocityX = 8 * speedCoeff;
        verlocityY = 2 * speedCoeff;
        this.hp = 15;
        this.reward = 15;
    }

    @Override
    public void update() {
        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);
        if(distanceToPlayer <= 0){
            verlocityX = 0;
            verlocityY = 0;
        }
        // Cap nhat vi tri enemy
        positionX += verlocityX;
        positionY += verlocityY;

        changeStatetimeRemain += 1;
        changeStatetimeRemain %= 300;
        if(changeStatetimeRemain == 0){
            state += 1;
            state %= 2;
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getChangeStatetimeRemain() {
        return changeStatetimeRemain;
    }

    public void setChangeStatetimeRemain(int changeStatetimeRemain) {
        this.changeStatetimeRemain = changeStatetimeRemain;
    }
}

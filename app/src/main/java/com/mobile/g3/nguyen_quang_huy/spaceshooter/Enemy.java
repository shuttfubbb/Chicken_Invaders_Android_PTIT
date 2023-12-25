package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class Enemy extends Circle{
    protected static double SPAWNS_PER_MINUTE = 40;
    protected static double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE/60.0;
    protected static double UPDATES_PER_SPAWN = GameLoop.MAX_UPS/SPAWNS_PER_SECOND;
    protected static double updatesUntilNextSpawn = UPDATES_PER_SPAWN;
    protected final Player player;
    protected Sprite sprite;
    protected int hp = 1;
    protected int reward = 1;

    public Enemy(Context context, Player player) {
        super(context, ContextCompat.getColor(context, R.color.enemy), Math.random()*900 + 100, 0, 30);
        this.player = player;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy0));
        this.sprite = new Sprite(frames, 1, true);
        verlocityX = -15;
        verlocityY = 1;
    }

    public Enemy(Context context, Player player, double radius) {
        super(context, ContextCompat.getColor(context, R.color.enemy), Math.random()*900 + 100, 0, radius);
        this.player = player;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy0));
        this.sprite = new Sprite(frames, 1, true);
        verlocityX = -15;
        verlocityY = 1;
    }

    public Enemy(Context context, Player player, double radius, double speedCoeff) {
        super(context, ContextCompat.getColor(context, R.color.enemy), Math.random()*900 + 100, 0, radius);
        this.player = player;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy0));
        this.sprite = new Sprite(frames, 1, true);
        verlocityX = -15 * speedCoeff;
        verlocityY = 1 * speedCoeff;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getReward() {
        return reward;
    }

    public static boolean readyToSpawn() {
        if (updatesUntilNextSpawn <= 0) {
            updatesUntilNextSpawn += UPDATES_PER_SPAWN;
            return true;
        } else {
            updatesUntilNextSpawn --;
            return false;
        }
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
    }

    public void draw(Canvas canvas){
        sprite.draw(canvas, this);
    }
}

package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;
import java.util.List;

public class Enemy2 extends Enemy{

    public Enemy2(Context context, Player player) {
        super(context, player);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy1));
        this.sprite = new Sprite(frames, 1, true);
        this.SPAWNS_PER_MINUTE = 10;
        verlocityX = -10;
        verlocityY = 0.7;
        this.hp = 5;
        this.reward = 5;
    }

    public Enemy2(Context context, Player player, double radius) {
        super(context, player, radius);
        List<Bitmap> frames = new ArrayList<Bitmap>();
        frames.add(BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy1));
        this.sprite = new Sprite(frames, 1, true);
        this.SPAWNS_PER_MINUTE = 10;
        verlocityX = -10;
        verlocityY = 0.7;
        this.hp = 5;
        this.reward = 5;
    }
}

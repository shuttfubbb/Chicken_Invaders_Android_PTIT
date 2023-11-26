package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;

import androidx.core.content.ContextCompat;

public class Enemy extends Circle{
    private static final double SPEED_PIXELS_PER_SECOND = Player.SPEED_PIXELS_PER_SECOND * 0.5;
    private static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private static final double SPAWNS_PER_MINUTE = 20;
    private static final double SPAWNS_PER_SECOND = SPAWNS_PER_MINUTE/60.0;
    private static final double UPDATES_PER_SPAWN = GameLoop.MAX_UPS/SPAWNS_PER_SECOND;
    private static double updatesUntilNextSpawn = UPDATES_PER_SPAWN;
    private final Player player;

    public Enemy(Context context, Player player) {
        super(context, ContextCompat.getColor(context, R.color.enemy), Math.random()*1000, Math.random()*1000, 30);
        this.player = player;
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
        double distanceToPlayerX = player.getPositionX() - positionX;
        double distanceToPlayerY = player.getPositionY() - positionY;

        double distanceToPlayer = GameObject.getDistanceBetweenObjects(this, player);

        double directionX = distanceToPlayerX/distanceToPlayer;
        double directionY = distanceToPlayerY/distanceToPlayer;
        if(distanceToPlayer > 0){
            verlocityX = directionX*MAX_SPEED;
            verlocityY = directionY*MAX_SPEED;
        }
        else{
            verlocityX = 0;
            verlocityY = 0;
        }
        // Cap nhat vi tri enemy
        positionX += verlocityX;
        positionY += verlocityY;
    }
}

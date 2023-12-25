package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import androidx.core.content.ContextCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player extends Circle implements Serializable{
    public static final double SPEED_PIXELS_PER_SECOND = 1000;
    public static final double MAX_SPEED = SPEED_PIXELS_PER_SECOND / GameLoop.MAX_UPS;
    private final Joystick joystick;
    private Sprite sprite;
    private int health = 3;
    private int remainGhostStep = 0;
    private int remainSkillStep = 0;
    private List<Bitmap> frames1 = new ArrayList<Bitmap>();
    private List<Bitmap> frames2 = new ArrayList<Bitmap>();

    public Player(Context context, Joystick joystick, double positionX, double positionY, double radius){
        super(context, ContextCompat.getColor(context, R.color.player), positionX, positionY, radius);
        this.joystick = joystick;
        Bitmap player0 = BitmapFactory.decodeResource(context.getResources(), R.drawable.player0);
        Bitmap player1 = BitmapFactory.decodeResource(context.getResources(), R.drawable.player1);
        frames1.add(player0);
        frames2.add(player0);
        frames2.add(player1);
        this.sprite = new Sprite(frames1, 10, true);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRemainGhostStep() {
        return remainGhostStep;
    }

    public void setRemainGhostStep(int remainGhostStep) {
        this.remainGhostStep = remainGhostStep;
    }

    public int getRemainSkillStep() {
        return remainSkillStep;
    }

    public void setRemainSkillStep(int remainSkillStep) {
        this.remainSkillStep = remainSkillStep;
    }

    public void draw(Canvas canvas){
        sprite.draw(canvas, this);
    }


    public void update() {
        // Cap nhat van toc dua vao joystick
        verlocityX = joystick.getActuatorX()*MAX_SPEED;
        verlocityY = joystick.getActuatorY()*MAX_SPEED;
        // Cap nhat vi tri
        positionX += verlocityX;
        positionY += verlocityY;

        //Cap nhat huong
        if(verlocityX != 0 || verlocityY != 0){
            double distance = Utils.getDistanceBetweenPoints(0, 0, verlocityX, verlocityY);
            directionX = verlocityX/distance;
            directionY = verlocityY/distance;
        }
        // Cap nhat thoi gian dung skill
        remainSkillStep = Math.max(0, remainSkillStep - 1);
        // Cap nhat thoi gian tang hinh
        remainGhostStep = Math.max(0, remainGhostStep - 1);
        if(remainGhostStep != 0){
            sprite.setFrames(frames2);
        }else{
            sprite.setFrames(frames1);
        }
    }
}

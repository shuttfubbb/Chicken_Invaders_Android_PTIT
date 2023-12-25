package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.graphics.Canvas;

public abstract class GameObject {
    protected double positionX;
    protected double positionY;
    protected double verlocityX = 0;
    protected double verlocityY = 0;
    protected double directionX = 1;
    protected double directionY = 0;

    public GameObject(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public abstract void draw(Canvas canvas);

    public abstract void update();
    public double getPositionX(){
        return positionX;
    }
    public double getPositionY(){
        return positionY;
    }
    public double getDirectionX() {
        return directionX;
    }
    public double getDirectionY() {
        return directionY;
    }
    public double getVerlocityX() {
        return verlocityX;
    }
    public void setVerlocityX(double verlocityX) {
        this.verlocityX = verlocityX;
    }
    public double getVerlocityY() {
        return verlocityY;
    }
    public void setVerlocityY(double verlocityY) {
        this.verlocityY = verlocityY;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    protected static double getDistanceBetweenObjects(GameObject obj1, GameObject obj2){
        return Math.sqrt(
            Math.pow(obj2.getPositionX() - obj1.getPositionX(), 2) +
            Math.pow(obj2.getPositionY() - obj1.getPositionY(), 2)
        );
    }
}

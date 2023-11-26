package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;

import java.util.List;

public class Sprite {
    private List<Bitmap> frames;
    private double UPS = GameLoop.MAX_UPS;
    private double FPS;
    private int NUMBER_UPDATE_FOR_NEXT_FRAME ;
    private int cnt_step = 0;
    private int cnt_frame = 0;
    private boolean isLoop;
    private boolean endLoop = false;
    private float width;
    private float height;
    public Sprite(List<Bitmap> frames, int FPS, boolean isLoop) {
        this.frames = frames;
        this.width = frames.get(0).getWidth();
        this.height = frames.get(0).getHeight();
        this.FPS = FPS;
        this.NUMBER_UPDATE_FOR_NEXT_FRAME = (int) (UPS/FPS);
        this.isLoop = isLoop;
    }
    public List<Bitmap> getFrames() {
        return frames;
    }
    public void setFrames(List<Bitmap> frames) {
        this.frames = frames;
    }
    public void draw(Canvas canvas, Circle obj) {
        if(cnt_frame == frames.size()){
            if(isLoop){
                cnt_frame = 0;
            }
            else{
                endLoop = true;
                return;
            }
        }
        cnt_step++;
        canvas.drawBitmap(this.frames.get(cnt_frame), (float) (obj.getPositionX()-width/2), (float) (obj.getPositionY()-height/2), null);
        if(cnt_step >= NUMBER_UPDATE_FOR_NEXT_FRAME) {
            cnt_frame ++;
            cnt_step = 0;
        }
    }

    public boolean isEndLoop() {
        return endLoop;
    }
}

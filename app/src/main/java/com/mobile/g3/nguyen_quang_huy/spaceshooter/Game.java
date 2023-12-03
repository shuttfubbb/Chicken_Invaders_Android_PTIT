package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*
* Game manages all object in the game and is reponsible for updating all states and render all objects to the screen
* */
public class Game extends SurfaceView implements SurfaceHolder.Callback {
    Member member;
    History history;
    static int screenWidth, screenHeight;
    private final Player player;
    private final Joystick joystick;
    private final int MAX_HEALTH = 3;
    private final Bitmap heartImage0 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.heart0);
    private final Bitmap heartImage1 = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.heart1);
    private final Bitmap background = BitmapFactory.decodeResource(getContext().getResources(), R.drawable.background);
    private GameLoop gameLoop;
    private List<Enemy> enemyList = new ArrayList<Enemy>();
    private List<Enemy2> enemy2List = new ArrayList<Enemy2>();
    private List<Spell> spellList = new ArrayList<Spell>();
    private List<Bullet> bulletList = new ArrayList<Bullet>();
    private List<Explosion> explosionList = new ArrayList<Explosion>();
    private int joystickPointerId = 0;
    private int numberOfSpellToCast = 0;

    public Game(Context context, Member member) {
        super(context);

        // Get surface holder and add callback
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        gameLoop = new GameLoop(this, surfaceHolder);

        // Init Game Objects
        this.member = member;
        this.history = new History();
        joystick = new Joystick(400, 800, 160, 90);
        player = new Player(getContext(), joystick, 500, 500, 30);
        setFocusable(true);

        // Display
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenWidth = size.x;
        screenHeight = size.y;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getActionMasked()){
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                if(joystick.getIsPressed()){
                    // Joystick da duoc nhan truoc su kien nay
                    numberOfSpellToCast ++;
                }
                else if(joystick.isPressed((double)event.getX(), (double)event.getY())){
                    // Joystick da duoc nhan chinh su kien nay va lay ID cua joystick
                    joystickPointerId = event.getPointerId(event.getActionIndex());
                    joystick.setIsPressed(true);
                }
                else{
                    // Joystick hien tai khong duoc nhan
                    numberOfSpellToCast ++;
                }
                return true;
            case MotionEvent.ACTION_MOVE:
                // Joystick duoc nhan va ca dang di chuyen
                if(joystick.getIsPressed()){
                    joystick.setActuator((double)event.getX(), (double)event.getY());
                }
                return true;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
                if(joystickPointerId == event.getPointerId(event.getActionIndex())){
                    // Joystick duoc nha ra
                    joystick.setIsPressed(false);
                    joystick.resetActuator();
                }
                return true;
        }
        return super.onTouchEvent(event);
    }
    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if(gameLoop.getState().equals(Thread.State.TERMINATED)){
            gameLoop = new GameLoop(this, surfaceHolder);
        }
        gameLoop.startLoop();
    }
    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }
    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }
    public void drawScore(Canvas canvas){
        Paint paint = new Paint();
        int color = ContextCompat.getColor(this.getContext(), R.color.red);
        paint.setColor(color);
        paint.setTextSize(50);
        canvas.drawText("Score: " + player.getScore(), 60, 60, paint);
    }
    public void drawBackground(Canvas canvas){
        canvas.drawBitmap(background, 0, 0, null);
    }
    public void drawHeath(Canvas canvas){
        int margin = 30;
        for(int i=1; i<=MAX_HEALTH; ++i){
            if(i <= player.getHealth()) {
                canvas.drawBitmap(heartImage0, screenWidth - margin - (heartImage0.getWidth() + 10) * (MAX_HEALTH - i + 1), margin, null);
            }
            else {
                canvas.drawBitmap(heartImage1, screenWidth - margin - (heartImage1.getWidth() + 10) * (MAX_HEALTH - i + 1), margin, null);
            }
        }
    }
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drawBackground(canvas);
        drawScore(canvas);
        drawHeath(canvas);
        for(Explosion explosion : explosionList){
            explosion.draw(canvas);
        }
        player.draw(canvas);
        for(Enemy enemy : enemyList){
            enemy.draw(canvas);
        }
        for(Enemy2 enemy : enemy2List){
            enemy.draw(canvas);
        }
        for(Bullet bullet : bulletList){
            bullet.draw(canvas);
        }
        joystick.draw(canvas);
    }

    public void update() {
        if(player.getHealth() <= 0){
            Intent intent = new Intent(getContext(), EndGameActivity.class);
            history.setScore(player.getScore());
            history.setMember(this.member);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                history.setDatetime(LocalDateTime.now());
            }
            intent.putExtra("history", history);
            intent.putExtra("member", member);
            getContext().startActivity(intent);
            ((Activity) getContext()).finish();
            return;
        }
        // Update game state
        joystick.update();
        player.update();
        for(Bullet bullet : bulletList){
            bullet.update();
        }
        for(Enemy enemy : enemyList){
            if(enemy.getPositionX() >= screenWidth - enemy.getRadius() - 20){
                double vX = enemy.getVerlocityX();
                enemy.setVerlocityX(vX * -1);
            }
            if(enemy.getPositionX() <= enemy.getRadius() + 20){
                double vX = enemy.getVerlocityX();
                enemy.setVerlocityX(vX * -1);
            }
            enemy.update();
        }
        for(Enemy2 enemy : enemy2List){
            if(enemy.getPositionX() >= screenWidth - enemy.getRadius() - 20){
                double vX = enemy.getVerlocityX();
                enemy.setVerlocityX(vX * -1);
            }
            if(enemy.getPositionX() <= enemy.getRadius() + 20){
                double vX = enemy.getVerlocityX();
                enemy.setVerlocityX(vX * -1);
            }
            enemy.update();
        }
        // Quan ly khoi tao enemy va bullet
        if(Enemy.readyToSpawn()){
            enemyList.add(new Enemy(getContext(), player));
        }
        if(Enemy2.readyToSpawn()){
            enemy2List.add(new Enemy2(getContext(), player, 60));
        }
        while(numberOfSpellToCast > 0){
            bulletList.add(new Bullet(getContext(), player));
            numberOfSpellToCast--;
        }
        // Kiem tra va cham, phat no
        for(int i=0; i<enemyList.size(); ++i){
            if(Circle.isColliding(enemyList.get(i), player)){
                player.setHealth(Math.max(0, player.getHealth() - 1));
                explosionList.add(new Explosion(getContext(), enemyList.get(i).getPositionX(), enemyList.get(i).getPositionY()));
                enemyList.remove(i);
                continue;
            }
            for(int j=0; j<bulletList.size(); ++j){
                if(Circle.isColliding(enemyList.get(i), bulletList.get(j))){
                    player.setScore(player.getScore() + 1);
                    explosionList.add(new Explosion(getContext(), enemyList.get(i).getPositionX(), enemyList.get(i).getPositionY()));
                    enemyList.remove(i);
                    bulletList.remove(j);
                    break;
                }
            }
        }
        for(int i=0; i<enemy2List.size(); --i){
            if(Circle.isColliding(enemy2List.get(i), player)){
                player.setHealth(Math.max(0, player.getHealth() - 1));
                explosionList.add(new Explosion(getContext(), enemy2List.get(i).getPositionX(), enemy2List.get(i).getPositionY()));
                enemy2List.remove(i);
                continue;
            }
            for(int j=0; j<bulletList.size(); ++j){
                if(Circle.isColliding(enemy2List.get(i), bulletList.get(j))){
                    enemy2List.get(i).setHp(enemy2List.get(i).getHp() - 1);
                    explosionList.add(new Explosion(getContext(), enemy2List.get(i).getPositionX(), enemy2List.get(i).getPositionY()));
                    bulletList.remove(j);
                    if(enemy2List.get(i).getHp() == 0){
                        player.setScore(player.getScore() + enemy2List.get(i).getReward());
                        enemy2List.remove(i);
                    }
                    break;
                }
            }
        }
        for(int i=0; i<explosionList.size(); ++i){
            if(explosionList.get(i).sprite.isEndLoop()){
                explosionList.remove(i);
            }
        }

        // Khong cho player chay ra khoi man hinh
        if(player.getPositionX() >= screenWidth - player.getRadius()){
            player.setPositionX(screenWidth - player.getRadius());
        } else if (player.getPositionX() < player.getRadius()) {
            player.setPositionX(player.getRadius());
        }
        if(player.getPositionY() >= screenHeight - player.getRadius()){
            player.setPositionY(screenHeight - player.getRadius());
        } else if (player.getPositionY() < player.getRadius()) {
            player.setPositionY(player.getRadius());
        }
    }
    public void pause() {
        gameLoop.stopLoop();
    }
}

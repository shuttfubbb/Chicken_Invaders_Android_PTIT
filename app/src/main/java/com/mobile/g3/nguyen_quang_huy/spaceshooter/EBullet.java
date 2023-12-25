package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import java.util.ArrayList;
import java.util.List;

public class EBullet extends Bullet{

    public EBullet(Context context, double positionX, double positionY, double MAX_SPEED, int direction) {
        super(context, positionX, positionY, MAX_SPEED, direction);
        this.radius = 25;
        List<Bitmap> frames = new ArrayList<Bitmap>();
        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.ebullet);
        Matrix matrix = new Matrix();
        matrix.postRotate(direction);

        Bitmap rotatedBitmap = Bitmap.createBitmap(originalBitmap, 0, 0, originalBitmap.getWidth(), originalBitmap.getHeight(), matrix, true);
        frames.add(rotatedBitmap);
        this.sprite = new Sprite(frames, 1, true);
    }
}

package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class LevelDBH extends DBHelper{
    public LevelDBH(Context context) {
        super(context);
    }
    public ArrayList<Level> getAllLevel(){
        ArrayList<Level> levels = new ArrayList<Level>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cs = db.rawQuery("SELECT * FROM level", null);
        cs.moveToFirst();
        while (!cs.isAfterLast()){
            int id = cs.getInt(0);
            String name = cs.getString(1);
            double speedCoeff = cs.getDouble(2);
            double quantityCoeff = cs.getDouble(3);
            Level level = new Level(id, name, speedCoeff, quantityCoeff);
            levels.add(level);
            cs.moveToNext();
        }
        return levels;
    }
}

package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class HistoryDBH extends DBHelper{
    public HistoryDBH(Context context) {
        super(context);
    }

    public boolean add(History history){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("datetime", history.getDatetime().toString());
        values.put("score", history.getScore());
        values.put("idMember", history.getMember().getId());
        long row =  db.insert("history", null, values);
        return row > 0;
    }
}

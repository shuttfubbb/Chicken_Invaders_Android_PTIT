package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import model.History;

public class HistoryDBH extends DBHelper{
    public HistoryDBH(Context context) {
        super(context);
    }

    public boolean add(History history){
        // Conver sang timestamp
        LocalDateTime localDateTime = history.getDatetime();
        DateTimeFormatter formatter = null;
        String formattedDateTime = "2023-11-27 10:47:30";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            formattedDateTime = localDateTime.format(formatter);
        }
        // dua vao database
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("datetime", formattedDateTime);
        values.put("score", history.getScore());
        values.put("idMember", history.getMember().getId());
        values.put("idLevel", history.getLevel().getId());
        long row =  db.insert("history", null, values);
        return row > 0;
    }


}

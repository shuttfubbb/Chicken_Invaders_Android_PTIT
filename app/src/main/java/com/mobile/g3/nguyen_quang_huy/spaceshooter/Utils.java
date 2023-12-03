package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Utils {
    public static double getDistanceBetweenPoints(double p1x, double p1y, double p2x, double p2y) {
        return   Math.sqrt(Math.pow(p1x - p2x, 2) + Math.pow(p1y - p2y, 2));
    }

//    public ArrayList<History> getAllHistory(Integer idMember){
//        ArrayList<History> historyList = new ArrayList<History>();
//        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "SELECT * FROM history WHERE idMember = " + idMember;
//        Cursor cs = db.rawQuery(sql, null);
//        cs.moveToFirst();
//        while (!cs.isAfterLast()){
//            History history = new History();
//            Integer id = cs.getInt(0);
//            String timestampString = cs.getString(1).substring(0, 19);
//            Integer score = cs.getInt(2);
//            history.setId(id);
//            history.setScore(score);
//            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                LocalDateTime localDateTime = LocalDateTime.parse(timestampString, formatter);
//                history.setDatetime(localDateTime);
//            }
//            historyList.add(history);
//            cs.moveToNext();
//        }
//        return historyList;
//    }
}

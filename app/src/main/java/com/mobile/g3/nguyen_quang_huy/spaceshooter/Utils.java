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
}

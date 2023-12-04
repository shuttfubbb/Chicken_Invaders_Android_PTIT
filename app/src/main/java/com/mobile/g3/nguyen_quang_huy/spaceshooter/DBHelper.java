package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "btl", null, 6);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Tao database Member
        String sql = "CREATE TABLE member(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(30), " +
                "username VARCHAR(20), " +
                "password VARCHAR(20), " +
                "music INTEGER(10), " +
                "soueff INTEGER(10), " +
                "skin INTEGER(10));";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO member VALUES(null, 'Nguyen Quang Huy', 'huy', '123', 100, 100, 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO member VALUES(null, 'Nguyen Dang Tien', 'tien', '123', 100, 100, 1)";
        sqLiteDatabase.execSQL(sql);
        // Tao database Game
        sql = "CREATE TABLE level(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name VARCHAR(30), " +
                "speedCoeff DOUBLE, " +
                "quantityCoeff DOUBLE);";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO level VALUES(null, 'Easy', 1, 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO level VALUES(null, 'Hard', 3, 2)";
        sqLiteDatabase.execSQL(sql);
        // Tao database History
        sql = "CREATE TABLE history(id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "datetime TIMESTAMP, " +
                "score INTEGER(10), " +
                "idMember INTEGER(10), " +
                "idLevel INTEGER(10), " +
                "FOREIGN KEY(idLevel) REFERENCES level(id), " +
                "FOREIGN KEY(idMember) REFERENCES member(id));";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO history VALUES(null, '2023-10-30 10:10:10', 10, 1, 1)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO history VALUES(null, '2023-10-30 11:11:11', 12, 1, 2)";
        sqLiteDatabase.execSQL(sql);
        sql = "INSERT INTO history VALUES(null, '2023-11-01 14:14:14', 14, 2, 1)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS history");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS member");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS level");
        onCreate(sqLiteDatabase);
    }
}

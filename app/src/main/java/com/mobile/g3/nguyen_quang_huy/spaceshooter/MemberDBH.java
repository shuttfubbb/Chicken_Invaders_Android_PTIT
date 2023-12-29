package com.mobile.g3.nguyen_quang_huy.spaceshooter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import model.Member;

public class MemberDBH extends DBHelper{

    private static final String TABLE_NAME = "member";
    private static final String USER_COL = "username";
    private static final String PW_COL = "password";
    public MemberDBH(Context context) {
        super(context);
    }
    public boolean checkLogin(Member member){
        String username = member.getUsername();
        String password = member.getPassword();
        String querySelect = "SELECT * FROM " + TABLE_NAME + " WHERE "
                + USER_COL + " = '" + username + "' AND "
                + PW_COL + " = '" + password + "' ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(querySelect, null);

        if(c.moveToFirst()){
            Integer id = c.getInt(0);
            String name = c.getString(1);

            member.setId(id);
            member.setName(name);
            db.close();
            return true;
        }
        db.close();
        return false;
    }
}

package com.example.info2022abschluss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    //So ziemlich das gleiche wie für den Taschenrechner nur halt hierauf angepasst

    private static final String DATABASE_NAME = "tictactoeINFO";
    private static final Integer DATABASE_VERSION = 1;

    private static final String TABLE_MATCHES = "matches";

    private static final String COL_MATCHID = "matchID";
    private static final String COL_NAME1 = "name1";
    private static final String COL_WINNER = "win";
    private static final String COL_NAME2 = "name2";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_MATCHES +
                " (" + COL_MATCHID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME1 + " VARCHAR(24), " +
                COL_WINNER + " VARCHAR(24), " +
                COL_NAME2 + " VARCHAR(24))";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES);
        onCreate(sqLiteDatabase);
    }

    public void savePlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME1, player.getName1());
        values.put(COL_WINNER, player.getWinner());
        values.put(COL_NAME2, player.getName2());

        db.insert(TABLE_MATCHES, null, values);
        db.close();
    }
    public ArrayList<Player> loadPlayers() {
        ArrayList<Player> tempList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlquery = "SELECT * FROM " + TABLE_MATCHES;
        Cursor cursor = db.rawQuery(sqlquery,null);

        if(cursor.moveToFirst()){
            do {
                Player tempPlayer = new Player(cursor.getString(1), cursor.getString(2), cursor.getString(3));
                tempList.add(tempPlayer);
            } while(cursor.moveToNext());
        }
        return tempList;
    }
}

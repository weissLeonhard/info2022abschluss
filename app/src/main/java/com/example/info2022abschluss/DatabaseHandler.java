package com.example.info2022abschluss;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tictactoeINFO";
    private static final Integer DATABASE_VERSION = 1;

    private static final String TABLE_PLAYERS = "players";

    private static final String COL_PLAYERID = "playerID";
    private static final String COL_NAME = "name";
    private static final String COL_GP = "gP";
    private static final String COL_GW = "gW";

    public DatabaseHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_PLAYERS +
                " (" + COL_PLAYERID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(24), " +
                COL_GP + " INTEGER, " +
                COL_GW + " INTEGER)";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYERS);
        onCreate(sqLiteDatabase);
    }

    public void savePlayer(Player player) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_NAME, player.getName());
        values.put(COL_GP, player.getGamesPlayed());
        values.put(COL_GW, player.getGamesWon());

        db.insert(TABLE_PLAYERS, null, values);
        db.close();
    }
    public ArrayList<Player> loadPlayers() {
        ArrayList<Player> tempList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String sqlquery = "SELECT * FROM " + TABLE_PLAYERS;
        Cursor cursor = db.rawQuery(sqlquery,null);

        if(cursor.moveToFirst()){
            do {
                Player tempPlayer = new Player(cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
                tempList.add(tempPlayer);
            } while(cursor.moveToNext());
        }
        return tempList;
    }
}

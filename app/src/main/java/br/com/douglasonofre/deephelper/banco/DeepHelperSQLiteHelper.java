package br.com.douglasonofre.deephelper.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DeepHelperSQLiteHelper extends SQLiteOpenHelper {

    public DeepHelperSQLiteHelper(Context context) {
        super(context, "deephelper_db", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        // Execute create table SQL
        db.execSQL("CREATE TABLE metas (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "texto TEXT NOT NULL," +
                "completado TEXT NOT NULL," +
                "prioridade TEXT NOT NULL);");
        db.execSQL("CREATE TABLE perfil (nivel INTEGER, xp INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        // DROP table
        db.execSQL("DROP TABLE IF EXISTS metas");
        db.execSQL("DROP TABLE IF EXISTS perfil");
        // Recreate table
        onCreate(db);
    }

}

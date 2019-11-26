package br.com.douglasonofre.deephelper.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


import br.com.douglasonofre.deephelper.dados.Perfil;

public class PerfilDAO {
    private Perfil perfil;

    private SQLiteDatabase db;
    private DeepHelperSQLiteHelper dbHelper;

    public PerfilDAO(Context context) {
        dbHelper = new DeepHelperSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void fechar() {
        db.close();
    }

    public void criarPerfil(int nivel, int xp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nivel", nivel);
        contentValues.put("xp", xp);
        db.insert("perfil", null, contentValues);
    }

    public void atualizarPerfil(int xp) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("xp", xp);
        db.update("perfil", contentValues, null,null);
    }

    public void excluirPerfil() {
        db.delete("perfil", null, null);
    }

}

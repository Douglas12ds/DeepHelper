package br.com.douglasonofre.deephelper.banco;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.douglasonofre.deephelper.dados.Meta;
import br.com.douglasonofre.deephelper.banco.DeepHelperSQLiteHelper;

public class MetaDAO {
    private SQLiteDatabase db;
    private DeepHelperSQLiteHelper dbHelper;

    public MetaDAO(Context context) {
        dbHelper = new DeepHelperSQLiteHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    public void fechar() {
        db.close();
    }

    public void criarMeta(String texto, String completado, String prioridade) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("texto", texto);
        contentValues.put("completado", completado);
        contentValues.put("prioridade", prioridade);
        db.insert("metas", null, contentValues);
    }

    public void atualizarMeta(int metaId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("completado", "verdadeiro");
        db.update("metas", contentValues, "id = " + metaId, null);
    }

    public void excluirMeta(int metaId) {
        db.delete("metas", "id = " + metaId, null);
    }


    public List<Meta> getMetas() {
        List<Meta> metaList = new ArrayList<Meta>();

        String[] tableColumns = new String[] {"id","texto", "completado", "prioridade"};

        Cursor cursor = db.query("metas", tableColumns, null, null, null, null, null);
        cursor.moveToFirst();

        // Iterate the results
        while (!cursor.isAfterLast()) {
            Meta meta = new Meta();
            meta.setId(cursor.getInt(0));
            meta.setTexto(cursor.getString(1));
            meta.setCompletado(cursor.getString(2));
            meta.setPrioridade(cursor.getString(3));

            metaList.add(meta);

            cursor.moveToNext();
        }

        return metaList;
    }

}

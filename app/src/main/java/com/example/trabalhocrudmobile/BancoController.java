package com.example.trabalhocrudmobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        banco = new CriaBanco(context);
    }

    public String insereDado(String nome, String email, String senha) {
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriaBanco.getNome(), nome);
        valores.put(CriaBanco.getEmail(), email);
        valores.put(CriaBanco.getSenha(), senha);

        resultado = db.insert(CriaBanco.getTabela(), null, valores);
        db.close();

        if(resultado == -1){
            return "Erro ao inserir registro";
        } else {
            return "Registro inserido com sucesso";
        }
    }

    public Cursor carregaDados(){
        Cursor cursor;
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA,null,null,null,null,null,null);

        if (cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

}

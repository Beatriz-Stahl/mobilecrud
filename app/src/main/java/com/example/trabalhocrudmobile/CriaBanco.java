package com.example.trabalhocrudmobile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "banco.db";
     public static final String TABELA = "contatos";
    private static final String ID = "_id";
    private static final String NOME = "nome";
    private static final String EMAIL = "email";
    private static final String SENHA = "senha";
    private static final int VERSAO = 1;


    public static String getNomeBanco() {
        return NOME_BANCO;
    }

    public static String getTabela() {
        return TABELA;
    }

    public static String getId() {
        return ID;
    }

    public static String getNome() {
        return NOME;
    }

    public static String getEmail() {
        return EMAIL;
    }

    public static String getSenha() {
        return SENHA;
    }





    public CriaBanco(Context context){
        super(context, NOME_BANCO, null,VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA+ "("
                + ID + " integer primary key autoincrement,"
                + NOME + " text,"
                + EMAIL + " text,"
                + SENHA + " text"
                +")";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);

    }

}

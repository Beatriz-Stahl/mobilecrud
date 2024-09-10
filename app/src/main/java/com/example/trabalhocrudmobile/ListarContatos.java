package com.example.trabalhocrudmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListarContatos extends AppCompatActivity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_contatos);

        BancoController crud =new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();
        String[] nomeCampos = new String[]{CriaBanco.getNome(), CriaBanco.getEmail()};
        int [] idViews = new int [] { R.id.editTextNome, R.id.editTextEmail};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),
                R.layout.activity_listar_contatos  ,cursor,nomeCampos,idViews,0);

        lista = (ListView) findViewById(R.id.listViewContatos);
        lista.setAdapter(adaptador);
    }
}
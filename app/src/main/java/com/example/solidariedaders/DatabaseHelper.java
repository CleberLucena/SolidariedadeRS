package com.example.solidariedaders;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Nome do banco de dados e versão
    private static final String DATABASE_NAME = "solidariedade.db";
    private static final int DATABASE_VERSION = 1;

    // Comando SQL para criar a tabela 'users'
    private static final String TABLE_CREATE =
            "CREATE TABLE users (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "name TEXT NOT NULL, " +
            "state TEXT NOT NULL, " +
            "age INTEGER NOT NULL, " +
            "message TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Cria a tabela quando o banco de dados é criado
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Atualiza o banco de dados se necessário, apagando a tabela anterior e criando uma nova
        db.execSQL("DROP TABLE IF EXISTS users");
        onCreate(db);
    }
}



package com.example.solidariedaders;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NumerosEmergenciaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numeros_emergencia); // Define o layout para esta Activity

        // Dados fictícios para os números de emergência
        String[] numeros = {
                "Bombeiros - 193",
                "Polícia Militar - 190",
                "Defesa Civil - 199",
                "Samu - 192",
                "--------------------------------------------------------------------",
                "Solicitar ou Informar alguma emergência: Whatsapp fone: (051) 98401-2527"
        };

        // Referenciando a ListView
        ListView listView = findViewById(R.id.listNumerosEmergencia);

        // Criando um ArrayAdapter para exibir os dados na ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, numeros);

        // Setando o adapter na ListView
        listView.setAdapter(adapter);

    }
}


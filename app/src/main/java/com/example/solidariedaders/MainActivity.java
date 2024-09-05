package com.example.solidariedaders;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        Button btnPostosColeta = findViewById(R.id.btnPostosColeta);
        Button btnNumerosEmergencia = findViewById(R.id.btnNumerosEmergencia);
        Button btnMapa = findViewById(R.id.btnMapa);
        ImageView btnMensagensSolidariedade = findViewById(R.id.btnSolidariedade); // Ícone de mensagens de solidariedade

        // Definindo a ação para o botão "Postos de Coleta"
        btnPostosColeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostosColetaActivity.class);
                startActivity(intent);
            }
        });

        // Definindo a ação para o botão "Números de Emergência"
        btnNumerosEmergencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NumerosEmergenciaActivity.class);
                startActivity(intent);
            }
        });

        // Definindo a ação para o botão "Mapa"
        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MapaActivity.class);
                startActivity(intent);
            }
        });

        // Definindo a ação para o ícone de mensagens de solidariedade
        btnMensagensSolidariedade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SolidariedadeActivity.class);
                startActivity(intent);
            }
        });

    }
}

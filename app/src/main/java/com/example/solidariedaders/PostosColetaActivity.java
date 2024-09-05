package com.example.solidariedaders;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class PostosColetaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postos_coleta);// Define o layout para esta Activity

        // Dados fictícios para os postos de coleta
        String[] postos = {
                "Paço Municipal – Praça Montevideo,10 – Centro Histórico ",
                "Shopping Praia de Belas- Av. Praia de Belas, 1181 – Praia de Belas",
                "Shopping João Pessoa – Av. João Pessoa,1831 –Azenha ",
                "DMAE -24 de outubro,200- Moinhos de Vento Posto Comercial Centro- Rua José Montaury, 159- Centro ",
                "DEMHAB- Av. Princesa Isabel,1115 – Santana",
                "Barra Shopping Sul- Av. Diário de Notícias, 300- Cristal ",
                "Flowork -Green Office Caixeiros- Rua Mostardeiro,777-14º andar- Moinhos de Vento  ",
                "Rua da Praia Shopping- Rua dos Andradas, 1001- Cetro Histórico ",
                "SAM’S Club – Av. Sertório, 6600- Anexo A-  Sarandi ",
                " BIG Zona Sul - Av. Eduardo Prado, 330 - Prédio 1 - Bloco 3 - Loja 01 -Vila Nova ",
                " BIG Sertório – Av. Sertório, 6006- Sarandi  ",
                " CARRIS – Linhas de ônibus ",
                " Shopping Iguatemi – Av. João Wallig, 1800- Passo D’ Areia ",
                "Shopping Passeo Zona Sul- Av. Wenceslau Escobar, 1823- Tristeza ",
                "AABB- Av. Cel. Marcos ,1000- Pedra Redonda",
                "Supermago - Av. Ipiranga,7815 – Jardim Botânico ",
        };

        // Referenciando a ListView
        ListView listView = findViewById(R.id.listPostosColeta);

        // Criando um ArrayAdapter para exibir os dados na ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, postos);

        // Setando o adapter na ListView
        listView.setAdapter(adapter);

    }
}


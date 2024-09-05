package com.example.solidariedaders;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;


public class MapaActivity extends AppCompatActivity {

    private MapView map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Configurações gerais do OSMdroid
        Configuration.getInstance().setUserAgentValue(BuildConfig.APPLICATION_ID);
        setContentView(R.layout.activity_mapa);

        // Inicia o mapa
        map = findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK); // Fonte de tile padrão do OpenStreetMap

        // Centraliza o mapa em um ponto específico
        GeoPoint startPoint = new GeoPoint(-30.0346, -51.2177);
        map.getController().setZoom(12.0); // Nível de zoom
        map.getController().setCenter(startPoint);

        // Adiciona um marcador
        addMarker(-30.048581313185533, -51.229112240256654, "Shopping Praia de Belas");
        addMarker(-30.045510318642634, -51.21333101978823, "Shopping João Pessoa");
        addMarker(-30.026772414767105, -51.205220301672185, "DMAE-24");
        addMarker(-30.045367146657565, -51.203061233279584, "DEMHAB");
        addMarker(-30.083055065625484, -51.245737178690696, "Barra Shopping Sul");
        addMarker(-30.028449300963477, -51.19917557024458, "Flowork");
        addMarker(-30.0305091690757, -51.23158963328047, "Rua da Praia Shopping");
        addMarker(-29.996242793956505, -51.140443818865286, "Sam's Clube");
        addMarker(-30.12139145373415, -51.219974675603595, "BIG Zona Sul");
        addMarker(-29.996030121172804, -51.14249573537047, "BIG Sertório");
        addMarker(-30.084465437532145, -51.24579548909685, "Carrefour Hipermercado");
        addMarker(-30.02489004736833, -51.16234470259132, "Shopping Iguatemir");
        addMarker(-30.104681250564052, -51.25425267560431, "Shopping Passeo Zona Sul");
        addMarker(-30.05628263477431, -51.15942482957253, "Super Mago");

    }

    private void addMarker(double latitude, double longitude, String title) {
        // Cria o ponto
        GeoPoint point = new GeoPoint(latitude, longitude);

        // Cria o marcador
        Marker marker = new Marker(map);
        marker.setPosition(point);
        marker.setTitle(title);

        // Adiciona o marcador ao mapa
        map.getOverlays().add(marker);
    }

    @Override
    protected void onResume() {
        super.onResume();
        map.onResume(); // Importante para a gestão de ciclos de vida do mapa
    }

    @Override
    protected void onPause() {
        super.onPause();
        map.onPause(); // Importante para a gestão de ciclos de vida do mapa
    }
}



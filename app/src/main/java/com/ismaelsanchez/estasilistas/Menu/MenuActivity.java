package com.ismaelsanchez.estasilistas.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ismaelsanchez.estasilistas.Extra.ClaseGlobal;
import com.ismaelsanchez.estasilistas.ListaZonas.ZonasActivity;
import com.ismaelsanchez.estasilistas.R;
import com.ismaelsanchez.estasilistas.Tiempos.TiemposActivity;

public class MenuActivity extends AppCompatActivity {

    Button btnListaZonas;
    Button btnTiempos;
    TextView txtUsuarioActivo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnListaZonas=(Button) findViewById(R.id.btnListaZonas);
        btnTiempos=(Button) findViewById(R.id.btnTiempos);
        txtUsuarioActivo=(TextView) findViewById(R.id.txtUsuarioActivo);

        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        txtUsuarioActivo.setText("Bienvenido, "+objGlobal.getNombre());

        btnListaZonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarListaZonas= new Intent(getApplicationContext(), ZonasActivity.class);
                startActivity(mostrarListaZonas);
            }
        });
        btnTiempos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mostrarListaZonas= new Intent(getApplicationContext(), TiemposActivity.class);
                startActivity(mostrarListaZonas);
            }
        });

        


    }


}
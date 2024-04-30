package com.ismaelsanchez.estasilistas.ListaZonas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Toast;

import com.ismaelsanchez.estasilistas.Extra.ClaseGlobal;
import com.ismaelsanchez.estasilistas.Extra.Conexion;
import com.ismaelsanchez.estasilistas.ListaVias.ViasActivity;
import com.ismaelsanchez.estasilistas.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ZonasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewZona;
    private RecyclerViewAdaptador adaptadorZona;
    List<Zona> zona= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zonas);

        recyclerViewZona=(RecyclerView) findViewById(R.id.recyclerZonas);
        recyclerViewZona.setLayoutManager(new LinearLayoutManager(this));

        adaptadorZona=new RecyclerViewAdaptador(obtenerZonasBD());

        adaptadorZona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
                objGlobal.setZona(zona.get(recyclerViewZona.getChildAdapterPosition(v)).getNombre());

                Intent mostrarListaVias= new Intent(getApplicationContext(), ViasActivity.class);
                startActivity(mostrarListaVias);
            }
        });

        recyclerViewZona.setAdapter(adaptadorZona);
    }

    public List<Zona> obtenerZonasBD(){
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();

        try{
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st=x.conexionBD(a,b,c).createStatement();
            ResultSet rs=st.executeQuery("select *from Zona");
            while (rs.next()){
                zona.add(new Zona(rs.getString("Nombre"),R.drawable.muro));
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return zona;
    }
}
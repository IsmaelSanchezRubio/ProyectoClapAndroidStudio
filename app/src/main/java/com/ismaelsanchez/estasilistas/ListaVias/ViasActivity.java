package com.ismaelsanchez.estasilistas.ListaVias;

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
import com.ismaelsanchez.estasilistas.ListaZonas.RecyclerViewAdaptador;
import com.ismaelsanchez.estasilistas.ListaZonas.Zona;
import com.ismaelsanchez.estasilistas.R;
import com.ismaelsanchez.estasilistas.VistaVia.VistaViaActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ViasActivity extends AppCompatActivity {

    private RecyclerView recyclerViewVia;
    private RecyclerViewAdaptador adaptadorVia;

    List<Zona> via= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vias);

        recyclerViewVia=(RecyclerView) findViewById(R.id.recyclerVias);
        recyclerViewVia.setLayoutManager(new LinearLayoutManager(this));

        adaptadorVia=new RecyclerViewAdaptador(obtenerViasBD());
        recyclerViewVia.setAdapter(adaptadorVia);

        adaptadorVia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
                objGlobal.setVia(via.get(recyclerViewVia.getChildAdapterPosition(v)).getNombre());

                Intent mostrarVia= new Intent(getApplicationContext(), VistaViaActivity.class);
                startActivity(mostrarVia);
            }
        });
    }

    public List<Zona> obtenerViasBD(){
        List<Zona> zona= new ArrayList<>();
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        try{
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st=x.conexionBD(a,b,c).createStatement();
            ResultSet rs=st.executeQuery("SELECT via.Nombre FROM Zona JOIN ViaZona ON Zona.Id = ViaZona.ZonaId " +
                    "JOIN via ON ViaZona.ViaId = via.Id WHERE Zona.nombre = '"+objGlobal.getZona()+"'");
            while (rs.next()){
                via.add(new Zona(rs.getString("Nombre"),R.drawable.escalador));
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return via;
    }
}
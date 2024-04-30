package com.ismaelsanchez.estasilistas.Tiempos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ismaelsanchez.estasilistas.Extra.ClaseGlobal;
import com.ismaelsanchez.estasilistas.Extra.Conexion;
import com.ismaelsanchez.estasilistas.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TiemposActivity extends AppCompatActivity {

    ListView lv2Nombre,lv2Tiempo,lv2Via;

    public List<String> list2Nombres, list2Tiempos, list2Vias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempos);

        lv2Nombre=(ListView) findViewById(R.id.lv2Nombre);
        lv2Tiempo=(ListView) findViewById(R.id.lv2Tiempo);
        lv2Via=(ListView) findViewById(R.id.lv2Via);

        List<String> list2Nombres = lista2NombresBD();
        Collections.reverse(list2Nombres);
        ArrayAdapter<String> adapterNombres = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list2Nombres);
        lv2Nombre.setAdapter(adapterNombres);

        List<String> list2Vias = lista2ViasBD();
        Collections.reverse(list2Vias);
        ArrayAdapter<String> adapterVias = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list2Vias);
        lv2Via.setAdapter(adapterVias);

        List<String> list2Tiempos = lista2TiemposBD();
        Collections.reverse(list2Tiempos);
        ArrayAdapter<String> adapterTiempos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list2Tiempos);
        lv2Tiempo.setAdapter(adapterTiempos);

    }

    public List<String> lista2NombresBD() {
        List<String> listaNombres = new ArrayList<>();
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        try {
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st = x.conexionBD(a,b,c).createStatement();
            ResultSet rs = st.executeQuery("SELECT Usuarios.Usuario FROM Tiempos JOIN Usuarios ON Tiempos.UsuarioId = Usuarios.Id");
            while (rs.next()) {
                listaNombres.add(rs.getString("Usuario"));
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listaNombres;
    }

    public List<String> lista2ViasBD() {
        List<String> listaVias = new ArrayList<>();
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        try {
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st = x.conexionBD(a,b,c).createStatement();
            ResultSet rs = st.executeQuery("SELECT via.Nombre FROM Tiempos JOIN via ON Tiempos.ViaId = via.Id");
            while (rs.next()) {
                listaVias.add(rs.getString("Nombre"));
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listaVias;
    }

    public List<String> lista2TiemposBD() {
        List<String> listaTiempos = new ArrayList<>();
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        try {
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st = x.conexionBD(a,b,c).createStatement();
            ResultSet rs = st.executeQuery("SELECT Tiempo FROM Tiempos");
            while (rs.next()) {
                listaTiempos.add(rs.getString("Tiempo"));
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listaTiempos;
    }
}
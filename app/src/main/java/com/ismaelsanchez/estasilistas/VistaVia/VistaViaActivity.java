package com.ismaelsanchez.estasilistas.VistaVia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
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

public class VistaViaActivity extends AppCompatActivity {

    TextView txtVia,txtInfo,txtMiTiempo;

    String infoVia,miTiempo;

    ListView lvNombre,lvTiempo;

    public List<String> listNombres, listTiempos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_via);

        txtVia=(TextView) findViewById(R.id.txtVia);
        txtInfo=(TextView) findViewById(R.id.txtInfo);
        txtMiTiempo=(TextView) findViewById(R.id.tvMiTiempo);
        lvNombre=(ListView) findViewById(R.id.lvNombre);
        lvTiempo=(ListView) findViewById(R.id.lvTiempo);


        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        txtVia.setText(objGlobal.getVia().toString());

        txtInfo.setText(obtenerInfoBD());
        if (obtenerMiTiempoBD() == null){
            txtMiTiempo.setText("Aún no tienes un tiempo. ¡Animo!");
        } else txtMiTiempo.setText("Tu tiempo: "+obtenerMiTiempoBD());


        List<String> listNombres = listaNombresBD();
        Collections.reverse(listNombres);
        ArrayAdapter<String> adapterNombres = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNombres);
        lvNombre.setAdapter(adapterNombres);

        List<String> listTiempos = listaTiemposBD();
        Collections.reverse(listTiempos);
        ArrayAdapter<String> adapterTiempos = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listTiempos);
        lvTiempo.setAdapter(adapterTiempos);

    }


    public String obtenerInfoBD(){
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        try{
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st=x.conexionBD(a,b,c).createStatement();
            ResultSet rs=st.executeQuery("SELECT Info FROM via WHERE via.Nombre = '"+objGlobal.getVia()+"'");
            while (rs.next()){
                infoVia= rs.getString("Info");
            }
        }catch (SQLException e){
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return infoVia;
    }

    public String obtenerMiTiempoBD() {
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        try {
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st = x.conexionBD(a,b,c).createStatement();
            ResultSet rs = st.executeQuery("SELECT Tiempos.Tiempo FROM Tiempos JOIN Via ON Tiempos.ViaId = Via.Id JOIN Usuarios ON Tiempos.UsuarioId = Usuarios.Id WHERE Via.Nombre = '"+objGlobal.getVia()+"' AND Usuarios.Usuario = '"+objGlobal.getNombre()+"'");
            while (rs.next()) {
                miTiempo = rs.getString("Tiempo");
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return miTiempo;
    }

    public List<String> listaNombresBD() {
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        List<String> listaNombres = new ArrayList<>();
        try {
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st = x.conexionBD(a,b,c).createStatement();
            ResultSet rs = st.executeQuery("SELECT Usuarios.Usuario FROM Tiempos JOIN Usuarios ON Tiempos.UsuarioId = Usuarios.Id JOIN Via ON Tiempos.ViaId = Via.Id WHERE Usuarios.Usuario != '"+objGlobal.getNombre()+"' AND Via.Nombre = '"+objGlobal.getVia()+"'");
            while (rs.next()) {
                listaNombres.add(rs.getString("Usuario"));
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listaNombres;
    }

    public List<String> listaTiemposBD() {
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        List<String> listaTiempos = new ArrayList<>();
        try {
            Conexion x = new Conexion();
            String a = objGlobal.getIpObtenida();
            String b = objGlobal.getPasswordObtenida();
            String c = objGlobal.getPortObtenida();
            x.conexionBD(a,b,c);
            Statement st = x.conexionBD(a,b,c).createStatement();
            ResultSet rs = st.executeQuery("SELECT Tiempos.Tiempo FROM Tiempos JOIN Via ON Tiempos.ViaId = Via.Id JOIN Usuarios ON Tiempos.UsuarioId = Usuarios.Id WHERE Via.Nombre = '"+objGlobal.getVia()+"' AND Usuarios.Usuario != '"+objGlobal.getNombre()+"'");
            while (rs.next()) {
                listaTiempos.add(rs.getString("Tiempo"));
            }
        } catch (SQLException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return listaTiempos;
    }

}
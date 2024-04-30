package com.ismaelsanchez.estasilistas.Extra;

import android.app.Activity;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ismaelsanchez.estasilistas.R;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {


    private String dbName = "ProyectoCLAPdb";
    private String user = "sa";



    public Connection conexionBD(String a, String b, String c){

        Connection conexion = null;
        try{
            StrictMode.ThreadPolicy policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://"+a+":"+c+";databaseName="+dbName+";user="+user+";password="+b+";");
        }catch (Exception e){

        }
        return conexion;
    }
}

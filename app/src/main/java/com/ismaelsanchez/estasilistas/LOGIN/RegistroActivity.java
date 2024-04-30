package com.ismaelsanchez.estasilistas.LOGIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ismaelsanchez.estasilistas.Extra.ClaseGlobal;
import com.ismaelsanchez.estasilistas.Extra.Conexion;
import com.ismaelsanchez.estasilistas.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistroActivity extends AppCompatActivity {

    EditText correo, usuario, contraseña;
    Button registrar;
    TextView iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        correo = findViewById(R.id.txtcorreo);
        usuario = findViewById(R.id.txtusuario);
        contraseña = findViewById(R.id.txtcontraseña);
        registrar = findViewById(R.id.btnregistrar);
        iniciar = findViewById(R.id.tviniciar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    registrarUsuario();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login= new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(login);
            }
        });
    }


    public void registrarUsuario() throws SQLException {
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        String a = objGlobal.getIpObtenida();
        String b = objGlobal.getPasswordObtenida();
        String c = objGlobal.getPortObtenida();
        Conexion x = new Conexion();
        x.conexionBD(a,b,c);

        Statement st=x.conexionBD(a,b,c).createStatement();
        int rs=st.executeUpdate("INSERT INTO Usuarios (Usuario, Correo, Contraseña) VALUES ('"+usuario.getText().toString()+"','"+correo.getText().toString()+"','"+contraseña.getText().toString()+"')");

        Toast.makeText(RegistroActivity.this,"Registro exitoso", Toast.LENGTH_SHORT).show();
        Intent login= new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(login);

        usuario.setText("");
        contraseña.setText("");
        correo.setText("");
    }


}
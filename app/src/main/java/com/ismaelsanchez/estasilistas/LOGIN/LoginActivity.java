package com.ismaelsanchez.estasilistas.LOGIN;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ismaelsanchez.estasilistas.Extra.ClaseGlobal;
import com.ismaelsanchez.estasilistas.Extra.Conexion;
import com.ismaelsanchez.estasilistas.Extra.x;
import com.ismaelsanchez.estasilistas.Menu.MenuActivity;
import com.ismaelsanchez.estasilistas.R;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginActivity extends AppCompatActivity {

    EditText usuario;
    EditText contraseña;
    TextView btnRegistrar;
    Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario=(EditText) findViewById(R.id.txtUsuario);
        contraseña=(EditText) findViewById(R.id.txtContraseña);
        btnRegistrar=(TextView) findViewById(R.id.btnRegistrar);
        btnIniciarSesion=(Button) findViewById(R.id.btnIniciarSesion);

        x miClase = new x(getApplicationContext());
        String textoDeStringXml = miClase.obtenerMiCadena();
        String textoDeStringXml2 = miClase.obtenerMiCadena2();
        String textoDeStringXml3 = miClase.obtenerMiCadena3();
        ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
        objGlobal.setIpObtenida(textoDeStringXml);
        objGlobal.setPasswordObtenida(textoDeStringXml2);
        objGlobal.setPortObtenida(textoDeStringXml3);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new LoginActivity.login().execute("");
            }
        });

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg= new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(reg);
            }
        });



    }


    public class login extends AsyncTask<String,String,String>{
        String z = null;
        Boolean exito = false;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings) {
            ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
            try {

                Conexion x = new Conexion();
                String a = objGlobal.getIpObtenida();
                String b = objGlobal.getPasswordObtenida();
                String c = objGlobal.getPortObtenida();
                x.conexionBD(a,b,c);
                Statement st=x.conexionBD(a,b,c).createStatement();
                ResultSet rs=st.executeQuery("SELECT * FROM Usuarios WHERE Usuario = '"+usuario.getText()+"' AND Contraseña = '"+contraseña.getText()+"'");

                if(rs.next()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this,"Acceso exitoso", Toast.LENGTH_SHORT).show();
                            ClaseGlobal objGlobal = (ClaseGlobal) getApplicationContext();
                            objGlobal.setNombre( usuario.getText().toString());
                            Intent menu= new Intent(getApplicationContext(), MenuActivity.class);
                            startActivity(menu);
                        }
                    });
                }
                else {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(LoginActivity.this,"Error en el usuario o contraseña.", Toast.LENGTH_SHORT).show();

                        }
                    });

                    usuario.setText("");
                    contraseña.setText("");
                }

            } catch (SQLException e) {
                exito=false;
                Log.e("ERROR DE CONEXION : ", e.getMessage());
            }

            return null;
        }
    }
}
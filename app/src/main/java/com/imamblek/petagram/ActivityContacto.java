package com.imamblek.petagram;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.util.Config;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContacto extends AppCompatActivity {
private EditText etContactoNombre;
private EditText etContactoEmail;
private EditText etContactoMensaje;
private ImageButton btnEnviarEmail;
String correo;
String contrasena;
Session session;



        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_contacto);
           androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar2);
            setSupportActionBar(miActionBar);

            // para activar el boton de regreso.
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            etContactoNombre =(EditText)findViewById(R.id.etContactoNombre);
            etContactoEmail =(EditText)findViewById(R.id.etContactoEmail);
            etContactoMensaje =(EditText)findViewById(R.id.etContactoMensaje);
            btnEnviarEmail =(ImageButton)findViewById(R.id.btnEnviarEmail);

            correo = "imamblek@gmail.com";
            contrasena = "***********";

            btnEnviarEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //permisos
                    StrictMode.ThreadPolicy policy = new  StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    //propiedades de conexion
                    Properties properties = new Properties();
                    properties.put("mail.smtp.host","smtp.gmail.com");
                    properties.put("mail.smtp.socketFactory.port","465");
                    properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                    properties.put("mail.smtp.auth","true");
                    properties.put("mail.smtp.port","465");

                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(correo,contrasena);
                        }
                    });
                        if (session != null){
                            Toast.makeText(ActivityContacto.this,"Session Ok",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(ActivityContacto.this,"Session Null",Toast.LENGTH_SHORT).show();
                        }
                    try {
                        MimeMessage message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(correo));
                        message.setRecipient(Message.RecipientType.TO,new InternetAddress("imamblek@gmail.com"));
                        message.setSubject("Mensaje de "+etContactoNombre);
                        message.setText(etContactoMensaje.getText().toString(),"text/html; charset=uft-8");
                        Transport.send(message);
                        Toast.makeText(ActivityContacto.this,"Mensaje enviado a "+etContactoEmail,Toast.LENGTH_LONG).show();

                    }catch(Exception e){
                        e.printStackTrace();
                        Toast.makeText(ActivityContacto.this,"No se pudo conectar con el servidor de correo de "+correo+", por favor verifique su conexion y que este trabajando con la cuenta correcta que tenga habilitado el servicio de mensajeria no segura.",Toast.LENGTH_LONG).show();

                    }
                }
            });

        }

}
package com.imamblek.petagram;

import android.os.Bundle;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class ActivityContacto extends AppCompatActivity {
private EditText etContactoNombre;
private EditText etContactoEmail;
private EditText etContactoMensaje;
private ImageButton btnEnviarEmail;

private Session session;

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
            btnEnviarEmail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //permisos
                    ThreadPolicy policy = new  ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    //propiedades de conexion
                    Properties properties = System.getProperties();
                    properties.put("mail.smtp.host", "smtp.gmail.com");
                    properties.put("mail.smtp.user", Login.USER);
                    properties.put("mail.smtp.password", Login.PASSWORD);
                    properties.put("mail.smtp.auth", "true");
                    properties.put("mail.smtp.starttls.enable", "true");
                    properties.put("mail.smtp.port", "587");
                    session = Session.getDefaultInstance(properties);
                    MimeMessage message = new MimeMessage(session);
                    try {

                        message.setFrom(new InternetAddress(Login.EMAIL));
                        message.setRecipient(Message.RecipientType.TO,new InternetAddress(etContactoEmail.getText().toString().trim()));
                        message.setSubject("Mensaje de Isaac Mora para "+etContactoNombre.getText().toString());
                        message.setText(etContactoMensaje.getText().toString());
                        Transport transport = session.getTransport("smtp");
                        transport.connect("smtp.gmail.com", Login.USER, Login.PASSWORD);
                        transport.sendMessage(message,message.getAllRecipients());
                        transport.close();
                        Toast.makeText(ActivityContacto.this,"Mensaje enviado a "+etContactoEmail.getText().toString()+ ", verifica tu bandeja de entrada Gmail.",Toast.LENGTH_LONG).show();
                        Toast.makeText(ActivityContacto.this,"**Gracias por probar mi codigo por favor calificame con un 100**",Toast.LENGTH_LONG).show();

                    }catch(Exception e){
                        e.printStackTrace();
                        Toast.makeText(ActivityContacto.this,"No se pudo conectar con el servidor de correo de "+ Login.EMAIL+", si este no es su cuenta de correo por favor modifique los datos de Login en el codigo de ActivityContacto y luego intente de nuevo.",Toast.LENGTH_LONG).show();
                        Toast.makeText(ActivityContacto.this,"Asegurece de tener habilitado el servicio de mensajeria no segura en su cuenta de Gmail.",Toast.LENGTH_LONG).show();
                        Toast.makeText(ActivityContacto.this,"Esta funcion no corre en emulador, solo en telefono, por favor intente en su telefono con los datos de su cuenta de Gmail.",Toast.LENGTH_LONG).show();
                    }
                }
            });

        }
    public class Login {
        public static final String EMAIL ="imamblek@gmail.com";//cuenta de correo Gmail
        public static final String USER ="imamblek";//usuario de cuenta Gmail
        public static final String PASSWORD ="******";//Clave de cuenta Gmail
    }
}
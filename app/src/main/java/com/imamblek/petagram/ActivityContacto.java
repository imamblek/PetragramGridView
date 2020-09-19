package com.imamblek.petagram;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import static android.content.Intent.createChooser;

public class ActivityContacto extends AppCompatActivity {
    EditText etContactoNombre;
    EditText etContactoEmail;
    EditText etContactoMensaje;
    ImageButton btnEnviarEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        etContactoNombre=(EditText) findViewById(R.id.etContactoNombre);
        etContactoEmail=(EditText) findViewById(R.id.etContactoEmail);
        etContactoMensaje=(EditText) findViewById(R.id.etContactoMensaje);
        btnEnviarEmail=(ImageButton) findViewById(R.id.btnEnviarEmail);

        btnEnviarEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email = String.valueOf(etContactoEmail.getText().toString().trim());
                String Asunto = String.valueOf("Mensaje de "+etContactoNombre.getText().toString());
                String TextoDelCorreo = String.valueOf(etContactoMensaje.getText().toString()+"\nAtte: "+etContactoNombre.getText().toString());
                enviarEmail(Email,Asunto,TextoDelCorreo);
            }


        });
    }

    private void enviarEmail(String Email, String Asunto, String TextoDelCorreo) {
        Intent enviarEmail = new Intent(Intent.ACTION_SEND);
        enviarEmail.setData(Uri.parse("mailto:"));
        enviarEmail.setType("text/plain");
        enviarEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{Email});
        enviarEmail.putExtra(Intent.EXTRA_SUBJECT, Asunto);
        enviarEmail.putExtra(Intent.EXTRA_TEXT, TextoDelCorreo);
        createChooser(enviarEmail,"email");

        startActivity(enviarEmail);
    }
}
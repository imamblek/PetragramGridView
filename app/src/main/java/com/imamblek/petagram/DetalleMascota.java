package com.imamblek.petagram;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.imamblek.petagram.adapter.MascotaAdaptador;
import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;

public class DetalleMascota extends AppCompatActivity {

    ArrayList <Mascota> mascotas;
    public RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota);
        androidx.appcompat.widget.Toolbar miActionBar = findViewById(R.id.miActionBar2);
        setSupportActionBar(miActionBar);

        // para activar el boton de regreso.
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotas = (RecyclerView) findViewById(R.id.rvMascotasFragment);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

    }

    private void setSupportActionBar(Toolbar miActionBar) {
    }

    private void setSupportActionBar(ActionBar miActionBar) {

    }

    public void inicializarAdaptador (){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas,this);
        rvMascotas.setAdapter(mascotaAdaptador);
    }


    public void inicializarListaContactos () {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.cangrejo, "Cangrejo", "0"));
        mascotas.add(new Mascota(R.drawable.delfin, "Delfin", "0"));
        mascotas.add(new Mascota(R.drawable.pulpo, "Pulpo", "0"));
        mascotas.add(new Mascota(R.drawable.estrella, "Estrella", "0"));
        mascotas.add(new Mascota(R.drawable.calamar, "Calamar", "0"));
    }
    //para llamar al menu de opciones
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    //para darle vida a los menus
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this, ActivityAcercade.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent i = new Intent(this, ActivityContacto.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
package com.imamblek.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.imamblek.petagram.R;
import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptadorGrid extends RecyclerView.Adapter<MascotaAdaptadorGrid.MascotaViewHolderGrid>{
//esta es la coleccion decalada del la clase interna.

    ArrayList<Mascota> mascotas;
    Activity activitygrid;
    int Huesos;
    public static  class MascotaViewHolderGrid extends RecyclerView.ViewHolder {
        // se llaman los metodos del la clase madre RecliclerView.
        //declarar todos los views del cardView llamandoles con igual ids. ahora son objetos.
        private ImageView imgFotoCVgrid;
        private TextView tvQtyHuesosCVgrid;
        /*private TextView tvNombreCV;*/
        /*private ImageButton bntDarHueso;*/



        public MascotaViewHolderGrid(@NonNull View itemView) {
            super(itemView);
            // asocio cada objeto declarado cn su respectivo view en el XLM usando casting y sus Ids.
            //al usar los mismo nombres que los identificadores se hca mas facil asociarlos.
            imgFotoCVgrid = (ImageView) itemView.findViewById(R.id.imgFotoCVgrid);
            tvQtyHuesosCVgrid = (TextView) itemView.findViewById(R.id.tvQtyHuesosCVgrid);
            /*tvNombreCV   = (TextView) itemView.findViewById(R.id.tvNombreCV);
            bntDarHueso = (ImageButton) itemView.findViewById(R.id.btnDarHueso);*/


        }



    }


    public MascotaAdaptadorGrid(ArrayList<Mascota> mascotas, Activity activitygrid) {
        this.mascotas = mascotas;
        this.activitygrid = activitygrid;

    }

    @NonNull
    @Override
    public MascotaViewHolderGrid onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //le dara vida (inflar) a nuestro Layout CardView al asociarlo cn el view en el Layout.
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_petagram_perfilgrid,parent,false);
        return new MascotaViewHolderGrid(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolderGrid mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);//obtiene el objeto iterando todas sus partes
        mascotaViewHolder.imgFotoCVgrid.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvQtyHuesosCVgrid.setText(mascota.getHuesos());

        /*mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.bntDarHueso.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Toast.makeText(activity ,"Diste like a "+ mascota.getNombre(),Toast.LENGTH_SHORT).show();
                String darHuesos = String.valueOf(++Huesos);
                mascotaViewHolder.tvQtyHuesosCV.setText(darHuesos);

            }
        });*/

    }

    @Override
    public int getItemCount() {//cantidad de elementos que contine mi lista
        return mascotas.size(); // mascotas .size es la cantidad de elementos que contiene la lista de mascotas
    }


}

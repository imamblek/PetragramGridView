package com.imamblek.petagram.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.imamblek.petagram.R;
import com.imamblek.petagram.adapter.MascotaAdaptadorGrid;
import com.imamblek.petagram.pogo.Mascota;

import java.util.ArrayList;


public class PerfilFragment extends Fragment {
    ArrayList <Mascota> mascotas;
    ArrayList <Mascota> mascotasMain;
    public RecyclerView rvMascotasGrid;
    public RecyclerView rvMascotasGridMain;

    /*// TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PerfilFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PerfilFragment newInstance(String param1, String param2) {
        PerfilFragment fragment = new PerfilFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        rvMascotasGrid = (RecyclerView) v.findViewById(R.id.rvMascotasGrid);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),3);

        rvMascotasGrid.setLayoutManager(gridLayoutManager);
        inicializarListaContactosGrid();
        inicializarAdaptadorGrid();

        return v;
    }
    public void inicializarAdaptadorGrid (){
        MascotaAdaptadorGrid mascotaAdaptadorGrid = new MascotaAdaptadorGrid(mascotas,getActivity());
        rvMascotasGrid.setAdapter(mascotaAdaptadorGrid);
    }


    public void inicializarListaContactosGrid () {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.cangrejo, "1"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "2"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "3"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "4"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "5"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "6"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "7"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "8"));
        mascotas.add(new Mascota(R.drawable.cangrejo, "9"));

    }

}
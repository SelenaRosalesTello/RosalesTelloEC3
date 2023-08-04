package com.rosales.ec03.fragmets;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rosales.ec03.databinding.FragmentHomeBinding;
import com.rosales.ec03.model.Entradas;
import com.rosales.ec03.model.Platos;
import com.rosales.ec03.model.Principal;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RVResumeAdapter adapter = new RVResumeAdapter(getData());
        binding.rvMoviesResume.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
        binding.rvMoviesResume.setLayoutManager(layoutManager);
    }

    private List<Principal> getData() {
        List<Principal> shows = new ArrayList<>();
        shows.add(new Platos("Pollo a la brasa","https://cloudfront-us-east-1.images.arcpublishing.com/infobae/CAU42VL7CNGTNNO4M34A627VPM.jpg",2));
        shows.add(new Platos("Ceviche","https://peru.info/archivos/publicacion/24-imagen-1316321112018.jpg",2));
        shows.add(new Platos("Arroz con pollo","https://imgmedia.buenazo.pe/1200x660/buenazo/original/2022/10/24/60d89da6913c240e6725db08.jpg",2));
        shows.add(new Platos("Pollo a la plancha","https://donangelo.pe/wp-content/uploads/2022/04/WhatsApp-Image-2022-05-28-at-1.26.47-PM-4.jpeg",2));
        shows.add(new Platos("Broster","https://media-cdn.tripadvisor.com/media/photo-s/1a/ed/28/c2/nuestro-delicioso-pollo.jpg",3));
        shows.add(new Platos("Chaufa","https://www.paulinacocina.net/wp-content/uploads/2021/12/arroz-chaufa-peruano-receta.jpg",3));
        shows.add(new Entradas("Ensalada Mixta","https://cocina-casera.com/wp-content/uploads/2011/12/ensalada-mixta-receta.jpg","Ensalada vegana muy deliciosa "));
        shows.add(new Entradas("Causa ","https://images-gmi-pmc.edge-generalmills.com/1fdf2172-1313-49e0-b964-9c2cbb484672.jpg","Excelente plato de entrada"));
        shows.add(new Entradas("Arroz con leche","https://iperu.pe/wp-content/uploads/2019/12/arroz-con-leche_800x534.jpg","Una entrada que te endulsa la mañana"));
        shows.add(new Entradas("Cusa de langostino","https://kasani.pe/wp-content/uploads/2020/10/CAUSA-DE-LANGOSTINOS-500x370.jpg","Plato de entrada especial"));
        shows.add(new Entradas("Tequeños","https://jameaperu.com/wp-content/uploads/2019/04/teque%C3%B1os_700x467.jpg","Plato de entrada con abudante relleno "));
        return shows;
    }

}
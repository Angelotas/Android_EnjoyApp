package com.example.ngel.enjoyapp;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.DateFormat;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.lang.reflect.Field;

/**
 * Created by Ángel on 19/12/2016.
 */

public class Result1Fragment extends Fragment{

    private static final String TAG =".Result1Fragment";
    private String nombreImagen;

    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_result1,
                container, false);
        Log.d(TAG,"onCreate");

        //ICONO DEL RESULTADO
        Button btnResult= (Button) view.findViewById(R.id.botonResultado);
        //Se recoge el nombre de icono del Activity anterior
        nombreImagen=this.getActivity().getIntent().getExtras().get("iconoResultado").toString();
        int id= getResources().getIdentifier(nombreImagen,"drawable",this.getActivity().getPackageName()); //id de la imagen resultado
        System.out.println(nombreImagen);
        Drawable d= getResources().getDrawable(id);
        btnResult.setBackground(d);

        //BOTON JUGAR DE NUEVO
        Button btnReiniciar = (Button) view.findViewById(R.id.botonJugardeNuevo);
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(getActivity(),IntroActivity.class);
                startActivity(intent);
            }
        });

        //BOTON COMPARTIR
        Button btnCompartir = (Button) view.findViewById(R.id.botonCompartir);
        btnCompartir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("image/*");

                share.putExtra(Intent.EXTRA_STREAM,
                        Uri.parse("android.resource://com.example.ngel.enjoyapp/drawable/"+nombreImagen));
                share.putExtra(Intent.EXTRA_TEXT, getResources().getString(R.string.textoCompartir));

                startActivity(Intent.createChooser(share, getResources().getString(R.string.labelCompartir)));
            }
        });




        return view;
    }


}

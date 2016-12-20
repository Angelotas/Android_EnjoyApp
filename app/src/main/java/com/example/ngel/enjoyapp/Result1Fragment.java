package com.example.ngel.enjoyapp;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.icu.text.DateFormat;
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

    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_result1,
                container, false);
        Log.d(TAG,"onCreate");

        Button btn= (Button) view.findViewById(R.id.botonPrueba);
        //Se recoge el nombre de icono del Activity anterior
        String nombreImagen= this.getActivity().getIntent().getExtras().get("iconoResultado").toString();
        int id= getResources().getIdentifier(nombreImagen,"drawable",this.getActivity().getPackageName());
        System.out.println(nombreImagen);
        Drawable d= getResources().getDrawable(id);
        btn.setBackground(d);



        return view;
    }


}

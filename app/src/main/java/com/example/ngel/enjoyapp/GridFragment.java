package com.example.ngel.enjoyapp;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Random;

import static android.content.Context.SENSOR_SERVICE;
import static android.content.Context.VIBRATOR_SERVICE;

/**
 * Created by Ángel on 30/11/2016.
 */

public class GridFragment extends Fragment  implements SensorEventListener {

    private static final String TAG = ".GridFragment";
    private SensorManager mSensorManager;
    private SharedPreferences prefs;
    private GridView gridView;
    private GridAdapter gridAdapter;
    private ArrayList<ElementoGrid> items;

    boolean movimiento=false;
    Random rnd1;  //random para casos normales que no sean multiplos de 9
    Random rnd2; //random para todos los valores que sean múltipos de 9
    int rndInt; //numero aleatorio del 0 al 20
    String nombreImg_,nombreImgOK; //nombre del tipo de imagen (_no multiplos, OK si multiplos)
    int idImg_, idImgOK; //identificador de la imagen

    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.frangment_grid,
                container, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        Log.d(TAG,"onCreate");

        //rellenamos el array con objetos de tipo ElementoGrid
        String tipoIconos = prefs.getString("prefSyncFrequency", "tip1_");
        this.rellenarArray(tipoIconos);

        // creamos el listado GRID
        gridAdapter = new GridAdapter(GridFragment.this.getActivity(), items);

        // *** referencia los layout
        gridView = (GridView) view.findViewById(R.id.gridview);

        // establecemos el adaptador en la lista
        gridView.setAdapter(gridAdapter);
        //registramos el tipo de sensor
        mSensorManager = (SensorManager)getActivity().getSystemService(SENSOR_SERVICE);
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI);


        return view;

    }

    public void rellenarArray(String tipoImagen){
        //creamos nuestra coleccion de datos
        items = new ArrayList<>();
        rnd2 = new Random();
        rndInt =rnd2.nextInt(24)+1;
        nombreImgOK=tipoImagen+rndInt;
        idImgOK= getResources().getIdentifier(nombreImgOK,"drawable",GridFragment.this.getActivity().getPackageName()); //obteniendo el id de la imagen
        for (int i=1; i<=100;i++){
            if (i % 9 == 0){
                items.add(new ElementoGrid(i,idImgOK));
            }
            else{
                Log.d(TAG,i+" EL TAMAÑO DEL ARRAY --> "+items.size());

                do{
                    rnd1 = new Random();
                    rndInt = rnd1.nextInt(24)+1; //NUMERO ALEATORIO DEL 0 AL 20
                    nombreImg_= tipoImagen+rndInt; //NOMBRE DEL RECURSO IMAGEN CON EL Nº ALEATORIO
                    idImg_ = getResources().getIdentifier(nombreImg_,"drawable",GridFragment.this.getActivity().getPackageName()); //obteniendo el id de la imagen

                    Log.d(TAG,"Entra");
                }
                while (((items.size() >= 1) && (items.get(i-2).getIdImagen() == idImg_)) || (idImg_==idImgOK));

                items.add(new ElementoGrid(i,idImg_));
            }
        }
        System.out.println("Para ver si el 9 es: "+items.get(9).getIdImagen());
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER && movimiento == false) {
            float values[] = event.values;
            float y= values[1];
            if (y < -19){ //movil hacia abajo
                movimiento=true;
                Vibrator v = (Vibrator) getActivity().getSystemService(VIBRATOR_SERVICE);
                v.vibrate(1000);
                fade(this.gridView); //transicion desvanecimiento
            }
        }
    }

    public void fade(View button) { //Para la transición con el siguiente actívity
        Intent intent= new Intent(getActivity(),Result1Activity.class);
        intent.putExtra("iconoResultado",nombreImgOK); //se envia el nombre de la imagen

        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}
}

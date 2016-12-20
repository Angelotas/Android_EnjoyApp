package com.example.ngel.enjoyapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Ángel on 19/12/2016.
 */

public class Result1Activity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result1);
        this.onBackPressed();
    }
    @Override
    public void onBackPressed() {} //para que no pueda regresar al activity anterior
}

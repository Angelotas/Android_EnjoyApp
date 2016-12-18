package com.example.ngel.enjoyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Ángel on 18/12/2016.
 */

public class SettingsActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Check whether this activity was created before
        if (savedInstanceState == null) {
            // Create a fragment
            SettingsFragment fragment = new SettingsFragment();
            getFragmentManager()
                    .beginTransaction()
                    .add(android.R.id.content, fragment,
                            fragment.getClass().getSimpleName()).commit();
        }
    }

}

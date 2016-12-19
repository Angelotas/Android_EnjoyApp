package com.example.ngel.enjoyapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Ángel on 19/12/2016.
 */

public class IntroFragment extends Fragment{

    Button btn;

    public View onCreateView(LayoutInflater inflater, ViewGroup
            container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_intro,
                container, false);
        btn = (Button) view.findViewById(R.id.entendido);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                left(v);
            }
        });

        return view;
    }

    public void left(View button) {
        Intent intent= new Intent(getActivity(), GridActivity.class);
        startActivity(intent);
        getActivity().overridePendingTransition(R.anim.left_in, R.anim.left_out);

    }
}


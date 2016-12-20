package com.example.ngel.enjoyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ángel on 25/11/2016.
 */
public class GridAdapter extends BaseAdapter {

    private Context context;

    ImageView imagV;
    ArrayList<ElementoGrid> items;

    public GridAdapter(Context context ,ArrayList<ElementoGrid> items){
        this.context = context;
        this.items=items;
    }

    static class ViewHolder {
        TextView idIte;
        ImageView imageIcon;
    }

    public int getCount() {
        return items.size();
    }

    @Override
    public ElementoGrid getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getIdItem();
    }

    public View getView(final int position, View view, final ViewGroup viewGroup) {

        ElementoGrid elem= getItem(position);

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.formato_item, viewGroup, false);
        }

        //INSTANCIANDO RECURSOS

        TextView idIte = (TextView) view.findViewById(R.id.idItem); //del xml formato_item
        ImageView imageIcon = (ImageView) view.findViewById(R.id.imageIcon);  //del xml formato_item

        idIte.setText(elem.idItemToString());    //relaciona el xml con el elemento java
        imageIcon.setImageResource(elem.getIdImagen());

        return view;
    }


}

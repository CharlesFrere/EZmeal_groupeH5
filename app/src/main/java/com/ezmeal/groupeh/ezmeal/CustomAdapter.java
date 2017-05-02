package com.ezmeal.groupeh.ezmeal;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by elthe on 01-05-17.
 */

public class CustomAdapter extends ArrayAdapter<String> {



    public CustomAdapter(Context context, ArrayList recette) {
        super(context, R.layout.customlist, recette);
    }

    BDDmanager myManager = new BDDmanager(getContext());
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View customView = myInflater.inflate(R.layout.customlist, parent, false);

        String RecetteTitre = getItem(position);
        TextView TVcustomTitle = (TextView) customView.findViewById(R.id.TVcustomTitle);
        //ImageView IVcustom = (ImageView) customView.findViewById(R.id.IVcustom);

        TVcustomTitle.setText(RecetteTitre); //change dynamiquement les titres en fct de ce qu'on a dans l'arraylist

        String descriptionFromBDD = myManager.searchData2(RecetteTitre, "description");
        TextView TVcustomDescription = (TextView) customView.findViewById(R.id.TVcustomDescription);
        TVcustomDescription.setText(descriptionFromBDD);

        String prepaFromBDD = myManager.searchData2(RecetteTitre, "Tpreparation");
        String cuissFromBDD = myManager.searchData2(RecetteTitre, "Tcuisson");
        int i = Integer.parseInt(prepaFromBDD);
        int j = Integer.parseInt(cuissFromBDD);
        int k = i+j;

        TextView TVduree = (TextView) customView.findViewById(R.id.TVduree);
        TVduree.setText(String.valueOf(k));

        //IVcustom.setImageResource(R.mipmap.cube);
        return customView;
    }
}

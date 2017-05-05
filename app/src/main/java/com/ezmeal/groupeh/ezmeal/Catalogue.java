package com.ezmeal.groupeh.ezmeal;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by elthe on 30-04-17.
 */

public class Catalogue extends BaseActivity {

    public ListView myListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogue);
        myListView = (ListView)findViewById(R.id.LVcatalogue);
        populateListView();
    }

    public void populateListView(){

        //on crée un adapteur pour la liste
        BDDmanager b = new BDDmanager(this);
        ArrayList arr = new ArrayList();

        String flag = getIntent().getStringExtra("flag"); //on choppe la lettre qui vient de l'activité précédente
        //CAS OU ON AFFICHE TOUTES LES RECETTES
        if(flag.equals("A")) {
            arr = b.getRecetteArray();
        }
        //CAS OU ON AFFICHE LES RECETTES SUR BASE DES MOTS CLEFS
        if(flag.equals("B")) {
            String motclef = getIntent().getStringExtra("motclef"); //on choppe la lettre qui vient de l'activité précédente
            arr = b.getRecetteArrayMotClef(motclef);
            //Toast.makeText(this, motclef, Toast.LENGTH_SHORT).show();
        }
        //CAS OU ON AFFICHE LES RECETTES SUR BASE DES FILTRES
        if(flag.equals("C")) {
            String Type = getIntent().getStringExtra("Type"); //on choppe le type et le soustype qui vient de l'activité précédente
            String SousType = getIntent().getStringExtra("SousType");
            arr = b.getRecetteArrayType(Type,SousType);
        }
        //on crée un adapteur pour la liste
        //ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        ListAdapter adapter = new CustomAdapter(this, arr);
        myListView.setAdapter(adapter);
    }

}

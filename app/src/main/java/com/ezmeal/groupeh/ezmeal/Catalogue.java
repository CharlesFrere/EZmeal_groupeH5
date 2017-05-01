package com.ezmeal.groupeh.ezmeal;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by elthe on 30-04-17.
 */

public class Catalogue extends BaseActivity {

    private ListView myListView;
    BDDmanager myManager = new BDDmanager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogue);
        myListView = (ListView)findViewById(R.id.LVcatalogue);
        populateListView();
    }

    private void populateListView(){
        BDDmanager b = new BDDmanager(this);
        ArrayList arr = new ArrayList();
        arr = b.getRecetteArray();
        //on crée un adapteur pour la liste
        //ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        ListAdapter adapter = new CustomAdapter(this, arr);
        myListView.setAdapter(adapter);
    }
}

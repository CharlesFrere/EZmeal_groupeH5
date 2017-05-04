package com.ezmeal.groupeh.ezmeal;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by elthe on 02-05-17.
 */



public class Rechercher extends BaseActivity implements AdapterView.OnItemSelectedListener {

    ArrayAdapter adapter4;
    Spinner spinner4;
    ArrayAdapter adapter5;
    Spinner spinner5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rechercher);

        adapter4 = ArrayAdapter.createFromResource(this, R.array.spinner4, android.R.layout.simple_spinner_dropdown_item);
        spinner4 = (Spinner) findViewById(R.id.SPtype);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Rechercher.this);

        adapter5 = ArrayAdapter.createFromResource(this, R.array.spinner4, android.R.layout.simple_spinner_dropdown_item);
        spinner5 = (Spinner) findViewById(R.id.SPsoustype);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Rechercher.this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);
        ((TextView) parent.getChildAt(0)).setTextSize(20);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void onBtnClick(View v) {
        if (v.getId() == R.id.bMotclef) {
            Intent gh = new Intent(Rechercher.this, Catalogue.class); //changement d'activity
            EditText e = (EditText) findViewById(R.id.ETmotClef); //le mot clef tappé
            String stre = e.getText().toString();
            gh.putExtra("motclef", stre); //on envoie le mot clef dans l'activité d'arrivée
            gh.putExtra("flag", "B"); //on envoie B pour prévenir qu'on vient de rechercher
            startActivity(gh);
        }
    }
}

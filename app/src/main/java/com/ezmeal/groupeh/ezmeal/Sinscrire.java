package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;

/**
 * Created by elthe on 23-04-17.
 */

public class Sinscrire extends BaseActivity implements AdapterView.OnItemSelectedListener {

    BDDmanager manager;
    ArrayAdapter adapter;
    Spinner spinner1;
    ArrayAdapter adapter2;
    Spinner spinner2;
    ArrayAdapter adapter3;
    Spinner spinner3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinscrire);
        manager = new BDDmanager(this);

        adapter = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_dropdown_item);
        spinner1 = (Spinner) findViewById(R.id.SPlangue);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Sinscrire.this);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner2, android.R.layout.simple_spinner_dropdown_item);
        spinner2 = (Spinner) findViewById(R.id.SPnationalite);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Sinscrire.this);

        adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner3, android.R.layout.simple_spinner_dropdown_item);
        spinner3 = (Spinner) findViewById(R.id.SPsexe);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Sinscrire.this);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        ((TextView) parent.getChildAt(0)).setTextColor(Color.GRAY);
        ((TextView) parent.getChildAt(0)).setTextSize(20);

        Spinner spinner = (Spinner) parent;
        if(spinner.getId() == R.id.SPlangue)
        {
            //TextView spinnerSelected = (TextView) view;
            //Toast.makeText(this, "you selected " + spinnerSelected.getText(), Toast.LENGTH_SHORT).show();
            String selectedItem = parent.getItemAtPosition(position).toString();
            Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show();


        }
        else if(spinner.getId() == R.id.SPnationalite)
        {
            TextView spinnerSelected = (TextView) view;
            //Toast.makeText(this, "hello  nationnnnnnnnalité", Toast.LENGTH_SHORT).show();
        }
        else if(spinner.getId() == R.id.SPsexe)
        {
            TextView spinnerSelected = (TextView) view;
            //Toast.makeText(this, "hello  sexe", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //on en a besoin car on implémente OnItemSlectedListener
    }

    public void onBtnClick(View v){
        if(v.getId() == R.id.bSinscrireForm){
            //add langue
            //add nationalité
            //add sexe
            TextView prenom = (EditText)findViewById(R.id.ETprenom);
            TextView nom = (EditText)findViewById(R.id.ETnom);
            TextView age = (EditText)findViewById(R.id.ETage);
            TextView email = (EditText)findViewById(R.id.ETemail);
            TextView password = (EditText)findViewById(R.id.ETmdp);
            TextView confirmer = (EditText)findViewById(R.id.ETconfirmer);

            String prenomstr = prenom.getText().toString();
            String nomstr = nom.getText().toString();
            String agestr = age.getText().toString();
            String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String confirmerstr = confirmer.getText().toString();


            if(!passwordstr.equals(confirmerstr)){  //si les 2 mdp ne sont pas égaux.
                Toast mdp = Toast.makeText(Sinscrire.this , "Les Mots de passe ne correspondent pas!" , Toast.LENGTH_SHORT);
                mdp.show();
            }
            else{
                User u = new User();
                u.setPrenom(prenomstr);
                u.setNom(nomstr);
                u.setAge(agestr);
                u.setEmail(emailstr);
                u.setMdp(passwordstr);

                String nationnalitestr = spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString();
                u.setNationnalite(nationnalitestr);
                String languestr = spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString();
                u.setLangue(languestr);
                String sexestr = spinner3.getItemAtPosition(spinner3.getSelectedItemPosition()).toString();
                u.setSexe(sexestr);

                manager.insertUser(u);

                Intent h = new Intent(Sinscrire.this, MainActivity.class); //changement d'activity
                startActivity(h);
            }



        }
    }

}

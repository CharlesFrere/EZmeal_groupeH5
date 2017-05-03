package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by elthe on 24-04-17.
 */

public class Compte extends BaseActivity implements AdapterView.OnItemSelectedListener {

    BDDmanager myManager = new BDDmanager(this);

    ArrayAdapter adapter;
    Spinner spinner1;
    ArrayAdapter adapter2;
    Spinner spinner2;
    ArrayAdapter adapter3;
    Spinner spinner3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compte);


        //mettre toutes les infos de l'utilisateur dans les champs pour qu'il puisse les modifier
        SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String emailDeUser = sharedInfo.getString("userEmail", "userEmail not found");
       // EditText bjt = (EditText) findViewById(R.id.ETprenom);
       // bjt.setText(emailDeUser);


        String prenomFromBDD = myManager.searchData(emailDeUser, "prenom");
        EditText prenom = (EditText) findViewById(R.id.ETprenom);
        prenom.setText(prenomFromBDD);

        String nomFromBDD = myManager.searchData(emailDeUser, "nom");
        EditText nom = (EditText) findViewById(R.id.ETnom);
        nom.setText(nomFromBDD);

        String ageFromBDD = myManager.searchData(emailDeUser, "age");
        EditText age = (EditText) findViewById(R.id.ETage);
        age.setText(ageFromBDD);

        //String emailFuck = sharedInfo.getString("userEmail", "userEmail not found");
        //String emailFromBDD = myManager.searchData(emailDeUser, "email");
        //EditText email = (EditText) findViewById(R.id.ETemail);
        //email.setText(emailDeUser);

        String mdpFromBDD = myManager.searchData(emailDeUser, "mdp");
        EditText mdp = (EditText) findViewById(R.id.ETmdp);
        mdp.setText(mdpFromBDD);

        String confirmerFromBDD = myManager.searchData(emailDeUser, "mdp");
        EditText confirmer = (EditText) findViewById(R.id.ETconfirmer);
        confirmer.setText(mdpFromBDD);

        //PARTIE SPINNER
        adapter = ArrayAdapter.createFromResource(this, R.array.spinner1, android.R.layout.simple_spinner_dropdown_item);
        spinner1 = (Spinner) findViewById(R.id.SPlangue);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Compte.this);

        adapter2 = ArrayAdapter.createFromResource(this, R.array.spinner2, android.R.layout.simple_spinner_dropdown_item);
        spinner2 = (Spinner) findViewById(R.id.SPnationalite);
        spinner2.setAdapter(adapter2);
        spinner2.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Compte.this);

        adapter3 = ArrayAdapter.createFromResource(this, R.array.spinner3, android.R.layout.simple_spinner_dropdown_item);
        spinner3 = (Spinner) findViewById(R.id.SPsexe);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) Compte.this);

        String langueFromBDD = myManager.searchData(emailDeUser, "langue");
        spinner1.setSelection(adapter.getPosition(langueFromBDD));

        String nationnaliteFromBDD = myManager.searchData(emailDeUser, "nationnalite");
        spinner2.setSelection(adapter2.getPosition(nationnaliteFromBDD));

        String sexeFromBDD = myManager.searchData(emailDeUser, "sexe");
        spinner3.setSelection(adapter3.getPosition(sexeFromBDD));

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        ((TextView) parent.getChildAt(0)).setTextColor(Color.BLACK);
        ((TextView) parent.getChildAt(0)).setTextSize(18);
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



    public void onBtnClick(View v) {
        if (v.getId() == R.id.bMenu) {
            Intent gh = new Intent(Compte.this, Display.class); //changement d'activity
            startActivity(gh);
        }


        if (v.getId() == R.id.bEnregistrer){
            //add langue
            //add nationalité
            //add sexe
            TextView prenom = (EditText)findViewById(R.id.ETprenom);
            TextView nom = (EditText)findViewById(R.id.ETnom);
            TextView age = (EditText)findViewById(R.id.ETage);
            //TextView email = (EditText)findViewById(R.id.ETemail);
            TextView password = (EditText)findViewById(R.id.ETmdp);
            TextView confirmer = (EditText)findViewById(R.id.ETconfirmer);

            String prenomstr = prenom.getText().toString();
            String nomstr = nom.getText().toString();
            String agestr = age.getText().toString();
            //String emailstr = email.getText().toString();
            String passwordstr = password.getText().toString();
            String confirmerstr = confirmer.getText().toString();

            if(!passwordstr.equals(confirmerstr)){  //si les 2 mdp ne sont pas égaux.
                Toast mdp = Toast.makeText(Compte.this , "Les Mots de passe ne correspondent pas!" , Toast.LENGTH_SHORT);
                mdp.show();
            }
            else{
                User uMod = new User();
                uMod.setPrenom(prenomstr);
                uMod.setNom(nomstr);
                uMod.setAge(agestr);
                //uMod.setEmail(emailstr);
                uMod.setMdp(passwordstr);


                String nationnalitestr = spinner2.getItemAtPosition(spinner2.getSelectedItemPosition()).toString();
                uMod.setNationnalite(nationnalitestr);
                String languestr = spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString();
                uMod.setLangue(languestr);
                String sexestr = spinner3.getItemAtPosition(spinner3.getSelectedItemPosition()).toString();
                uMod.setSexe(sexestr);


                //on a besoin de l'email pour savoir quel utilisateur updater
                SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String emailDeUser = sharedInfo.getString("userEmail", "userEmail not found");

                myManager.updateUser(uMod, emailDeUser);

                Intent gh = new Intent(Compte.this, Display.class); //changement d'activity
                startActivity(gh);
            }

        }

    }


}

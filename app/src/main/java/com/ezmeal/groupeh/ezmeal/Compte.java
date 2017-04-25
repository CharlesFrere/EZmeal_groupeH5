package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by elthe on 24-04-17.
 */

public class Compte extends BaseActivity {

    BDDmanager myManager = new BDDmanager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        String emailFuck = sharedInfo.getString("userEmail", "userEmail not found");
        //String emailFromBDD = myManager.searchData(emailDeUser, "email");
        EditText email = (EditText) findViewById(R.id.ETemail);
        email.setText(emailDeUser);

        String mdpFromBDD = myManager.searchData(emailDeUser, "mdp");
        EditText mdp = (EditText) findViewById(R.id.ETmdp);
        mdp.setText(mdpFromBDD);

        String confirmerFromBDD = myManager.searchData(emailDeUser, "mdp");
        EditText confirmer = (EditText) findViewById(R.id.ETconfirmer);
        confirmer.setText(mdpFromBDD);
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
                Toast mdp = Toast.makeText(Compte.this , "Les Mots de passe ne correspondent pas!" , Toast.LENGTH_SHORT);
                mdp.show();
            }
            else{
                User uMod = new User();
                uMod.setPrenom(prenomstr);
                uMod.setNom(nomstr);
                uMod.setAge(agestr);
                uMod.setEmail(emailstr);
                uMod.setMdp(passwordstr);

                myManager.updateUser(uMod);

                Intent gh = new Intent(Compte.this, Display.class); //changement d'activity
                startActivity(gh);
            }

        }

    }


}

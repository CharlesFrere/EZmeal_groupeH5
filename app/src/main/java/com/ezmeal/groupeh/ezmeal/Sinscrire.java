package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by elthe on 23-04-17.
 */

public class Sinscrire extends BaseActivity {

    BDDmanager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sinscrire);
        manager = new BDDmanager(this);
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

                manager.insertUser(u);

                Intent h = new Intent(Sinscrire.this, MainActivity.class); //changement d'activity
                startActivity(h);
            }



        }
    }

}

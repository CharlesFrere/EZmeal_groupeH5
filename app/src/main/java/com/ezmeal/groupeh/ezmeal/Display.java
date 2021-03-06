package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by elthe on 22-04-17.
 */

public class Display extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String adremail = getIntent().getStringExtra("adremail"); //on choppe l'email qui vient de l'activité précédente (login)
        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(adremail);
    }

    public void onBtnClick(View v) {

        if (v.getId() == R.id.bCatalogue) {
            Intent ghh = new Intent(Display.this, Catalogue.class); //changement d'activity
            ghh.putExtra("flag", "A"); //on envoie stre dans l'activité d'arrivée
            startActivity(ghh);
        }

        if (v.getId() == R.id.bChercher) {
            Intent ghhg = new Intent(Display.this, Rechercher.class); //changement d'activity
            startActivity(ghhg);
        }

        if (v.getId() == R.id.bDeconnecter) {
            Intent gh = new Intent(Display.this, MainActivity.class); //changement d'activity
            startActivity(gh);
        }

        if(v.getId() == R.id.bCompte){
            Intent g = new Intent(Display.this, Compte.class); //changement d'activity
            startActivity(g);
        }
        if(v.getId() == R.id.bPreferences) {
            Intent ghhhq = new Intent(Display.this, ChoixContraintes.class); //changement d'activity
            startActivity(ghhhq);
        }
    }
}

package com.ezmeal.groupeh.ezmeal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by elthe on 22-04-17.
 */

public class Display extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String adremail = getIntent().getStringExtra("adremail"); //on choppe l'email qui vient de l'activité précédente
        TextView tv = (TextView)findViewById(R.id.TVusername);
        tv.setText(adremail);
    }

    public void onBtnClick(View v) {
        if (v.getId() == R.id.bDeconnecter) {
            Intent gh = new Intent(Display.this, MainActivity.class); //changement d'activity
            startActivity(gh);
        }

        if(v.getId() == R.id.bCompte){
            Intent g = new Intent(Display.this, Compte.class); //changement d'activity
            startActivity(g);
        }
    }
}

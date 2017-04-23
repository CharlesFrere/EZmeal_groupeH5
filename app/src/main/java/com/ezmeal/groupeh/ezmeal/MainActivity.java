package com.ezmeal.groupeh.ezmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    BDDmanager manager = new BDDmanager(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Click sur le bouton Display pr chts de activity
    public void onBtnClick(View v){

        if(v.getId() == R.id.bLogin){

            EditText e = (EditText)findViewById(R.id.ETemail); //on choppe ce qui est mit dans le field email
            String stre = e.getText().toString(); //et on le transfo en String
            EditText f = (EditText)findViewById(R.id.ETmdp); //on choppe ce qui est mit dans le field mdp
            String strf = f.getText().toString(); //et on le transfo en String

            //on regarde si l'email et le mdp correspondent dans la bdd
            String mdp = manager.searchMdp(stre);
            if(strf.equals(mdp)){
                Intent i = new Intent(MainActivity.this, Display.class); //changement d'activity
                i.putExtra("adremail", stre); //on envoie stre dans l'activité d'arrivée
                startActivity(i);
            }
            else{
                Toast tryAgain = Toast.makeText(MainActivity.this , "Mauvais mot de passe ou email..." , Toast.LENGTH_SHORT);
                tryAgain.show();
            }
        }


        if(v.getId() == R.id.bSinscrire){
            Intent g = new Intent(MainActivity.this, Sinscrire.class); //changement d'activity
            startActivity(g);
        }
    }
}

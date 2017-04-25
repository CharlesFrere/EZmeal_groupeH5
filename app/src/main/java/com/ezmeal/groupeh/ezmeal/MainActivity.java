package com.ezmeal.groupeh.ezmeal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends BaseActivity {

    BDDmanager manager = new BDDmanager(this);  //construit la db (appelle le constructor)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Click sur le bouton Display pr chts de activity
    public void onBtnClick(View v){

        if(v.getId() == R.id.bLogin){

            //showMessage("hello", "gars bonjour pomme oka!");


            EditText e = (EditText)findViewById(R.id.ETemail); //on choppe ce qui est mit dans le field email
            String stre = e.getText().toString(); //et on le transfo en String

            EditText f = (EditText)findViewById(R.id.ETmdp); //on choppe ce qui est mit dans le field mdp
            String strf = f.getText().toString(); //et on le transfo en String

            //on regarde si l'email et le mdp correspondent dans la bdd
            String mdp = manager.searchMdp(stre);
            if(strf.equals(mdp)){
                //Enregister l'email de l'utilisateur, pour pouvoir l'utiliser ailleurs dans l'app
                SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);  //mode private pour que que accessible par cette app
                SharedPreferences.Editor editor = sharedInfo.edit();
                editor.putString("userEmail", ((EditText)findViewById(R.id.ETemail)).getText().toString() );
                editor.apply();
                Toast.makeText(this, "email saved!", Toast.LENGTH_LONG).show();

                //changement d'activity
                Intent i = new Intent(MainActivity.this, Display.class);
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





    //SHOW MESSAGE
    public void showMessage(String titre, String contenu){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(titre);
        builder.setMessage(contenu);
        builder.show();
    }
}

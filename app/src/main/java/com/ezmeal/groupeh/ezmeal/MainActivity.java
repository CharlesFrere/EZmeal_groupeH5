package com.ezmeal.groupeh.ezmeal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Click sur le bouton Display pr chts de activity
    public void onBtnClick(View v){
        if(v.getId() == R.id.bLogin){

            EditText e = (EditText)findViewById(R.id.ETusername); //on choppe ce qui est mit dans le field ETusername
            String stre = e.getText().toString(); //et on le transfo en String


            Intent i = new Intent(MainActivity.this, Display.class); //changement d'activity
            i.putExtra("username", stre); //on envoie stre dans l'activité d'arrivée
            startActivity(i);
        }
    }
}

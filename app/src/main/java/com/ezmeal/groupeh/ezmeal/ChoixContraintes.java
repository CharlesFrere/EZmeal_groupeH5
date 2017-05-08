package com.ezmeal.groupeh.ezmeal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by charlesfrere on 5/05/17.
 */

public class ChoixContraintes extends BaseActivity{
    //String contrainte;
    //String préférence1, préférence2, préférence3;
    //String indésiré1, indésiré2, indésiré3;
    ArrayList<String> selectedItems = new ArrayList<>();
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choix_contraintes);
        ListView ch1 = (ListView)findViewById(R.id.checkable_list);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items = {"Musulman","Juif","Végétarien","Vegan"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.checkable_list);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView)view).getText().toString();
                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                }
                else
                    selectedItems.add(selectedItem);
            }
        });

    }

    public void showSelectedItems(View v){
        String items= "";
        for(String item:selectedItems){
            items +="-"+item+"\n";
        }
        Toast.makeText(this, "Vous avez choisi vos contraintes \n"+items,Toast.LENGTH_LONG).show();

    }



    /*public void setContraintes(String contrainte){
        this.contrainte = contrainte;
    }

    public void setPreferences(String pref1, String pref2, String pref3){
        this.préférence1 = pref1;
        this.préférence2 = pref2;
        this.préférence3 = pref3;
    }

    public void setIndésirés(String indésiré1,String indésiré2, String indésiré3){
        this.indésiré1 = indésiré1;
        this.indésiré2 = indésiré2;
        this.indésiré3 = indésiré3;
    }
    */

    public void onBtnClick(View v) {
        if (v.getId() == R.id.buttonEnr) {

            TextView preference1 = (EditText) findViewById(R.id.editText3);
            TextView preference2 = (EditText) findViewById(R.id.editText2);
            TextView preference3 = (EditText) findViewById(R.id.editText);

            TextView indesire1 = (EditText) findViewById(R.id.editText7);
            TextView indesire2 = (EditText) findViewById(R.id.editText6);
            TextView indesire3 = (EditText) findViewById(R.id.editText5);

            //TextView contrainte = (EditText) findViewById(R.id.liste_contraintes);


            String pref1 = preference1.getText().toString();
            String pref2 = preference2.getText().toString();
            String pref3 = preference3.getText().toString();

            String ind1 = indesire1.getText().toString();
            String ind2 = indesire2.getText().toString();
            String ind3 = indesire3.getText().toString();

            //String contr = contrainte.getText().toString();

            // comment enregister les contraintes ? aller chercher le User uMod de Compte ?

            User user = new User();
            //user.setContraintes(contr);
            user.setPreferences(pref1,pref2,pref3);
            user.setIndésirés(ind1,ind2,ind3);

            Intent azerty = new Intent(ChoixContraintes.this, Display.class);
            startActivity(azerty);
        }

        }




}

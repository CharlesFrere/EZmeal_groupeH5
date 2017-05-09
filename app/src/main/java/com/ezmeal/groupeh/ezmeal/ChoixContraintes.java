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
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.view.View;

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

import java.util.ArrayList;


/**
 * Created by charlesfrere on 5/05/17.
 */

public class ChoixContraintes extends BaseActivity{

    BDDmanager myManager = new BDDmanager(this);
    //String contrainte;
    //String préférence1, préférence2, préférence3;
    //String indésiré1, indésiré2, indésiré3;
    ArrayList<String> selectedItems;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.choix_contraintes);
        selectedItems=new ArrayList<String>();


    }

    public void showSelectedItems(View v){
        String items= "";
        for(String item:selectedItems){
            items +="-"+item+"\n";
        }
        Toast.makeText(this, "Vous avez choisi vos contraintes \n"+items,Toast.LENGTH_LONG).show();

    }

    public void onStart(){
        super.onStart();
        //create an instance of ListView
        ListView chl=(ListView) findViewById(R.id.checkable_list);
        //set multiple selection mode
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"lactose","halal","cachère","végétatien"};
        //supply data itmes to ListView
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,R.layout.checkable_list,R.id.txt_title,items);
        chl.setAdapter(aa);
        //set OnItemClickListener
        chl.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items

            }

        });
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
        if (v.getId() == R.id.buttonChoix) {



            TextView preference1 = (EditText) findViewById(R.id.editText3);
            TextView preference2 = (EditText) findViewById(R.id.editText2);
            TextView preference3 = (EditText) findViewById(R.id.editText);

            TextView indesire1 = (EditText) findViewById(R.id.editText7);
            TextView indesire2 = (EditText) findViewById(R.id.editText6);
            TextView indesire3 = (EditText) findViewById(R.id.editText5);




            String pref1 = preference1.getText().toString();
            String pref2 = preference2.getText().toString();
            String pref3 = preference3.getText().toString();

            String ind1 = indesire1.getText().toString();
            String ind2 = indesire2.getText().toString();
            String ind3 = indesire3.getText().toString();



            ArrayList<String> gout = new ArrayList<>();
            gout.add(0,pref1);
            gout.add(1,pref2);
            gout.add(2,pref3);
            gout.add(3,ind1);
            gout.add(4,ind2);
            gout.add(5,ind3);
            // b.insertGout(gout);
            SharedPreferences sharedInfo = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
            String emailDeUser = sharedInfo.getString("userEmail", "userEmail not found");

            myManager.insertGout(emailDeUser,gout);
            myManager.insertUserContrainte(emailDeUser,selectedItems);

           // b.insertUserContrainte(selectedItems);


            //user.setPreferences(pref1,pref2,pref3);
            //user.setIndésirés(ind1,ind2,ind3);

            Intent azerty = new Intent(ChoixContraintes.this, Display.class);
            startActivity(azerty);
        }

        }




}

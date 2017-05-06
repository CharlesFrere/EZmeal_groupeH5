package com.ezmeal.groupeh.ezmeal;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by noe_d on 01-05-17.
 */

public class Recette extends BaseActivity {

    public  ArrayList<ArrayList> getBon (ArrayList<String> list) {
        ArrayList<ArrayList> are = new ArrayList<>();
        ArrayList<String> nom = new ArrayList<>();
        ArrayList<Integer> pourcentage = new ArrayList<>();
        are.add(nom);
        are.add(pourcentage);
        BDDmanager c = new BDDmanager(this);
        ArrayList<String> zar = new ArrayList();
        int check = 0 ;
        int nombre = 0 ;
        int preference = 0 ;

        for (int x = 0 ; x < list.size() ; x++ ) {
            zar = c.getAliment(list.get(x));
            check = 0;
            preference = 0;
            nombre = 0;
            for(int t = 0 ; t < zar.size() && check==0; t++){
                if (getContrainte(c.getContrainteA(zar.get(t)), c.getContrainteU("hasard") ) == false ){
                   check++;
                }
                preference = preference + c.getPref(zar.get(t),"hasard").get(0);
                nombre++;
            }
            if (check == 0){
                are.get(0).add(list.get(x));
                are.get(1).add((preference *100)/nombre);
            }
        }
        return are ;

    }
    public boolean getContrainte(ArrayList contrainteA , ArrayList contrainteU ){
        for (int i = 0; i < contrainteA.size() ; i++ ) {
            for(int j = 0; j < contrainteU.size() ; j++) {
                if (contrainteA.get(i) == null) {
                    return true;
                }
                if ( contrainteA.get(i) ==  contrainteU.get(j) ) {
                    return false;
                }
            }
        }
        return true;
    }
    public ArrayList<String> trier(ArrayList<String> listRecette ) {
        ArrayList<ArrayList> are = getBon(listRecette);
        ArrayList<String> RecetteTrier = new ArrayList<>();
        Integer j = -100;
        int count = 0;

        while (!are.get(0).isEmpty()) {
            for (int i = 0; i < are.get(1).size(); i++) {
                if ((Integer)are.get(1).get(i) > j) {
                    count = i;
                    j = (Integer) are.get(1).get(i);
                }
            }
            RecetteTrier.add(are.get(0).get(count).toString());
            are.get(0).remove(count);
            are.get(1).remove(count);
        }
        return RecetteTrier;
    }

}

package com.ezmeal.groupeh.ezmeal;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by elthe on 23-04-17.
 */

public class BDDmanager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 6;
    private static final String DATABASE_NAME = "myBDD.db";
    private static final String TABLE_NAME = "utilisateur";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PRENOM = "prenom";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MDP = "mdp";
    private static final String TABLE_CREATE = "CREATE TABLE" + TABLE_NAME;


    public BDDmanager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "CREATE TABLE " + TABLE_NAME + "(" +
                        COLUMN_EMAIL + " VARCHAR(255) PRIMARY KEY, " +
                        //COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PRENOM + " VARCHAR(255), " +
                        COLUMN_NOM + " VARCHAR(255), " +
                        COLUMN_AGE + " VARCHAR(255), " +
                        COLUMN_MDP + " VARCHAR(255) " +
                        ");";
        db.execSQL(query);
    }

    //création de insterUser()
    public void insertUser(User u){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PRENOM, u.getPrenom());
        values.put(COLUMN_NOM, u.getNom());
        values.put(COLUMN_AGE, u.getAge());
        values.put(COLUMN_MDP, u.getMdp());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //Création de updateUser()
    public void updateUser(User u, String email){
        SQLiteDatabase db = this.getReadableDatabase();
        /*ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PRENOM, u.getPrenom());
        values.put(COLUMN_NOM, u.getNom());
        values.put(COLUMN_AGE, u.getAge());
        values.put(COLUMN_MDP, u.getMdp()); */


        String query = "UPDATE utilisateur SET PRENOM = '"+u.getPrenom()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query);
    }




    //Création de searchMpd()
    public String searchMdp(String mail){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select email, mdp from "+TABLE_NAME;
        //pose le curseur au résultat de la query
        Cursor c = db.rawQuery(query, null);
        String x, y;
        y = "pas trouvé";
        if(c.moveToFirst()){
            do{
                x = c.getString(c.getColumnIndex(COLUMN_EMAIL));
                if(x.equals(mail)){
                    y = c.getString(c.getColumnIndex(COLUMN_MDP));
                    break;
                }
            }
            while(c.moveToNext());
        }
        c.close();
        return y;
    }


    //Search une data grâce à email
    public String searchData(String mail, String dataColumn){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select email, " + dataColumn +" from "+TABLE_NAME;
        //pose le curseur au résufltat de la query
        Cursor cu = db.rawQuery(query, null);
        String x, y;
        y = "pas trouvé";
        if(cu.moveToFirst()){
            do{
                x = cu.getString(cu.getColumnIndex(COLUMN_EMAIL));
                if(x.equals(mail)){
                    y = cu.getString(cu.getColumnIndex(dataColumn));
                    break;
                }
            }
            while(cu.moveToNext());
        }
        cu.close();
        return y;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // delete the existing database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        // call onCreate
        onCreate(db);
    }
}

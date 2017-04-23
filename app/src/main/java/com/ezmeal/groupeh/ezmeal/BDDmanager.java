package com.ezmeal.groupeh.ezmeal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * Created by elthe on 23-04-17.
 */

public class BDDmanager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "myBDD.db";
    private static final String TABLE_NAME = "utilisateur";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_PRENOM = "prenom";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MDP = "mdp";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "CREATE TABLE" + TABLE_NAME;


    public BDDmanager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =  "CREATE TABLE " + TABLE_NAME + "(" +
                        //COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PRENOM + " VARCHAR(255), " +
                        COLUMN_NOM + " VARCHAR(255), " +
                        COLUMN_EMAIL + " VARCHAR(255) PRIMARY KEY, " +
                        COLUMN_MDP + " VARCHAR(255) " +
                        ");";
        db.execSQL(query);
        this.db = db;
    }

    //création de insterUser()
    public void insertUser(User u){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EMAIL, u.getEmail());
        values.put(COLUMN_PRENOM, u.getPrenom());
        values.put(COLUMN_NOM, u.getNom());
        values.put(COLUMN_MDP, u.getMdp());


        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    //Création de searchMpd()
    public String searchMdp(String mail){
        db = this.getReadableDatabase();

        String query = "select email, mdp from "+TABLE_NAME;
        //pose le curseur au résultat de la query
        Cursor cursor = db.rawQuery(query, null);
        String x, y;
        y = "pas trouvé";
        if(cursor.moveToFirst()){
            do{
                x = cursor.getString(0);
                if(x.equals(mail)){
                    y = cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }
        cursor.close();
        return y;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL(query);
        onCreate(db);
    }
}

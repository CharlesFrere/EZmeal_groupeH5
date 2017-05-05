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

import java.util.ArrayList;

/**
 * Created by elthe on 23-04-17.
 */

public class BDDmanager extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 32;
    private static final String DATABASE_NAME = "myBDD.db";
    private static final String TABLE_NAME = "utilisateur";
    //private static final String COLUMN_ID = "id";
    private static final String COLUMN_PRENOM = "prenom";
    private static final String COLUMN_NOM = "nom";
    private static final String COLUMN_AGE = "age";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_MDP = "mdp";
    private static final String COLUMN_LANGUE = "langue";
    private static final String COLUMN_NATIONNALITE = "nationnalite";
    private static final String COLUMN_SEXE = "sexe";
    //private static final String TABLE_CREATE = "CREATE TABLE" + TABLE_NAME;

    //2eme table
    private static final String TABLE_NAME2 = "recette";
    private static final String COLUMN_NOMR = "nomR";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_ETAPE = "etape";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TPREPARATION = "Tpreparation";
    private static final String COLUMN_TCUISSON = "Tcuisson";
    private static final String COLUMN_FACILITE = "facilite";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_SOUSTYPE = "sousType";
    private static final String COLUMN_NBR = "nbr";
    private static final String COLUMN_IMAGE = "image";


    //3eme table
    private static final String TABLE_NAME3 = "contrainte";
    private static final String COLUMN_EMAIL2 = "email";
    private static final String COLUMN_CONTRAINTEU = "contrainteu";

    //4eme table
    private static final String TABLE_NAME4 = "aliments";
    private static final String COLUMN_ALIMENT = "aliment";
    private static final String COLUMN_CONTRAINTEA = "contraintea";

    //5eme table
    private static final String TABLE_NAME5 = "quantite";
    private static final String COLUMN_ALIMENT2 = "aliment";
    private static final String COLUMN_NOMR2 = "recette";
    private static final String COLUMN_QUANTITE = "quantite";

    //6eme table
    private static final String TABLE_NAME6 = "gout";
    private static final String COLUMN_ALIMENT3 = "aliment";
    private static final String COLUMN_EMAIL3 = "email";
    private static final String COLUMN_GOUT = "gout";




    public BDDmanager(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        //création de la table recettes
        String query =  "CREATE TABLE " + TABLE_NAME2 + "(" +
                COLUMN_NOMR + " VARCHAR(255) PRIMARY KEY, " +
                //COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_DESCRIPTION + " VARCHAR(255), " +
                COLUMN_ETAPE + " VARCHAR(255), " +
                COLUMN_DATE + " VARCHAR(255), " +
                COLUMN_TPREPARATION + " INTEGER, " +
                COLUMN_TCUISSON + " INTEGER, " +
                COLUMN_FACILITE + " INTEGER, " +
                COLUMN_TYPE + " VARCHAR(255), " +
                COLUMN_SOUSTYPE + " VARCHAR(255), " +
                COLUMN_NBR + " INTEGER, " +
                COLUMN_IMAGE + " VARCHAR(255) " +
                ");";
        db.execSQL(query);

        //on met des données dans la table recette
        ContentValues PatesSaumon = new ContentValues();
        PatesSaumon.put(COLUMN_NOMR, "Pâtes au saumon");
        PatesSaumon.put(COLUMN_DESCRIPTION, "Pâtes au saumon fumé à la vince");
        PatesSaumon.put(COLUMN_ETAPE, "Faire fondre le beurre dans une casserole et y faire revenir l'échalote hachée jusqu'à ce qu'elle blondisse.\n" +
                "Déglacer avec le vin blanc et attendre la reprise de l'ébullition.\n" +
                "Ajouter le jus de citron, la crème fraîche, la sauce tomate et la ciboulette.\n" +
                "Enfin, ajouter à la préparation le saumon coupé grossièrement en carrés. \n" +
                "Laisser chauffer la sauce sur feu très doux pendant la cuisson des pâtes.\n" +
                "Servez la sauce et les pâtes séparément.\n" +
                "Bon appétit !!!");
        PatesSaumon.put(COLUMN_DATE, "2017-03-07");
        PatesSaumon.put(COLUMN_TPREPARATION, 10);
        PatesSaumon.put(COLUMN_TCUISSON, 15);
        PatesSaumon.put(COLUMN_FACILITE, "facile");
        PatesSaumon.put(COLUMN_TYPE, "plat");
        PatesSaumon.put(COLUMN_SOUSTYPE, "chaud");
        PatesSaumon.put(COLUMN_NBR, 4);
        PatesSaumon.put(COLUMN_IMAGE, "patesSaumon");
        db.insert(TABLE_NAME2, null, PatesSaumon);

        ContentValues ChaussonPoires = new ContentValues();
        ChaussonPoires.put(COLUMN_NOMR, "Chausson au poires");
        ChaussonPoires.put(COLUMN_DESCRIPTION, "Recette à base de poires version grand-mère");
        ChaussonPoires.put(COLUMN_ETAPE, "Préchauffer votre four à 200°C. \n" +
                "Pelez les poires et les couper en petits morceaux. \n" +
                "Faire fondre le beurre dans un poêle anti adhésive, ajouter dans les morceaux de poires, saupoudrez du sucre roux et de cannelle (abondamment, moi j'adore ça!!), bien mélanger et laisser mijoter...Eteigner le feu et laisser refroidir quelques minutes. \n" +
                "Déroulez vos pâtes feuilletées. Découper deux bords parallèles de façon à obtenir deux bords droits l'un en face de l'autre, et deux bords arrondis l'un en face de l'autre (un peu compliqué!!). \n" +
                "Couper ensuite deux longues bandes identiques dans le sens de la longueur (commencer à couper depuis un bord arrondi). \n" +
                "Placer un bonne cuillère à soupe de préparation aux poires au bas d'une bande. Replier le bord supérieur par dessus. Souder le bord tout le long du chausson. Tailler trois \"nervures\" sur le dessus du chausson. \n" +
                "Mélanger le jaune d'oeuf, le lait et le sucre. Déposer ce mélange au pinceau sur le chausson. \n" +
                "Réitérer cette opération jusqu'à obtenir 4 chaussons aux poires. \n" +
                "Placer au four pendant 15 mn.");
        ChaussonPoires.put(COLUMN_DATE, "2017-05-07");
        ChaussonPoires.put(COLUMN_TPREPARATION, 15);
        ChaussonPoires.put(COLUMN_TCUISSON, 20);
        ChaussonPoires.put(COLUMN_FACILITE, "moyen");
        ChaussonPoires.put(COLUMN_TYPE, "plat");
        ChaussonPoires.put(COLUMN_SOUSTYPE, "chaud");
        ChaussonPoires.put(COLUMN_NBR, 4);
        ChaussonPoires.put(COLUMN_IMAGE, "ChaussonPoires");
        db.insert(TABLE_NAME2, null, ChaussonPoires);


        //création de la table utilisateur, qui est initIalement vide
        String queryB =  "CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_EMAIL + " VARCHAR(255) PRIMARY KEY, " +
                //COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PRENOM + " VARCHAR(255), " +
                COLUMN_NOM + " VARCHAR(255), " +
                COLUMN_AGE + " VARCHAR(255), " +
                COLUMN_MDP + " VARCHAR(255), " +
                COLUMN_LANGUE + " VARCHAR(255), " +
                COLUMN_NATIONNALITE + " VARCHAR(255), " +
                COLUMN_SEXE + " VARCHAR(255) " +
                ");";
        db.execSQL(queryB);

        //création de la table contrainte, qui est initIalement vide
        String queryC =  "CREATE TABLE " + TABLE_NAME3 + "(" +
                COLUMN_EMAIL2 + " VARCHAR(255), " +
                COLUMN_CONTRAINTEU + " VARCHAR(255) " +
                ");";
        db.execSQL(queryC);

        //création de la table aliment, qui est initIalement vide
        String queryD =  "CREATE TABLE " + TABLE_NAME4 + "(" +
                COLUMN_ALIMENT + " VARCHAR(255), " +
                COLUMN_CONTRAINTEA + " VARCHAR(255) " +
                ");";
        db.execSQL(queryD);

        //création de la table quantite, qui est initIalement vide
        String queryE =  "CREATE TABLE " + TABLE_NAME5 + "(" +
                COLUMN_ALIMENT2 + " VARCHAR(255), " +
                COLUMN_NOMR2 + " VARCHAR(255), " +
                COLUMN_QUANTITE + " VARCHAR(255) " +
                ");";
        db.execSQL(queryE);

        //création de la table gout, qui est initIalement vide
        String queryF =  "CREATE TABLE " + TABLE_NAME6 + "(" +
                COLUMN_ALIMENT3 + " VARCHAR(255), " +
                COLUMN_EMAIL3 + " VARCHAR(255), " +
                COLUMN_GOUT + " VARCHAR(255) " +
                ");";
        db.execSQL(queryF);
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
        values.put(COLUMN_LANGUE, u.getLangue());
        values.put(COLUMN_NATIONNALITE, u.getNationnalite());
        values.put(COLUMN_SEXE, u.getSexe());

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
        String query2 = "UPDATE utilisateur SET NOM = '"+u.getNom()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query2);
        String query3 = "UPDATE utilisateur SET AGE = '"+u.getAge()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query3);
        String query4 = "UPDATE utilisateur SET MDP = '"+u.getMdp()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query4);

        String query5 = "UPDATE utilisateur SET LANGUE = '"+u.getLangue()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query5);
        String query6 = "UPDATE utilisateur SET NATIONNALITE = '"+u.getNationnalite()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query6);
        String query7 = "UPDATE utilisateur SET SEXE = '"+u.getSexe()+"' WHERE EMAIL = '"+email+"'";
        db.execSQL(query7);
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

    //Search une data grâce à recette
    public String searchData2(String NomR, String dataColumn){
        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select nomR, " + dataColumn +" from "+TABLE_NAME2;
        //pose le curseur au résufltat de la query
        Cursor cu = db.rawQuery(query, null);
        String x, y;
        y = "pas trouvé";
        if(cu.moveToFirst()){
            do{
                x = cu.getString(cu.getColumnIndex(COLUMN_NOMR));
                if(x.equals(NomR)){
                    y = cu.getString(cu.getColumnIndex(dataColumn));
                    break;
                }
            }
            while(cu.moveToNext());
        }
        cu.close();
        return y;
    }

    //Création d'un arraylist qui contient les titres de toutes les recettes
    public ArrayList<String> getRecetteArray(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NOMR FROM " + TABLE_NAME2;
        Cursor dataCursor = db.rawQuery(query, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listData = new ArrayList<>();
        while(dataCursor.moveToNext()){
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listData.add(dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NOMR)));
        }
        dataCursor.close();
        return listData;
    }

    //Création d'un arraylist qui contient les titres des recettes en fct des mots clefs
    public ArrayList<String> getRecetteArrayMotClef(String motClef){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NOMR FROM " + TABLE_NAME2 + " WHERE NOMR OR DESCRIPTION LIKE " + "'%" + motClef + "%'";
        Cursor dataCursor = db.rawQuery(query, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listData = new ArrayList<>();
        while(dataCursor.moveToNext()){
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listData.add(dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NOMR)));
        }
        dataCursor.close();
        return listData;
    }


    public ArrayList<String> getRecetteArrayType(String Type , String SousType){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT DISTINCT NOMR FROM " + TABLE_NAME2 + "WHERE TYPE =" + Type ;
        Cursor dataCursor = db.rawQuery(query, null);
        //on choppe les données grâce au curseur et on les met dans listData
        ArrayList<String> listData = new ArrayList<>();
        while(dataCursor.moveToNext()) {
            listData.add(dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NOMR)));
        }
        dataCursor.close();

        if(SousType == null){
            return listData;
        }
        else
        {
            //On prend les SousType d'une recette de la liste
            for(int j=0;j<listData.size();j++) {
                String query2 = "SELECT SOUSTYPE FROM " + TABLE_NAME2 + "WHERE NOMR=" + listData.get(j);
                Cursor dataCursor2 = db.rawQuery(query2, null);
                //Boucle pour check les SousTypes de l'utilisateur
                    // Tant que la recette contient encore des SousTYpe, on check
                while (dataCursor2.moveToNext()) {
                    if(dataCursor2.getString(dataCursor.getColumnIndex(COLUMN_SOUSTYPE)) == SousType)
                    {
                        break;
                    }
                }
                // Si on sort de la boucle car on n'obtient aucune correspondance, on retire la recette
                if(!dataCursor.moveToNext()) {
                    listData.remove(j);
                }

                dataCursor2.close();
            }
            return listData;
        }
    }




    //Création d'un arraylist qui contient les titres des recettes en des types et sous types
    //à faire

    public ArrayList<String> getContrainteU(String util){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryC = "SELECT CONTRAINTEU FROM " + TABLE_NAME3 + "WHERE EMAIL2 = " + util;
        Cursor dataCursora = db.rawQuery(queryC, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listDataa = new ArrayList<>();
        while(dataCursora.moveToNext()){
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listDataa.add(dataCursora.getString(dataCursora.getColumnIndex(COLUMN_CONTRAINTEU)));
        }
        dataCursora.close();
        return listDataa;
    }

    public ArrayList<String> getContrainteA(String alim){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryD = "SELECT CONTRAINTEA FROM " + TABLE_NAME4 +"WHERE ALIMENT = " + alim;
        Cursor dataCursorb = db.rawQuery(queryD, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listDatab = new ArrayList<>();
        while(dataCursorb.moveToNext()){
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listDatab.add(dataCursorb.getString(dataCursorb.getColumnIndex(COLUMN_CONTRAINTEA)));
        }
        dataCursorb.close();
        return listDatab;
    }

    public ArrayList<String> getAliment(String recette) {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryE = "SELECT ALIMENT2 FROM " + TABLE_NAME5 + "WHERE NOMR2 = " + recette;
        Cursor dataCursorc = db.rawQuery(queryE, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listDatac = new ArrayList<>();
        while (dataCursorc.moveToNext()) {
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listDatac.add(dataCursorc.getString(dataCursorc.getColumnIndex(COLUMN_ALIMENT2)));
        }
        dataCursorc.close();
        return listDatac;
    }
    public ArrayList<Integer> getPref(String alim , String util) {
        SQLiteDatabase db = this.getReadableDatabase();
        String queryF = "SELECT GOUT FROM " + TABLE_NAME6 + "WHERE ALIMENT = " + alim +"AND EMAIL =" + util;
        Cursor dataCursorc = db.rawQuery(queryF, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<Integer> listDatac = new ArrayList<>();
        while (dataCursorc.moveToNext()) {
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listDatac.add(dataCursorc.getInt(dataCursorc.getColumnIndex(COLUMN_GOUT)));
        }
        dataCursorc.close();
        return listDatac;
    }

    //Méthode qui renvoie une certaine info(descrption, date,...) d'une recette en fct de son titre.


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // delete the existing database
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME4);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME5);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME6);
        // call onCreate
        onCreate(db);
    }
}
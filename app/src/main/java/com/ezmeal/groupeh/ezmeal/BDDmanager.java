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


    private static final int DATABASE_VERSION = 86;
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
    private static final String TABLE_NAME5 = "Tquantite";
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
        //PatesSaumon.put(COLUMN_DESCRIPTION, "Pâtes au saumon fumé à la vince");
        PatesSaumon.put(COLUMN_DESCRIPTION, "LOOOOOL");
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
        PatesSaumon.put(COLUMN_IMAGE, "img1");
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
        ChaussonPoires.put(COLUMN_SOUSTYPE, "Froid");
        ChaussonPoires.put(COLUMN_NBR, 4);
        ChaussonPoires.put(COLUMN_IMAGE, "img2");
        db.insert(TABLE_NAME2, null, ChaussonPoires);


        ContentValues PatesBolo = new ContentValues();
        PatesBolo.put(COLUMN_NOMR, "Pâtes à la bolognaise");
        PatesBolo.put(COLUMN_DESCRIPTION, "Pâtes avec des boulettes de viandes et une sauce à base de tomates");
        PatesBolo.put(COLUMN_ETAPE, " Faites fondre un peu de beurre ou mettez de l’huile dans le fond de la casserole.\n" +
                "Coupez les oignons, les poivrons et les tomates, incorporez au fur et à mesure dans la préparation.\n" +
                "Ajoutez la viande hachée et séparez la en petit morceaux .\n" +
                "Ajoutez le concentré de tomates.\n" +
                "Laissez chauffer à feux doux pendant 20 minutes. \n" +
                "Faites chauffer de l’eau\n" +
                "Cuisez les pâtes, puis servez.\n" +
                "Bon appétit !!!");
        PatesBolo.put(COLUMN_DATE, "2017-03-07");
        PatesBolo.put(COLUMN_TPREPARATION, 20);
        PatesBolo.put(COLUMN_TCUISSON, 35);
        PatesBolo.put(COLUMN_FACILITE, "facile");
        PatesBolo.put(COLUMN_TYPE, "plat");
        PatesBolo.put(COLUMN_SOUSTYPE, "chaud");
        PatesBolo.put(COLUMN_NBR, 4);
        PatesBolo.put(COLUMN_IMAGE, "img3");
        db.insert(TABLE_NAME2, null, PatesBolo);


        ContentValues SoupePoisson = new ContentValues();
        SoupePoisson.put(COLUMN_NOMR, "Soupe de poisson");
        SoupePoisson.put(COLUMN_DESCRIPTION, "Soupe à base de poisson et légumes en morceaux");
        SoupePoisson.put(COLUMN_ETAPE, " coupez les oignons, les échalottes et les poireaux.\n" +
                "Ajoutez les dans la casserole au fur et à mesure dans cet ordre.\n" +
                "Coupez le saumon et le cabillaud en cubes de taille moyenne.\n" +
                "Insérez les dans la soupe, en même temps que beaucoup d’eau.\n" +
                "Laissez la soupe cuire 10 minutes. \n" +
                "Laissez reposer à feux doux quelques minutes. \n" +
                "Servez.\n" +
                "Bon appétit !!!");
        SoupePoisson.put(COLUMN_DATE, "2017-03-07");
        SoupePoisson.put(COLUMN_TPREPARATION, 20);
        SoupePoisson.put(COLUMN_TCUISSON, 35);
        SoupePoisson.put(COLUMN_FACILITE, "moyen");
        SoupePoisson.put(COLUMN_TYPE, "plat");
        SoupePoisson.put(COLUMN_SOUSTYPE, "chaud");
        SoupePoisson.put(COLUMN_NBR, 4);
        SoupePoisson.put(COLUMN_IMAGE, "img4");
        db.insert(TABLE_NAME2, null, SoupePoisson);

        ContentValues PouletChampignons = new ContentValues();
        PouletChampignons .put(COLUMN_NOMR, "Poulet au champignons");
        PouletChampignons .put(COLUMN_DESCRIPTION, "Poulet avec des champignons, lardons et onions, cuit dans du vin rouge");
        PouletChampignons .put(COLUMN_ETAPE, "Coupez les oignons et mettez-les à dorer dans une poêle avec de l’huile.\n" +
                "commencer à couper et brosser les champignons.\n" +
                "Ajoutez les et attendez trois minutes.\n" +
                "ajoutez le poulet, puis les lardons.\n" +
                "Versez un verre de vin, laissez absorber, puis un autre verre. \n" +
                "Laissez reposer à feux doux quelques minutes. \n" +
                "Servez.\n" +
                "Bon appétit !!!");
        PouletChampignons.put(COLUMN_DATE, "2017-03-07");
        PouletChampignons.put(COLUMN_TPREPARATION, 25);
        PouletChampignons.put(COLUMN_TCUISSON, 15);
        PouletChampignons.put(COLUMN_FACILITE, "facile");
        PouletChampignons.put(COLUMN_TYPE, "plat");
        PouletChampignons.put(COLUMN_SOUSTYPE, "chaud");
        PouletChampignons.put(COLUMN_NBR, 4);
        PouletChampignons.put(COLUMN_IMAGE, "img5");
        db.insert(TABLE_NAME2, null, PouletChampignons);

        ContentValues RizCoco = new ContentValues();
        RizCoco.put(COLUMN_NOMR, "Riz au lait coco fraise");
        RizCoco.put(COLUMN_DESCRIPTION, "Riz au lait avec des extraits de coco et de la fraise");
        RizCoco.put(COLUMN_ETAPE, "Faites bouillir une grande casserole d’eau.\n" +
                "Faites cuire du riz pendant 10 minutes.\n" +
                "Mettez le riz, la noix de coco et le lait de coco dans une autre casserole.\n" +
                "Laissez cuire 15 min en remuant.\n" +
                "Ajoutez des fraises écrasées et du sucre. \n" +
                "Bon appétit !!!");
        RizCoco.put(COLUMN_DATE, "2017-03-07");
        RizCoco.put(COLUMN_TPREPARATION, 10);
        RizCoco.put(COLUMN_TCUISSON, 35);
        RizCoco.put(COLUMN_FACILITE, "facile");
        RizCoco.put(COLUMN_TYPE, "dessert");
        RizCoco.put(COLUMN_SOUSTYPE, "froid");
        RizCoco.put(COLUMN_NBR, 4);
        RizCoco.put(COLUMN_IMAGE, "img13");
        db.insert(TABLE_NAME2, null, RizCoco);


        ContentValues Gauffres = new ContentValues();
        Gauffres.put(COLUMN_NOMR, "Gaufres classiques");
        Gauffres.put(COLUMN_DESCRIPTION, "Gaufres préparées à l’ancienne");
        Gauffres.put(COLUMN_ETAPE, "Mélangez la farine et le sel, faites un puit au centre du récipient et ajoutez les œufs cassés.\n" +
                "Fouettez puis ajoutez le sucre, le sucre vanillé, la levure et l’huile.\n" +
                "Fouettez encore et gardez la préparation liquide avec de l’eau.\n" +
                "Laissez reposer 30 min, puis versez dans un moule.\n" +
                "Cuisez 3 minutes et servez. \n" +


                "Bon appétit !!!");
        Gauffres.put(COLUMN_DATE, "2017-03-07");
        Gauffres.put(COLUMN_TPREPARATION, 20);
        Gauffres.put(COLUMN_TCUISSON, 35);
        Gauffres.put(COLUMN_FACILITE, "moyen");
        Gauffres.put(COLUMN_TYPE, "dessert");
        Gauffres.put(COLUMN_SOUSTYPE, "chaud");
        Gauffres.put(COLUMN_NBR, 4);
        Gauffres.put(COLUMN_IMAGE, "img14");
        db.insert(TABLE_NAME2, null, Gauffres);


        ContentValues CabillaudTomates = new ContentValues();
        CabillaudTomates.put(COLUMN_NOMR, "Cabillaud aux tomates");
        CabillaudTomates.put(COLUMN_DESCRIPTION, "Cabillaux servi avec une sauce à base de tomates et de poivrons");
        CabillaudTomates.put(COLUMN_ETAPE, "Coupez les onions et mettez-les à dorer dans une poêle avec de l’huile.\n" +
                "coupez les tomates et ajoutez les dans la poêle.\n" +
                "Coupez les poivrons en petits dés et ajoutez-les.\n" +
                "Préparez une deuxième poêle et faites chauffer de l’eau.\n" +
                "Mettez-y quelques gouttes d’huile, puis cuisez le poisson dedans. \n" +
                "Quand l’eau est chaude, cuisez le riz. \n" +
                "Tout devrait être prêt en même temps, vous pouvez donc servir dès que le riz est cuit.\n" +
                "Bon appétit !!!");
        CabillaudTomates.put(COLUMN_DATE, "2017-03-07");
        CabillaudTomates.put(COLUMN_TPREPARATION, 25);
        CabillaudTomates.put(COLUMN_TCUISSON, 15);
        CabillaudTomates.put(COLUMN_FACILITE, "facile");
        CabillaudTomates.put(COLUMN_TYPE, "plat");
        CabillaudTomates.put(COLUMN_SOUSTYPE, "chaud");
        CabillaudTomates.put(COLUMN_NBR, 4);
        CabillaudTomates.put(COLUMN_IMAGE, "img6");
        db.insert(TABLE_NAME2, null, CabillaudTomates);

        ContentValues RotiPorc = new ContentValues();
        RotiPorc.put(COLUMN_NOMR, "Rôti de Porc");
        RotiPorc.put(COLUMN_DESCRIPTION, "Porc rôti en tranche avec une sauce de légumes");
        RotiPorc.put(COLUMN_ETAPE, "Placez le rôti entier dans une casserole avec du bacon au-dessus et mettez celle-ci dans le four pour une heure vingt à 180°.\n" +
                "coupez les oignons, les carottes et les échalottes, l’ail et le céleri, puis incorporez-les au fur et à mesure dans une poêle avec un fond d’huile.\n" +
                "Attendez une vingtaine de minutes.\n" +
                "Vérifier l’avancement de la cuisson du porc.\n" +
                "Ajoutez un verre de vin blanc sec. \n" +
                "Une fois celui-ci absorbé, ajoutez le second. \n" +
                "Laissez les légumes sur un feu doux, puis une fois le porc cuit, coupez-le en tranches et servez.\n" +
                "Bon appétit !!!");
        RotiPorc.put(COLUMN_DATE, "2017-03-07");
        RotiPorc.put(COLUMN_TPREPARATION, 25);
        RotiPorc.put(COLUMN_TCUISSON, 60);
        RotiPorc.put(COLUMN_FACILITE, "moyen");
        RotiPorc.put(COLUMN_TYPE, "plat");
        RotiPorc.put(COLUMN_SOUSTYPE, "chaud");
        RotiPorc.put(COLUMN_NBR, 4);
        RotiPorc.put(COLUMN_IMAGE, "img7");
        db.insert(TABLE_NAME2, null, RotiPorc);

        ContentValues PateNapo = new ContentValues();
        PateNapo.put(COLUMN_NOMR, "Pâtes napolitaines");
        PateNapo.put(COLUMN_DESCRIPTION, "Pâtes aux tomates et poivrons");
        PateNapo.put(COLUMN_ETAPE, "Coupez les tomates et le céleri.\n" +
                "Mettez-les dans une casserole sur un petit morceau de beurre.\n" +
                "Remplissez une casserole d’eau et faites la chauffer .\n" +
                "Ajoutez du poivre noir et curcuma aux légumes.\n" +
                "Faites cuire les pâtes. \n" +

                "Une fois les pâtes cuites, servez.\n" +
                "Bon appétit !!!");
        PateNapo.put(COLUMN_DATE, "2017-03-07");
        PateNapo.put(COLUMN_TPREPARATION, 25);
        PateNapo.put(COLUMN_TCUISSON, 15);
        PateNapo.put(COLUMN_FACILITE, "facile");
        PateNapo.put(COLUMN_TYPE, "plat");
        PateNapo.put(COLUMN_SOUSTYPE, "chaud");
        PateNapo.put(COLUMN_NBR, 4);
        PateNapo.put(COLUMN_IMAGE, "img8");
        db.insert(TABLE_NAME2, null, PateNapo);


        ContentValues CourgettesFarc = new ContentValues();
        CourgettesFarc.put(COLUMN_NOMR, "Courgettes Farcies au quinoa");
        CourgettesFarc.put(COLUMN_DESCRIPTION, "Courgettes Farcies de quinoa et de légume");
        CourgettesFarc.put(COLUMN_ETAPE, "Précuisez les courgettes 10 min à la vapeur.\n" +
                "Coupez-les tomates et les olives en petit morceaux, coupez en deux et videz les courgettes.\n" +
                "Placez le tout dans un récipient et salez.\n" +
                "Remplissez les courgettes de la farce ainsi préparées.\n" +
                "Placez les courgettes dans une casserole remplie de 200ml d’eau avec un cube de bouillon, laissez cuire vingt minutes en arrosant. \n" +
                "Ajoutez du basilic. \n" +
                "Servez.\n" +
                "Bon appétit !!!");
        CourgettesFarc.put(COLUMN_DATE, "2017-03-07");
        CourgettesFarc.put(COLUMN_TPREPARATION, 25);
        CourgettesFarc.put(COLUMN_TCUISSON, 60);
        CourgettesFarc.put(COLUMN_FACILITE, "moyenne");
        CourgettesFarc.put(COLUMN_TYPE, "plat");
        CourgettesFarc.put(COLUMN_SOUSTYPE, "chaud");
        CourgettesFarc.put(COLUMN_NBR, 4);
        CourgettesFarc.put(COLUMN_IMAGE, "img9");
        db.insert(TABLE_NAME2, null, CourgettesFarc);


        ContentValues HamburgerMaison = new ContentValues();
        HamburgerMaison.put(COLUMN_NOMR, "Hamburger Maison");
        HamburgerMaison.put(COLUMN_DESCRIPTION, "Hamburger au fromage et à la salade");
        HamburgerMaison.put(COLUMN_ETAPE, "cuisez la viande hachée à la poêle jusqu’à ce que le niveau de cuisson souhaité soit atteint et réalisez les autres étapes en attendant.\n" +
                "Faites dorer des oignons dans de l’huile une deuxième poêle.\n" +
                "coupez les tomates en tranches.\n" +
                "lavez la salade et préparez le .\n" +


                "Servez.\n" +
                "Bon appétit !!!");
        HamburgerMaison.put(COLUMN_DATE, "2017-03-07");
        HamburgerMaison.put(COLUMN_TPREPARATION, 15);
        HamburgerMaison.put(COLUMN_TCUISSON, 10);
        HamburgerMaison.put(COLUMN_FACILITE, "facile");
        HamburgerMaison.put(COLUMN_TYPE, "plat");
        HamburgerMaison.put(COLUMN_SOUSTYPE, "chaud");
        HamburgerMaison.put(COLUMN_NBR, 4);
        HamburgerMaison.put(COLUMN_IMAGE, "img10");
        db.insert(TABLE_NAME2, null, HamburgerMaison);

        ContentValues Tiramisu = new ContentValues();
        Tiramisu.put(COLUMN_NOMR, "Tiramisu Italien");
        Tiramisu.put(COLUMN_DESCRIPTION, "Tiramisu avec de la mascarpone et des boudoirs");
        Tiramisu.put(COLUMN_ETAPE, "Battez les jaunes d’œufs puis ajoutez la mascarpone et battez à nouveau.\n" +
                "Battre les blancs en neige et incorporez-les.\n" +
                "Imbibez les biscuits de café, puis placez-en dans un plat, ajoutez la moitié de la crème.\n" +
                "Répétez l’opération avec l’autre moitié des biscuits et de la crème.\n" +
                "Placez au réfrigérateur quelques heures puis saupoudrez de cacao. \n" +


                "Bon appétit !!!");
        Tiramisu.put(COLUMN_DATE, "2017-03-07");
        Tiramisu.put(COLUMN_TPREPARATION, 20);
        Tiramisu.put(COLUMN_TCUISSON, 120);
        Tiramisu.put(COLUMN_FACILITE, "moyen");
        Tiramisu.put(COLUMN_TYPE, "dessert");
        Tiramisu.put(COLUMN_SOUSTYPE, "froid");
        Tiramisu.put(COLUMN_NBR, 4);
        Tiramisu.put(COLUMN_IMAGE, "img15");
        db.insert(TABLE_NAME2, null, Tiramisu);

        ContentValues CakeCrabe = new ContentValues();
        CakeCrabe.put(COLUMN_NOMR, "Cake au crabe");
        CakeCrabe.put(COLUMN_DESCRIPTION, "Minis cakes au crabe");
        CakeCrabe.put(COLUMN_ETAPE, "Chauffez le four à 200°C et faites fondre le beurre.\n" +
                "Mélangez farine et levure dans un saladier.\n" +
                "Faites-y un puit, ajoutez le beurre, les œufs et le lait.\n" +
                "Salez, poivrez, ajoutez le crabe émietté, l’ail et le fromage râpé.\n" +
                "Disposez dans des petits moules, puis cuisez 15-20 minutes. \n" +


                "Bon appétit !!!");
        CakeCrabe.put(COLUMN_DATE, "2017-03-07");
        CakeCrabe.put(COLUMN_TPREPARATION, 20);
        CakeCrabe.put(COLUMN_TCUISSON, 20);
        CakeCrabe.put(COLUMN_FACILITE, "moyen");
        CakeCrabe.put(COLUMN_TYPE, "entrée");
        CakeCrabe.put(COLUMN_SOUSTYPE, "chaud");
        CakeCrabe.put(COLUMN_NBR, 4);
        CakeCrabe.put(COLUMN_IMAGE, "img16");
        db.insert(TABLE_NAME2, null, CakeCrabe);

        ContentValues VelouteCarottes = new ContentValues();
        VelouteCarottes.put(COLUMN_NOMR, "Velouté au carottes");
        VelouteCarottes.put(COLUMN_DESCRIPTION, "Soupe épaisse et savoureuse à base de carottes");
        VelouteCarottes.put(COLUMN_ETAPE, "Coupez les carottes en petites rondelles et faites les revenir 10 minutes dans de l’huile.\n" +
                "Ajoutez 500ml de bouillon de volaille et laissez cuire 20 min.\n" +
                "Ajoutez la crème et le lait.\n" +
                "Mixez et assaisonnez.\n" +
                "Une fois le mélange bien onctueux et uniforme, servez. \n" +
                "Bon appétit !!!");
        VelouteCarottes.put(COLUMN_DATE, "2017-03-07");
        VelouteCarottes.put(COLUMN_TPREPARATION, 20);
        VelouteCarottes.put(COLUMN_TCUISSON, 20);
        VelouteCarottes.put(COLUMN_FACILITE, "moyen");
        VelouteCarottes.put(COLUMN_TYPE, "entrée");
        VelouteCarottes.put(COLUMN_SOUSTYPE, "chaud");
        VelouteCarottes.put(COLUMN_NBR, 4);
        VelouteCarottes.put(COLUMN_IMAGE, "img17");
        db.insert(TABLE_NAME2, null, VelouteCarottes);

        ContentValues SaintJacquesSafran = new ContentValues();
        SaintJacquesSafran.put(COLUMN_NOMR, "Saint-Jacques au safran");
        SaintJacquesSafran.put(COLUMN_DESCRIPTION, "Noix de Saint-Jacques à la crème safrannée");
        SaintJacquesSafran.put(COLUMN_ETAPE, ".\n" +
                "Chauffer l’huile dans une grande poêle.\n" +
                "Cuire 2-3 minutes les noix dans l’huile en veillant à e qu’elles ne se touchent pas.\n" +
                "Retournez les Saint-Jacques sans les piquer et cuisez les 2 min de plus.\n" +
                "Ajoutez la crème fraîche, cuisez 1 minutes 30 et servez.\n" +
                "Bon appétit !!!");
        SaintJacquesSafran.put(COLUMN_DATE, "2017-03-07");
        SaintJacquesSafran.put(COLUMN_TPREPARATION, 5);
        SaintJacquesSafran.put(COLUMN_TCUISSON, 8);
        SaintJacquesSafran.put(COLUMN_FACILITE, "moyen");
        SaintJacquesSafran.put(COLUMN_TYPE, "entrée");
        SaintJacquesSafran.put(COLUMN_SOUSTYPE, "chaud");
        SaintJacquesSafran.put(COLUMN_NBR, 4);
        SaintJacquesSafran.put(COLUMN_IMAGE, "img18");
        db.insert(TABLE_NAME2, null, SaintJacquesSafran);


        ContentValues QuicheSaumon = new ContentValues();
        QuicheSaumon.put(COLUMN_NOMR, "Quiche au saumon");
        QuicheSaumon.put (COLUMN_DESCRIPTION, "Quiche au saumon fumé simple à réaliser ");
        QuicheSaumon.put (COLUMN_ETAPE, "Préchauffez le four à 200°C.\n" +
                "Mettez la pâte dans un moule à tarte.\n" +
                "Emincez l’oignon et faites-le cuire dans du beurre.\n" +
                "Mélangez les jaunes d’œuf, la crème et le fromage dans un saladier, salez et poivrez.\n" +
                "Coupez le saumon fumé, puis verser les morceaux de saumon et les oignons sur la pâte. \n" +
                "Versez par-dessus la préparation d’œuf et crème. \n" +
                "Faites cuire le tout 35-45 min au four, puis servez.\n" +
                "Bon appétit !!!");
        QuicheSaumon.put (COLUMN_DATE, "2017-03-07");
        QuicheSaumon.put (COLUMN_TPREPARATION, 20);
        QuicheSaumon.put (COLUMN_TCUISSON, 40);
        QuicheSaumon.put (COLUMN_FACILITE, "moyen");
        QuicheSaumon.put (COLUMN_TYPE, "plat");
        QuicheSaumon.put (COLUMN_SOUSTYPE, "chaud");
        QuicheSaumon.put (COLUMN_NBR, 4);
        QuicheSaumon.put(COLUMN_IMAGE, "img11");
        db.insert(TABLE_NAME2, null, QuicheSaumon);

        ContentValues CakeCitron = new ContentValues();
        CakeCitron.put(COLUMN_NOMR, "Cake au citron");
        CakeCitron.put (COLUMN_DESCRIPTION, "Cake au citron classique et simple à réaliser");
        CakeCitron.put (COLUMN_ETAPE, "Faites fondre le beurre au micro-onde.\n" +
                "Mélangez les œufs, le sucre et le sel dans un saadier au bain marie. Ajoutez ensuite le beurre fondu.\n" +
                "Ajoutez la levure et la farine.\n" +
                "Ajoutez le jus et le zeste de citron.\n" +
                "Beurrez un moule et versez la pâte. \n" +
                "Versez par-dessus la préparation d’œuf et crème. \n" +
                "Faites cuire le tout 35-45 min au four, puis servez.\n" +
                "Bon appétit !!!");
        CakeCitron.put (COLUMN_DATE, "2017-03-07");
        CakeCitron.put (COLUMN_TPREPARATION, 20);
        CakeCitron.put (COLUMN_TCUISSON, 40);
        CakeCitron.put (COLUMN_FACILITE, "moyen");
        CakeCitron.put (COLUMN_TYPE, "dessert");
        CakeCitron.put (COLUMN_SOUSTYPE, "froid");
        CakeCitron.put (COLUMN_NBR, 4);
        CakeCitron.put(COLUMN_IMAGE, "img12");
        db.insert(TABLE_NAME2, null, CakeCitron);

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

        //on met les données dans la table quantite
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('Saumon', 'Pâtes au saumon', '300g')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('Huile', 'Pâtes au saumon', '3 cuillères')");

        //Pâtes à la bolognaise
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('pâtes', 'Pâtes à la bolognaise', '400g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('beurre', 'Pâtes à la bolognaise', '20g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('huile', 'Pâtes à la bolognaise', '2 cuillères de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('poivrons', 'Pâtes à la bolognaise', '1')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignons', 'Pâtes à la bolognaise', '1')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('tomates', 'Pâtes à la bolognaise', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('viande hachée', 'Pâtes à la bolognaise', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('concentré de tomates', 'Pâtes à la bolognaise', '200ml de')");

        //Soupe de poisson
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignons', 'Soupe de poisson', '1')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('échalottes', 'Soupe de poisson', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('poireaux', 'Soupe de poisson', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('saumon', 'Soupe de poisson', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('cabillaud', 'Soupe de poisson', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('cubes de bouillon', 'Soupe de poisson', '1')");

        //Poulet au champignons
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignons', 'Poulet au champignons', '1')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('champignons', 'Poulet au champignons', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('lardons', 'Poulet au champignons', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('poulet', 'Poulet au champignons', '400g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('vin', 'Poulet au champignons', '1 verre de')");
/*
        //Cabillaux aux tomates
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('tomates', 'Cabillaud aux tomates', 200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('poivrons', 'Cabillaud aux tomates', '1')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignons', 'Cabillaud aux tomates', '1')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('cabillaux', 'Cabillaud aux tomates', '400g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('huile', 'Cabillaud aux tomates', '3 cuillères de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('riz', 'Cabillaud aux tomates', '400g de')");
        //Rôti de Porc
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('porc', 'Rôti de Porc', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('bacon', 'Rôti de Porc', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignons', 'Rôti de Porc', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('carottes', 'Rôti de Porc', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('échalottes', 'Rôti de Porc', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('huile', 'Rôti de Porc', '2 cuillères de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('vin blanc sec', 'Rôti de Porc', '2 verres de')");
        //Pâtes napolitaines
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('tomates', 'Pâtes Napolitaines', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('céleri', 'Pâtes Napolitaines', '50g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('beurre', 'Pâtes Napolitaines', '20g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('poivre', 'Pâtes Napolitaines', '2 pincées de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('curcuma', 'Pâtes Napolitaines', '1 pincée de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('pâtes', 'Pâtes Napolitaines', '400g de')");
        //Courgettes farcies au quinoa
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('courgettes', 'Courgettes farcies au quinoa', '3 grosses’)");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('tomates', 'Courgettes farcies au quinoa', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('olives', 'Courgettes farcies au quinoa', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('quinoa', 'Courgettes farcies au quinoa', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('basilic', 'Courgettes farcies au quinoa', '3 feuilles de')");
        //Hamburger Maison
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('pains', 'Hamburger Maison', '4')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('viande hachée', 'Hamburger Maison', '4 pièces de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignons', 'Hamburger Maison', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('tomates', 'Hamburger Maison', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('salade', 'Hamburger Maison', 'quelques feuilles de')");
        //Quiche au saumon
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('pâte à tarte', 'Quiche au saumon', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('oignon', 'Quiche au saumon', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('œufs', 'Quiche au saumon', '3')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('fromage', 'Quiche au saumon', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('crème', 'Quiche au saumon', '100ml de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('poivre', 'Quiche au saumon', 'quelques pincées de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sel', 'Quiche au saumon', 'quelque pincées de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('saumon fumé', 'Quiche au saumon', '300g de')");
        //Cake au citron
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('beurre', 'Cake au citron', '20g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('œufs', 'Cake au citron', '3')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sucre', 'Cake au citron', '3 cuillères à café de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sel', 'Cake au citron', '2 cuillères à café de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('levure', 'Cake au citron', '1 portion de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('farine', 'Cake au citron', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('citron', 'Cake au citron', '4')");
        //Riz au lait coco fraise
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('riz', 'Riz au lait coco fraise', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('noix de coco', 'Riz au lait coco fraise', '150g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('lait de coco', 'Riz au lait coco fraise', '200ml de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('fraises', 'Riz au lait coco fraise', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sucre', 'Riz au lait coco fraise', '2 pincées de')");
        //Gaufres classiques
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('farine', 'Gaufres classiques', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sel', 'Gaufres classiques', '3 pincées de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('œufs', 'Gaufres classiques', '3 de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sucre', 'Gaufres classiques', '2 pincées de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('sucre vanillé', 'Gaufres classiques', '3 pincées de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('huile', 'Gaufres classiques', '2 cuillère à soupe d''')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('levure', 'Gaufres classiques', '1 portion de')");
        //Tiramisu
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('œufs', 'Tiramisu', '3')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('mascarpone', 'Tiramisu', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('biscuits', 'Tiramisu', '20')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('café', 'Tiramisu', '200ml de')");
        //Cake au crabe
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('beurre', 'Cake au crabe', '40g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('farine', 'Cake au crabe', '300g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('levure', 'Cake au crabe', 'une portion de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('lait', 'Cake au crabe', '200ml de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('œufs', 'Cake au crabe', '3')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('crabe émietté', 'Cake au crabe', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('fromage', 'Cake au crabe', '100g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('ail', 'Cake au crabe', '40 g d''')");
        //Velouté au carottes
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('carottes', 'Velouté au carottes', 'une dizaine de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('bouillon de volaille', 'Velouté au carottes', 'un cube de')"); db.execSQL("INSERT INTO quantite ('aliment','recette','quantite') " + "VALUES ('crème', 'Velouté au carottes', '100ml de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('lait', 'Velouté au carottes', '150ml de')");
        //Saint-Jacques au safran
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('noix de Saint-Jacques', 'Saint-Jacques au safran', '200g de')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('huile', 'Saint-Jacques au safran', '2 cuillères d''')");
        db.execSQL("INSERT INTO Tquantite ('aliment','recette','quantite') " + "VALUES ('crème fraîche', 'Saint-Jacques au safran', '40ml de')");
*/

        //db.execSQL("INSERT INTO "+TABLE_NAME5+" VALUES ('Pâtes au saumon', 'Pâtes', '300g')");

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
    public ArrayList<String> getRecetteArray(String u){
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
        Recette r = new Recette();
        r.trier(u,listData);
        return listData;
    }

    //Création d'un arraylist qui contient les titres des recettes en fct des mots clefs
    public ArrayList<String> getRecetteArrayMotClef(String motClef){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT NOMR FROM " + TABLE_NAME2 + " WHERE NOMR LIKE "+ "'%" + motClef + "%'" + " OR DESCRIPTION LIKE " + "'%" + motClef + "%'";
        Cursor dataCursor = db.rawQuery(query, null);
        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listData = new ArrayList<>();
        while(dataCursor.moveToNext()){
            //choppe la valeur de la database en column
            //et l'ajoute à l'arraylist
            listData.add(dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NOMR)));
        }
        dataCursor.close();
        //listData = Recette.trier(listData);
        return listData;
    }


    public ArrayList<String> getRecetteArrayType(String Type , String SousType){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> listData = new ArrayList<>();
        if(SousType == null){
            String query = "SELECT DISTINCT NOMR FROM " + TABLE_NAME2 + " WHERE TYPE = ? ";
            Cursor dataCursor = db.rawQuery(query, new String[] {Type} );
            //on choppe les données grâce au curseur et on les met dans listData

            while(dataCursor.moveToNext()) {
                listData.add(dataCursor.getString(dataCursor.getColumnIndex(COLUMN_NOMR)));
            }
            dataCursor.close();
            //Recette.trier(listData);
            return listData;
        }
        else
        {
                String query2 = "SELECT DISTINCT NOMR FROM "+ TABLE_NAME2 + " WHERE TYPE = ? AND SOUSTYPE = ? " ;
                Cursor dataCursor2 = db.rawQuery(query2, new String[] {Type,SousType});

                while (dataCursor2.moveToNext()) {
                    listData.add(dataCursor2.getString(dataCursor2.getColumnIndex(COLUMN_NOMR)));
                }
                dataCursor2.close();
           // listData =Recette.trier(listData);
            return listData;
        }
    }

    public void insertGout(String u,ArrayList<String> Aliment){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        db.delete(TABLE_NAME6,"EMAIL =?" , new String[] {u});
        for(int i=0;i<3;i++){
            String a =Aliment.get(i);
            if(a != "") {

                values.put(COLUMN_ALIMENT3, Aliment.get(i));
                values.put(COLUMN_EMAIL3, u);       // comment récuper l'email de l'utilisateur actuelle ?
                values.put(COLUMN_GOUT, 1);
                db.insert(TABLE_NAME6, null, values);
            }

        }
        for(int j =3;j<6;j++){
            if(Aliment.get(j) != "") {
                values.put(COLUMN_ALIMENT3, Aliment.get(j));values.put(COLUMN_EMAIL3, u);
                values.put(COLUMN_GOUT, -1);
                db.insert(TABLE_NAME6, null, values);

            }
        }
    }
    public void insertUserContrainte(String u,ArrayList<String> ContrainteU) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        db.delete(TABLE_NAME3,"EMAIL =?" , new String[] {u});
        for(int i=0;i<ContrainteU.size();i++) {
            values.put(COLUMN_EMAIL2, u);
            values.put(COLUMN_CONTRAINTEU, ContrainteU.get(i));       // comment récuper l'email de l'utilisateur actuelle
            db.insert(TABLE_NAME3, null, values);
        }
    }



    public ArrayList<String> getContrainteU(String util){
        // FAUX car l'utilisateur mettra dans une liste ses contraintes que l'on devra reprendre
        SQLiteDatabase db = this.getReadableDatabase();
        String queryC = "SELECT contrainteu FROM " + TABLE_NAME3 + "WHERE email = " + util;
        Cursor dataCursora = db.rawQuery(queryC, null);            //et l'ajoute à l'arraylist

        //on choppe les données grâce au curseur et on les met dans une liste
        ArrayList<String> listDataa = new ArrayList<>();
        while(dataCursora.moveToNext()){
            //choppe la valeur de la database en column
            listDataa.add(dataCursora.getString(dataCursora.getColumnIndex(COLUMN_CONTRAINTEU)));
        }
        dataCursora.close();
        return listDataa;
    }

    public ArrayList<String> getContrainteA(String alim){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryD = "SELECT contraintea FROM " + TABLE_NAME4 +"WHERE aliment = " + alim;
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
        int a =3;
        SQLiteDatabase db = this.getReadableDatabase();
        int b=4;
        String query123 = "SELECT aliment FROM " + TABLE_NAME5 + " WHERE recette = " + recette;
        Cursor dataCursorc = db.rawQuery(query123, null);
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
        String queryF = "SELECT gout FROM " + TABLE_NAME6 + "WHERE aliment = " + alim +"AND email =" + util;
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
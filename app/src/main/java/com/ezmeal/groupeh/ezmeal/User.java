package com.ezmeal.groupeh.ezmeal;

/**
 * Created by elthe on 23-04-17.
 */

public class User {

    String prenom, nom, email, mdp, age, langue, nationnalite, sexe;
    String contrainte;
    String préférence1, préférence2, préférence3;
    String indésiré1, indésiré2, indésiré3;

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public void setNationnalite(String nationnalite) {
        this.nationnalite = nationnalite;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLangue() {
        return langue;
    }

    public String getNationnalite() {
        return nationnalite;
    }

    public String getSexe() {
        return sexe;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public String getAge() {
        return age;
    }

    public void setContraintes(String contrainte){
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
}

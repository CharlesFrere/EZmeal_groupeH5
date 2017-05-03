package com.ezmeal.groupeh.ezmeal;

/**
 * Created by elthe on 23-04-17.
 */

public class User {

    String prenom, nom, email, mdp, age, langue, nationnalite, sexe;

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
}

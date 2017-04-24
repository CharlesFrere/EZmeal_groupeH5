package com.ezmeal.groupeh.ezmeal;

/**
 * Created by elthe on 23-04-17.
 */

public class User {

    String prenom, nom, email, mdp, age;

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

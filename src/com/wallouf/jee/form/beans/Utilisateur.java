package com.wallouf.jee.form.beans;

public class Utilisateur {

    private String email;
    private String motDePasse;
    private String nom;

    public Utilisateur( String email, String motDePasse, String nom ) {
        super();
        this.email = email;
        this.motDePasse = motDePasse;
        this.nom = nom;
    }

    public Utilisateur() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail( String email ) {
        this.email = email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse( String motDePasse ) {
        this.motDePasse = motDePasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

}

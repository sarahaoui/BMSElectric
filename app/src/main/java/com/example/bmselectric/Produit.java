package com.example.bmselectric;

public class Produit {
    public String id;
    public String nom;
    public String idcat;
    public  String description;

    public Produit(String id,String idcat, String nom, String description) {
        this.id = id;
        this.idcat = idcat;
        this.nom = nom;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

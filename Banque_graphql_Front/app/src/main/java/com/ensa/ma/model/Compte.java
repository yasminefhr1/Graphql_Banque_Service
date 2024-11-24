package com.ensa.ma.model;

public class Compte {
    private int id;
    private double solde;
    private TypeCompte type;
    private String dateCreation;

    public Compte(int id, double solde, TypeCompte type, String dateCreation) {
        this.id = id;
        this.solde = solde;
        this.type = type;
        this.dateCreation = dateCreation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) { // Accepte TypeCompte au lieu de String
        this.type = type;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }
}

package com.ensa.ma.model;

public class Transaction {
    private int compteId;
    private double montant;
    private TypeTransaction type;

    public Transaction(int compteId, double montant, TypeTransaction type) {
        this.compteId = compteId;
        this.montant = montant;
        this.type = type;
    }

    public int getCompteId() {
        return compteId;
    }

    public void setCompteId(int compteId) {
        this.compteId = compteId;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

}
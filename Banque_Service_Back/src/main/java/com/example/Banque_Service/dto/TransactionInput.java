package com.example.Banque_Service.dto;

import com.example.Banque_Service.entities.TypeTransaction;
import lombok.Data;

@Data
public class TransactionInput {
    private double montant;
    private TypeTransaction type;
    private String compteId;
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public TypeTransaction getType() {
		return type;
	}
	public void setType(TypeTransaction type) {
		this.type = type;
	}
	public String getCompteId() {
		return compteId;
	}
	public void setCompteId(String compteId) {
		this.compteId = compteId;
	}
    
}
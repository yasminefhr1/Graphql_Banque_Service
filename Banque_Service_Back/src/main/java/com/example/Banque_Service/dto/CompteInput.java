package com.example.Banque_Service.dto;

import com.example.Banque_Service.entities.TypeCompte;
import lombok.Data;

@Data
public class CompteInput {
    private double solde;
    private TypeCompte type;
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	
}
package com.example.Banque_Service.dto;

import lombok.Data;
import com.example.Banque_Service.entities.TypeTransaction;
import java.util.Date;

@Data
public class TransactionRequest {
    private double montant;
    private Date date;
    private TypeTransaction type;
    private Long compteId;
}
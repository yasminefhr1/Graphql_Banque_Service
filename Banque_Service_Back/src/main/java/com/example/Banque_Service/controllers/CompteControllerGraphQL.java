package com.example.Banque_Service.controllers;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import com.example.Banque_Service.entities.*;
import com.example.Banque_Service.repositories.*;
import lombok.AllArgsConstructor;
import com.example.Banque_Service.dto.*;
import java.util.Date;



import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class CompteControllerGraphQL {
    private CompteRepository compteRepository;
    private TransactionRepository transactionRepository;
    
    @QueryMapping
    public List<Compte> allComptes() {
        return compteRepository.findAll();
    }

    @QueryMapping
    public Compte compteById(@Argument Long id) {
        Compte compte = compteRepository.findById(id).orElse(null);
        if (compte == null) throw new RuntimeException(String.format("Compte %s not found", id));
        return compte;
    }

    @MutationMapping
    public Compte saveCompte(@Argument Compte compte) {
        return compteRepository.save(compte);
    }

    @QueryMapping
    public Map<String, Object> totalSolde() {
        long count = compteRepository.count();
        double sum = compteRepository.sumSoldes();
        double average = count > 0 ? sum / count : 0;

        return Map.of(
            "count", count,
            "sum", sum,
            "average", average
        );
    }
    
    
    
    
    @MutationMapping
    public Transaction addTransaction(@Argument TransactionInput transaction) {
        Compte compte = compteRepository.findById(Long.parseLong(transaction.getCompteId()))
                .orElseThrow(() -> new RuntimeException("Compte not found"));

        Transaction newTransaction = new Transaction();
        newTransaction.setMontant(transaction.getMontant());
        newTransaction.setDate(new Date());
        newTransaction.setType(transaction.getType());
        newTransaction.setCompte(compte);

        return transactionRepository.save(newTransaction);
    }

    @QueryMapping
    public List<Transaction> compteTransactions(@Argument Long id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte not found"));
        return transactionRepository.findByCompte(compte);
    }

    @QueryMapping
    public Map<String, Object> transactionStats() {
        long count = transactionRepository.count();
        double sumDepots = transactionRepository.sumByType(TypeTransaction.DEPOT);
        double sumRetraits = transactionRepository.sumByType(TypeTransaction.RETRAIT);
        return Map.of(
                "count", count,
                "sumDepots", sumDepots,
                "sumRetraits", sumRetraits
        );
    }
}
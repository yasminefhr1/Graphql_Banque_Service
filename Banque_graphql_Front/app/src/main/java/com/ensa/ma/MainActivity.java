package com.ensa.ma;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ensa.ma.adapter.CompteAdapter;
import com.ensa.ma.model.Compte;
import com.ensa.ma.model.TypeCompte;
import com.ensa.ma.model.TypeTransaction;
import com.ensa.ma.viewmodel.CompteViewModel;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements CompteAdapter.OnCompteClickListener {
    private CompteViewModel viewModel;
    private CompteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupRecyclerView();
        setupViewModel();

        Button addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> showAddCompteDialog());
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CompteAdapter(this, viewModel, this);
        recyclerView.setAdapter(adapter);
    }

    private void setupViewModel() {
        viewModel = new ViewModelProvider(this).get(CompteViewModel.class);

        viewModel.getComptes().observe(this, comptes -> {
            if (comptes != null) {
                adapter.updateData(comptes);
            }
        });

        viewModel.getError().observe(this, error -> {
            if (error != null) {
                Toast.makeText(this, error, Toast.LENGTH_LONG).show();
            }
        });

        viewModel.fetchComptes();
    }

    private void showAddCompteDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Ajouter un compte");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_add_compte, null);
        builder.setView(customLayout);

        TextInputEditText soldeInput = customLayout.findViewById(R.id.soldeInput);
        Spinner typeSpinner = customLayout.findViewById(R.id.typeSpinner);

        // Utiliser l'énumération TypeCompte pour remplir le Spinner
        ArrayAdapter<TypeCompte> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, TypeCompte.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        builder.setPositiveButton("Ajouter", (dialog, which) -> {
            String soldeStr = soldeInput.getText().toString();
            TypeCompte type = (TypeCompte) typeSpinner.getSelectedItem(); // Récupérer l'objet TypeCompte

            if (!soldeStr.isEmpty()) {
                double solde = Double.parseDouble(soldeStr);
                viewModel.addCompte(solde, type.name()); // Utiliser type.name() pour convertir en String
            } else {
                Toast.makeText(this, "Veuillez entrer un solde valide.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Annuler", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    @Override
    public void onCompteClick(Compte compte) {
        showTransactionDialog(compte);
    }

    private void showTransactionDialog(Compte compte) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Transaction");

        final View customLayout = getLayoutInflater().inflate(R.layout.dialog_transaction, null);
        builder.setView(customLayout);

        TextInputEditText montantInput = customLayout.findViewById(R.id.montantInput);
        Spinner typeSpinner = customLayout.findViewById(R.id.typeSpinner);

        ArrayAdapter<TypeTransaction> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, TypeTransaction.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);

        builder.setPositiveButton("Effectuer", (dialog, which) -> {
            String montantStr = montantInput.getText().toString();
            TypeTransaction type = (TypeTransaction) typeSpinner.getSelectedItem();

            if (!montantStr.isEmpty()) {
                double montant = Double.parseDouble(montantStr);
                Toast.makeText(this, "Transaction effectuée avec succès.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Veuillez entrer un montant valide.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Annuler", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }
}

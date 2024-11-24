package com.ensa.ma.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.ensa.ma.R;
import com.ensa.ma.model.Compte;
import com.ensa.ma.viewmodel.CompteViewModel;
import java.util.List;

public class CompteAdapter extends RecyclerView.Adapter<CompteAdapter.CompteViewHolder> {
    private List<Compte> comptes;
    private final Context context;
    private final CompteViewModel viewModel;
    private final OnCompteClickListener listener;

    public CompteAdapter(Context context, CompteViewModel viewModel, OnCompteClickListener listener) {
        this.context = context;
        this.viewModel = viewModel;
        this.listener = listener;
    }

    public void updateData(List<Compte> comptes) {
        this.comptes = comptes;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CompteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_compte, parent, false);
        return new CompteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompteViewHolder holder, int position) {
        Compte compte = comptes.get(position);
        holder.tvSolde.setText("Solde: " + compte.getSolde());
        holder.tvType.setText("Type: " + compte.getType());
        holder.tvDate.setText("Date: " + compte.getDateCreation());
        holder.itemView.setOnClickListener(v -> listener.onCompteClick(compte));
    }

    @Override
    public int getItemCount() {
        return (comptes == null) ? 0 : comptes.size();
    }

    public interface OnCompteClickListener {
        void onCompteClick(Compte compte);
    }

    public static class CompteViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvSolde;
        private final TextView tvType;
        private final TextView tvDate;


        public CompteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSolde = itemView.findViewById(R.id.tvSolde);
            tvType = itemView.findViewById(R.id.tvType);
            tvDate = itemView.findViewById(R.id.tvDate);

        }
    }
}

package com.tolganacar.cryptocurrencytracker.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tolganacar.cryptocurrencytracker.databinding.RecyclerRowBinding;
import com.tolganacar.cryptocurrencytracker.model.CryptoModel;

import java.util.ArrayList;

public class CryptoAdapter extends RecyclerView.Adapter<CryptoAdapter.CryptoHolder> {

    ArrayList<CryptoModel> cryptoList;

    private String[] colors = {"#8d7dff", "#5cff75", "#c078aa","#005a80","#ffa2a5","#ff7434"};

    public CryptoAdapter(ArrayList<CryptoModel> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @NonNull
    @Override
    public CryptoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new CryptoHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CryptoHolder holder, int position) {
        holder.recyclerRowBinding.textCurrency.setText(cryptoList.get(position).currency);
        holder.recyclerRowBinding.textPrice.setText(cryptoList.get(position).price);
        holder.itemView.setBackgroundColor(Color.parseColor(colors[position % 6]));
    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }

    public class CryptoHolder extends RecyclerView.ViewHolder {

        private RecyclerRowBinding recyclerRowBinding;

        public CryptoHolder(RecyclerRowBinding recyclerRowBinding) {
            super(recyclerRowBinding.getRoot());
            this.recyclerRowBinding = recyclerRowBinding;
        }
    }
}

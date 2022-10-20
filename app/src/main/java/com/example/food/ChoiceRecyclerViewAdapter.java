package com.example.food;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChoiceRecyclerViewAdapter extends RecyclerView.Adapter<ChoiceRecyclerViewAdapter.ChoiceRecyclerViewViewHolder> {

    Context context;
    ArrayList<ChoiceRecyclerViewModel> choiceRecyclerViewModels;

    public ChoiceRecyclerViewAdapter(Context context, ArrayList<ChoiceRecyclerViewModel> choiceRecyclerViewModels) {
        this.context = context;
        this.choiceRecyclerViewModels = choiceRecyclerViewModels;
    }

    @NonNull
    @Override
    public ChoiceRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.choice_recycler_view, parent, false);
        return new ChoiceRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChoiceRecyclerViewViewHolder holder, int position) {
        holder.choiceName.setText(choiceRecyclerViewModels.get(position).getName());
        holder.choiceDescription.setText(choiceRecyclerViewModels.get(position).getDescription());
        holder.choicePrice.setText(choiceRecyclerViewModels.get(position).getPrice());
    }

    @Override
    public int getItemCount() {
        return choiceRecyclerViewModels.size();
    }

    public static class ChoiceRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        ImageView choiceImage;
        TextView choiceName, choiceDescription, choicePrice;

        public ChoiceRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            choiceImage = itemView.findViewById(R.id.choiceImage);
            choiceName = itemView.findViewById(R.id.choiceName);
            choiceDescription = itemView.findViewById(R.id.choiceDescription);
            choicePrice = itemView.findViewById(R.id.choicePrice);
        }
    }
}
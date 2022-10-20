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

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter<CategoryRecyclerViewAdapter.CategoryRecyclerViewViewHolder> {

    Context context;
    ArrayList<CategoryRecyclerViewModel> categoryRecyclerViewModels;

    public CategoryRecyclerViewAdapter(Context context, ArrayList<CategoryRecyclerViewModel> categoryRecyclerViewModels) {
        this.context = context;
        this.categoryRecyclerViewModels = categoryRecyclerViewModels;
    }

    @NonNull
    @Override
    public CategoryRecyclerViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_recycler_view, parent, false);
        return new CategoryRecyclerViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRecyclerViewViewHolder holder, int position) {
        holder.categoryName.setText(categoryRecyclerViewModels.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return categoryRecyclerViewModels.size();
    }

    public static class CategoryRecyclerViewViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView categoryName;

        public CategoryRecyclerViewViewHolder(@NonNull View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.categoryImage);
            categoryName = itemView.findViewById(R.id.categoryName);
        }
    }
}
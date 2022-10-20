package com.example.food;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CategoryRecyclerViewModel> categoryRecyclerViewModels = new ArrayList<>();
    ArrayList<ChoiceRecyclerViewModel> choiceRecyclerViewModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Category RecyclerView
        RecyclerView category = findViewById(R.id.category);

        setUpCategoryRecyclerViewModels();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        category.setLayoutManager(linearLayoutManager);

        CategoryRecyclerViewAdapter categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(this, categoryRecyclerViewModels);
        category.setAdapter(categoryRecyclerViewAdapter);

        //Choice RecyclerView
        RecyclerView choice = findViewById(R.id.choice);

        setUpChoiceRecyclerViewModels();

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        choice.setLayoutManager(linearLayoutManager1);

        ChoiceRecyclerViewAdapter choiceRecyclerViewAdapter = new ChoiceRecyclerViewAdapter(this, choiceRecyclerViewModels);
        choice.setAdapter(choiceRecyclerViewAdapter);
    }

    private void setUpCategoryRecyclerViewModels() {
        String[] categoryNames = getResources().getStringArray(R.array.category_name);

        for (String categoryName : categoryNames) {
            categoryRecyclerViewModels.add(new CategoryRecyclerViewModel(R.drawable.ic_launcher_foreground, categoryName));
        }
    }

    private void setUpChoiceRecyclerViewModels() {
        String[] choiceNames = getResources().getStringArray(R.array.choice_name);
        String[] choiceDescriptions = getResources().getStringArray(R.array.choice_description);
        String[] choicePrices = getResources().getStringArray(R.array.choice_price);

        for (int i = 0; i < choiceNames.length; i++) {
            choiceRecyclerViewModels.add(new ChoiceRecyclerViewModel(R.drawable.ic_launcher_foreground, choiceNames[i], choiceDescriptions[i], choicePrices[i]));
        }
    }
}
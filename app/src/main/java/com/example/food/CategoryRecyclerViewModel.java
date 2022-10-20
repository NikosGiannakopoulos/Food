package com.example.food;

public class CategoryRecyclerViewModel {

    int image;
    String name;

    public CategoryRecyclerViewModel(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
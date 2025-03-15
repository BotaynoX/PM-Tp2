package com.example.tp2;

public class Recipe {
    private String title;
    private int imageResId;
    private String description;
    private String ingredients;

    public Recipe(String title, int imageResId, String description, String ingredients) {
        this.title = title;
        this.imageResId = imageResId;
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getTitle() {
        return title;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getDescription() {
        return description;
    }

    public String getIngredients() {
        return ingredients;
    }
}

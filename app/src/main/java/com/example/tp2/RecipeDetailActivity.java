package com.example.tp2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeDetailActivity extends AppCompatActivity {
    private TextView textDescription, textIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        textDescription = findViewById(R.id.textDescription);
        textIngredients = findViewById(R.id.textIngredients);

        String description = getIntent().getStringExtra("description");
        String ingredients = getIntent().getStringExtra("ingredients");

        textDescription.setText(description);
        textIngredients.setText(ingredients);
    }
}

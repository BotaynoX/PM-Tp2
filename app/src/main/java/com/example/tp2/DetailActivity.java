package com.example.tp2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageView;
    private TextView titleText, textDescription, textIngredients; // FIX: Using correct IDs

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        imageView = findViewById(R.id.imageView);
        titleText = findViewById(R.id.titleText);
        textDescription = findViewById(R.id.textDescription); // FIXED ID
        textIngredients = findViewById(R.id.textIngredients); // FIXED ID

        String title = getIntent().getStringExtra("title");
        int imageResId = getIntent().getIntExtra("imageResId", R.drawable.pizza1);
        String description = getIntent().getStringExtra("description");
        String ingredients = getIntent().getStringExtra("ingredients");

        titleText.setText(title);
        imageView.setImageResource(imageResId);
        textDescription.setText(description); // FIXED ID
        textIngredients.setText(ingredients); // FIXED ID
    }
}

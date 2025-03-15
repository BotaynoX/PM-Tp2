package com.example.tp2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecipeAdapter.OnItemClickListener {
    private RecyclerView recyclerView;
    private RecipeAdapter adapter;
    private List<Recipe> recipeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pizza Recipes");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadPizzaRecipes();

        adapter = new RecipeAdapter(this, recipeList, this);
        recyclerView.setAdapter(adapter);
    }

    private void loadPizzaRecipes() {
        recipeList = new ArrayList<>();
        recipeList.add(new Recipe("Bruschetta Pizza", R.drawable.pizza1, "A delightful twist on traditional pizza.", "- 1/2 pound pork sausage\n- 1 prebaked pizza crust\n- 1 cup tomatoes"));
        recipeList.add(new Recipe("Pepperoni Pizza", R.drawable.pizza2, "Classic choice with spicy pepperoni.", "- 1 cup pizza sauce\n- 2 cups mozzarella\n- 1/2 cup pepperoni slices"));
        recipeList.add(new Recipe("Margherita Pizza", R.drawable.pizza3, "Mozzarella, tomatoes, and fresh basil.", "- 1 pizza dough\n- 2 tomatoes\n- Fresh mozzarella\n- Basil leaves"));
        recipeList.add(new Recipe("BBQ Chicken Pizza", R.drawable.pizza4, "Grilled chicken with tangy BBQ sauce.", "- 1/2 cup BBQ sauce\n- 1 cup chicken breast\n- 1/2 cup red onion\n- Mozzarella"));
        recipeList.add(new Recipe("Hawaiian Pizza", R.drawable.pizza1, "Sweet pineapple with ham.", "- 1/2 cup pizza sauce\n- 1 cup mozzarella\n- 1/2 cup ham\n- 1/2 cup pineapple"));
        recipeList.add(new Recipe("Meat Lover’s Pizza", R.drawable.pizza2, "Loaded with sausage, pepperoni, and bacon.", "- 1/2 cup tomato sauce\n- 1 cup mozzarella\n- Pepperoni, sausage, bacon"));
        recipeList.add(new Recipe("Vegetarian Pizza", R.drawable.pizza3, "Topped with bell peppers, mushrooms, and olives.", "- 1/2 cup tomato sauce\n- 1 cup mozzarella\n- Bell peppers, mushrooms, olives"));
        recipeList.add(new Recipe("Buffalo Chicken Pizza", R.drawable.pizza4, "Spicy buffalo chicken with blue cheese.", "- 1/2 cup buffalo sauce\n- 1 cup chicken breast\n- Blue cheese\n- Mozzarella"));
        recipeList.add(new Recipe("Bruschetta Pizza", R.drawable.pizza1, "A delightful twist on traditional pizza.", "- 1/2 pound pork sausage\n- 1 prebaked pizza crust\n- 1 cup tomatoes"));
        recipeList.add(new Recipe("Pepperoni Pizza", R.drawable.pizza2, "Classic choice with spicy pepperoni.", "- 1 cup pizza sauce\n- 2 cups mozzarella\n- 1/2 cup pepperoni slices"));
        recipeList.add(new Recipe("Margherita Pizza", R.drawable.pizza3, "Mozzarella, tomatoes, and fresh basil.", "- 1 pizza dough\n- 2 tomatoes\n- Fresh mozzarella\n- Basil leaves"));
        recipeList.add(new Recipe("BBQ Chicken Pizza", R.drawable.pizza4, "Grilled chicken with tangy BBQ sauce.", "- 1/2 cup BBQ sauce\n- 1 cup chicken breast\n- 1/2 cup red onion\n- Mozzarella"));
        recipeList.add(new Recipe("Hawaiian Pizza", R.drawable.pizza1, "Sweet pineapple with ham.", "- 1/2 cup pizza sauce\n- 1 cup mozzarella\n- 1/2 cup ham\n- 1/2 cup pineapple"));
        recipeList.add(new Recipe("Meat Lover’s Pizza", R.drawable.pizza2, "Loaded with sausage, pepperoni, and bacon.", "- 1/2 cup tomato sauce\n- 1 cup mozzarella\n- Pepperoni, sausage, bacon"));
        recipeList.add(new Recipe("Vegetarian Pizza", R.drawable.pizza3, "Topped with bell peppers, mushrooms, and olives.", "- 1/2 cup tomato sauce\n- 1 cup mozzarella\n- Bell peppers, mushrooms, olives"));
        recipeList.add(new Recipe("Buffalo Chicken Pizza", R.drawable.pizza4, "Spicy buffalo chicken with blue cheese.", "- 1/2 cup buffalo sauce\n- 1 cup chicken breast\n- Blue cheese\n- Mozzarella"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_share) {
            shareApp();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void shareApp() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Recipes App");
        intent.putExtra(Intent.EXTRA_TEXT, "Check out this amazing Pizza Recipes App!");
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    @Override
    public void onItemClick(int position) {
        Recipe selectedRecipe = recipeList.get(position);
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtra("recipe", (CharSequence) selectedRecipe);
        startActivity(intent);
    }
}

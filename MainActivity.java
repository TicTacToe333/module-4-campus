package com.example.module4campus;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    //references to the stuff
    Button add_recipe, view_all, add_ingredient, find_recipe;
    EditText dish_name, number, measurement, ingredient;
    ListView lv_recipe_list;
    DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);

    ArrayAdapter recipeArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add_recipe = findViewById(R.id.add_recipe);
        view_all = findViewById(R.id.view_all);
        add_ingredient = findViewById(R.id.add_ingredient);
        find_recipe = findViewById(R.id.find_recipe);
        dish_name = findViewById(R.id.dish_name);
        number = findViewById(R.id.number);
        measurement = findViewById(R.id.measurement);
        ingredient = findViewById(R.id.ingredient);
        lv_recipe_list = findViewById(R.id.lv_recipe_list);

        databaseHelper = new DatabaseHelper(MainActivity.this);

        //recipeArrayAdapter = new ArrayAdapter<RecipeModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
        //lv_recipe_list.setAdapter(recipeArrayAdapter);


        //button listeners for add button
        add_recipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                RecipeModel recipeModel;
                try{
                    recipeModel = new RecipeModel(-1,dish_name.getText().toString());
                    Toast.makeText(MainActivity.this, recipeModel.toString(),Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "Error adding recipe",Toast.LENGTH_SHORT).show();
                    recipeModel = new RecipeModel(-1,"error");
                }
                DatabaseHelper databaseHelper = new DatabaseHelper(MainActivity.this);
                boolean success = databaseHelper.addOne(recipeModel);
                Toast.makeText(MainActivity.this, "Success = " + success, Toast.LENGTH_SHORT).show();

                recipeArrayAdapter = new ArrayAdapter<RecipeModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
                lv_recipe_list.setAdapter(null);

            }
        });
        view_all.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                List<RecipeModel> everyone = databaseHelper.getEveryone();
                recipeArrayAdapter = new ArrayAdapter<RecipeModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
                lv_recipe_list.setAdapter(recipeArrayAdapter);


            }
        });

        add_ingredient.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                RecipeModel recipeModel;
                Ingredient ingredients;
                try{
                    recipeModel = new RecipeModel(1,dish_name.getText().toString());
                    ingredients = new Ingredient((Float.parseFloat(number.getText().toString())), measurement.getText().toString(), ingredient.getText().toString());

                    Toast.makeText(MainActivity.this, recipeModel.toString(),Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(MainActivity.this, "Error adding ingredient",Toast.LENGTH_SHORT).show();
                    recipeModel = new RecipeModel(-1,"error");
                }

                List<RecipeModel> everyone = databaseHelper.getEveryone();
                recipeArrayAdapter = new ArrayAdapter<RecipeModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
                lv_recipe_list.setAdapter(null);


            }
        });

        find_recipe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                List<RecipeModel> everyone = databaseHelper.getEveryone();
                recipeArrayAdapter = new ArrayAdapter<RecipeModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
                lv_recipe_list.setAdapter(null);


            }
        });


        lv_recipe_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                RecipeModel clickedRecipe = (RecipeModel) adapterView.getItemAtPosition(i);
                databaseHelper.deleteOne(clickedRecipe);

                recipeArrayAdapter = new ArrayAdapter<RecipeModel>(MainActivity.this, android.R.layout.simple_list_item_1, databaseHelper.getEveryone());
                lv_recipe_list.setAdapter(recipeArrayAdapter);

                Toast.makeText(MainActivity.this, "Deleted " + clickedRecipe.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
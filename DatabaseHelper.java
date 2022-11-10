package com.example.module4campus;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String RECIPE_TABLE = "RECIPE_TABLE";
    public static final String COLUMN_RECIPE_NAME = "RECIPE_NAME";
    public static final String COLUMN_ID = "ID";
    //public static final String COLUMN_RECIPE
//, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version
    public DatabaseHelper(@Nullable Context context) {
        super(context, "recipe.db", null, 1);
    }

    //called the first time a database object is accessed
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + RECIPE_TABLE + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_RECIPE_NAME + " TEXT)";
        db.execSQL(createTableStatement);
    }

    //called if the database version changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    public boolean addOne(RecipeModel recipeModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_RECIPE_NAME, recipeModel.getDishName());

        long insert = db.insert(RECIPE_TABLE, null, cv);
        if (insert == -1){
            return false;
        }else{
            return true;
        }

    }
    public List<RecipeModel> getEveryone(){
        List<RecipeModel> returnList = new ArrayList<>();
        String queryString  = "SELECT * FROM " + RECIPE_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);
        //if there are results, loop through results
        if(cursor.moveToFirst()){
            do{
                int recipeID = cursor.getInt(0);
                String dishName = cursor.getString(1);

                RecipeModel newRecipe = new RecipeModel(recipeID, dishName);
                returnList.add(newRecipe);
            }while(cursor.moveToNext());

        }else{
            //failure, nothing will be added to the list
        }
        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteOne(RecipeModel recipeModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + RECIPE_TABLE + " WHERE " + COLUMN_ID + " = " + recipeModel.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }

}

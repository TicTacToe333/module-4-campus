package com.example.module4campus;

public class RecipeModel {
    private int id;
    private String dishName;

    public RecipeModel(int id, String dishName) {
        this.id = id;
        this.dishName = dishName;
    }

    @Override
    public String toString() {
        return "RecipeModel{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }
    public int getId() {
        return id;
    }

    public String getDishName() {
        return dishName;
    }


}

package com.example.module4campus;

public class Ingredient {
    private float number;
    private String measurement;
    private String item;

    public Ingredient(float number, String measurement, String item) {
        this.number = number;
        this.measurement = measurement;
        this.item = item;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "number=" + number +
                ", measurement='" + measurement + '\'' +
                ", item='" + item + '\'' +
                '}';
    }

    public float getNumber() {
        return number;
    }

    public String getMeasurement() {
        return measurement;
    }

    public String getItem() {
        return item;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

package com.example.finalproject;

import androidx.annotation.NonNull;

//Chris
public class FoodData {
    private String itemName;
    private String itemDescription;
    private String itemTime;
    private int itemImage;

    public FoodData(String itemName, String itemDescription, String itemTime, int itemImage) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemTime = itemTime;
        this.itemImage = itemImage;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getItemTime() {
        return itemTime;
    }

    public void setItemTime(String itemTime) {
        this.itemTime = itemTime;
    }

    public int getItemImage() {
        return itemImage;
    }

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    @NonNull
    @Override
    public String toString() {
        return itemName;
    }
}


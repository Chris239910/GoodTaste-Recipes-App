package com.example.finalproject;
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

    public String getItemDescription() {
        return itemDescription;
    }

    public String getItemTime() {
        return itemTime;
    }

    public int getItemImage() {
        return itemImage;
    }
}

